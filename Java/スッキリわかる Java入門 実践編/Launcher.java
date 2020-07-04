import java.lang.reflect.*;

public class Launcher
{
  public static void main(String[]args)
  {
    try
    {
      //第一引数FQCNクラス情報
      Class<?> cinfo = Class.forName(args[0]);
      String fqcn = cinfo.getName();
      //起動方法情報
      String launch = args[1];
      //現在メモリ使用量(MB)表示(下記メソッド①)
      showmemory();
      //FQCNクラス内包全メソッド名の表示(下記メソッド②)
      showmethod(cinfo);
      //第二引数による場合分け
      if(launch.equals("E"))
      {
        //別プロセスとして起動(下記メソッド③)
        launchExternal(cinfo);
        //現在メモリ使用量(MB)表示(下記メソッド①)
        showmemory();
        //起動成功
        System.exit(1);
      }
      else if(launch.equals("I"))
      {
        //リフレクションにてmainメソッド呼び出し
        launchInternal(cinfo);
        //現在メモリ使用量(MB)表示(下記メソッド①)
        showmemory();
        //起動成功
        System.exit(1);
      }
      else
      {
        //現在メモリ使用量(MB)表示(下記メソッド①)
        showmemory();
        //起動失敗
        System.exit(0);
      }
    }
    catch(Exception e)
    {
      //現在メモリ使用量(MB)表示(下記メソッド①)
      showmemory();
      //起動失敗
      System.exit(0);
    }
  }
  //①現在メモリ使用量(MB単位)表示メソッド
  public static void showmemory()
  {
    long total = Runtime.getRuntime().totalMemory();
    long free = Runtime.getRuntime().freeMemory();
    long now = ((total - free)/1024/1024) ;
    System.out.println("現在メモリ使用量:"+now+"MB");
  }
  //②FQCNクラス内包全メソッド名の表示
  public static void showmethod(Class<?> clazz)throws Exception
  {
    Method[] method = clazz.getDeclaredMethods();
    System.out.println("メソッド名一覧を表示します");
    for(Method m:method)
    {
      System.out.println(m.getName());
    }
  }
  //③ProcesBuilderで別プロセスとして起動
  public static void launchExternal(Class<?> clazz)throws Exception
  {
    ProcessBuilder pb = new ProcessBuilder("java",clazz.getName());
    Process process = pb.start();
    process.waitFor();
  }
  //④リフレクションでmainメソッド呼び出し
  public static void launchInternal(Class<?> clazz)throws Exception
  {
    Method method = clazz.getMethod("main",String[].class);
    String[] args = {};
    method.invoke(null,(Object)args);
  }
}
