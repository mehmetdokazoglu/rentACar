package com.projects.rentACar.validation;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.core.result.SuccessResult;
import com.projects.rentACar.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class EmailValidation implements Validator<UserDto>{

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    @Override
    public Result validate(UserDto userDto) {

        if(userDto.getEmail() == null || userDto.getEmail().isEmpty()){
            return new ErrorResult("Email alanını boş bırakmayınız");
        }
        if(!userDto.getEmail().matches(EMAIL_REGEX)){
            return new ErrorResult("Emailinizi email formatında giriniz. Örnek: example@domain.com");
        }
        return new SuccessResult();
    }
}
