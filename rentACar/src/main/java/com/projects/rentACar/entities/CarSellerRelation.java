package com.projects.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carSellerRelations", uniqueConstraints = {@UniqueConstraint(columnNames = {"carId", "sellerId"})})
public class CarSellerRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carSellerRelationId")
    private Integer carSellerRelationId;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Seller seller;
}
