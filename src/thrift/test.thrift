namespace java com.github.mgljava.thrift.server

typedef i32 int

service AddtionService {
  int add (1:int n1, 2:int n2),
}