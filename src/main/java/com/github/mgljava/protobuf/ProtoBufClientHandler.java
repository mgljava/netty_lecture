package com.github.mgljava.protobuf;

import com.github.mgljava.protobuf.DataInfo.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ProtoBufClientHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {

    System.out.println("==================Client=====================");
    final Student student = Student.newBuilder()
        .setName("张三")
        .setAge(20)
        .setAddress("四川成都").build();

    ctx.writeAndFlush(student);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
