package com.github.mgljava.nio;

import java.nio.IntBuffer;

public class NioTest2 {

  public static void main(String[] args) {
    IntBuffer byteBuffer = IntBuffer.allocate(5);
    for (int i = 0; i < 5; i++) {
      byteBuffer.put(i);
    }

    byteBuffer.flip();
    byteBuffer.position(3);
    byteBuffer.compact();

    // byteBuffer.mark();
    // byteBuffer.reset();
    // byteBuffer.equals(other);
    // byteBuffer.compareTo(other);

    for (int i = 0; i < byteBuffer.remaining(); i++) {
      System.out.println(byteBuffer.get(i));
    }
  }
}
