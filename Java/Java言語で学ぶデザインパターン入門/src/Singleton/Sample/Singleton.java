public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton() {
        System.out.println("�C���X�^���X�𐶐����܂����B");
    }
    public static Singleton getInstance() {
        return singleton;
    }
}
