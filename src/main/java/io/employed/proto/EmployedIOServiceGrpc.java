package io.employed.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: protocol/employed_io_service.proto")
public final class EmployedIOServiceGrpc {

  private EmployedIOServiceGrpc() {}

  public static final String SERVICE_NAME = "employed.io.EmployedIOService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<ConnectionRequest,
      io.employed.proto.Message> METHOD_CONNECT =
      io.grpc.MethodDescriptor.<ConnectionRequest, io.employed.proto.Message>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "employed.io.EmployedIOService", "connect"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              ConnectionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.employed.proto.Message.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.employed.proto.Message,
      io.employed.proto.Status> METHOD_SEND_MESSAGE =
      io.grpc.MethodDescriptor.<io.employed.proto.Message, io.employed.proto.Status>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "employed.io.EmployedIOService", "sendMessage"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.employed.proto.Message.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.employed.proto.Status.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmployedIOServiceStub newStub(io.grpc.Channel channel) {
    return new EmployedIOServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmployedIOServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmployedIOServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmployedIOServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmployedIOServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EmployedIOServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void connect(ConnectionRequest request,
        io.grpc.stub.StreamObserver<io.employed.proto.Message> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CONNECT, responseObserver);
    }

    /**
     */
    public void sendMessage(io.employed.proto.Message request,
        io.grpc.stub.StreamObserver<io.employed.proto.Status> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_MESSAGE, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CONNECT,
            asyncServerStreamingCall(
              new MethodHandlers<
                ConnectionRequest,
                io.employed.proto.Message>(
                  this, METHODID_CONNECT)))
          .addMethod(
            METHOD_SEND_MESSAGE,
            asyncUnaryCall(
              new MethodHandlers<
                io.employed.proto.Message,
                io.employed.proto.Status>(
                  this, METHODID_SEND_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class EmployedIOServiceStub extends io.grpc.stub.AbstractStub<EmployedIOServiceStub> {
    private EmployedIOServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployedIOServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EmployedIOServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployedIOServiceStub(channel, callOptions);
    }

    /**
     */
    public void connect(ConnectionRequest request,
        io.grpc.stub.StreamObserver<io.employed.proto.Message> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_CONNECT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(io.employed.proto.Message request,
        io.grpc.stub.StreamObserver<io.employed.proto.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmployedIOServiceBlockingStub extends io.grpc.stub.AbstractStub<EmployedIOServiceBlockingStub> {
    private EmployedIOServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployedIOServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EmployedIOServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployedIOServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<io.employed.proto.Message> connect(
        ConnectionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_CONNECT, getCallOptions(), request);
    }

    /**
     */
    public io.employed.proto.Status sendMessage(io.employed.proto.Message request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_MESSAGE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmployedIOServiceFutureStub extends io.grpc.stub.AbstractStub<EmployedIOServiceFutureStub> {
    private EmployedIOServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployedIOServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected EmployedIOServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployedIOServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.employed.proto.Status> sendMessage(
        io.employed.proto.Message request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_MESSAGE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CONNECT = 0;
  private static final int METHODID_SEND_MESSAGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmployedIOServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmployedIOServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONNECT:
          serviceImpl.connect((ConnectionRequest) request,
              (io.grpc.stub.StreamObserver<io.employed.proto.Message>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((io.employed.proto.Message) request,
              (io.grpc.stub.StreamObserver<io.employed.proto.Status>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class EmployedIOServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return EmployedIOProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EmployedIOServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmployedIOServiceDescriptorSupplier())
              .addMethod(METHOD_CONNECT)
              .addMethod(METHOD_SEND_MESSAGE)
              .build();
        }
      }
    }
    return result;
  }
}
