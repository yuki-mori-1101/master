import java.util.*;

class Hero
{
  private String name;
  public Hero(String name)
  {
    this.name = name;
  }
  public String getName()
  {
    return this.name;
  }
}
public class Chapter32
{
  public static void main(String[]args)
  {
    Hero hero1 = new Hero("斎藤");
    Hero hero2 = new Hero("鈴木");

    Map<Hero,Integer> heros = new  HashMap<Hero,Integer>();
    heros.put(hero1,3);
    heros.put(hero2,7);

    for(Hero key:heros.keySet())
    {
      int value = heros.get(key);
      System.out.println(key.getName()+"が倒した敵="+value);
    }
  }
}
