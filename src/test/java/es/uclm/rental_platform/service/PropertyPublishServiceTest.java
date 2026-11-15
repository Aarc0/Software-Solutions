package es.uclm.rental_platform.service;

// el framework de pruebas 
import org.junit.jupiter.api.Test;        // @Test: marca un método como prueba
import org.junit.jupiter.api.BeforeEach;  // @BeforeEach: se ejecuta antes de CADA test
import org.junit.jupiter.api.io.TempDir;  // @TempDir: carpeta temporal que se borra sola al terminar
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.assertEquals;  // Assert: compara valor esperado y real
import static org.junit.jupiter.api.Assertions.assertThrows;  // Assert: comprueba que se lanza una excepción

// crear clones de los objetos
import static org.mockito.Mockito.mock;   // crea un repositorio falso, sin base de datos
import static org.mockito.Mockito.when;   // define qué responde el falso ("cuando te llamen, devuelve...")
import static org.mockito.Mockito.verify; // comprueba si se llamó a un método y cuántas veces
import static org.mockito.Mockito.never;  // "nunca": se usa dentro de verify
import static org.mockito.ArgumentMatchers.any; // "cualquier argumento", para no concretar el valor
import static org.mockito.ArgumentMatchers.nullable;

import org.springframework.mock.web.MockMultipartFile; // archivo subido falso: nombre, tipo y contenido


import java.io.File;   
import java.util.List;

import es.uclm.rental_platform.domain.Property; 
import es.uclm.rental_platform.domain.Owner;               
import es.uclm.rental_platform.repository.PropertyRepository;  
import es.uclm.rental_platform.repository.UserRepository;      

class PropertyPublishServiceTest 
{
    @TempDir 
    File uploadSimulado;

    //!Arrange
    private final Property property = new Property(null, "calle 1", "piso", 50.0, 80);
    private PropertyRepository propertyRepo;
    private PropertyService service;

    //Como comenté esto es para que se ejecute antes de cada @Test
    @BeforeEach 
    void setUp()
    {
        //Crea la copia del PropertyRepository y guarda que pueda usar los distintos métodos como save, finAll...
        propertyRepo = mock(PropertyRepository.class);


        // por defecto devuelve un valor vacío según el tipo (null para objetos, 0, false,
        // colección vacía u Optional.empty). Como el servicio devuelve lo que le da save(),
        // le indicamos al mock que devuelva el mismo objeto que recibe, igual que el real.
        // Solo hace falta cuando el test comprueba el valor devuelto (CP-01 y CP-02).
        when(propertyRepo.save(any(Property.class))).thenAnswer(inv -> inv.getArgument(0));


        //Se llama al constructor de PropertyService para crear el servicio real a usar
        //PropertyRepo son los métodos de la base de datos
        //UserRepository se crea un falso aunque no se use aún en el service
        //La ruta a la carpeta temporal
        service = new PropertyService(propertyRepo,mock(UserRepository.class), uploadSimulado.getPath());
    }

    @Test //?CP-01 
    void shouldAcceptPropertyWhenNotProvidingPhotos()
    {
        //!Act
        Property resultado = service.crear(property,List.of());

        //!Assert
        assertEquals(property, resultado);
        verify(propertyRepo).save(property);
    }

    @Test //?CP-02
    void shouldAcceptPropertyWhenProvidingPhotos() 
    {

        //Nombre del archivo
        //Nombre original del archivo
        //Tipo del archivo
        //Contenido del archivo
        MockMultipartFile fotos = new MockMultipartFile("fotos", "foto.png","image/png",new byte[]{1});
        
        //!Act
        Property resultado = service.crear(property,List.of(fotos));

        //!Assert
        assertEquals(property, resultado);      //confirma que el servicio devuelve o no el inmueble
        assertEquals(1, resultado.getPhotos().size()); //Confirma que a la propiedad añadida se la hayan añadido las fotos
        assertEquals(1, uploadSimulado.list().length); //Comprueba que el archivo se haya escrito en disco
        verify(propertyRepo).save(property); //Verifica que a propertyRepo se le llamo una vez a save pasandole una propiedad 
    }

    @Test //?CP-03
    void shouldRejectPropertyWhenProvidingPhotosWithWrongFormat()
    {
        MockMultipartFile archivo = new MockMultipartFile("archivo", "archivo.pdf","application/pdf",new byte[]{1});

        //!Assert
        assertThrows(IllegalArgumentException.class, () -> service.crear(property,List.of(archivo)));

        //Verifica que a propertyRepo nunca se le llamo a save con cualquier
        verify(propertyRepo,never()).save(any());
        assertEquals(0, uploadSimulado.list().length); //Comprueba que no se ha escrito nada en disco
    }



    


}