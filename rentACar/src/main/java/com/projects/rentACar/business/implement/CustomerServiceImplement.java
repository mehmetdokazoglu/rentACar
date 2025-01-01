package com.projects.rentACar.business.implement;

import com.projects.rentACar.business.CustomerService;
import com.projects.rentACar.core.result.*;
import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.dtos.CustomerDtoFilterSpec;
import com.projects.rentACar.dtos.UserDto;
import com.projects.rentACar.entities.Customer;
import com.projects.rentACar.mapper.CustomerDtoFilterMapper;
import com.projects.rentACar.mapper.CustomerDtoMapper;
import com.projects.rentACar.mapper.CustomerDtoRegisterMapper;
import com.projects.rentACar.repository.CustomerRepository;
import com.projects.rentACar.specification.CustomerSpecification;
import com.projects.rentACar.validation.DateOfBirthValidation;
import com.projects.rentACar.validation.EmailValidation;
import com.projects.rentACar.validation.NationalIdentityValidation;
import com.projects.rentACar.validation.UserNameValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplement implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper customerDtoMapper;
    private final CustomerDtoRegisterMapper customerDtoRegisterMapper;

    private final NationalIdentityValidation nationalIdentityValidation;
    private final EmailValidation emailValidation;
    private final UserNameValidation userNameValidation;
    private final DateOfBirthValidation dateOfBirthValidation;
    @Autowired
    private UserAuthenticationService userAuthenticationService;


    @Override
    public DataResult<CustomerDto> register(CustomerDto customerDto) {

        Result result = new SuccessDataResult<>(null);
        if (customerDto == null || customerDto.getUserDto() == null) {
            return new ErrorDataResult<>(null, "Lütfen istenen bilgileri doldurunuz");
        }
        if (customerDto.getFirstName() == null || customerDto.getFirstName().isEmpty()) {
            return new ErrorDataResult<>(null, "Adınızı giriniz");
        }
        if (customerDto.getLastName() == null || customerDto.getLastName().isEmpty()) {
            return new ErrorDataResult<>(null, "Soyadınızı giriniz");
        }
        result = this.emailValidation.validate(customerDto.getUserDto());
        if (!result.getSuccess()) {
            return new ErrorDataResult<>(null, result.getMessage());
        }
        result = this.userNameValidation.validate(customerDto.getUserDto());
        if (!result.getSuccess()) {
            return new ErrorDataResult<>(null, result.getMessage());
        }
        result = this.nationalIdentityValidation.validate(customerDto);
        if (!result.getSuccess()) {
            return new ErrorDataResult<>(null, result.getMessage());
        }
        result = this.dateOfBirthValidation.validate(customerDto);
        if (!result.getSuccess()) {
            return new ErrorDataResult<>(null, result.getMessage());
        }
        return new SuccessDataResult<>(customerDtoRegisterMapper.map(customerRepository.save(customerDtoRegisterMapper.convertToEntity(customerDto))), "Müşteri eklendi");
    }

    @Override
    public String verify(UserDto userDto) {
        return userAuthenticationService.verify(userDto);
    }

    @Override
    public DataResult<List<CustomerDto>> getAllCar() {
        return new SuccessDataResult<>(customerDtoMapper.mapList(customerRepository.findAll()), "Müşteriler listelendi");
    }

    @Override
    public DataResult<CustomerDto> update(CustomerDto customerDto) {
        Customer resultCustomer = customerRepository.findByCustomerId(customerDto.getCustomerId());
        if (resultCustomer == null) {
            throw new NullPointerException("Müşteri bulunamadı");
        }
        return new SuccessDataResult<>(customerDtoRegisterMapper.map(customerRepository.save(customerDtoRegisterMapper.convertToEntity(customerDto))), "Müşteri güncellendi");
    }

    @Override
    public Result delete(Integer customerId) {

        if (customerRepository.findByCustomerId(customerId) == null) {
            return new ErrorResult("Böyle bir kullanıcı sistemde kayıtlı değil");
        }
        customerRepository.deleteById(customerId);
        return new SuccessResult("Kullanıcı başarıyla silindi");
    }

    @Override
    public DataResult<List<CustomerDto>> filter(CustomerDtoFilterSpec customerDtoFilterSpec) {
        List<Customer> customers = customerRepository.findAll(CustomerSpecification.filterBySpecification(customerDtoFilterSpec));
        if (customers.isEmpty()) {
            return new ErrorDataResult<>(null, "Böyle bir kullanıcı sistemde kayıtlı değil");
        }
        return new SuccessDataResult<>((customerDtoMapper.mapList(customers)), "Data listelendi");
    }
}



