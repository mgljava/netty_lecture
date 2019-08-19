package com.github.mgljava.protobuf.netty;

import com.github.mgljava.protobuf.netty.NettyDemoData.RequestUser;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyDemoServerHandler extends SimpleChannelInboundHandler<RequestUser> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, RequestUser msg) throws Exception {
    System.out.println(msg.getUserName());
    System.out.println(msg.getAge());
    System.out.println(msg.getPassword());

    NettyDemoData.ResponseBank bank = NettyDemoData.ResponseBank.newBuilder().setBankName("中国工商银行")
        .setBankNo("6222222200000000000").setMoney(560000.23).build();

    ctx.channel().writeAndFlush(bank);
  }
}
