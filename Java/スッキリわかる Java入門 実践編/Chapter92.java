import java.io.*;
import java.util.zip.GZIPOutputStream;

class Chapter92
{
  //問題文ではエラー処理不要だが、コンパイルの為に『throws IOException』記述
  public static void main(String[]args)throws IOException
  {
    String fromfile = args[0];
    String tofile = args[1];
    FileInputStream fis = null;
    GZIPOutputStream gzos = null;
    try
    {
      fis = new FileInputStream(fromfile);
      FileOutputStream fos = new FileOutputStream(tofile);
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      gzos = new GZIPOutputStream(bos);
      int i = fis.read();
      while( !(i==-1) )
      {
        gzos.write(i);
        i = fis.read();
      }
      gzos.flush();
      gzos.close();
      gzos.close();
    }
    catch(IOException e)
    {
      System.out.println("エラー");
      try
      {
        if( fis!=null)
        {
          fis.close();
        }
        if( gzos!=null)
        {
          gzos.close();
        }
      }
      catch(IOException ee)
      { }
    }
  }
}
