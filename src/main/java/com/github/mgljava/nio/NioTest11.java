package com.github.mgljava.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 关于Buffer的 Scattering 与 Gathering
 */
public class NioTest11 {

  public static void main(String[] args) throws Exception {

    try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
      InetSocketAddress address = new InetSocketAddress(8899);
      serverSocketChannel.bind(address);

      int messageLength = 2 + 3 + 4;
      ByteBuffer[] buffers = new ByteBuffer[3];

      buffers[0] = ByteBuffer.allocate(2);
      buffers[1] = ByteBuffer.allocate(3);
      buffers[2] = ByteBuffer.allocate(4);

      SocketChannel socketChannel = serverSocketChannel.accept();
      while (true) {
        int bytesRead = 0;
        while (bytesRead < messageLength) {
          final long r = socketChannel.read(buffers);
          bytesRead += r;

          System.out.println("bytesRead : " + bytesRead);
          Arrays.stream(buffers)
              .map(buffer -> "position: " + buffer.position() + ", limit : " + buffer.limit())
              .forEach(System.out::println);
        }

        Arrays.stream(buffers)
            .forEach(ByteBuffer::flip);

        long bytesWritten = 0;
        while (bytesWritten < messageLength) {
          long r = socketChannel.write(buffers);
          bytesWritten += r;
        }
        Arrays.stream(buffers).forEach(ByteBuffer::clear);
        System.out.println("bytesRead : " + bytesRead + ", bytesWritten : " + bytesWritten + ", messageLength : " + messageLength);
      }
    }
  }
}
