package com.projects.rentACar.validation;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.core.result.SuccessResult;
import com.projects.rentACar.dtos.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class NationalIdentityValidation implements Validator<CustomerDto>{

    private static final String NATIONALIDENTITY_REGEX = "^[1-9][0-9]{10}$";

    @Override
    public Result validate(CustomerDto customerDto) {

        if(customerDto.getNationalIdentity() == null || customerDto.getNationalIdentity().isEmpty()){
            return new ErrorResult("Tc kimlik numaranızı giriniz");
        }
        if(!customerDto.getNationalIdentity().matches(NATIONALIDENTITY_REGEX)){
            return new ErrorResult("Tc kimlik numaranızı doğru formatta giriniz");
        }
        return new SuccessResult();
    }
}
