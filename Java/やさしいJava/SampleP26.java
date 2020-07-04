import java.io.*;

class SampleP26
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("2つの整数を入力してください。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str = br.readLine();
     int a = Integer.parseInt(str);
     str = br.readLine();
     int b = Integer.parseInt(str);

     int big = Math.min(a,b);

     System.out.println(a+"と"+b+"のうち小さい整数は"+big+"です。");
   }
}
