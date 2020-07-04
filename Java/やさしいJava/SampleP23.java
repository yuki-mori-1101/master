//Lesson9練習問題5
class MyPoint
{
  private int x;
  private int y;

  public void setX(int px){
    if(px>=0 && 100>=px)
    {
      this.x = px;
    }
    else
    {
      System.out.println("0〜100で入力してください。");
    }
  }
  public void setY(int py){
    if(py>=0 && 100>=py)
    {
      this.y = py;
    }
    else
    {
      System.out.println("0〜100で入力してください。");
    }
  }
  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  public MyPoint(){
    this.x = 0;
    this.y = 0;
    System.out.println("マイポイントクラスを作成しました。");
  }
  public MyPoint(int px,int py)
  {
    if(px>=0 && 100>=px)
    {
      this.x = px;
    }
    else
    {
      System.out.println("x:0〜100以外なので0でセットします。");
    }
    if(py>=0 && 100>=py)
    {
      this.y = py;
    }
    else
    {
      System.out.println("y:0〜100以外なので0でセットします。");
    }
    System.out.println("座標軸をセットしました。");
  }
}
class SampleP23
{
  public static void main(String[]args)
  {
    MyPoint mypoint = new MyPoint();
    System.out.println("X座標は"+mypoint.getX() +",Y座標は"+mypoint.getY() );
    mypoint = new MyPoint(101,101);
    System.out.println("X座標は"+mypoint.getX() +",Y座標は"+mypoint.getY() );
    mypoint = new MyPoint(10,10);
    System.out.println("X座標は"+mypoint.getX() +",Y座標は"+mypoint.getY() );

  }
}
