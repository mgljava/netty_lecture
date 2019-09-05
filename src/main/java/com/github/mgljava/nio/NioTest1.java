package com.github.mgljava.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

  public static void main(String[] args) {

    IntBuffer intBuffer = IntBuffer.allocate(10);
    System.out.println("capacity : " + intBuffer.capacity());
    System.out.println("limit : " + intBuffer.limit());
    System.out.println("position : " + intBuffer.position());

    for (int i = 0; i < 5; i++) {
      int randomNumber = new SecureRandom().nextInt(6);
      intBuffer.put(randomNumber);
    }
    System.out.println("---------------------------");
    System.out.println("capacity : " + intBuffer.capacity());
    System.out.println("limit : " + intBuffer.limit());
    System.out.println("position : " + intBuffer.position());
    intBuffer.flip();
    System.out.println("---------------------------");
    System.out.println("capacity : " + intBuffer.capacity());
    System.out.println("limit : " + intBuffer.limit());
    System.out.println("position : " + intBuffer.position());
    while (intBuffer.hasRemaining()) {
      System.out.println(intBuffer.get());
    }
  }
}
