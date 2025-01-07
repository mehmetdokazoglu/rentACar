package com.projects.rentACar.payment.business;

import com.projects.rentACar.core.result.Result;
import com.projects.rentACar.payment.dto.PaymentRequestDto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;
//
//@Service
//public class GrpcPaymentService implements PaymentService{

//    private final PaymentValidationServiceGrpc.PaymentValidationServiceBlockingStub paymentStub;
//
//    public GrpcPaymentService() {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
//                .usePlaintext()
//                .build();
//        paymentStub = PaymentValidationServiceGrpc.newBlockingStub(channel);
//    }
//
//
//    @Override
//    public Result pay(PaymentRequestDto paymentRequestDto) {
//        PaymentRequest request = PaymentRequest.newBuilder()
//                .setCardHolderName(paymentRequestDto.getCardHolderName())
//                .setCardNumber(paymentRequestDto.getCardNumber())
//                .setCvvCode(paymentRequestDto.getCvvCode())
//                .setExpirationDate(paymentRequestDto.getExpirationDate())
//                .build();
//
//        // gRPC servisine istek gönderiliyor
//        PaymentResponse response = paymentStub.processPayment(request);
//
//        // Sonuç döndürülüyor
//        return new Result(response.getSuccess(), response.getMessage());
//    }
//    }
//}
