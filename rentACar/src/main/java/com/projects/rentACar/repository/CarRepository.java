package com.projects.rentACar.repository;

import com.projects.rentACar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findByCarId(Integer carId);
    Car findByCarName(String carName);
}
