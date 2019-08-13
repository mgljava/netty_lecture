package com.github.mgljava.wechat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

  private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    Channel channel = ctx.channel();
    channelGroup.forEach(ch -> {
      if (channel != ch) {
        ch.writeAndFlush(ch.remoteAddress() + " 发送的消息：" + msg + "\n");
      } else {
        ch.writeAndFlush(" 【自己】 " + msg + "\n");
      }
    });
  }

  /**
   * 服务器端和客户端建立好了连接
   */
  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    final Channel channel = ctx.channel();

    channelGroup.writeAndFlush(" 【服务器】 - " + channel.remoteAddress() + " 加入\n");

    channelGroup.add(channel);
  }

  /**
   * 连接断了
   */
  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    final Channel channel = ctx.channel();
    channel.writeAndFlush(" 【服务器】 - " + channel.remoteAddress() + " 离开\n");
    channelGroup.remove(channel); // netty 会自动调用，可以不写
  }

  /**
   * 连接处于活动状态
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    final Channel channel = ctx.channel();
    System.out.println(channel.remoteAddress() + " 上线");
  }

  /**
   * 连接处于非活动状态
   */
  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    final Channel channel = ctx.channel();
    System.out.println(channel.remoteAddress() + " 下线");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
