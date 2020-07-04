import java.io.*;

class SampleP7
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("円周率の値はいくつですか?");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));
     String str = br.readLine();

     System.out.println("円周率の値は"+str+"です。");
  }
}
