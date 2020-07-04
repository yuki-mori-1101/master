import java.io.*;

class SampleP21
{
  public static void main(String[]args)throws IOException
  {
    System.out.println("5人のテスト点数を入力してください。");

    BufferedReader br =
     new BufferedReader(new InputStreamReader(System.in));

     int[] test = new int[5];

     for(int i=0;i<5;i++)
     {
       String str = br.readLine();
       test[i] = Integer.parseInt(str);
     }
     for(int n=0;n<test.length;n++)
     {
       System.out.println(n+1+"番目のテスト点数は"+test[n]+"です。");

     }
     for(int j=0;j<test.length;j++)
     {
       for(int k=j+1;k<test.length;k++)
       {
         if(test[k]>test[j])
         {
           int tmp = test[k];
           test[k] = test[j];
           test[j] = tmp;
         }
       }
     }
     System.out.println("最高点は"+test[0]+"です。");
     System.out.println("その他含め上から順に出力します。");
     for(int l=0;l<test.length;l++)
     {
       System.out.println(l+1+"番："+test[l]);
     }
  }
}
