package com.projects.rentACar.payment.controller;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.payment.business.PaymentService;
import com.projects.rentACar.payment.dto.PaymentRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/creditCard")
@RequiredArgsConstructor
public class CreditCardPaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public Result pay(@Valid @RequestBody PaymentRequestDto paymentRequestDto){
        return paymentService.pay(paymentRequestDto);
    }
}
