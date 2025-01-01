package com.projects.rentACar.repository;

import com.projects.rentACar.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

    District findByDistrictId(Integer districtId);

    District findByDistrictName(String districtName);
}
