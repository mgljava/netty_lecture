package com.github.mgljava.proto3.grpc;

import com.github.mgljava.proto3.MyRequest;
import com.github.mgljava.proto3.MyResponse;
import com.github.mgljava.proto3.StudentServiceGrpc.StudentServiceImplBase;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceImplBase {

  @Override
  public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {

    final String username = request.getUsername();
    System.out.println("Service Got username is : " + username);

    final MyResponse sweepMonk = MyResponse.newBuilder()
        .setRealname("sweepMonk").build();

    responseObserver.onNext(sweepMonk);
    responseObserver.onCompleted();
  }

  @Override
  public void getStreamRealName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
    System.out.println("getStreamRealName method Got param : " + request.getUsername());
    responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
    responseObserver.onNext(MyResponse.newBuilder().setRealname("李四").build());
    responseObserver.onCompleted();
  }

  /**
   * 客户端流对象，服务端单个对象
   * @param responseObserver
   * @return
   */
  @Override
  public StreamObserver<MyRequest> getRealNameByStreamUsername(StreamObserver<MyResponse> responseObserver) {
    return new StreamObserver<MyRequest>() {
      @Override
      public void onNext(MyRequest value) {

      }

      @Override
      public void onError(Throwable t) {

      }

      @Override
      public void onCompleted() {
        responseObserver.onNext(MyResponse.newBuilder().setRealname("3 11").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("3 21").build());
        responseObserver.onCompleted();
      }
    };
  }

  @Override
  public StreamObserver<MyRequest> getStreamRealNameByStreamUsername(StreamObserver<MyResponse> responseObserver) {
    return null;
  }
}
