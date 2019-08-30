package com.github.mgljava.proto3.grpc;

import com.github.mgljava.proto3.MyRequest;
import com.github.mgljava.proto3.MyResponse;
import com.github.mgljava.proto3.StudentServiceGrpc;
import com.github.mgljava.proto3.StudentServiceGrpc.StudentServiceBlockingStub;
import com.github.mgljava.proto3.StudentServiceGrpc.StudentServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Iterator;

public class StudentServiceClient {

  public static void main(String[] args) {

    final ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext();
    final ManagedChannel channel = channelBuilder.build();
    final StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc.newBlockingStub(channel);

    final MyResponse sweep = studentServiceBlockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("sweep").build());

    final String realname = sweep.getRealname();
    System.out.println("realname is : " + realname);

    final Iterator<MyResponse> clientUsername = studentServiceBlockingStub
        .getStreamRealName(MyRequest.newBuilder().setUsername("client username").build());

    clientUsername.forEachRemaining(item -> System.out.println(item.getRealname()));

    final StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(channel);
    final StreamObserver<MyResponse> responseObserver = new StreamObserver<MyResponse>() {
      @Override
      public void onNext(MyResponse value) {
        System.out.println("client 3 : realName : " + value.getRealname());
      }

      @Override
      public void onError(Throwable t) {

      }

      @Override
      public void onCompleted() {

      }
    };
    final StreamObserver<MyRequest> realNameByStreamUsername = studentServiceStub.getRealNameByStreamUsername(responseObserver);
    realNameByStreamUsername.onCompleted();
  }
}
