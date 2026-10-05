package es.uclm.rental_platform.domain;

import java.time.LocalDate;

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
import jakarta.persistence.Table;

@Entity 
@Table(name = "booking")
public class Booking {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY hace que el atributo id sea autoincremental 
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)// LAZY solo carga el objeto cuando se usa
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "renter_id")
    private Renter renter;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING) // Pillar los valores posibles del enum
    @Column(name = "cancel_policy", nullable = false)
    private CancelPolicy cancelPolicy;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private boolean paid;

    public Long getId() {
        return id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CancelPolicy getCancelPolicy() {
        return cancelPolicy;
    }

    public void setCancelPolicy(CancelPolicy cancelPolicy) {
        this.cancelPolicy = cancelPolicy;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }


    
}
