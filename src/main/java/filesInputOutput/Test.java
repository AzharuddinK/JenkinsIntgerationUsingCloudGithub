package filesInputOutput;

import java.io.File;
import java.io.IOException;


public class Test {
	
	public final static String ROOT_PATH = System.getProperty("user.dir")+"/Downloads/";
	public static void main(String[] args) throws IOException {
		
		UnzipFiles.unzipFiles(ROOT_PATH, ROOT_PATH);
		//FileUtils.copyAllFilesFromSubDirectoriesToParent(ROOT_PATH);
		FileUtils.deleteFileWithSpecificExtensionFromRootFolder(ROOT_PATH,".zip");
		 //File file = new File(ROOT_PATH);
		//FileUtils.deleteSubDirectoryFromParent(file);
		
		
	}
	
	
	

	
}
