package com.github.mgljava.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

  public static void main(String[] args) throws Exception {

    RandomAccessFile randomAccessFile = new RandomAccessFile("niotestfile/FileLockTest.txt", "rw");
    final FileChannel fileChannel = randomAccessFile.getChannel();
    final FileLock fileLock = fileChannel.lock(0, 3, true);
    System.out.println("valid : " + fileLock.isValid());
    System.out.println("lock type : " + fileLock.isShared());

    fileLock.release();
    randomAccessFile.close();
  }
}
