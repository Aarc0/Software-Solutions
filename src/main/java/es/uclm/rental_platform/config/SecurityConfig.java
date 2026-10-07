package es.uclm.rental_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //Ademas de esto para poder identificar correctamente a los usuarios se necesitara un UserDetailsServive
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            //auth es el configurador de reglas de acceso. El nombre es indiferente, se le entregan las reglas de la lamda expression
            .authorizeHttpRequests(auth -> auth //lambda expresion, dice que al objeto llamado auth se le aplican las siguientes reglas. 
                //Siendo estas las reglas
                .requestMatchers("/", "/error,/login,").permitAll()//Rutas permitidas a cualquiera
                .requestMatchers("/publish").authenticated()//Rutas que piden que el usario este autenticado
                .anyRequest().permitAll()//Regla general. Permite el resto de rutas
            )
            .formLogin(form -> form.loginPage("/login").permitAll());//Habilita el login hecho por el equipo.

        return http.build();
    }
}