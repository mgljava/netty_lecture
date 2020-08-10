package com.github.mgljava.firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import java.net.URI;
import java.net.URISyntaxException;

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

  /**
   * 读取客户端发过来的请求，并向客户端返回响应.
   */
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws URISyntaxException {
    System.out.println(msg.getClass());
    if (msg instanceof HttpRequest) {

      HttpRequest httpRequest = (HttpRequest) msg;
      System.out.println("request method ： " + httpRequest.method().name());
      URI uri = new URI(httpRequest.uri());
      System.out.println("uri : " + uri.getPath());

      ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
      System.out.println("method invoked channelRead0");
      FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
      response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
      response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

      ctx.writeAndFlush(response);
      ctx.channel().closeFuture();
    }
  }

  @Override
  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelRegistered");
  }

  @Override
  public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelUnregistered");
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelActive");
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelInactive");
  }
}
