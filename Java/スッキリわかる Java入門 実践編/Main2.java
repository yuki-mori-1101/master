interface Func1
{
  public abstract boolean call(int x);
}
interface Func2
{
  public abstract String call(boolean male,String name);
}
public class Main2
{
  public static void main(String[]args)
  {
    FuncList2 funclist = new FuncList2();
    Func1 func1 = FuncList2 :: isOdd;
    Func2 func2 = funclist :: addNamePrefix;

    System.out.println(func1.call(7));
    System.out.println(func2.call(true,"Mori"));
  }
}
