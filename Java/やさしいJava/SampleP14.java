import java.io.*;

class SampleP14
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("1〜10までの整数を入力してください。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str = br.readLine();
     int number = Integer.parseInt(str);

     if(number<=10 && number>=0)
     {
       System.out.println("正解です。");
     }
     else if(!(number<=10 && number>=0))
     {
       System.out.println("間違いです。");
     }
  }
}
