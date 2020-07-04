public class Chapter211
{
  public static void main(String[]args)
  {
    StringBuilder sb = new StringBuilder();
    for(int i=1;i<=100;i++)
    {
      sb.append(i).append(",");
    }
    String s = sb.toString();
    String[] a = s.split(",");
    for(int j=0;j<100;j++)
    {
      System.out.println(a[j]);//String[]配列
    }
  }
}
