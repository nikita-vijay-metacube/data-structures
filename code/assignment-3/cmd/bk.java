
import java.io.*;

public class bk
{
    public static void main(String[] args) throws Exception
    {
        
        String currentpath=System.getProperty("user.dir");
        if (null != currentpath && currentpath.length() > 0 )
        {
            int endIndex = currentpath.lastIndexOf("\\");
            if (endIndex != -1)  
            {
                currentpath = currentpath.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
            }
        }  
        Process p = Runtime.getRuntime().exec("cmd.exe /c start cd "+currentpath+"\"/\" && dir");
    }
}
