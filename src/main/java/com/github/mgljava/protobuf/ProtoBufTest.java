package com.github.mgljava.protobuf;

import com.github.mgljava.protobuf.DataInfo.Student;

public class ProtoBufTest {

  public static void main(String[] args) throws Exception {

    final Student student = Student.newBuilder()
        .setName("张三")
        .setAge(20)
        .setAddress("成都").build();

    final byte[] student2ByteArray = student.toByteArray();

    final Student student1 = Student.parseFrom(student2ByteArray);
    System.out.println(student1.getName());
    System.out.println(student1.getAddress());
    System.out.println(student1.getAge());

    /**
     * 任务
     * 1. 在两台JVM中运行
     * 2. 借助Netty
     * 3. Netty对ProtoBuf的支持
     */
  }
}
