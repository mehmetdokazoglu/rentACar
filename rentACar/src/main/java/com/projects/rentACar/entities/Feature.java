package com.projects.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "featureId")
    private Integer featureId;

    @Column(name = "feature", unique = true)
    private String feature;

    @OneToMany(mappedBy = "feature")
    private List<CarFeatureRelation> carFeatureRelations;
}
