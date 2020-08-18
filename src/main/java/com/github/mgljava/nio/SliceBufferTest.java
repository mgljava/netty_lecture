package com.github.mgljava.nio;

import java.nio.ByteBuffer;

/**
 * 分片Buffer，分片的Buffer和原buffer是共享底层的数组
 */
public class SliceBufferTest {

  public static void main(String[] args) {

    ByteBuffer buffer = ByteBuffer.allocate(10);
    for (int i = 0; i < buffer.capacity(); i++) {
      buffer.put((byte) i);
    }

    buffer.position(2);
    buffer.limit(6);
    final ByteBuffer sliceBuffer = buffer.slice();// 左闭右开
    System.out.println("-------1--------");
    System.out.println("sliceBuffer.capacity()： " + sliceBuffer.capacity());
    System.out.println("sliceBuffer.position()：" + sliceBuffer.position());
    System.out.println("sliceBuffer.limit()：" + sliceBuffer.limit());
    System.out.println("---------------");
    while (sliceBuffer.hasRemaining()) {
      System.out.println(sliceBuffer.get());
    }
  }
}
