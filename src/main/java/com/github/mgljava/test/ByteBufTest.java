package com.github.mgljava.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufTest {

  public static void main(String[] args) {
    ByteBuf byteBuf = Unpooled.wrappedBuffer("helloww".getBytes());
    System.out.println(byteBuf.capacity());
    System.out.println(byteBuf.isReadable());
    byteBuf.setByte(2, 'c');
    System.out.println((char) byteBuf.getByte(2));
  }
}
