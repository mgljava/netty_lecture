package com.github.mgljava.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/**
 * 有三个客户端，当服务器端收到一个客户端的请求的数据时，分发给另外两个客户端，然后并返回数据给客户端
 */
public class NioServer {

  private final static Map<String, SocketChannel> clientMap = new HashMap<>();

  /**
   * 与传统的IO编程不一样的是，现在NIO的服务端只有一个线程
   */
  public static void main(String[] args) throws Exception {

    // 一个通道（Channel），多个客户端连接到一个通道上
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.configureBlocking(false);
    serverSocketChannel.bind(new InetSocketAddress(8899));
    Selector selector = Selector.open();
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    while (true) {
      try {
        selector.select(); // 返回关注的selectionKey的数量

        final Set<SelectionKey> selectionKeys = selector.selectedKeys();
        selectionKeys.forEach(selectionKey -> {
          final SocketChannel client;
          try {

            if (selectionKey.isAcceptable()) {
              ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
              client = server.accept();
              client.configureBlocking(false);
              client.register(selector, SelectionKey.OP_READ);
              String key = " 【" + UUID.randomUUID().toString() + "】 ";
              clientMap.put(key, client);
            } else if (selectionKey.isReadable()) {
              client = (SocketChannel) selectionKey.channel();
              ByteBuffer readBuffer = ByteBuffer.allocate(1024);
              readBuffer.clear();

              int count = client.read(readBuffer);
              if (count > 0) {

                readBuffer.flip();
                Charset charset = StandardCharsets.UTF_8;
                String receiveMessage = String.valueOf(charset.decode(readBuffer).array());
                System.out.println("client : " + client + ": " + receiveMessage);

                // 获取发送者的 key（UUID）
                String senderKey = null;
                for (Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                  if (client == entry.getValue()) {
                    senderKey = entry.getKey();
                    break;
                  }
                }

                // 发送消息到其他客户端
                for (Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                  final SocketChannel socketChannel = entry.getValue();
                  ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                  writeBuffer.put((senderKey + " : " + receiveMessage).getBytes());
                  writeBuffer.flip();
                  socketChannel.write(writeBuffer);
                }
              }
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        });
        selectionKeys.clear();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
