import java.io.*;

class SampleP11
{
  public static void main(String[]args)throws IOException
{
  System.out.println("科目1〜5の点数を入力してください。");

  BufferedReader br =
   new BufferedReader(new InputStreamReader(System.in));

   String str1 = br.readLine();
   String str2 = br.readLine();
   String str3 = br.readLine();
   String str4 = br.readLine();
   String str5 = br.readLine();

   int score1 = Integer.parseInt(str1);
   int score2 = Integer.parseInt(str2);
   int score3 = Integer.parseInt(str3);
   int score4 = Integer.parseInt(str4);
   int score5 = Integer.parseInt(str5);

   int sum = score1+score2+score3+score4+score5;
   int average = sum/5;

   System.out.println("5科目の合計点は"+sum+"です。");
   System.out.println("5科目の平均点は"+average+"です。");

}
}
