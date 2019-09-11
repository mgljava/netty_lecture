package com.github.mgljava.nio;

import java.nio.ByteBuffer;

/**
 * 只读Buffer， 我们可以调用Buffer的asReadOnlyBuffer转为一个只读Buffer，
 * 但是我们不能将只读Buffer转为可读写的Buffer
 */
public class HeapByteBufferRTest {

  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    System.out.println(buffer.getClass());
    for (int i = 0; i < buffer.capacity(); i++) {
      buffer.put((byte) i);
    }
    final ByteBuffer asReadOnlyBuffer = buffer.asReadOnlyBuffer();
    System.out.println(asReadOnlyBuffer.getClass());

  }
}
