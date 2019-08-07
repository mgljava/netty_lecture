package com.github.mgljava.thirdexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 开发一个聊天的程序
 * ABC三个客户
 * 1. 如果只有一个A 用户建立连接，不做操作
 * 2. 如果B上线，那么在B控制台打印上线信息，然后告诉A， B已经上线了。
 * 3. 如果C上线，同样和2一样的操作；
 * 4. 发送消息： 1. 如果A发送了一条消息，那么将会去广播到在线的用户，都会收到消息
 *             2. 如果A下线，那么广播通知所有的用户告诉 A 已经下线了
 */
public class MyChatServer {

  public static void main(String[] args) throws Exception {

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap();
      serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
          .childHandler(new MyChatInitializer());
      final ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }

  }
}
