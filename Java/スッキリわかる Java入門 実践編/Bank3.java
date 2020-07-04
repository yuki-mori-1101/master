import org.apache.commons.lang3.builder.*;

public class Bank3
{
  String name;
  String address;
  public Bank3(String name,String address)
  {
    this.name = name;
    this.address = address;
  }
  public boolean equals(Object o)
  {
    return EqualsBuilder.reflectionEquals(this,o);
  }
  public int hashcode()
  {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}
