package es.uclm.rental_platform.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import es.uclm.rental_platform.service.PropertyService;

class HomeControllerTest {

    @Test
    void getListDevuelveLaVistaList() throws Exception {
        PropertyService propertyService = mock(PropertyService.class);
        when(propertyService.list()).thenReturn(List.of());

        MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(new HomeController(propertyService))
            .setViewResolvers((viewName, locale) -> (model, request, response) -> { })
            .build();

        mockMvc.perform(get("/List"))
            .andExpect(status().isOk())
            .andExpect(view().name("List"))
            .andExpect(model().attribute("properties", List.of()));

        verify(propertyService).list();
    }
}
