import java.io.*;

class mkdir 
{
 public static void main(String arg[])
 {
  if(arg.length==0)
  {
   System.err.println("\nRequired Parameter Missing..\n");
   System.exit(1);
  }
  
  File d=new File(arg[0]);

  if(!d.mkdirs())
    System.err.println("\nCannot create directory - "+arg[0]+"\n");  
 }
}
