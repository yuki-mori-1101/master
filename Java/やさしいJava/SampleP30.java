import java.awt.*;
import java.awt.event.*;

public class SampleP30 extends Frame
{
  private Button bt;

  public static void main(String[]args)
  {
    SampleP30 sm = new SampleP30();
  }
  public SampleP30()
  {
    super("Lesson14-4");

    bt = new Button("さようなら");
    add(bt);

    addWindowListener(new SampleWindowListener());
    bt.addMouseListener(new SampleMouseListener());

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
  class SampleMouseListener implements MouseListener
  {
    public void mouseClicked(MouseEvent e){}
      public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
          public void mouseEntered(MouseEvent e)
          {
            bt.setLabel("ようこそ");
          }
          public void mouseExited(MouseEvent e)
          {
            bt.setLabel("さようなら");
          }
  }
}
