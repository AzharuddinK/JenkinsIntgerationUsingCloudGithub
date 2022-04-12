package filesInputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFiles {
	
	public static void main(String[] args) throws IOException {
        String zipFilePath = System.getProperty("user.dir")+"/Downloads/";
        unzipFiles(zipFilePath, zipFilePath);
    }

	public static void unzipFiles(String src,String dest) throws IOException {
	        List<String> listOfzipFiles=getFileNames(src);
	        for(int i=0;i<listOfzipFiles.size();i++) {
	        	unzip(src+listOfzipFiles.get(i), src);
	        }
	}
	
	
	
    private static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
	private static List<String> getFileNames(String path) throws IOException {
		List<String> zipFiles = new ArrayList<>();
		File folder = new File(path);
		File[] files = folder.listFiles();
		for (File file : files) {
			if(file.getName().contains(".zip")) {
				zipFiles.add(file.getName());
			}
		}
		return zipFiles;
	}

}
