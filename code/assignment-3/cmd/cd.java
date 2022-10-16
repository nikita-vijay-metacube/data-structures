
import java.io.*;

public class cd
{

    public static void main(String[] args) throws Exception
    {
        
        String currentpath=System.getProperty("user.dir");
        System.out.println("currentpath "+currentpath+"\"/"+args[0]);
        Process p = Runtime.getRuntime().exec("cmd.exe /c start cd "+currentpath+"\"/"+args[0]+"\" && dir");
    }
}
