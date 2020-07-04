import org.apache.commons.lang3.builder.*;
import java.util.*;

public class BookforChapter82 implements Comparable<BookforChapter82>,Cloneable
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
  public int hashCode()
  {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  public boolean equals(Object o)
  {
    return EqualsBuilder.reflectionEquals(this,o);
  }
  public int compareTo(BookforChapter82 o)
  {
    return CompareToBuilder.reflectionCompare(this,o);
  }
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this);
  }
}
