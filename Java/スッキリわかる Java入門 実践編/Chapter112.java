import java.io.*;
import java.net.*;

public class Chapter112
{
  public static void main(String[]args)
  {
    Socket sock = null;
    OutputStream os = null;
    try
    {
      sock = new Socket("smtp.example.com",60025);
      os = sock.getOutputStream();
      os.write("HELO example.com¥r¥n".getBytes());
      //以下同手順にて問題文各行を読込
      os.flush();
      sock.close();
    }
    catch(IOException e)
    {
      try
      {
        os.flush();
        sock.close();
      }
      catch(IOException ee)
      { }
    }
  }
}
