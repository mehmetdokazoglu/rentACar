package com.projects.rentACar.validation;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.core.result.SuccessResult;
import com.projects.rentACar.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserNameValidation implements Validator<UserDto> {

    @Override
    public Result validate(UserDto userDto) {

        if(userDto.getUserName() == null || userDto.getUserName().isEmpty()){
            return new ErrorResult("Kullanıcı adınızı giriniz");
        }
        if(!(userDto.getUserName().length() >= 6)){
            return new ErrorResult("Kullanıcı adı en az 6 karakterden oluşmalıdır");
        }
        return new SuccessResult();
    }
}
