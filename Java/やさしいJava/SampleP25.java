import java.io.*;

class SampleP25
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("文字列を入力してください。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str = br.readLine();
     StringBuffer sb = new StringBuffer(str);

     System.out.println("aの挿入位置を整数で入力してください。");

     String intstr = br.readLine();
     int insertpoint = Integer.parseInt(intstr);

     sb = sb.insert(insertpoint,'a');

     System.out.println(sb+"になりました。");
  }
}
