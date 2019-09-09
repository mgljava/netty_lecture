package com.github.mgljava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {

  public static void main(String[] args) throws Exception {

    byteBufferTest();
  }


  private static void byteBufferTest() throws IOException {
    long start = System.currentTimeMillis();
    final FileChannel inputStreamChannel;
    try (FileInputStream fileInputStream = new FileInputStream("niotestfile/input.txt")) {
      inputStreamChannel = fileInputStream.getChannel();
    }
    final FileChannel outputStreamChannel;
    try (FileOutputStream fileOutputStream = new FileOutputStream("niotestfile/output.txt")) {
      outputStreamChannel = fileOutputStream.getChannel();
    }
    ByteBuffer byteBuffer = ByteBuffer.allocate(8096000);
    while (true) {
      byteBuffer.clear();
      int read = inputStreamChannel.read(byteBuffer);
      if (-1 == read) {
        break;
      }

      byteBuffer.flip();
      outputStreamChannel.write(byteBuffer);
    }
    inputStreamChannel.close();
    outputStreamChannel.close();
    System.out.println("cost : " + (System.currentTimeMillis() - start)); // 12s  /231
  }
}
