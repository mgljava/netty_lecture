package com.github.mgljava.proto3;

import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

  @Override
  public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {

    final String username = request.getUsername();
    System.out.println("Service Got username is : " + username);

    MyResponse myResponse = MyResponse.newBuilder()
        .setRealname("monk").build();

    responseObserver.onNext(myResponse);
    responseObserver.onCompleted();
  }
}
