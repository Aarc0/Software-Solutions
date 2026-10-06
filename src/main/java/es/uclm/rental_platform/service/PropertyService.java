package es.uclm.rental_platform.service;

import java.util.NoSuchElementException;

import es.uclm.rental_platform.domain.Owner;
import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.domain.User;
import es.uclm.rental_platform.repository.PropertyRepository;
import es.uclm.rental_platform.repository.UserRepository;

public class PropertyService 
{
    private final PropertyRepository property_repo;
    private final UserRepository user_repo;
    //Constructor
    public PropertyService(PropertyRepository property_repo, UserRepository user_repo)
    {
        this.property_repo = property_repo;
        this.user_repo = user_repo;
    }

    public Property crear(Owner owner, String address, Double nightPrice)
    {
        //Primero verificamos si el dueño existe en la BBDD
        try 
        {
            User user = user_repo.findById(owner.getId()).orElseThrow();    
        } 
        catch (NoSuchElementException e) 
        {
            throw new IllegalArgumentException("El usuario que se ha intentado obtener no existe");
        }

        return new Property(owner, address, nightPrice);
    }



}
