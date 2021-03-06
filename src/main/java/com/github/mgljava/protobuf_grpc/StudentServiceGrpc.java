package com.github.mgljava.protobuf_grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {
  }

  public static final String SERVICE_NAME = "guide.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealNameByUsername",
      requestType = MyRequest.class,
      responseType = MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<MyRequest, MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod =
              io.grpc.MethodDescriptor.<MyRequest, MyResponse>newBuilder()
                  .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                  .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealNameByUsername"))
                  .setSampledToLocalTracing(true)
                  .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      MyRequest.getDefaultInstance()))
                  .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getRealNameByUsername"))
                  .build();
        }
      }
    }
    return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetStreamRealNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStreamRealName",
      requestType = MyRequest.class,
      responseType = MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetStreamRealNameMethod() {
    io.grpc.MethodDescriptor<MyRequest, MyResponse> getGetStreamRealNameMethod;
    if ((getGetStreamRealNameMethod = StudentServiceGrpc.getGetStreamRealNameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStreamRealNameMethod = StudentServiceGrpc.getGetStreamRealNameMethod) == null) {
          StudentServiceGrpc.getGetStreamRealNameMethod = getGetStreamRealNameMethod =
              io.grpc.MethodDescriptor.<MyRequest, MyResponse>newBuilder()
                  .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                  .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStreamRealName"))
                  .setSampledToLocalTracing(true)
                  .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      MyRequest.getDefaultInstance()))
                  .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getStreamRealName"))
                  .build();
        }
      }
    }
    return getGetStreamRealNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentByAges",
      requestType = StudentRequest.class,
      responseType = StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentByAgesMethod() {
    io.grpc.MethodDescriptor<StudentRequest, StudentResponse> getGetStudentByAgesMethod;
    if ((getGetStudentByAgesMethod = StudentServiceGrpc.getGetStudentByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentByAgesMethod = StudentServiceGrpc.getGetStudentByAgesMethod) == null) {
          StudentServiceGrpc.getGetStudentByAgesMethod = getGetStudentByAgesMethod =
              io.grpc.MethodDescriptor.<StudentRequest, StudentResponse>newBuilder()
                  .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
                  .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentByAges"))
                  .setSampledToLocalTracing(true)
                  .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      StudentRequest.getDefaultInstance()))
                  .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentByAges"))
                  .build();
        }
      }
    }
    return getGetStudentByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentsByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsByAges",
      requestType = StudentRequest.class,
      responseType = StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentsByAgesMethod() {
    io.grpc.MethodDescriptor<StudentRequest, StudentResponse> getGetStudentsByAgesMethod;
    if ((getGetStudentsByAgesMethod = StudentServiceGrpc.getGetStudentsByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentsByAgesMethod = StudentServiceGrpc.getGetStudentsByAgesMethod) == null) {
          StudentServiceGrpc.getGetStudentsByAgesMethod = getGetStudentsByAgesMethod =
              io.grpc.MethodDescriptor.<StudentRequest, StudentResponse>newBuilder()
                  .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                  .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentsByAges"))
                  .setSampledToLocalTracing(true)
                  .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      StudentRequest.getDefaultInstance()))
                  .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                      StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentsByAges"))
                  .build();
        }
      }
    }
    return getGetStudentsByAgesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   *
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     *
     */
    public void getRealNameByUsername(MyRequest request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     *
     */
    public void getStreamRealName(MyRequest request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStreamRealNameMethod(), responseObserver);
    }

    /**
     *
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentByAges(
        io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentByAgesMethod(), responseObserver);
    }

    /**
     *
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentsByAges(
        io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentsByAgesMethod(), responseObserver);
    }

    @Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetRealNameByUsernameMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      MyRequest,
                      MyResponse>(
                      this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
              getGetStreamRealNameMethod(),
              asyncServerStreamingCall(
                  new MethodHandlers<
                      MyRequest,
                      MyResponse>(
                      this, METHODID_GET_STREAM_REAL_NAME)))
          .addMethod(
              getGetStudentByAgesMethod(),
              asyncClientStreamingCall(
                  new MethodHandlers<
                      StudentRequest,
                      StudentResponse>(
                      this, METHODID_GET_STUDENT_BY_AGES)))
          .addMethod(
              getGetStudentsByAgesMethod(),
              asyncBidiStreamingCall(
                  new MethodHandlers<
                      StudentRequest,
                      StudentResponse>(
                      this, METHODID_GET_STUDENTS_BY_AGES)))
          .build();
    }
  }

  /**
   *
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {

    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     *
     */
    public void getRealNameByUsername(MyRequest request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     */
    public void getStreamRealName(MyRequest request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStreamRealNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentByAges(
        io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     *
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentsByAges(
        io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetStudentsByAgesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   *
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {

    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     */
    public MyResponse getRealNameByUsername(MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     *
     */
    public java.util.Iterator<MyResponse> getStreamRealName(
        MyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStreamRealNameMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {

    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     *
     */
    public com.google.common.util.concurrent.ListenableFuture<MyResponse> getRealNameByUsername(
        MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_STREAM_REAL_NAME = 1;
  private static final int METHODID_GET_STUDENT_BY_AGES = 2;
  private static final int METHODID_GET_STUDENTS_BY_AGES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((MyRequest) request,
              (io.grpc.stub.StreamObserver<MyResponse>) responseObserver);
          break;
        case METHODID_GET_STREAM_REAL_NAME:
          serviceImpl.getStreamRealName((MyRequest) request,
              (io.grpc.stub.StreamObserver<MyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentByAges(
              (io.grpc.stub.StreamObserver<StudentResponse>) responseObserver);
        case METHODID_GET_STUDENTS_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentsByAges(
              (io.grpc.stub.StreamObserver<StudentResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

    StudentServiceBaseDescriptorSupplier() {
    }

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return StudentProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {

    StudentServiceFileDescriptorSupplier() {
    }
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethod())
              .addMethod(getGetStreamRealNameMethod())
              .addMethod(getGetStudentByAgesMethod())
              .addMethod(getGetStudentsByAgesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
