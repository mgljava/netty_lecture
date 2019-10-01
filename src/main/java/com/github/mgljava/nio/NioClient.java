package com.github.mgljava.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {

  public static void main(String[] args) throws Exception {
    SocketChannel socketChannel = null;
    try {
      socketChannel = SocketChannel.open();
      socketChannel.configureBlocking(false);

      Selector selector = Selector.open();
      socketChannel.register(selector, SelectionKey.OP_CONNECT);
      socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));

      while (true) {

        selector.select();
        final Set<SelectionKey> selectionKeys = selector.selectedKeys();

        selectionKeys.forEach(selectionKey -> {

          if (selectionKey.isConnectable()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();

            // 连接是否在进行
            if (client.isConnectionPending()) {
              try {
                client.finishConnect();
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put((LocalDateTime.now() + " 连接成功").getBytes());

                writeBuffer.flip();
                client.write(writeBuffer);

                // 当建立好连接之后，新开一个线程来处理控制台的输入数据
                ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                executorService.submit(() -> {
                  while (true) {
                    writeBuffer.clear();
                    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                    BufferedReader bf = new BufferedReader(inputStreamReader);
                    final String sendMessage = bf.readLine();
                    writeBuffer.put(sendMessage.getBytes());
                    writeBuffer.flip();
                    client.write(writeBuffer);
                  }
                });
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
            try {
              client.register(selector, SelectionKey.OP_READ);
            } catch (ClosedChannelException e) {
              e.printStackTrace();
            }
          } else if (selectionKey.isReadable()) {
            SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            try {
              int read = socketChannel1.read(byteBuffer);
              if (read > 0) {
                String message = new String(byteBuffer.array(), 0, read);
                System.out.println(message);
              }
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        });
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (null != socketChannel) {
        socketChannel.close();
      }
    }
  }
}
