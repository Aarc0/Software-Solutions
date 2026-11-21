package es.uclm.rental_platform.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.service.PropertyService;

public class PropertyControllerTest {

    @Test
    void getPropertyConIdExistenteDevuelveDetalleConElInmuebleEnElModelo() throws Exception {
        // Arrange
        Long propertyId = 42L;
        Property property = new Property(null, "Calle Mayor 10", "Piso", 50.0, 60);
        PropertyService propertyService = mock(PropertyService.class);
        when(propertyService.findById(propertyId)).thenReturn(Optional.of(property));

        MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(new PropertyController(propertyService))
            // standaloneSetup no carga Thymeleaf; esta vista simulada permite
            // completar la petición sin intentar resolver la plantilla real.
            .setViewResolvers((viewName, locale) -> (model, request, response) -> { })
            .build();

        // Act y Assert
        mockMvc.perform(get("/property/{id}", propertyId))
            .andExpect(status().isOk())
            .andExpect(view().name("PropertyDetail"))
            .andExpect(model().attribute("property", property));

        verify(propertyService).findById(propertyId);
    }
}
