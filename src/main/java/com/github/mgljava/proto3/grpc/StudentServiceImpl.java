package com.github.mgljava.proto3.grpc;

import com.github.mgljava.proto3.MyRequest;
import com.github.mgljava.proto3.MyResponse;
import com.github.mgljava.proto3.StudentRequest;
import com.github.mgljava.proto3.StudentResponse;
import com.github.mgljava.proto3.StudentServiceGrpc.StudentServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.UUID;

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
   */
  @Override
  public StreamObserver<StudentRequest> getStudentByAges(StreamObserver<StudentResponse> responseObserver) {

    return new StreamObserver<StudentRequest>() {
      @Override
      public void onNext(StudentRequest value) {
        System.out.println(value.getAge());
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        responseObserver.onNext(StudentResponse.newBuilder()
            .setName("张三")
            .setAge(20)
            .setAddress("成都").build());
        responseObserver.onCompleted();
      }
    };
  }


  @Override
  public StreamObserver<StudentRequest> getStudentsByAges(StreamObserver<StudentResponse> responseObserver) {
    return new StreamObserver<StudentRequest>() {
      @Override
      public void onNext(StudentRequest value) {
        System.out.println("server get param : " + value.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName(UUID.randomUUID().toString())
            .setAge(value.getAge())
            .setAddress("北京").build());
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        responseObserver.onCompleted();
      }
    };
  }
}
