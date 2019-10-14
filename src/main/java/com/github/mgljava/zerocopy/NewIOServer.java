package com.github.mgljava.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Java NIO 零拷贝
 * 1. 依赖于底层操作系统，如果操作系统支持，那就支持，如果不支持，那就不支持。和Java语言以及JVM无关
 * 2. 需要支持gather操作，protocol engine（协议引擎）
 * 3. 零拷贝原理和步骤
 *   1. 用户发起一个系统调用，然后从用户空间切换到内核空间
 *   2. 内核将数据从硬盘写入到 kernel buffer中（DMA参与）。并同时将 FD（文件描述符，其中包含了 kernel buffer 的地址和buffer长度）写到 socket buffer中
 *   3. 当需要将数据写入到 socket buffer中时，协议引擎会先从 socket buffer中获取文件描述符的信息，然后根据文件描述符的信息去 kernel buffer中拷贝数据（DMA参与）
 * 4. 参见文章：
 *   1. https://juejin.im/post/5c1c532551882579520b1f47
 *   2. http://sound2gd.wang/2018/07/24/Java-NIO%E5%88%86%E6%9E%90-11-%E9%9B%B6%E6%8B%B7%E8%B4%9D%E6%8A%80%E6%9C%AF/
 *   3. https://blog.csdn.net/u013096088/article/details/79122671
 */
public class NewIOServer {

  public static void main(String[] args) throws Exception {

    InetSocketAddress socketAddress = new InetSocketAddress(8899);
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    ServerSocket serverSocket = serverSocketChannel.socket();
    serverSocket.setReuseAddress(true);
    serverSocket.bind(socketAddress);

    ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

    while (true) {
      SocketChannel socketChannel = serverSocketChannel.accept();
      socketChannel.configureBlocking(true);
      int readCount = 0;
      while (-1 != readCount) {
        readCount = socketChannel.read(byteBuffer);
        byteBuffer.rewind();
      }
    }
  }
}
