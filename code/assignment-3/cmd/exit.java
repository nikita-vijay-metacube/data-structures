
import java.io.*;

public class exit
{

    public static void main(String[] args) throws Exception
    {
        Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
    }
}
