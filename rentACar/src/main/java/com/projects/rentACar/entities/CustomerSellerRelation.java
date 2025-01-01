package com.projects.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customerSellerRelations", uniqueConstraints = {@UniqueConstraint(columnNames = {"customerId", "sellerId"})})
public class CustomerSellerRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerSellerRelationId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "sellerId")
    private Seller seller;
}
