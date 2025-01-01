package com.projects.rentACar.repository;

import com.projects.rentACar.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
    
    Seller findBySellerId(Integer sellerId);

    Seller findByCompanyName(String companyName);

//    @Query("SELECT s from Seller s JOIN s.user u WHERE s.companyName =: companyName and u.email =:email AND u.userName =:userName")
//    List<Seller> findBySellerAndUser(String companyName, String email, String userName);
}
