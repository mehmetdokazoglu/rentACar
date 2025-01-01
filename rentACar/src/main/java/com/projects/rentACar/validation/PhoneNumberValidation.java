package com.projects.rentACar.validation;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.core.result.SuccessResult;
import com.projects.rentACar.dtos.SellerDto;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberValidation implements Validator<SellerDto> {

    private static final String PHONENUMBER_REGEX = "^0\\d{10}$";

    @Override
    public Result validate(SellerDto sellerDto) {

        if(sellerDto.getPhoneNumber() == null || sellerDto.getPhoneNumber().isEmpty()){
            return new ErrorResult("Şirketinize ait telefon numarasını giriniz");
        }
        if(!sellerDto.getPhoneNumber().matches(PHONENUMBER_REGEX)){
            return new ErrorResult("Telefon numaranızı doğru bir formatta giriniz.");
        }
        return new SuccessResult();
    }
}
