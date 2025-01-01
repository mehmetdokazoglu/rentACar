package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRelationDtoMapper {

    public CustomerDto map(Customer customer){

        return new CustomerDto.Builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .userDto(new UserDtoMapperByOnlyUsername().map(customer.getUser()))
                .build();
    }

    public List<CustomerDto> mapList(List<Customer> customers){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for(Customer customer : customers){
            customerDtoList.add(this.map(customer));
        }
        return customerDtoList;
    }

    public Customer convertToEntityByOnlyId(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerId(customer.getCustomerId());
        return customer;
    }
}
