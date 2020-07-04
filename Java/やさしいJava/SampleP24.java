import java.io.*;

class SampleP24
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("文字列を入力して下さい.");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str = br.readLine();

     StringBuffer sb = new StringBuffer(str);
     sb = sb.reverse();

     System.out.println(str+"を逆順にすると"+sb+"です。");
  }
}
