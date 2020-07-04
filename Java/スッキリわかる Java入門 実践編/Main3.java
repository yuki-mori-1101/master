interface Func1
{
  public abstract boolean call(int x);
}
interface Func2
{
  public abstract String call(boolean male,String name);
}
public class Main3
{
  public static void main(String[]args)
  {
    Func1 func1 = x -> x%2==1;
    Func2 func2 = (male,name) -> { if(male==true) return "Mr." + name;
                                                   else return "Ms." +name;
                                                 };
    System.out.println(func1.call(7));
    System.out.println(func2.call(false,"Mori"));
  }
}
