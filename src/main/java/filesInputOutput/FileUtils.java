package filesInputOutput;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {

	
	public final static String ROOT_PATH ="C:\\Users\\azhar\\OneDrive\\Desktop\\FileTotest";
	public static void main(String[] args) throws IOException {
		
		copyAllFilesFromSubDirectoriesToParent(ROOT_PATH);
	   File f = new File(ROOT_PATH);
	   deleteSubDirectoryFromParent(f);
	}
	
	
	
	public static void copyAllFilesFromSubDirectoriesToParent(String ParentFolderPath) {
		List<String> listOfFiles;
		List<String> names;
		try {
			listOfFiles = listFilesFromSubDirectories(ParentFolderPath);
			names=getFileNames(ParentFolderPath);
			Path sourceDir,targetDir;
			for(int i=0;i<listOfFiles.size();i++) {
				sourceDir=Paths.get(listOfFiles.get(i));
				targetDir = Paths.get(ParentFolderPath+"/"+names.get(i));
				Files.copy(sourceDir, targetDir,StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static long getListOfDirectries(URI abspath) {
		
		long count = 0;
		try {
			count = Files.find(
				    Paths.get(abspath), 
				    1,  // how deep do we want to descend
				    (path, attributes) -> attributes.isDirectory()
				).count() - 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;		
	}
	
	
public static long getListFiles(URI absolutePath) {
		
		long count = 0;
		try {
			count = Files.find(
				    Paths.get(absolutePath), 
				    1,  // how deep do we want to descend
				    (path, attributes) -> attributes.isRegularFile()
				).count() - 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;		
	}
	
	
	

	private static List<String> listFilesFromSubDirectories(String path) throws IOException {
		List<String> filepaths = new ArrayList<>();

		File folder = new File(path);

		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				File[] f = file.listFiles();
				for (File ff : f) {
					//System.out.println(ff.getAbsolutePath());
					filepaths.add(ff.getAbsolutePath());
				}

			}
		}
		
		return filepaths;
	}

	
	private static List<String> getFileNames(String path) throws IOException {
		List<String> names = new ArrayList<>();

		File folder = new File(path);

		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				File[] f = file.listFiles();
				for (File ff : f) {
					names.add(ff.getName());
				}

			}
		}
		
		return names;
	}
	
	
	private static void deleteSubDIR(String path) throws IOException {
		File folder = new File(path);
		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
			 deleteSubDIR(path);
			}
		}
		
		
	}

	public static void deleteFileWithSpecificExtensionFromRootFolder(String path,String extension) throws IOException {
		File folder = new File(path);
		File[] files = folder.listFiles();
		for (File file : files) {
			if(file.isDirectory()==false && file.getName().contains(extension)==true) {
				file.delete();
			}
		}
	System.out.println(" All "+extension+" files Has been deleted successfully from Root Folder...");
	}
	
	
	
	public static void deleteSubDirectoryFromParent(File directory) {
        if (directory.exists()&&directory.isDirectory()) {
               File[] files = directory.listFiles();
               if (null != files) {
                     for (int i = 0; i < files.length; i++) {
                            System.out.println(files[i].getName());
                            if (files[i].isDirectory()) {
                               File[] ff = files[i].listFiles();
                               for(int k=0;k<ff.length;k++) {
                            	   ff[0].delete();
                            	   files[i].delete();
                               }
                               deleteSubDirectoryFromParent(directory);
                            } 
                          
                     }
               }
             
        }
 }
	
}
