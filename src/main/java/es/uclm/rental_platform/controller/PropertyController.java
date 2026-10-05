package es.uclm.rental_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class PropertyController {

    @GetMapping("/publish")
    public String hola(){
        return "Primera prueba controller";
    }
}
