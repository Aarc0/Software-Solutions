package es.uclm.rental_platform.domain;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

  
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "night_price", nullable = false)
    private Double nightPrice;

    @Column(name = "bail", nullable = true)
    private Double bail;
  
    @Column(name = "surface", nullable = false)
    private Integer surface;

    @Column(name = "maxTravelers", nullable = true)
    private Integer maxTravelers;

    @Column(name = "beds", nullable = true)
    private Integer beds;

    @Column(name = "rooms", nullable = true)
    private Integer rooms;

    @Column(name = "baths", nullable = true)
    private Integer baths;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(nullable = false)
    private boolean elevator;

    @Column(nullable = false)
    private boolean garage;

    @Column(nullable = false)
    private boolean terrace;    

    @Column(nullable = false)
    private boolean pool;
    
    @Column(nullable = false)
    private boolean airCon;    
    
    @Column(nullable = false)
    private boolean heater;    
    
    @Column(nullable = false)
    private boolean furniture;
    
    @Column(nullable = false)
    private boolean wifi;
    
    @Column(nullable = false)
    private boolean basicServices;
    
    @Column(nullable = false)
    private boolean canSmoke;
    
    @Column(nullable = false)
    private boolean onlyGirls;
    
    @Column(nullable = false)
    private boolean onlyBoys;
    
    @Column(nullable = false)
    private boolean petsAllowed;

    // Constructor getters y setters necesarios para la capa de aplicacion (service)
    protected Property() {
    }

    public Property(Owner owner, String address, String type, Double nightPrice, Integer surface) {
        this.owner = owner;
        this.address = address;
        this.type = type;
        this.nightPrice = nightPrice;
        this.surface = surface;
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

    public String getType(){
      return type;
    }

    public Double getNightPrice(){
      return nightPrice;
    }

    public Double getBail(){
      return bail;
    }

    public Integer getSurface(){
      return surface;
    }

    public Integer getMaxTravelers(){
      return maxTravelers;
    }

    public Integer getBeds(){
      return beds;
    }

    public Integer getRooms(){
      return rooms;
    }

    public Integer getBaths(){
      return baths;
    }

    public String getDescription(){
      return description;
    }

    public boolean getElevator() {
      return elevator;
    }

    public boolean getGarage() {
      return garage;
    }

    public boolean getTerrace() {
      return terrace;
    }

    public boolean getPool() {
      return pool;
    }

    public boolean getAirCon() {
      return airCon;
    }

    public boolean getHeater() {
      return heater;
    }

    public boolean getFurniture() {
      return furniture;
    }

    public boolean getWifi() {
      return wifi;
    }

    public boolean getBasicServices() {
      return basicServices;
    }

    public boolean getCanSmoke() {
      return canSmoke;
    }

    public boolean getOnlyGirls() {
      return onlyGirls;
    }

    public boolean getOnlyBoys() {
      return onlyBoys;
    }

    public boolean getPetsAllowed() {
      return petsAllowed;
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

    public void setType(String type) {
      this.type = type;
    }

    public void setNightPrice(Double nightPrice) {
      this.nightPrice = nightPrice;
    }

    public void setBail(Double bail) {
        this.bail = bail;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public void setMaxTravelers(Integer maxTravelers) {
        this.maxTravelers = maxTravelers;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public void setTerrace(boolean terrace) {
        this.terrace = terrace;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public void setAirCon(boolean airCon) {
        this.airCon = airCon;
    }

    public void setHeater(boolean heater) {
        this.heater = heater;
    }

    public void setFurniture(boolean furniture) {
        this.furniture = furniture;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public void setBasicServices(boolean basicServices) {
        this.basicServices = basicServices;
    }

    public void setCanSmoke(boolean canSmoke) {
        this.canSmoke = canSmoke;
    }

    public void setOnlyGirls(boolean onlyGirls) {
        this.onlyGirls = onlyGirls;
    }

    public void setOnlyBoys(boolean onlyBoys) {
        this.onlyBoys = onlyBoys;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

}
