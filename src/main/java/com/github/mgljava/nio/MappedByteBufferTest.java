package com.github.mgljava.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

/**
 * 内存映射文件
 */
public class MappedByteBufferTest {

  public static void main(String[] args) throws Exception {
    RandomAccessFile randomAccessFile = new RandomAccessFile("niotestfile/mappedTest.txt", "rw");
    final MappedByteBuffer mappedByteBuffer = randomAccessFile.getChannel().map(MapMode.READ_WRITE, 0, 5);

    mappedByteBuffer.put(0, (byte)'a');
    mappedByteBuffer.put(2, (byte)'c');
    randomAccessFile.close();
  }
}
