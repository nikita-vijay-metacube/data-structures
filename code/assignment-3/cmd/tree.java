import java.io.*;

class MyFilter implements FilenameFilter
{
 public boolean accept(File d,String fname)
 {
  try
  {
   File f=new File(d.getCanonicalPath()+"/"+fname);
   return f.isDirectory();
  }
  catch(IOException e){}
  return false;
 }
}

class tree
{
 public static void main(String arg[]) throws IOException
 {
  String dn=".";
  if(arg.length==1)
    dn=arg[0];

  File d=new File(dn);
  if(!d.isDirectory())
  {
   System.err.println("\nDirectory not found -"+arg[0]+"\n");
   System.exit(2);
  }

  System.out.print("\n"+d.getCanonicalPath());
  expend(d,"    ");
  System.out.println();
 }

 static void expend(File d,String spc)
 {
  File files[]=d.listFiles(new MyFilter());

  for(File f:files)
  {
   System.out.printf("\n%s%s",spc,f.getName());
   expend(f,spc+"    ");
  } 
 }
}