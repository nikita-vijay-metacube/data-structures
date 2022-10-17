import java.io.*;

class ls
{
 public static void main(String arg[]) throws IOException
 {
  String dn="."; 

  if(arg.length==1)
    dn=arg[0];

  File d=new File(dn);

  if(!d.isDirectory())
  {
   System.out.println("\nDirectory not found - "+arg[0]+"\n");
   System.exit(1);
  }
    
//  String fnames[]=d.list();
//  System.out.println();

/* 
  dn=d.getCanonicalPath();  

  for(String s:fnames)
  {
   File f=new File(dn+"/"+s);
   System.out.printf("\n\t%-40s %s",s,f.exists());
  }
*/


/*
  for(String s:fnames)
  {
   File f=new File(s);
   System.out.printf("\n\t%-40s %s",s,f.exists());         //it does't work on child directory 
  }
*/



  File files[]=d.listFiles();
  for(File f:files)
  {
   System.out.printf("\n\t%-40s %s",f.getName(),f.exists());
  }
  System.out.println();
 }
}