import java.util.*;
import java.text.*;

public class Chapter21
{
  public static void main(String[]args)
  {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int future = day+100;
    calendar.set(Calendar.DAY_OF_MONTH,future);
    date = calendar.getTime();

    SimpleDateFormat sdf = new SimpleDateFormat("西暦yyyy年MM月dd日");
    System.out.println(sdf.format(date));
  }

}
