package com.github.mgljava.heartbeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;

public class HeartbeatInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) {
    final ChannelPipeline pipeline = ch.pipeline();

    // 空闲检测处理器 IdleStateHandler
    pipeline.addLast(new IdleStateHandler(5, 7, 10, TimeUnit.SECONDS));
    pipeline.addLast(new HeartbeatHandler());
  }
}
