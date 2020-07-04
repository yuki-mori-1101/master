import java.util.*;

public class Book implements Comparable<Book>,Cloneable
{
  private String title;
  private Date publishDate;
  private String comment;

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
  //equals()メソッドのオーバーライド
  public boolean equals(Object o){
    if(o == this) {return true;}
    if(o == null) {return false;}
    if( !(o instanceof Book) ) {return false;}
    Book r = (Book) o;
    if( !(this.title.equals(r.title)) ) {return false;}
    if( !(this.publishDate.equals(r.publishDate)) ) {return false;}
    return true;
  }
  public int hashCode(){
    int result = 37;
    result = result*31+title.hashCode();
    result = result*31+publishDate.hashCode();
    result = result*31*comment.hashCode();
    return result;
  }
  public int compareTo(Book obj){
    return this.publishDate.compareTo(obj.publishDate);
  }
  public Book clone(){
    Book book = new Book();
    book.title = this.title;
    book.publishDate = (Date)this.publishDate.clone();
    book.comment = this.comment;
    return book;
  }
}
