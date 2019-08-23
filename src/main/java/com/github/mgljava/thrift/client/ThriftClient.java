package com.github.mgljava.thrift.client;

import com.github.mgljava.thrift.Person;
import com.github.mgljava.thrift.PersonService;
import com.github.mgljava.thrift.PersonService.Client;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {

  public static void main(String[] args) {

    TTransport tTransport = new TFramedTransport(new TSocket("localhost", 8899), 600);

    TProtocol protocol = new TCompactProtocol(tTransport);
    PersonService.Client client = new Client(protocol);

    try {
      tTransport.open();
      final Person person = client.getPersonByUsername("张三");
      System.out.println("Client username " + person.getUsername());
      System.out.println("Client age " + person.getAge());
      System.out.println("Client married " + person.isMarried());

      System.out.println("----------------");
      Person newPerson = new Person();
      newPerson.setUsername("李四");
      newPerson.setAge(30);
      newPerson.setMarried(true);

      client.savePerson(newPerson);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tTransport.close();
    }
  }
}
