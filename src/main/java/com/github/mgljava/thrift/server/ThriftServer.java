package com.github.mgljava.thrift.server;

import com.github.mgljava.thrift.PersonService;
import com.github.mgljava.thrift.PersonService.Processor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.THsHaServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class ThriftServer {

  public static void main(String[] args) throws Exception {

    TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8899);
    THsHaServer.Args arg = new Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);

    PersonService.Processor<PersonServiceImpl> processor = new Processor<>(new PersonServiceImpl());

    arg.protocolFactory(new TCompactProtocol.Factory());
    arg.transportFactory(new TFramedTransport.Factory());
    arg.processorFactory(new TProcessorFactory(processor));

    TServer server = new THsHaServer(arg);
    System.out.println("Server Started...");
    server.serve();
  }
}
