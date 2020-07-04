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
public class Chapter31
{
  public static void main(String[]args)
  {
    Hero hero1 = new Hero("斎藤");
    Hero hero2 = new Hero("鈴木");

    List<Hero> hero = new ArrayList<Hero>();
    hero.add(hero1);
    hero.add(hero2);

    for(Hero h:hero)
    {
      System.out.println(h.getName());
    }
  }
}
