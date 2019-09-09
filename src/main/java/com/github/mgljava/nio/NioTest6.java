package com.github.mgljava.nio;

import java.nio.ByteBuffer;

/**
 * 分片 Buffer
 */
public class NioTest6 {

  public static void main(String[] args) {

    ByteBuffer buffer = ByteBuffer.allocate(10);
    for (int i = 0; i < buffer.capacity(); i++) {
      buffer.put((byte)i);
    }

    buffer.position(2);
    buffer.limit(6);
    final ByteBuffer sliceBuffer = buffer.slice();// 左闭右开
    System.out.println("---------------");
    System.out.println(sliceBuffer.capacity());
    System.out.println(sliceBuffer.position());
    System.out.println(sliceBuffer.limit());
    System.out.println("---------------");
    while (sliceBuffer.hasRemaining()) {
      System.out.println(sliceBuffer.get());
    }
  }
}
