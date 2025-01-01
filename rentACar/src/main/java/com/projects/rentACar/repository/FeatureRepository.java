package com.projects.rentACar.repository;

import com.projects.rentACar.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {

    Feature findByFeatureId(Integer featureId);

    Feature findByFeature(String feature);
}
