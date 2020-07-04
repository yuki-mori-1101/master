import java.io.*;

class SampleP8
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("身長と体重と入力してください。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str = br.readLine();
     double db = Double.parseDouble(str);

     BufferedReader br2 =
      new BufferedReader(new InputStreamReader(System.in));

      String str2 = br2.readLine();
      double db2 = Double.parseDouble(str2);

      System.out.println("身長は"+ db +"です。");
      System.out.println("体重は"+db2+"です。");
  }
}
