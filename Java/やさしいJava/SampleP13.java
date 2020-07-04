import java.io.*;

class SampleP13
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("整数を2つ入力してくださいい。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str1 = br.readLine();
     String str2 = br.readLine();
     int number1 = Integer.parseInt(str1);
     int number2 = Integer.parseInt(str2);

     if(number1>number2)
     {
       System.out.println(number2+"より"+number1+"の方が大きいです。");
     }
     else if(number2>number1)
     {
       System.out.println(number1+"より"+number2+"の方が大きいです。");
     }
     else if(number1==number2)
     {
       System.out.println("2つの値は同じ数です。");
     }

   }
}
