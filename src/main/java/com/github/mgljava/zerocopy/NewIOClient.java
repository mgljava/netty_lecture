package com.github.mgljava.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {

  public static void main(String[] args) throws Exception {

    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.connect(new InetSocketAddress("localhost", 8899));
    socketChannel.configureBlocking(true);

    String fileName = "d:/VM/CentOS-7-x86_64-Minimal-1810.iso";

    try (FileChannel fileChannel = new FileInputStream(fileName).getChannel()) {

      long position = 0;
      long size = fileChannel.size();
      long total = 0;
      int count = 0;
      long start = System.currentTimeMillis();
      while (position < size) {
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送：" + transferCount);
        if (transferCount < 0) {
          break;
        }
        count++;
        total += transferCount;
        position += transferCount;
      }

      System.out.println("发送的总字节数：" + total + ", 耗时：" + (System.currentTimeMillis() - start) + ", 传输次数：" + count);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
