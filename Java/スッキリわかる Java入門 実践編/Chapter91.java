import java.io.*;

class Chapter91
{
  //問題文ではエラー処理不要だが、コンパイルの為に『throws IOException』記述
  public static void main(String[]args)throws IOException
  {
    String fromfile = args[0];
    String tofile = args[1];

    FileInputStream fis = new FileInputStream(fromfile);
    FileOutputStream fos = new FileOutputStream(tofile);
    int i = fis.read();
    while( !(i==-1) )
    {
      fos.write(i);
      i = fis.read();
    }
    fos.flush();
    fos.close();
    fis.close();
  }
}
/*
問題文指定外のjava.nio.Pathインターフェース/Fileクラス使用
import java.nio.*;

class Chapter91
{
  public static vpid main(String[]args)
  {
    File.copy(Path.get(args[0].args[1]));
  }
  */
