package com.github.mgljava.nio;

import java.nio.ByteBuffer;

/**
 * 类型化的 put与 get方法
 * ByteBuffer 使用, 可以使用到自定义协议中，放进去是什么，取出来就是什么。
 */
public class ByteBufferTest {

  public static void main(String[] args) {

    ByteBuffer buffer = ByteBuffer.allocate(64);

    buffer.putInt(10);
    buffer.putLong(20L);

    buffer.flip();

    System.out.println(buffer.getInt());
    System.out.println(buffer.getLong());
  }
}
