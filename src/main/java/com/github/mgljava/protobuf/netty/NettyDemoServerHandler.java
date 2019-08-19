package com.github.mgljava.protobuf.netty;

import com.github.mgljava.protobuf.netty.NettyDemoData.RequestUser;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyDemoServerHandler extends SimpleChannelInboundHandler<RequestUser> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, RequestUser requestUser) {
    System.out.println("姓名：" + requestUser.getUserName());
    System.out.println("年龄：" + requestUser.getAge());
    System.out.println("密码：" + requestUser.getPassword());

    NettyDemoData.ResponseBank response = NettyDemoData.ResponseBank.newBuilder().setBankName("银行")
        .setBankNo("123456789987654321").setMoney(100.00).build();

    ctx.channel().writeAndFlush(response);
  }
}
