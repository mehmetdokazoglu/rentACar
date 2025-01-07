//package com.projects.rentACar.config;
//
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class GrpcServer {
//
//    private final int port = 8081;
//    private Server server;
//
//    public void start() throws Exception {
//        // Sunucuyu başlatıyoruz
//        server = ServerBuilder.forPort(port)
//                .addService(new PaymentConfirmationServiceImpl())  // PaymentConfirmationServiceImpl servisi ekleniyor
//                .build()
//                .start();
//
//        System.out.println("gRPC Server started, listening on port " + port);
//        server.awaitTermination();
//    }
//
//    public void stop() {
//        if (server != null) {
//            server.shutdown();
//        }
//    }
//}
