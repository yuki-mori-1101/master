import java.io.*;
import java.net.*;

public class Chapter111
{
  public static void main(String[]args)
  {
    URL url = null;
    InputStream is = null;
    OutputStream os = null;
    try
    {
      url = new URL("http://dokojava.jp/favicon.ico");
      is = url.openStream();
      os = new FileOutputStream("dj.ico");
      int i = is.read();
      while(i != -1)
      {
        os.write((byte)i);
        i = is.read();
      }
    }
    catch(IOException e)
    {
      System.out.println("エラー");
    }
    finally
    {
      try
      {
        os.flush();
        is.close();
        os.close();
      }
      catch(IOException ee)
      {  }
    }
  }
}
