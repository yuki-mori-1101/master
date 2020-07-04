import java.util.function.*;
//SAMinterfaceの宣言①
interface Func1{
  public abstract boolean function1(int x);
}
//SAMinterfaceの宣言②
interface Func2{
  public abstract String function2(boolean male,String name);
}
//関数処理内容の定義→FuncList.javaに定義
//FuncListにて定義された関数処理をSAMinterfaceに代入
public class Chapter62
{
  public static void main(String[]args)
  {
    FuncList funclist1 = new FuncList();
    Func1 func1 = x -> x%2==1;
    Func2 func2 = (male,name) -> {
      if(male==true){ return "Mr."+name; }
      else{ return "Ms."+name; }
    };
    boolean a = func1.function1(5);
    String b = func2.function2(true,"森");

    System.out.println(a);
    System.out.println(b);
  }
}
