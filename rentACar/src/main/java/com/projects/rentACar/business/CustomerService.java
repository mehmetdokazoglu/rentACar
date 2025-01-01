package com.projects.rentACar.business;

import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.dtos.CustomerDtoFilterSpec;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.entities.Customer;

import javax.xml.crypto.Data;
import java.util.List;

public interface CustomerService {

    DataResult<CustomerDto> register(CustomerDto customerDto);
    DataResult<List<CustomerDto>> getAllCar();
    DataResult<CustomerDto> update(CustomerDto customerDto);
    String verify(UserDto userDto);
    Result delete(Integer customerId);
    DataResult<List<CustomerDto>> filter(CustomerDtoFilterSpec customerDtoFilterSpec);
}
