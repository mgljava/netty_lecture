package com.github.mgljava.protobuf;

import com.github.mgljava.protobuf.netty.NettyDemoData;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class ProtoBufServer {

  public static void main(String[] args) throws Exception {

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap();
      serverBootstrap.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .handler(new LoggingHandler(LogLevel.INFO))
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
              final ChannelPipeline pipeline = ch.pipeline();
              //解码器，通过Google Protocol Buffers序列化框架动态的切割接收到的ByteBuf
              pipeline.addLast(new ProtobufVarint32FrameDecoder());
              //服务器端接收的是客户端RequestUser对象，所以这边将接收对象进行解码生产实列
              // pipeline.addLast(new ProtobufDecoder(NettyDemoData.RequestUser.getDefaultInstance()));
              pipeline.addLast(new StringEncoder());
              //Google Protocol Buffers编码器
              pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
              //Google Protocol Buffers编码器
              pipeline.addLast(new ProtobufEncoder());
              pipeline.addLast(new ProtobufDecoder(DataInfo.Student.getDefaultInstance()));
              pipeline.addLast(new ProtoBufServerHandler());
            }
          });
      final ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
