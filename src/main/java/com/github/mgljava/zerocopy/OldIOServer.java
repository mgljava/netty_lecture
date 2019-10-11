package com.github.mgljava.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer {

  public static void main(String[] args) throws Exception {

    ServerSocket serverSocket = new ServerSocket(8899);
    while (true) {
      final Socket socket = serverSocket.accept();

      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

      byte[] byteArray = new byte[4096];

      while (true) {
        final int readCount = dataInputStream.read(byteArray, 0, byteArray.length);
        if (readCount == -1) {
          break;
        }
      }
      dataInputStream.close();
    }
  }
}
