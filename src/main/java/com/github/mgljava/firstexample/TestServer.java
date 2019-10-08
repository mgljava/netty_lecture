package com.github.mgljava.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * 1. 编写EventLoop
 * 2. 编写Initializer，把我们编写的Handler加入进去
 * 3. 编写Handler
 */
public class TestServer {

  public static void main(String[] args) throws Exception {

    // BossGroup 主要是获取客户端的连接，指派任务给worker
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    // WorkerGroup 主要是处理客户端的请求，响应
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      // 服务器的启动类 ServerBootstrap
      ServerBootstrap serverBootstrap = new ServerBootstrap();
      serverBootstrap.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          // childHandler 针对于workerGroup的handler
          // handler 针对于bossGroup的handler
          .childHandler(new TestServerInitializer());
      final ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
