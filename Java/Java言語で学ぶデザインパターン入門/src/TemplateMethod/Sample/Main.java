public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');                  // 'H'��������CharDisplay�̃C���X�^���X��1�����B
        AbstractDisplay d2 = new StringDisplay("Hello, world.");    // "Hello, world."��������StringDisplay�̃C���X�^���X��1�����B
        AbstractDisplay d3 = new StringDisplay("�����ɂ��́B");     // "�����ɂ��́B"��������StringDisplay�̃C���X�^���X��1�����B
        d1.display();                                               // d1,d2,d3�Ƃ��A���ׂē���AbstractDisplay�̃T�u�N���X�̃C���X�^���X�������A
        d2.display();                                               // �p������display���\�b�h���Ăяo�����Ƃ��ł����B
        d3.display();                                               // ���ۂ̓����͌X�̃N���XCharDisplay��StringDisplay�Œ��܂��B
    }
}__
