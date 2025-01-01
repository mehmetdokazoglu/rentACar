package com.projects.rentACar.payment.business;

import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.payment.dto.PaymentRequestDto;

public interface PaymentService {

    Result pay(PaymentRequestDto paymentRequestDto);
}
