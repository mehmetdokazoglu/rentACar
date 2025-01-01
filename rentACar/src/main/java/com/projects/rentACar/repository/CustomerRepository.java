package com.projects.rentACar.repository;

import com.projects.rentACar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {

    Customer findByCustomerId(Integer customerId);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    Customer findByUser_Email(String email);

    Customer findByUser_UserName(String userName);

    Customer findByNationalIdentity(String nationalIdentity);
}
