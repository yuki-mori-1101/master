package framework;
import java.util.*;

public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, NewProduct proto) {
        showcase.put(name, proto);
    }
    public NewProduct create(String protoname) {
        NewProduct p = (NewProduct)showcase.get(protoname);
        return p.createClone();
    }
}
