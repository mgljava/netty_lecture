package com.github.mgljava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DirectByteBufferTest {

  public static void main(String[] args) throws Exception {

    final FileChannel inputStreamChannel;
    FileInputStream fileInputStream = new FileInputStream("niotestfile/input2.txt");
    inputStreamChannel = fileInputStream.getChannel();

    final FileChannel outputStreamChannel;
    FileOutputStream fileOutputStream = new FileOutputStream("niotestfile/output2.txt");
    outputStreamChannel = fileOutputStream.getChannel();

    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
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

  }
}
