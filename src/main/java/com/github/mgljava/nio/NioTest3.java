package com.github.mgljava.nio;

import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class NioTest3 {

  public static void main(String[] args) throws Exception {
    FileInputStream fileInputStream = new FileInputStream("/Users/monk/store/commitlog/00000000000000000000");
    FileChannel fileChannel = fileInputStream.getChannel();
    MappedByteBuffer byteBuffer = fileChannel.map(MapMode.READ_ONLY, 0, fileInputStream.available());
    // while (byteBuffer.hasRemaining()) {
    for (int i = 0; i < 100; i++) {
      System.out.print(byteBuffer.get(i) + " ");
    }

    //}
  }
}
