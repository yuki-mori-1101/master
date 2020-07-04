import java.awt.*;
import java.awt.event.*;

public class SampleP29 extends Frame
{

  Image im;
  int x = 10;
  int y = 10;
  public static void main(String[]args)
  {
    SampleP29 sm = new SampleP29();
  }
  public SampleP29()
  {
    super("Lesson14-3");

    Toolkit tk = getToolkit();
    im = tk.getImage("Image,jpg");

    addWindowListener(new SampleWindowListener());

    setSize(250,200);
    setVisible(true);

  }
  public void paint(Graphics g)
  {
    g.drawImage(im,x,y,this);
  }
  class SampleWindowListener extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }
  class SampleMouseAdapter extends MouseAdapter
  {
    public void mousePressed(MouseEvent e)
    {
      x = e.getX();
      y = e.getY();
      repaint();
    }
  }
}
