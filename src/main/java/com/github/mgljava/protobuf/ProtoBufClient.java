package com.github.mgljava.protobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;

public class ProtoBufClient {

  public static void main(String[] args) throws Exception {

    EventLoopGroup group = new NioEventLoopGroup();

    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(group)
          .channel(NioSocketChannel.class)
          .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
              final ChannelPipeline pipeline = ch.pipeline();
              //解码器，通过Google Protocol Buffers序列化框架动态的切割接收到的ByteBuf
              pipeline.addLast(new ProtobufVarint32FrameDecoder());
              //将接收到的二进制文件解码成具体的实例，这边接收到的是服务端的ResponseBank对象实列
              // pipeline.addLast(new ProtobufDecoder(NettyDemoData.ResponseBank.getDefaultInstance()));
              pipeline.addLast(new StringDecoder());
              //Google Protocol Buffers编码器
              pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
              //Google Protocol Buffers编码器
              pipeline.addLast(new ProtobufEncoder());
              //pipeline.addLast(new ProtobufDecoder(DataInfo.Student.getDefaultInstance()));
              pipeline.addLast(new ProtoBufClientHandler());
            }
          });
      final ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
    }
  }
}
