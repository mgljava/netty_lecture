package com.github.mgljava.echo;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@Sharable // 标志一个ChannelHandler 可以被多个Channel安全的共享
public class EchoServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(msg);
    ctx.writeAndFlush(msg);
  }
}
