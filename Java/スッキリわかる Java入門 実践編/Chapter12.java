import java.io.*;

class Name
{
  public static String conntact(String folder,String file)
  {
    if( !(folder.endsWith("¥")) )
    {
      folder = folder+"¥";
    }
    return folder+file;
  }
}

public class Chapter12
{
  public static void main(String[]args)
  {
    try
    {
      BufferedReader br =
       new BufferedReader(new InputStreamReader(System.in));
      System.out.print("フォルダ名＞");
      String str1 = br.readLine();
      System.out.print("ファイル名＞");
      String str2 = br.readLine();

      String str = Name.conntact(str1,str2);

      System.out.println(str);
    }
    catch(IOException e)
    {
      System.out.println("エラー");
    }
  }
}
