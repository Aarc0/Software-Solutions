package es.uclm.rental_platform.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.uclm.rental_platform.service.PropertyService;


@Controller 
public class HomeController {
    
    private final PropertyService propertyService;


    public HomeController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @GetMapping("/")
    public String home(){
        return "home";
    }
     @GetMapping("/login")
    public String login(){
        return "login";
  
    }@GetMapping("/Register")
    public String Register(){
        return "Register";
    }
    
    @GetMapping("/Formulary")
    public String Formulary(){
        return "Formulary";
    }

    @GetMapping("/List")
    public String List(Model model){
        model.addAttribute("properties", propertyService.list());
        return "List";
    }
    
}
