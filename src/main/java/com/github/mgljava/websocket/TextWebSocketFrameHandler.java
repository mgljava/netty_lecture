package com.github.mgljava.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.time.LocalDateTime;

/**
 * 处理文本的数据传输
 * 因为WebSocket连接是基于Http连接之上的。所以想要处理WebSocket连接，必须先发起一个 Http连接，
 * 然后通过 upgrade 将Http连接升级为 WebSocket连接，如果升级成功，那么客户端和服务端将建立全双工（双向数据传输）的链接
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
    System.out.println("收到消息：" + msg.text());

    ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间：" + LocalDateTime.now()));
  }

  @Override
  public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    System.out.println("handlerAdded：" + ctx.channel().id().asLongText());
  }

  @Override
  public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    System.out.println("handlerRemoved：" + ctx.channel().id().asLongText());
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    System.out.println("异常发生");
    ctx.close();
  }
}
