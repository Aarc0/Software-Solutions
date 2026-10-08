package es.uclm.rental_platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uclm.rental_platform.domain.User;


public interface UserRepository extends JpaRepository<User,Long>
{

    //Reescribo los métodos para que podamos saber de manera
    //más visual qué operaciones hay
    boolean existsByEmail(String email);

    @Override 
    <S extends User> S save(S entity); //INSERT / UPDATE entidad

    Optional<User> findByEmail(String email); //Necesario para verificar el inicio de sesion

    @Override
    Optional<User> findById(Long id);

    @Override
    List<User> findAll();

    @Override
    void delete(User entity);         //Elimina entidad específica se le pasa su objeto

    @Override
    void deleteById(Long id);             //Elimina entidad pasandole su ID

    @Override
    boolean existsById(Long id);          //Comprueba si existe una entidad con ese ID

}
