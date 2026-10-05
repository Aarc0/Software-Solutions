package es.uclm.rental_platform.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false) // String normal, pero se ha de hashear
    private String pass;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String lastName;

    @Column(nullable = true)
    private String address;

    // Roles, si no tiene el roll entonces null
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Owner owner;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Renter renter;
    
    // Constructor getters y setters necesarios para la capa de aplicacion (service)
    protected User(){

    }
    
    public User(String email, String pass, String name){
        this.email = email;
        this.pass = pass;
        this.name = name;
    }

    // Falta Documentar
    // Establecer Roles
    public Owner becomOwner(){
        if(owner == null) owner = new Owner(this);
        return owner;
    }

    public Renter becomeRenter(){
        if(renter == null) renter = new Renter(this);
        return renter;
    }
    
    // Comprobar Roles
    public boolean isOwner(){
        return owner != null;
    }

    public boolean isRenter(){
        return renter != null;
    }

    public Long getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public Owner getOwner() {
        return owner;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) { 
        this.address = address; 
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}