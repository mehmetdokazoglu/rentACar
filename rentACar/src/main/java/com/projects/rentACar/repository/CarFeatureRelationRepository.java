package com.projects.rentACar.repository;

import com.projects.rentACar.entities.CarFeatureRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFeatureRelationRepository extends JpaRepository<CarFeatureRelation, Integer> {

    CarFeatureRelation findByCarFeatureRelationId(Integer carFeatureRelationId);

//    CarFeatureRelation findByFeature_FeatureId(Integer featureId);
//
//    CarFeatureRelation findByCar_CarId(Integer carId);

    CarFeatureRelation findByCar_CarIdAndFeature_FeatureId(Integer carId, Integer featureId);

}
