import java.time.*;
import java.time.format.*;

public class Chapter22
{
  public static void main(String[]args)
  {
    LocalDateTime localdatetime = LocalDateTime.now();
    localdatetime = localdatetime.plusDays(100);

    DateTimeFormatter f = DateTimeFormatter.ofPattern("西暦yyyy年MM月dd日");

    String str = localdatetime.format(f);

    System.out.println(str);

  }
}
