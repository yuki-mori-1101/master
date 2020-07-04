package idcard;
import framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
    private HashMap database = new HashMap();
    private int serial;
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }
    protected void registerProduct(Product product) {
        IDCard idCard = (IDCard)product;
        database.put(idCard.getSerial(), idCard.getOwner());
    }
    public HashMap getDatabase() {
        return database;
    }
}
