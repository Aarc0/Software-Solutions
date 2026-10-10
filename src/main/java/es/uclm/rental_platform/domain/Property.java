package es.uclm.rental_platform.domain;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Reflejar que un propietario puede tener una o muchas propiedades
    @ManyToOne(fetch = FetchType.LAZY)// LAZY solo carga el objeto cuando se usa
    @JoinColumn(name = "owner_id")
    private Owner owner;

    // Una propiedad puede tener una o muchas disponibilidades y reservas
    // Cascade se ocupa de propagar operaciones de padre a hijos y orphan de que no se quede ninguna fila de un objeto ya borrado
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Availability> availabilities = new ArrayList<>();

    
    @OneToMany(mappedBy = "property")
    private List<Booking> bookings = new ArrayList<>();
    

    @Column(nullable = false, unique = true)
    private String address;

    @Column(name = "night_price", nullable = false)
    private Double nightPrice;

    // Constructor getters y setters necesarios para la capa de aplicacion (service)
    protected Property() {
    }

    public Property(Owner owner, String address, Double nightPrice) {
        this.owner = owner;
        this.address = address;
        this.nightPrice = nightPrice;
    }

    public Long getId() {
     return id;
    }

    public Owner getOwner(){
      return owner;
    }

    public List<Availability> getAvailabilities(){
      return availabilities;
    }

    public List<Booking> getBookings(){
      return bookings;
    }

    public String getAddress(){
      return address;
    }

    public Double getNightPrice(){
      return nightPrice;
    }

    public void setOwner(Owner owner) {
      this.owner = owner;
    }

    public void setAvailabilities(List<Availability> availabilities) {
      this.availabilities = availabilities;
    }

    public void setBookings(List<Booking> bookings) {
      this.bookings = bookings;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public void setNightPrice(Double nightPrice) {
      this.nightPrice = nightPrice;
    }

}
