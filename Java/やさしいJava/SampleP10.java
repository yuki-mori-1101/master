import java.io.*;

class SampleP10
{
  public static void main(String[]args)throws IOException
{
  System.out.println("三角形の高さと底辺を入力してください。");

  BufferedReader br =
   new BufferedReader(new InputStreamReader(System.in));

   String str = br.readLine();
   double high = Double.parseDouble(str);

   BufferedReader br2 =
    new BufferedReader(new InputStreamReader(System.in));

    String str2 = br2.readLine();
    double base = Double.parseDouble(str2);

    double result = (base*high)/2;

    System.out.println(result);

}
}
