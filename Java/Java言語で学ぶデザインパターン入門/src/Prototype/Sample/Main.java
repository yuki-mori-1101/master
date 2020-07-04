import framework.*;

public class Main {
    public static void main(String[] args) {
        //
        Manager manager = new Manager();
        NewUnderlinePen upen = new NewUnderlinePen('~');
        NewMessageBox mbox = new NewMessageBox('*');
        NewMessageBox sbox = new NewMessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        //
        NewProduct p1 = manager.create("strong message");
        p1.use("Hello, world.");
        NewProduct p2 = manager.create("warning box");
        p2.use("Hello, world.");
        NewProduct p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
