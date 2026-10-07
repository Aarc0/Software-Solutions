package es.uclm.rental_platform.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.service.PropertyService;

@Controller 
public class PropertyController {

    //Objeto a utilizar para ayudar a llevar una traza de la comunicacion. Aparecera en la terminal
    private static final Logger logger =LoggerFactory.getLogger(PropertyController.class);

    //Creacion del service
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/publish")
    public String formulary(){

        logger.info("GET /publish recibido correctamente");
        return "Formulary";
    }

    @PostMapping("/publish") //Cuando se de a publicar inmueble se haga el post. Usar service para enviar datos a dom
    public String publishProperty(Property property){
        String addres = property.getAddress();
        double nightPrice = property.getNightPrice();

        //propertyService.crear(owner, addres, nightPrice);
        logger.info("POST /publish recibido correctamente");
        return "redirect:/"; //Redirige al home.html
    }

    //Adicion de exceptionHandler para controlar errores. Muy general

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e){
        logger.error("Se ha producido un error ", e);

        return "error"; //html que aparece cuando se produc un error

    }
}
