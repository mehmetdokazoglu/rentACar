package com.projects.rentACar.mapper;

import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.entities.Customer;
import com.projects.rentACar.entities.User;
import com.projects.rentACar.entities.enums.Permission;
import com.projects.rentACar.entities.enums.Role;
import com.projects.rentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerDtoRegisterMapper {

    private final UserRepository userRepository;


    public CustomerDto map(Customer customer){

        return new CustomerDto.Builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .userDto(new UserDtoRegisterMapper().map(customer.getUser()))
                .dateOfBirth(customer.getDateOfBirth())
                .nationalIdentity(customer.getNationalIdentity())
                .build();
    }

    public List<CustomerDto> mapList(List<Customer> customers){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for(Customer customer : customers){
            customerDtoList.add(this.map(customer));
        }
        return customerDtoList;
    }

    public Customer convertToEntity(CustomerDto customerDto){


        User user = new UserDtoRegisterMapper().convertToEntity(customerDto.getUserDto());
        user.setRole(Role.CUSTOMER);
        user.setPermissions(Permission.getPermissionByRole(Role.CUSTOMER));
        user = userRepository.save(user);

        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setFirstName(customerDto.getFirstName().trim().toUpperCase());
        customer.setLastName(customerDto.getLastName().trim().toUpperCase());
        customer.setUser(user);
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setNationalIdentity(customerDto.getNationalIdentity());
        return customer;
    }

    public Customer convertToEntityByOnlyId(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        return customer;
    }
}
