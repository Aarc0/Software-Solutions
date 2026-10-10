package es.uclm.rental_platform.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
    //Constructor
    
    public PropertyService(PropertyRepository property_repo, UserRepository user_repo)
    {
        this.property_repo = property_repo;
        this.user_repo = user_repo;
    }
    
    public Property crear(Long ownerID, String address, Double nightPrice)
    {
        try 
        {
            //Primero verificamos si el dueño existe en la BBDD
            User user = user_repo.findById(ownerID).orElseThrow();   

            //Si el usuario existe, creamos una propiedad con el dueño y los detalles de la viviendia
            Property property = new Property(user.getOwner(), address, nightPrice);

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

    public Property crear(String email, String address, Double nightPrice)
    {
        Optional<User> consulta = user_repo.findByEmail(email);
        if (consulta.isEmpty())
        {
            throw new IllegalArgumentException("El usuario con email " + email + " no existe");
        }

        return crear(consulta.get().getId(), address, nightPrice);
    }
}
