package com.github.mgljava.protobuf.netty;

import com.github.mgljava.protobuf.netty.NettyDemoData.ResponseBank;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyDemoClientHandler extends SimpleChannelInboundHandler<ResponseBank> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ResponseBank msg) {
    System.out.println("账号：" + msg.getBankNo());
    System.out.println("名称：" + msg.getBankName());
    System.out.println("存款：" + msg.getMoney());
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    NettyDemoData.RequestUser user = NettyDemoData.RequestUser.newBuilder()
        .setUserName("张三")
        .setAge(20)
        .setPassword("123456").build();
    ctx.channel().writeAndFlush(user);
  }
}
