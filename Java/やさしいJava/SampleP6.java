
import java.io.*;

class SampleP6
{
  public static void main (String[]args)throws IOException
  {
    System.out.println("あなたは何歳ですか?");

    BufferedReader br =
     new BufferedReader (new InputStreamReader(System.in));

     String str = br.readLine();
     System.out.println("あなたは" +str+ "歳です。");
  }

}
