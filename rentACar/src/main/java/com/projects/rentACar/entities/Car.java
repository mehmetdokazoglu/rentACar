package com.projects.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Integer carId;

    @Column(name = "carName", unique = true)
    private String carName;

    @Column(name = "vehicleProductionDate")
    private LocalDate vehicleProductionDate;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "car")
    private List<CarSellerRelation> carSellerRelations;

    @OneToMany(mappedBy = "car")
    private List<CarFeatureRelation> carFeatureRelations;
}
