package com.github.mgljava.nio.charset;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTest {

  public static void main(String[] args) throws Exception {

    String inputFile = "niotestfile/CharsetTest_In.txt";
    String outputFile = "niotestfile/CharsetTest_Out.txt";

    RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
    RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

    long inputFileLength = new File(inputFile).length();

    final FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
    final FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

    final MappedByteBuffer inputData = inputFileChannel.map(MapMode.READ_ONLY, 0, inputFileLength);

    // final Charset charset = Charset.forName("utf-8");
    final Charset charset = Charset.forName("iso-8859-1");
    final CharsetEncoder encoder = charset.newEncoder(); // 编码：把字符串转为字节数组
    final CharsetDecoder decoder = charset.newDecoder(); // 解码：把字节数组转为字符串

    Charset.availableCharsets().forEach((key, value) -> System.out.println(key + ", " + value));

    System.out.println("\n");

    System.out.println(Charset.defaultCharset());

    CharBuffer charBuffer = decoder.decode(inputData);
    System.out.println(charBuffer.get(0));

    ByteBuffer outputData = encoder.encode(charBuffer);

    outputFileChannel.write(outputData);

    inputRandomAccessFile.close();
    outputRandomAccessFile.close();
  }
}
