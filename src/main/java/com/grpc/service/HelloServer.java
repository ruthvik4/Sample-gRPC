package com.grpc.service;

import hello.HelloRequest;
import hello.HelloResponse;
import hello.HelloServerGrpc.HelloServerImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServer extends HelloServerImplBase{

	@Override
	public void helloMethod(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
		HelloResponse response = HelloResponse.newBuilder().setGreet("Hi - "  + request.getName()).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	
}
