package com.projects.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carFeatureRelations", uniqueConstraints = {@UniqueConstraint(columnNames = {"carId", "featureId"})})
public class CarFeatureRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carFeatureRelationId")
    private Integer carFeatureRelationId;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "featureId")
    private Feature feature;
}
