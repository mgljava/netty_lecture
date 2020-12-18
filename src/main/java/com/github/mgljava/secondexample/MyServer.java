package com.github.mgljava.secondexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {

  public static void main(String[] args) throws InterruptedException {

    // 死循环,NioEventLoopGroup完成一些准备工作，给一些变量赋值
    EventLoopGroup bossGroup = new NioEventLoopGroup();

    /*
     * 可以设置 bossGroup的线程数为1
     * EventLoopGroup bossGroup = new NioEventLoopGroup(1);
     */
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap();

      /*
      group(bossGroup, workerGroup) 作用是给成员变量赋值
      channel(NioServerSocketChannel.class) 给channel的成员变量赋值
      .childHandler(new MyServerInitializer()) 给父类的成员变量赋值childHandler
       */
      serverBootstrap.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(new MyServerInitializer());

      /**
       * bind 方法：创建一个新的channel进行绑定
       */
      final ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
