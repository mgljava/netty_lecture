package com.github.mgljava.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 将内容写到文件中
 */
public class WriteToChannel {

  public static void main(String[] args) throws Exception{

    FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");

    final FileChannel channel = fileOutputStream.getChannel();

    ByteBuffer byteBuffer = ByteBuffer.allocate(512);

    byte[] message = "hello world".getBytes();

    for (byte b : message) {
      byteBuffer.put(b);
    }

    byteBuffer.flip();

    channel.write(byteBuffer);
    fileOutputStream.close();
    channel.close();
  }
}
