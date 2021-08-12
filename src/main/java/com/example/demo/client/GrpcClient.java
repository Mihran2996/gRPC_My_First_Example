package com.example.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.build.grpc.MessageRequest;
import org.build.grpc.MessageResponse;
import org.build.grpc.MessageServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        MessageServiceGrpc.
                MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(channel);
        MessageResponse response = stub.hello(MessageRequest.newBuilder()
                .setMsg("Hello from client)")
                .build());
        System.out.println(response.getHello());
        channel.shutdown();
    }
}
