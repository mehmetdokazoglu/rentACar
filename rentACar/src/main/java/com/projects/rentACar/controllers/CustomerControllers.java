package com.projects.rentACar.controllers;

import com.projects.rentACar.business.CustomerService;
import com.projects.rentACar.core.result.DataResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.dtos.CustomerDtoFilterSpec;
import com.projects.rentACar.dtos.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerControllers {

    private final CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<DataResult<CustomerDto>> register(@RequestBody @Valid CustomerDto customerDto) {
        DataResult<CustomerDto> result = customerService.register(customerDto);
        return new ResponseEntity<>(result, result.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        return customerService.verify(userDto);
    }

    @PreAuthorize("hasAuthority('MANAGE_CUSTOMER')")
    @GetMapping("/getAllCustomer")
    public DataResult<List<CustomerDto>> getAllCustomer(){
        return customerService.getAllCar();
    }

    @PreAuthorize("hasAuthority('MANAGE_OWN_PROFILE_CUSTOMER') and @customerRepository.findByUserId(#customerDto.userId) != null " +
            "and @customerRepository.findByUserId(#customerDto.userId).getUserId() == authentication.principal.userId")
    @PutMapping("/update")
    public DataResult<CustomerDto> update(@RequestBody CustomerDto customerDto){
        return customerService.update(customerDto);
    }

    @PreAuthorize("hasAuthority('MANAGE_OWN_PROFILE_CUSTOMER') and @customerRepository.findByUserId(#customerDto.userId) != null " +
            "and @customerRepository.findByUserId(#customerDto.userId).getUserId() == authentication.principal.userId")
    @DeleteMapping("/delete/{userId}")
    public Result delete(@PathVariable Integer userId){
        return customerService.delete(userId);
    }

    @PreAuthorize("hasAuthority('MANAGE_CUSTOMER')")
    @PostMapping("/filter")
    public DataResult<List<CustomerDto>> filter(@RequestBody CustomerDtoFilterSpec customerDtoFilterSpec){
        return customerService.filter(customerDtoFilterSpec);
    }
}
