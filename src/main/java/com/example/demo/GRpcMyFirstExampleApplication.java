package com.example.demo;

import com.example.demo.service.MessageServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GRpcMyFirstExampleApplication {

    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new MessageServiceImpl())
                .build();
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }

}
