package es.uclm.rental_platform.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import es.uclm.rental_platform.domain.Owner;
import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.domain.User;
import es.uclm.rental_platform.repository.PropertyRepository;
import es.uclm.rental_platform.repository.UserRepository;

@service
public class UserService {
	private final UserRepository user_repo;
	private final PropertyRepository property_repo;
	
	public UserService(UserRepository user_repo, PropertyRepository property_repo){
		this.user_repo = user_repo;
		this.property_repo = property_repo;
		
	}
	public User crear(String email, String pass, String name){
		try{
			//falta try-catch
		}catch (NoSuchElementException e)
		{
		
		}
	}
	
}
