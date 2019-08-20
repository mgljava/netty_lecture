package com.github.mgljava.protobuf.multi_protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class MultiProtocolClient {

  public static void main(String[] args) throws Exception {
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
          .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
              ChannelPipeline pipeline = ch.pipeline();

              pipeline.addLast(new ProtobufVarint32FrameDecoder());
              pipeline.addLast(new ProtobufDecoder(TaskProtocolWrapper.TaskProtocol.getDefaultInstance()));
              pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
              pipeline.addLast(new ProtobufEncoder());
              pipeline.addLast(new MultiProtocolClientHandler());
            }
          });

      ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
      channelFuture.channel().closeFuture().sync();

    } finally {
      eventLoopGroup.shutdownGracefully();
    }
  }
}
