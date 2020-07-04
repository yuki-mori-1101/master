import java.io.*;

class SampleP20
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("2以上の整数を入力してください。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str = br.readLine();
     int number = Integer.parseInt(str);

     for(int i=2;i<=number;i++)
     {
       if(i==number)
       {
         System.out.println(number+"は素数です。");
       }
       else if(number%i==0)
       {
         System.out.println(number+"は素数ではありません。");
         break;
       }
     }
  }
}
