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
public class Chapter61
{
  public static void main(String[]args)
  {
    FuncList funclist1 = new FuncList();
    Func1 func1 = FuncList::isOdd;
    Func2 func2 = funclist1::addNamePrefix;
    boolean a = func1.function1(6);
    String b = func2.function2(true,"森");

    System.out.println(a);
    System.out.println(b);
  }
}
