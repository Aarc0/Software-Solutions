package es.uclm.rental_platform.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.uclm.rental_platform.repository.UserRepository;

@Configuration 
public class DataInitializer {
    @Bean 
    CommandLineRunner init(UserRepository userRepository){ // Creación de dato de prueba mediante el commandLineRuner
        return args -> {
            User user = new User("test@test.com", "trakatra", "Paco");
            user.becomeOwner();
            userRepository.save(user);
        };
    }
}
