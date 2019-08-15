package com.github.mgljava.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    final ChannelPipeline pipeline = ch.pipeline();
    // WebSocket 基于 Http协议
    pipeline.addLast(new HttpServerCodec());

    // 块处理
    pipeline.addLast(new ChunkedWriteHandler());

    // 聚合请求或者响应
    pipeline.addLast(new HttpObjectAggregator(8192));

    //    ws://server:port/context_path
    // eg ws://server:port/ws
    pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
    pipeline.addLast(new TextWebSocketFrameHandler());
  }
}
