//Lesson8練習問題5
class MyPoint
{
  private int x;
  private int y;

  public void setX(int px){
    this.x = px;
  }
  public void setY(int py){
    this.y = py;
  }
  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  //問題外コンストラクタ
  public MyPoint(){
    int x =0;
    int y=0;
    System.out.println("マイポイントクラスを作成しました。");
  }
}
class SampleP22
{
  public static void main(String[]args)
  {
    MyPoint mypoint = new MyPoint();

    mypoint.setX(10);
    mypoint.setY(5);

    int px = mypoint.getX();
    int py = mypoint.getY();

    System.out.println("X座標は"+px+",Y座標は"+py+"です。");
  }
}
