package com.projects.rentACar.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {

    @NotBlank(message = "Lutfen kart sahibinin adini ve soyadini giriniz")
    private String cardHolderName;

    @NotBlank(message = "Lutfen kart numaranizi giriniz")
    private String cardNumber;

    @NotBlank(message = "Lutfen cvv kodunu giriniz")
    private String cvvCode;

    @NotNull(message = "Lutfen son kullanma tarihi alanini giriniz")
    private LocalDate expirationDate;
}
