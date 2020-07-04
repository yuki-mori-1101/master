import java.io.*;

class SampleP12
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     System.out.println("数字を入力してください。");
     String str = br.readLine();
     int number = Integer.parseInt(str);

     int result = number%2;

     if(result==0)
     {
       System.out.println(number+"は偶数です");
     }
     else if(result==1)
     {
       System.out.println(number+"は奇数です。");
     }

  }
}
