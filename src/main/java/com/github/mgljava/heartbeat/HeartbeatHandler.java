package com.github.mgljava.heartbeat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import java.net.InetSocketAddress;

public class HeartbeatHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {

    if (evt instanceof IdleStateEvent) {
      IdleStateEvent event = (IdleStateEvent) evt;
      String eventType = null;
      switch (event.state()) {
        case READER_IDLE:
          eventType = "读空闲";
          break;
        case WRITER_IDLE:
          eventType = "写空闲";
          break;
        case ALL_IDLE:
          eventType = "读写空闲";
          break;
      }
      System.out.println(ctx.channel().remoteAddress() + "超时事件：" + eventType);

      final Channel channel = ctx.channel();
      final ChannelFuture future = channel.connect(new InetSocketAddress("localhost", 8080));
      future.addListener((ChannelFutureListener) future1 -> {
        if (future1.isSuccess()) {
          ByteBuf buffer = Unpooled.copiedBuffer("Hello", CharsetUtil.UTF_8);
          future1.channel().writeAndFlush(buffer);
        } else {
          final Throwable cause = future1.cause();
          cause.printStackTrace();
        }
      });

      ctx.channel().close();
    }
  }
}
