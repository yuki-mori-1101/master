import java.sql.*;
import java.util.*;
import java.io.*;

class ItemDAO
{
  public static ArrayList<Item> findByMinimumPrice(int i)
  {
    try
    {
      Class.forName("org.h2.Driver");
    }
    catch(ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    Connection con = null;
    try
    {
      con = DriverManager.getConnection("jcbc:h2:~/rpgdb");
      PreparedStatement pstmt = con.prepareStatement
           ("SELECT * FROM ITEMS WHERE PRICE > ?");
      pstmt.setInt(1,1);
      ResultSet rs = pstmt.executeQuery();
      ArrayList<Item> items = new ArrayList<Item>();
      while(rs.next())
      {
        Item item = new Item();
        item.setName(rs.getString("String"));
        item.setPrice(rs.getInt("PRICE"));
        item.setWeight(rs.getInt("WEIGHT"));
        items.add(item);
      }
      rs.close();
      pstmt.close();
      return items;
    }
    catch(SQLException ee)
    {
      ee.printStackTrace();
    }
    finally
    {
      if(con!=null)
      {
        try
        {
          con.close();
        }
        catch(SQLException eee)
        {
          eee.printStackTrace();
        }
      }
    }
  }
}
