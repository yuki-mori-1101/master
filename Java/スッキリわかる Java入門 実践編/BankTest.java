import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest
{
  //3文字の確認
  @Test public void threenamecheck()
  {
    Bank bank = new Bank();
    bank.setName("あああ");
  }
  //2文字の確認
  @Test(expected=IllegalArgumentException.class)
   public void twonamecheck()
  {
    Bank bank = new Bank();
    bank.setName("ああ");
  }
  //nullの確認
  @Test public void nullnamecheck()
  {
    try
    {
      Bank bank = new Bank();
      bank.setName(null);
    }
    catch(NullPointerException e)
    {
      return;
    }
    fail();
  }
}
