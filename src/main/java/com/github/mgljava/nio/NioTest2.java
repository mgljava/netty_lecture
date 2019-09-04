package com.github.mgljava.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {

  public static void main(String[] args) throws Exception {

    FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");
    final FileChannel fileChannel = fileInputStream.getChannel();

    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
    fileChannel.read(byteBuffer);

    byteBuffer.flip();

    while (byteBuffer.hasRemaining()) {
      final byte b = byteBuffer.get();
      System.out.println("character : " + (char) b);
    }

    fileChannel.close();
  }
}
