package framework;
import java.lang.Cloneable;

public abstract class NewProduct implements Cloneable {
    abstract public void use(String s);
    public NewProduct createClone(){
      NewProduct p = null;
      try {
          p = clone();
      } catch (CloneNotSupportedException e) {
          e.printStackTrace();
      }
      return p;
    }
    @Override
    public NewProduct clone() throws CloneNotSupportedException{
      NewProduct p = (NewProduct) super.clone();
      return p;
    }
}
