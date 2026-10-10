// package es.uclm.rental_platform.service;

// import java.util.NoSuchElementException;

// import org.springframework.stereotype.Service;

// import es.uclm.rental_platform.domain.Owner;
// import es.uclm.rental_platform.domain.Property;
// import es.uclm.rental_platform.domain.User;
// import es.uclm.rental_platform.repository.PropertyRepository;
// import es.uclm.rental_platform.repository.UserRepository;

// @Service
// public class UserService {
// 	private final UserRepository user_repo;
// 	private final PropertyRepository property_repo;
	
// 	public UserService(UserRepository user_repo, PropertyRepository property_repo){
// 		this.user_repo = user_repo;
// 		this.property_repo = property_repo;
		
// 	}
// }
// 	public User crear(String email, String pass, String name){
// 		//en el try catch se verifica que no exista el usuario pa evitar duplicados
// 		try{
// 			if(user_repo.existByEmail(email)){
// 				throw new IllegalArgumentException("Este email ya esta registrado");
// 			}
// 		}
// 		User user = new User(email, pass, name);
// 		return user_repo.save(user);

// 		catch (IllegalArgumentException e){
// 			System.out.println("Error del correo");	
// 		}
// 	}
	
// }

