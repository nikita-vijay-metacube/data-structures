// Java Program to Search for a File in a Directory 
import java.io.File;
import java.util.function.Function; 

public class find { 
	
	public static void main(String[] argv) throws Exception 
	{ 
		// Create an object of the File class 
		// Replace the file path with path of the directory 
		// File directory = new File("/home/user/"); 
        File directory=new File(System.getProperty("user.dir"));
		// File directory = new File(argv[0]); 

		// store all names with same name 
		// with/without extension 
		String[] flist = directory.list(); 
		int flag = 0; 
		if (flist == null) { 
			System.out.println("Empty directory."); 
		} 
		else { 

			// Linear search in the array 
			for (int i = 0; i < flist.length && flag==0; i++) { 
				String filename = flist[i]; 
                String dirpath = System.getProperty("user.dir");
                flag = evaluateDirectory(dirpath,filename,argv[0]);
			} 
		} 

		if (flag == 0) { 
			System.out.println("File Not Found"); 
		} 
	} 
    static int evaluateDirectory(String dirpath,String filename,String searchDir){
        int returnVal = 0;
        if (filename.equalsIgnoreCase(searchDir)) { 
            System.out.println(filename + " found in \"" + dirpath +"\""); 
            returnVal = 1; 
        } 
        dirpath=dirpath+"/"+filename;
        File subdirectory=new File(dirpath);
        String[] subDir = subdirectory.list();
		if (!(subDir == null)) { 
			for (int i = 0; i < subDir.length && returnVal==0; i++) { 
				filename = subDir[i]; 
                returnVal = evaluateDirectory(dirpath,filename,searchDir);
			} 
        }
        return returnVal;
    }
}
