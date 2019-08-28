package com.github.mgljava.proto3;

import com.github.mgljava.proto3.StudentServiceGrpc.StudentServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class StudentServiceClient {

  public static void main(String[] args) {

    final ManagedChannelBuilder<?> managedChannelBuilder = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext();
    final ManagedChannel channel = managedChannelBuilder.build();
    final StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc.newBlockingStub(channel);

    final MyResponse sweep = studentServiceBlockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("sweep").build());

    final String realname = sweep.getRealname();
    System.out.println("realname is : " + realname);
  }
}
