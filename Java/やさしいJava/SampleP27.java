import java.awt.*;
import java.awt.event.*;

public class SampleP27 extends Frame
{
  private Label lb;

  public static void main(String[]args)
  {
    SampleP27 sm  = new SampleP27();
  }
  public SampleP27()
  {
    super("Lesson14-1");

    lb = new Label("Hello!");

    add(lb);

    lb.setForeground(Color.blue);
    lb.setFont(new Font("Selif",Font.ITALIC,32));

    addWindowListener(new SampleWindowListener());

    setSize(250,200);
    setVisible(true);

  }
  class SampleWindowListener extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }
}
