package es.uclm.rental_platform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.uclm.rental_platform.domain.User;
import es.uclm.rental_platform.repository.UserRepository;

@Service 
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepo;
    public CustomUserDetailsService(UserRepository userRepo){
        this.userRepo=userRepo;
    }

    @Override 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<User> consulta = userRepo.findByEmail(email);
        if(consulta.isEmpty()){
            throw new UsernameNotFoundException("No existe el usario " + email);
        }

        User user = consulta.get();

        // Authorities es la colección de roles/permisos; aquí contiene un único rol.
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Se asigna un único rol según el perfil asociado al usuario.
        if (user.isOwner()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_OWNER"));
        } else if (user.isRenter()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_RENTER"));
        } else {
            throw new UsernameNotFoundException("El usuario no tiene un perfil asignado: " + email);
        }

        // Devuelve a Spring Security los datos necesarios para autenticar al usuario.Devuelve un objeto de tipo userdetails
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPass())
                .authorities(authorities)
                .build();
    }
}
