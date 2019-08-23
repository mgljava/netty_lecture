package com.github.mgljava.thrift.server;

import com.github.mgljava.thrift.DataException;
import com.github.mgljava.thrift.Person;
import com.github.mgljava.thrift.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {

  @Override
  public Person getPersonByUsername(String username) throws DataException, TException {
    System.out.println("Got Client Params Username is : " + username);
    Person person = new Person();
    person.setUsername(username);
    person.setAge(20);
    person.setMarried(false);
    return person;
  }

  @Override
  public void savePerson(Person person) {

    System.out.println("Got Client Param Person : " + person);
    System.out.println("username : " + person.getUsername());
    System.out.println("age : " + person.getAge());
    System.out.println("married : " + person.isMarried());
  }
}
