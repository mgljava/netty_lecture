package com.github.mgljava.proto3.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class StudentServiceServer {

  public static void main(String[] args) throws Exception {

    Server server = ServerBuilder.forPort(8090).addService(new StudentServiceImpl()).build();
    server.start();
    System.out.println("Server started, listening on " + 8090);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      server.shutdown();
      System.err.println("*** server shut down");
    }));

    server.awaitTermination();
  }
}
