package com.github.mgljava.protobuf.netty;

import com.github.mgljava.protobuf.netty.NettyDemoData.ResponseBank;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyDemoClientHandler extends SimpleChannelInboundHandler<ResponseBank> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, ResponseBank msg) throws Exception {
    System.out.println(msg.getBankNo());
    System.out.println(msg.getBankName());
    System.out.println(msg.getMoney());
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    NettyDemoData.RequestUser user = NettyDemoData.RequestUser.newBuilder()
        .setUserName("张三").setAge(27).setPassword("123456").build();
    ctx.channel().writeAndFlush(user);
  }
}
