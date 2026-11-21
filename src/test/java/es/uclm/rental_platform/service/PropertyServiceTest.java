package es.uclm.rental_platform.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.repository.PropertyRepository;
import es.uclm.rental_platform.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {
    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private UserRepository userRepository;

    private PropertyService propertyService;

    @BeforeEach
    void setUp() {
        propertyService = new PropertyService(propertyRepository, userRepository, "uploads");
    }

    @Test
    void listDevuelveLasPropiedadesCuandoHayInmuebles() {
        //Arrange se preparan 2 propiedades como datos de prueba
        Property primera = new Property(null, "Calle Mayor", "Piso", 50.0, 60);
        Property segunda = new Property(null, "Avenida España", "Casa", 75.0, 90);
        List<Property> propiedades = List.of(primera, segunda);

        when(propertyRepository.findAll()).thenReturn(propiedades);

        //Act se llama al método a comprobar
        List<Property> resultado = propertyService.list();

        //Assert comprueba el resultado
        assertEquals(propiedades, resultado);
        //assertEquals(List.of(primera), resultado);
        verify(propertyRepository).findAll();
    }

    @Test 
    void listDevuelveListaVaciaCuandoNoHayInmuebles(){
        //Arrange

        when(propertyRepository.findAll()).thenReturn(List.of());

        //Act se llama al método a comprobar
        List<Property> resultado = propertyService.list();

        //Assert
        assertTrue(resultado.isEmpty());
        verify(propertyRepository).findAll();
    }




}
