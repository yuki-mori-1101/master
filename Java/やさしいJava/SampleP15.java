import java.io.*;

class SampleP15
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("成績を入力してください。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     String str = br.readLine();
     int score = Integer.parseInt(str);

     switch(score)
     {
       case 1:
       System.out.println("もっと頑張りましょう。");
       break;
       case 2:
       System.out.println("もう少し頑張りましょう");
       break;
       case 3:
       System.out.println("さらに上を目指して頑張りましょう。");
       break;
       case 4:
       System.out.println("大変よくできました。");
       break;
       case 5:
       System.out.println("大変優秀です。");
       break;
     }
  }
}
