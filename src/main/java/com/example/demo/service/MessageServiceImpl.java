package com.example.demo.service;

import io.grpc.stub.StreamObserver;
import org.build.grpc.MessageRequest;
import org.build.grpc.MessageResponse;
import org.build.grpc.MessageServiceGrpc;

public class MessageServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {
    @Override
    public void hello(MessageRequest request, StreamObserver<MessageResponse> responseStreamObserver) {
        MessageResponse response = MessageResponse.newBuilder()
                .setHello("Hello from server)) ` " + request.getMsg())
                .build();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }
}
