namespace java com.github.mgljava.thrift.server

typedef i32 int

struct News {
  1:int id;
  2:string title;
  3:string content;
  4:string mediaFrom;
  5:string author;
}

service IndexNewsOperatorServices {
  bool indexNews(1:int indexNews),
  bool removeNewsById(1:int id)
}

service AddtionService {
  int add (1:int n1, 2:int n2),
}