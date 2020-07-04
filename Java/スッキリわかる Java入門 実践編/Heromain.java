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
class Heromain
{
  public static void main(String[]args)
  {
    Hero h1 = new Hero("斎藤");
    Hero h2 = new Hero("鈴木");
    Map<Hero,Integer> heroes = new HashMap<Hero,Integer>();
    heroes.put(h1,7);
    heroes.put(h2,3);
    for(Hero key:heroes.keySet())
    {
      Integer value = heroes.get(key);
      System.out.println(key.getName()+"が倒した敵="+value);
    }
  }
}
