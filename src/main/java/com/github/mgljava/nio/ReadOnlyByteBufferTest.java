package com.github.mgljava.nio;

import java.nio.ByteBuffer;

/**
 * 只读Buffer， 我们可以调用Buffer的asReadOnlyBuffer转为一个只读Buffer，
 * 但是我们不能将只读Buffer转为可读写的Buffer
 * 当对只读buffer进行操作时，将会抛出 ReadOnlyBufferException
 */
public class ReadOnlyByteBufferTest {

  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    System.out.println(buffer.getClass());
    for (int i = 0; i < buffer.capacity(); i++) {
      buffer.put((byte) i);
    }
    final ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
    System.out.println(readOnlyBuffer.getClass());
    readOnlyBuffer.position(2);
    // readOnlyBuffer.putInt(20); 不允许操作只读 buffer
  }
}
