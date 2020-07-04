import java.org.apache.commons.lang3.builder.*;

public class Book implements Comparable<Book>,Cloneable
{
  //フィールドの宣言
  private String title;
  private Date publishDate;
  private String comment;
  /*equals()メソッドのオーバーライド
  public boolean equals(Object o){
    if(o == this) {return true;}
    if(o == null) {return false;}
    if( !(o instanceof Book) ) {return false;}
    Book r = (Book) o;
    if( !(this.title.equals(r.title)) ) {return false;}
    if( !(this.publishDate.equals(r.publishDate)) ) {return false;}
    return true;
  }*/
  //→→→EqualsBuilderにてequals定義
  public boolean equals(Object o){
    return EqualsBuilder.refrectionEquals(this,o);
  }
  /*hashCode()メソッドのオーバーライド
  public int hashCode(){
    int result = 37;
    result = result*31+title.hashCode();
    result = result*31+publishDate.hashCode();
    result = result*31*comment.hashCode();
    return result;
  }*/
  //→→→HashCodeBuilderにてhashcode定義
  public int hashCode(){
    return HashCodeBuilder.reflectionHashCode(this);
  }
  /*compareTo()メソッドのオーバーライド
  public int compareTo(Book obj){
    return this.publishDate.compareTo(obj.publishDate);
  }*/
  public int compareTo(Book o){
    return CompareToBuilder.reflectionCompare(this,o);
  }
  //clone()メソッド定義
  public Book clone(){
    Book book = new Book();
    book.title = this.title;
    book.publishDate = (Date)this.publishDate.clone();
    book.comment = this.comment;
    return book;
  }
  public String getTitle(){
    return this.title;
  }
  public Date getPublishDate(){
    return this.publishDate;
  }
  public String getComment(){
    return this.comment;
  }
  public void setTitle(String s){
    this.title = s;
  }
  public void setPublishDate(Date d){
    this.publishDate = d;
  }
  public void setComment(String t){
    this.comment = t;
  }
}
