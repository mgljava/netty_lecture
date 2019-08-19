package com.github.mgljava.protobuf;

import com.github.mgljava.protobuf.DataInfo.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoBufServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Student student) throws Exception {
    System.out.println("--------------Server---------------");
    System.out.println("姓名：" + student.getName());
    System.out.println("年龄：" + student.getAge());
    System.out.println("住址：" + student.getAddress());

    ctx.channel().writeAndFlush("Success");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
