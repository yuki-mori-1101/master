
public class MemoryEater
{
  public static void main(String[]args)
  {
    System.out.println("MemoryEater...");
    long[] longarray = new long[1280000];
    for(int i =0;i<1280000;i++)
    {
      longarray[i] = i;
    }
  }
}
