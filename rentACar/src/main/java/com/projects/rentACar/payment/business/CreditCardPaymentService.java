package com.projects.rentACar.payment.business;

import com.projects.rentACar.core.result.ErrorResult;
import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.core.result.SuccessResult;
import com.projects.rentACar.payment.dto.PaymentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditCardPaymentService implements PaymentService {

    private final WebClient webClient;

    @Override
    public Mono<Result> pay(PaymentRequestDto paymentRequestDto) {
        if (paymentRequestDto == null) {
            return Mono.just(new ErrorResult("Lütfen kart bilgilerini eksiksiz giriniz"));
        }

        return webClient.post()
                .uri("/api/paymentConfirmation/processPayment")
                .bodyValue(paymentRequestDto)
                .retrieve()
                .bodyToMono(Result.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    return Mono.just(new ErrorResult("PaymentConfirmation servisine ulaşılamadı: " + ex.getMessage()));
                })
                .onErrorResume(Exception.class, ex -> {
                    return Mono.just(new ErrorResult("Beklenmedik bir hata oluştu: " + ex.getMessage()));
                })
                .flatMap(result -> {
                    if (!result.getSuccess()) {
                        return Mono.just(new ErrorResult("Ödeme işlemi başarısız: " + result.getMessage()));
                    }
                    return Mono.just(new SuccessResult("Ödeme başarılı"));
                });
    }
}
