package com.example.paymentservice.service;

import com.example.paymentservice.grpc.PaymentRequest;
import com.example.paymentservice.grpc.PaymentResponse;
import com.example.paymentservice.grpc.PaymentServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@AllArgsConstructor
@GrpcService
public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase {

    @Override
    public void processPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
        PaymentResponse response = PaymentResponse.newBuilder()
                .setSuccess(true)
                .setTransactionId("txn_" + System.currentTimeMillis())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
