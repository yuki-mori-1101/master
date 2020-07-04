import java.awt.*;
import java.awt.event.*;

public class SampleP31 extends Frame implements Runnable
{
  int x=100;
  int y=100;
  int num;

  public static void main(String[]args)
  {
    SampleP31 sm = new SampleP31();
  }
  public SampleP31()
  {
    super("Lesson14-5");

    Thread th;
    th = new Thread(this);
    th.start();

    setSize(250,200);
    setVisible(true);
  }
  public void run()
  {
    try
    {
      for(int i=0;i<10;i++)
      {
        num =i;
        repaint();
        Thread.sleep(1000);
        x +=10;
      }
    }
    catch(InterruptedException e){}
  }
  public void paint(Graphics g)
  {
    String str = num +"です。";
    g.drawString(str,x,y);
  }
  class SampleWindowListener extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }
}
