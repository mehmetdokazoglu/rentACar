package com.projects.rentACar.payment.business;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.core.result.SuccessResult;
import com.projects.rentACar.payment.dto.PaymentRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentService implements PaymentService{

    @Override
    public Result pay(PaymentRequestDto paymentRequestDto) {
        if(paymentRequestDto == null){
                return new ErrorResult("Lütfen kart bilgilerinizi eksiksiz giriniz");
        }
        return new SuccessResult("Ödeme işlemi başarılı");
    }
}
