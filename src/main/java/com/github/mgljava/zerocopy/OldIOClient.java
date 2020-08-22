package com.github.mgljava.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OldIOClient {

  public static void main(String[] args) throws Exception {

    Socket socket = new Socket("127.0.0.1", 8899);

    String fileName = "/Users/monk/Desktop/Study/Video/Cinema 4D R19从入门到精通.zip";

    InputStream inputStream = new FileInputStream(fileName);

    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

    byte[] buffer = new byte[4096];
    long readCount;
    long total = 0L;

    long startTime = System.currentTimeMillis();

    while ((readCount = inputStream.read(buffer)) >= 0) {
      total += readCount;
      dataOutputStream.write(buffer);
    }

    // 发送的总字节数：962592768, 耗时：9738
    // 发送的总字节数：962592768, 耗时：10259
    // 发送的总字节数：962592768, 耗时：8691
    // 发送的总字节数：962592768, 耗时：8643
    // 发送的总字节数：962592768, 耗时：9187
    // 发送的总字节数：962592768, 耗时：8919
    // 发送的总字节数：962592768, 耗时：9027

    // 发送的总字节数：962592768, 耗时：1398
    // 发送的总字节数：962592768, 耗时：1122
    System.out.println("发送的总字节数：" + total + ", 耗时：" + (System.currentTimeMillis() - startTime));
    dataOutputStream.close();
    inputStream.close();
    socket.close();
  }
}
