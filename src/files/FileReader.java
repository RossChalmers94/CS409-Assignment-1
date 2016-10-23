package files;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader {
	
	private static ArrayList<File> files = new ArrayList<File>();
	
	

	public FileReader(){
		
	}
	
	public static ArrayList<File> readFiles(File filePath){
		
		for(File file : filePath.listFiles()){
			if(file.isDirectory()){
				readFiles(file);
			}
			else
			{
				if(file.getName().endsWith(".java")){
				 files.add(file);
				}
			}
			
		}
		return files;
		
	}

}
