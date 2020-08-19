package com.github.mgljava.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 服务器端监听5个端口号 这5个端口号都有客户端与之连接
 */
public class SelectorTest1 {

  public static void main(String[] args) throws IOException {

    int[] ports = new int[5];
    ports[0] = 5000;
    ports[1] = 5001;
    ports[2] = 5002;
    ports[3] = 5003;
    ports[4] = 5004;

    Selector selector = Selector.open();

    for (int port : ports) {
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
      serverSocketChannel.configureBlocking(false); // 是否阻塞
      final ServerSocket serverSocket = serverSocketChannel.socket();
      InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
      serverSocket.bind(inetSocketAddress);

      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 将ServerSocket注册到selector上

      System.out.println("监听端口: " + port);
    }

    while (true) {
      int numbers = selector.select();
      System.out.println("numbers : " + numbers);

      final Set<SelectionKey> selectionKeys = selector.selectedKeys();
      System.out.println("selectionKeys : " + selectionKeys);

      final Iterator<SelectionKey> iterator = selectionKeys.iterator();
      while (iterator.hasNext()) {
        final SelectionKey selectionKey = iterator.next();

        if (selectionKey.isAcceptable()) {

          ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
          final SocketChannel socketChannel = serverSocketChannel.accept();
          socketChannel.configureBlocking(false);

          socketChannel.register(selector, SelectionKey.OP_READ);

          iterator.remove();

          System.out.println("获得客户端连接：" + socketChannel);
        } else if (selectionKey.isReadable()) {
          SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

          int bytesRead = 0;

          while (true) {
            ByteBuffer buffer = ByteBuffer.allocate(512);

            buffer.clear();

            int read = socketChannel.read(buffer);

            if (read <= 0) {
              break;
            }

            buffer.flip();
            socketChannel.write(buffer);

            bytesRead += read;
          }
          System.out.println("读取： " + bytesRead + ", 来自于：" + socketChannel);
          iterator.remove();
        }
      }
    }

  }
}
