package idcard;
import framework.*;

public class IDCard extends Product {
    private String owner;
    private int serial;
    IDCard(String owner, int serial) {
        System.out.println(owner + "(" + serial + ")" + "�̃J�[�h�������܂��B");
        this.owner = owner;wΩ
        this.serial = serial;
    }
    public void use() {
        System.out.println(owner + "(" + serial + ")" + "�̃J�[�h���g���܂��B");
    }
    public String getOwner() {
        return owner;
    }
    public int getSerial() {
        return serial;
    }
}
