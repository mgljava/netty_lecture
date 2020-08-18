package com.github.mgljava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 把一个文件的内容复制到另一个文件
 */
public class CopyFileToOtherFile {

  public static void main(String[] args) throws Exception {

    byteBufferTest();
  }


  private static void byteBufferTest() throws IOException {
    long start = System.currentTimeMillis();
    final FileChannel inputStreamChannel;
    FileInputStream fileInputStream = new FileInputStream("niotestfile/input.txt");
    inputStreamChannel = fileInputStream.getChannel();
    final FileChannel outputStreamChannel;
    FileOutputStream fileOutputStream = new FileOutputStream("niotestfile/output.txt");
    outputStreamChannel = fileOutputStream.getChannel();

    ByteBuffer byteBuffer = ByteBuffer.allocate(5);
    while (true) {
      byteBuffer.clear(); // 如果注释掉该行，会一直写，因为没有重置 position和limit，所以read方法返回0
      int read = inputStreamChannel.read(byteBuffer);
      System.out.println("read : " + read);
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
