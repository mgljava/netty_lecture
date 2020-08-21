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
import java.nio.charset.StandardCharsets;

// 通过内存映射文件来拷贝文件
public class CharsetTest {

  public static void main(String[] args) throws Exception {

    String inputFile = "niotestfile/CharsetTest_In.txt";
    String outputFile = "niotestfile/CharsetTest_Out.txt";

    RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
    RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

    long inputFileLength = new File(inputFile).length();

    final FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
    final FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

    // 内存映射
    final MappedByteBuffer inputData = inputFileChannel.map(MapMode.READ_ONLY, 0, inputFileLength);

    // 编码和解码一致就不会出现中文乱码问题
    final Charset charset1 = StandardCharsets.UTF_8;
    final Charset charset2 = StandardCharsets.ISO_8859_1;
    final CharsetEncoder encoder = charset2.newEncoder(); // 编码：把字符串转为字节数组
    final CharsetDecoder decoder = charset2.newDecoder(); // 解码：把字节数组转为字符串

    // 获取系统所有的字符集
    // Charset.availableCharsets().forEach((key, value) -> System.out.println(key + ", " + value));

    // 把内存映射文件解码成CharBuffer
    CharBuffer charBuffer = decoder.decode(inputData);

    // 将charBuffer编码为byteBuffer
    ByteBuffer outputData = encoder.encode(charBuffer);

    outputFileChannel.write(outputData);

    inputRandomAccessFile.close();
    outputRandomAccessFile.close();
  }
}
