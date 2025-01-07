package com.projects.rentACar.payment.business;

import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.payment.dto.PaymentRequestDto;
import reactor.core.publisher.Mono;

public interface PaymentService {

    Mono<Result> pay(PaymentRequestDto paymentRequestDto);
}
