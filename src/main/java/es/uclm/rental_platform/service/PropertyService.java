package es.uclm.rental_platform.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.uclm.rental_platform.domain.Photos;
import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.domain.User;
import es.uclm.rental_platform.repository.PropertyRepository;
import es.uclm.rental_platform.repository.UserRepository;

/*


*/

@Service 
public class PropertyService 
{
    private final PropertyRepository property_repo;
    private final UserRepository user_repo;
    private final Path uploadDirectory;
    //Constructor
    
    public PropertyService(
        PropertyRepository property_repo,
        UserRepository user_repo,
        @Value("${app.upload.dir:uploads}") String uploadDirectory)
    {
        this.property_repo = property_repo;
        this.user_repo = user_repo;
        this.uploadDirectory = Path.of(uploadDirectory).toAbsolutePath().normalize();
    }
    
    public Property crear(Long ownerID, String address, String type, Double nightPrice, int surface)
    {
        try 
        {
            //Primero verificamos si el dueño existe en la BBDD
            User user = user_repo.findById(ownerID).orElseThrow();   

            //Si el usuario existe, creamos una propiedad con el dueño y los detalles de la viviendia
            Property property = new Property(user.getOwner(), address, type, nightPrice, surface);

            return property_repo.save(property);
        } 
        catch (NoSuchElementException e) 
        {
            throw new IllegalArgumentException("El usuario que se ha intentado obtener no existe");
        }

    }

    public Property crear(Property property)
    {
        return property_repo.save(property);
    }

    public Property crear(Property property, List<MultipartFile> photos)
    {
        List<MultipartFile> uploadedPhotos = photos == null
            ? List.of()
            : photos.stream()
                .filter(photo -> photo != null && !photo.isEmpty())
                .toList();

        if (uploadedPhotos.isEmpty()) {
            return crear(property);
        }

        List<String> extensions = uploadedPhotos.stream()
            .map(this::imageExtension)
            .toList();
        List<Path> savedFiles = new ArrayList<>();

        try {
            Files.createDirectories(uploadDirectory);

            for (int i = 0; i < uploadedPhotos.size(); i++) {
                String fileName = UUID.randomUUID() + extensions.get(i);
                Path destination = uploadDirectory.resolve(fileName);
                savedFiles.add(destination);
                uploadedPhotos.get(i).transferTo(destination);
                property.getPhotos().add(new Photos("/uploads/" + fileName, property));
            }

            return property_repo.save(property);
        } catch (IOException e) {
            UncheckedIOException failure = new UncheckedIOException("No se pudieron guardar las imágenes", e);
            deleteUploadedFiles(savedFiles, failure);
            throw failure;
        } catch (RuntimeException e) {
            deleteUploadedFiles(savedFiles, e);
            throw e;
        }
    }

    private String imageExtension(MultipartFile photo)
    {
        String contentType = photo.getContentType();
        if (contentType == null) {
            throw new IllegalArgumentException("No se pudo determinar el formato de una imagen");
        }

        return switch (contentType.toLowerCase(Locale.ROOT)) {
            case "image/jpeg", "image/jpg" -> ".jpg";
            case "image/png" -> ".png";
            case "image/gif" -> ".gif";
            case "image/webp" -> ".webp";
            default -> throw new IllegalArgumentException("Formato de imagen no permitido: " + contentType);
        };
    }

    private void deleteUploadedFiles(List<Path> files, Exception failure)
    {
        for (Path file : files) {
            try {
                Files.deleteIfExists(file);
            } catch (IOException cleanupFailure) {
                failure.addSuppressed(cleanupFailure);
            }
        }
    }

    public Property crear(String email, String address, String type, Double nightPrice, int surface)
    {
        Optional<User> consulta = user_repo.findByEmail(email);
        if (consulta.isEmpty())
        {
            throw new IllegalArgumentException("El usuario con email " + email + " no existe");
        }

        return crear(consulta.get().getId(), address, type, nightPrice, surface);
    }
}
