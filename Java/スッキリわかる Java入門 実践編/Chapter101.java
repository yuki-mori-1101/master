import java.io.*;
import java.util.*;

public class Chapter101
{
  public static void main(String[]args)throws IOException
  {
    Reader fr = new FileReader("c¥¥pref.properties");
    Properties p = new Properties();
    p.load(fr);
    String strcapital = p.getProperty("aichi.capital");
    String strfood = p.getProperty("aichi.food");
    System.out.println(strcapital+":"+strfood);
    fr.close();
  }
}
