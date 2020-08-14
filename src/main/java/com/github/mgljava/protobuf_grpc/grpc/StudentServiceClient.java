package com.github.mgljava.protobuf_grpc.grpc;

import com.github.mgljava.protobuf_grpc.MyRequest;
import com.github.mgljava.protobuf_grpc.MyResponse;
import com.github.mgljava.protobuf_grpc.StudentRequest;
import com.github.mgljava.protobuf_grpc.StudentResponse;
import com.github.mgljava.protobuf_grpc.StudentServiceGrpc;
import com.github.mgljava.protobuf_grpc.StudentServiceGrpc.StudentServiceBlockingStub;
import com.github.mgljava.protobuf_grpc.StudentServiceGrpc.StudentServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Iterator;

public class StudentServiceClient {

  public static void main(String[] args) throws InterruptedException {

    final ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext();
    final ManagedChannel channel = channelBuilder.build();
    final StudentServiceBlockingStub studentServiceBlockingStub = StudentServiceGrpc.newBlockingStub(channel);
    final StudentServiceStub sub = StudentServiceGrpc.newStub(channel);

    // 双方都是单个请求
    final MyResponse sweep = studentServiceBlockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("sweep").build());

    final String realname = sweep.getRealname();
    System.out.println("realname is : " + realname);

    System.out.println("--------------------------");

    // 客户端单个请求，服务端返回一个 stream 对象
    final Iterator<MyResponse> clientUsername = studentServiceBlockingStub
        .getStreamRealName(MyRequest.newBuilder().setUsername("client username").build());

    clientUsername.forEachRemaining(item -> System.out.println(item.getRealname()));

    System.out.println("-------------------------");

    // 客户端 stream 对象，服务端单个返回
    final StreamObserver<StudentRequest> studentsByAges = sub.getStudentsByAges(new StreamObserver<StudentResponse>() {
      @Override
      public void onNext(StudentResponse value) {
        System.out.println(value.getName());
        System.out.println(value.getAge());
        System.out.println(value.getAddress());
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        System.out.println("completed!");
      }
    });
    for (int i = 1; i < 10; i++) {
      studentsByAges.onNext(StudentRequest.newBuilder().setAge(i * 10).build());
    }
    studentsByAges.onCompleted();

    System.out.println("----------------------------");
    // 客户端和服务端都是 stream 对象
    StreamObserver<StudentResponse> streamObserver = new StreamObserver<StudentResponse>() {
      @Override
      public void onNext(StudentResponse value) {
        System.out.println("收到服务端信息，姓名： " + value.getName() + "， 年龄 ： " + value.getAge() + "，地址：" + value.getAddress());
      }

      @Override
      public void onError(Throwable t) {
        t.printStackTrace();
      }

      @Override
      public void onCompleted() {
        System.out.println("read completed!");
      }
    };
    final StreamObserver<StudentRequest> studentsByAges1 = sub.getStudentsByAges(streamObserver);
    for (int i = 1; i < 10; i++) {
      studentsByAges1.onNext(StudentRequest.newBuilder().setAge(i * 10).build());
      Thread.sleep(1000);
    }
    studentsByAges1.onCompleted();
    Thread.sleep(10000);
  }
}
