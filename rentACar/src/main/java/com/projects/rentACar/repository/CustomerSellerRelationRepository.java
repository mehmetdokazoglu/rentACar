package com.projects.rentACar.repository;

import com.projects.rentACar.entities.CustomerSellerRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerSellerRelationRepository extends JpaRepository<CustomerSellerRelation, Integer>, JpaSpecificationExecutor<CustomerSellerRelation> {

    List<CustomerSellerRelation> findByCustomer_CustomerIdAndSeller_SellerId(Integer customerId, Integer sellerId);
}
