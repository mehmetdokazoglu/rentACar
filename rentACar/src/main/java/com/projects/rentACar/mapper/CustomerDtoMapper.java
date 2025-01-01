package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDtoMapper{

    public CustomerDto map(Customer customer){

        return new CustomerDto.Builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .userDto(new UserDtoMapper().map(customer.getUser()))
                .dateOfBirth(customer.getDateOfBirth())
                .build();
    }

    public List<CustomerDto> mapList(List<Customer> customers){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for(Customer customer : customers){
            customerDtoList.add(this.map(customer));
        }
        return customerDtoList;
    }

    public CustomerDto mapByOnlyCustomer(Customer customer){

        return new CustomerDto.Builder()
//                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .nationalIdentity(customer.getNationalIdentity())
                .build();
    }

    public List<CustomerDto> mapByOnlyCustomerList(List<Customer> customers){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for(Customer customer : customers){
            customerDtoList.add(this.map(customer));
        }
        return customerDtoList;
    }

    public Customer convertToEntityByOnlyCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
//        customer.setCustomerId(customerDto.getCustomerId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setNationalIdentity(customerDto.getNationalIdentity());
        return customer;
    }

    public Customer convertToEntityByOnlyId(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
//        customer.setFirstName(customerDto.getFirstName());
//        customer.setLastName(customerDto.getLastName());
//        customer.setDateOfBirth(customerDto.getDateOfBirth());
//        customer.setNationalIdentity(customerDto.getNationalIdentity());
        return customer;
    }
}
