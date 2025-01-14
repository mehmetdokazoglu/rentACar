package com.projects.rentACar.repository;

import com.projects.rentACar.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findByAddressId(Integer addressId);

    Address findByApartmentNumber(String apartmentNumber);
}
