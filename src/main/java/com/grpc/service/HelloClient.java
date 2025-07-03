package com.grpc.service;

import hello.HelloRequest;
import hello.HelloResponse;
import hello.HelloServerGrpc;
import hello.HelloServerGrpc.HelloServerBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient{
	public static void main(String[] args) {
		// Connect to gRPC server running locally on port 9090
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // Disable TLS (for testing only)
                .build();
        
        HelloServerBlockingStub stub = HelloServerGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setName("First Project").build();
        
        HelloResponse response = stub.helloMethod(request);
        
        System.out.println("HelloClient.main() :: " + response.getGreet());
        
        channel.shutdown();
        

	}

}
