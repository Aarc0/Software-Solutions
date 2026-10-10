package es.uclm.rental_platform.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.uclm.rental_platform.repository.UserRepository;
import es.uclm.rental_platform.repository.PropertyRepository;


@Configuration 
public class DataInitializer 
{
    @Bean 
    CommandLineRunner init(UserRepository userRepository, PropertyRepository propertyRepository)
    { // Creación de dato de prueba mediante el commandLineRuner
        return args -> {
            User u1 = new User("p1@test.com", "pass", "ana");
            u1.becomeOwner();
            userRepository.save(u1);

            User u2 = new User("p2@test.com","pass","ricardo");
            u2.becomeOwner();
            userRepository.save(u2);

            User u3 = new User("p3@test.com", "pass", "miguel");
            u3.becomeRenter();
            userRepository.save(u3);

            User u4 = new User("p4@test.com","pass","marios");
            u4.becomeRenter();
            userRepository.save(u4);

            Property p1 = new Property(u1.getOwner(),"Calle constitucion",(double)2);
            propertyRepository.save(p1);

            Property p2 = new Property(u1.getOwner(),"Calle hidalgo",(double)4);
            propertyRepository.save(p2);

            Property p3 = new Property(u2.getOwner(),"Calle carlos III",(double)6);
            propertyRepository.save(p3);

            Property p4 = new Property(u2.getOwner(),"Calle aguacate",(double)8);
            propertyRepository.save(p4);

            

        };
    }
}
