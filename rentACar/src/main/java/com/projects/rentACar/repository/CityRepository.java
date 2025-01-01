package com.projects.rentACar.repository;

import com.projects.rentACar.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findByCityId(Integer cityId);

    City findByCityName(String cityName);
}
