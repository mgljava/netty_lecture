package com.github.mgljava.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

// 通道初始化器，泛型一般传入 SocketChannel
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) {
    final ChannelPipeline pipeline = ch.pipeline();
    pipeline.addLast("httpServerCodec", new HttpServerCodec());
    pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
  }
}
