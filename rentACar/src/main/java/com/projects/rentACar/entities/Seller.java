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
@Table(name = "sellers")
public class Seller{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sellerId")
    private Integer sellerId;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "companyName", unique = true)
    private String companyName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "seller")
    private List<Address> addresses;

    @OneToMany(mappedBy = "seller")
    private List<CarSellerRelation> sellerRelations;

    @OneToMany(mappedBy = "seller")
    private List<CustomerSellerRelation> customerSellerRelations;

}
