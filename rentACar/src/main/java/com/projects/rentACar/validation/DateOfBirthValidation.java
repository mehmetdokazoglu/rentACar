package com.projects.rentACar.validation;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.core.result.SuccessResult;
import com.projects.rentACar.dtos.CustomerDto;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class DateOfBirthValidation implements Validator<CustomerDto>{

    private final static String DATEOFBIRTH_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    @Override
    public Result validate(CustomerDto customerDto) {
        if(customerDto.getDateOfBirth() == null ){
            return new ErrorResult("Doğum tarihini giriniz");
        }
        String convertToString = customerDto.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE);
        if(!convertToString.matches(DATEOFBIRTH_REGEX)){
            return new ErrorResult("Doğum tarihinizi doğru formatta giriniz. Örneğin: yyyy-MM-dd");
        }
        return new SuccessResult();
    }
}
