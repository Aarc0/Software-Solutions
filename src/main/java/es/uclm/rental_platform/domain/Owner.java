package es.uclm.rental_platform.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "owner")
public class Owner {
    @Id 
    private Long id; // conservar la primary key del user(sin crear una nueva)

    // user_id primary key y foreign key a la vez
    @OneToOne(fetch = FetchType.LAZY)// LAZY solo carga el objeto cuando se usa
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    // Un propietario puede tener uno o muchos inmuebles
    @OneToMany(mappedBy = "owner")
    private List<Property> properties = new ArrayList<>();

    // Constructor getters y setters necesarios para la capa de aplicacion (service)
    protected Owner(){

    }

    public Owner(User user){
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public List<Property> getProperties(){
        return properties;
    }

    public void setProperties(List<Property> properties)
    {
        this.properties = properties;
    }
}
