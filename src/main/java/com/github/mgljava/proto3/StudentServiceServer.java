package com.github.mgljava.proto3;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class StudentServiceServer {

  public static void main(String[] args) throws Exception {

    Server server = ServerBuilder.forPort(8090).addService(new StudentServiceImpl()).build();
    server.start();
    System.out.println("Server started, listening on " + 8090);
    server.awaitTermination();
  }
}
