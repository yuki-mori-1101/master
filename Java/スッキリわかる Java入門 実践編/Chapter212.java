
class Classpath
{
  public static String path(String folder,String file)
  {
    if(! (folder.matches(".*¥¥")) )
    {
      folder += "¥¥";
    }
    return folder + file;
  }
}

class Chapter212
{
  public static void main(String[]args)
  {
    System.out.println(Classpath.path("abcde","fghijk"));
  }
}
