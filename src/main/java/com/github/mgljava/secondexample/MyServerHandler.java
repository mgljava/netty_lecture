package com.github.mgljava.secondexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws InterruptedException {
    Thread.sleep(2000);
    final Channel channel = ctx.channel();
    System.out.println(channel.remoteAddress() + ", " + msg);
    channel.writeAndFlush("from server : " + UUID.randomUUID());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
