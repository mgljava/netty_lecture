package com.github.mgljava.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class IOTest {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = new FileInputStream("/Users/monk/gcviewer.properties");
    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
    DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
    System.out.println((char) dataInputStream.readByte());
    System.out.println((char) dataInputStream.readByte());
  }
}
