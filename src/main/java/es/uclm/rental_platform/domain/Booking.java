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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
