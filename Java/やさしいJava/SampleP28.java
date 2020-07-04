import java.awt.*;
import java.awt.event.*;

public class SampleP28 extends Frame
{
  public static void main(String[]args)
  {
    SampleP28 sm = new SampleP28();
  }
  public SampleP28()
  {
    super("Lesson14-2");

    addWindowListener(new SampleWindowListener());

    setSize(250,200);
    setVisible(true);

  }
  public void paint(Graphics g)
  {
    g.fillRect(50,50,100,100);
  }
}
class SampleWindowListener extends WindowAdapter
{
  public void windowClosing(WindowEvent e)
  {
    System.exit(0);
  }
}
