package es.uclm.rental_platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uclm.rental_platform.domain.Property;


public interface PropertyRepository extends JpaRepository<Property,Long>
{
    //Reescribo los métodos para que podamos saber de manera
    //más visual qué operaciones hay
    
    @Override 
    <S extends Property> S save(S entity); //INSERT / UPDATE entidad

    @Override
    Optional<Property> findById(Long id); //Busca entidad por su ID

    @Override
    List<Property> findAll();             //Lista con todas las entidades

    @Override
    void delete(Property entity);         //Elimina entidad específica se le pasa su objeto

    @Override
    void deleteById(Long id);             //Elimina entidad pasandole su ID

    @Override
    boolean existsById(Long id);          //Comprueba si existe una entidad con ese ID
    
}
