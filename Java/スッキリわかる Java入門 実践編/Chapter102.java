import java.io.*;

class Employee implements Serializable//社員クラス
{
  String name;
  int age;
}
class Department implements Serializable//部署クラス
{
  String name;
  Employee leader;
}

public class Chapter102
{
  public static void main(String[]args)throws IOException
  {
    Employee tanaka = new Employee();
    tanaka.name = "田中一郎";
    tanaka.age = 41;
    Department soumubu = new Department();
    soumubu.name = "総務部";
    soumubu.leader = tanaka;
    FileOutputStream fos = new FileOutputStream("c:company.dat");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(soumubu);
    oos.flush();
    oos.close();
  }
}
