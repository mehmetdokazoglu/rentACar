package com.projects.rentACar.repository;

import com.projects.rentACar.entities.CarSellerRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarSellerRelationRepository extends JpaRepository<CarSellerRelation, Integer> , JpaSpecificationExecutor<CarSellerRelation> {

    CarSellerRelation findByCarSellerRelationId(Integer carSellerRelationId);

    List<CarSellerRelation> findBySeller_CompanyName(String companyName);
}
