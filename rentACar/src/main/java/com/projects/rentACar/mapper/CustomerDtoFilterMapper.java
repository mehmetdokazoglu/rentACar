package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.dtos.CustomerFilterDto;
import com.projects.rentACar.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDtoFilterMapper {

    public CustomerFilterDto map(Customer customer){

        return new CustomerFilterDto.Builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .build();
    }

    public List<CustomerFilterDto> mapList(List<Customer> customers){
        List<CustomerFilterDto> customerDtoList= new ArrayList<>();
        for(Customer customer : customers){
            customerDtoList.add(this.map(customer));
        }
        return customerDtoList;
    }

    public Customer convertToEntityByOnlyId(CustomerFilterDto customerFilterDto){
        Customer customer = new Customer();
        customer.setCustomerId(customerFilterDto.getCustomerId());
        return customer;
    }
}
