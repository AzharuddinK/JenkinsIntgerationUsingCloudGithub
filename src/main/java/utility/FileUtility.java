package utility;

import java.io.File;

import junit.framework.Assert;

public class FileUtility {
	
	public static String getFileAbsolutePath(String folderlocation){
		String filepath="";
		try{
			File file=getLastModified(folderlocation);
			filepath=file.getAbsolutePath();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return filepath;
	}
	
	public static File getLastModified(String directoryFilePath)
	{ 
		File chosenFile = null;
		try{
		File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }
	    
	}catch(Exception ex){
		System.out.println(ex.getMessage());
	}
	return chosenFile;
	}

	
	public static String getLastModifiedFileName(String directoryFilePath)
	{ 
		File chosenFile = null;
		try{
		File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }
	    
	}catch(Exception ex){
		System.out.println(ex.getMessage());
	}
	return chosenFile.getAbsolutePath();
	}
	
	public static String getAbsoluteFilePath(String...parameters){
		File filePath =null;
		try{
			filePath = new File(System.getProperty("user.dir") + "/"+parameters[0]+"/"+parameters[1]+parameters[2]);
			
		}catch(Exception ex){
			System.out.println("File is not present or corrupted "+ ex.fillInStackTrace());
		}
		return filePath.getAbsolutePath();
	}
}
