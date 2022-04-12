package utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadTextFile {

	/***
	 * Read All Lines in File and store into List<String>
	 * @param filepath
	 * @return
	 */
	public static List<String> readLines(String filepath){
		List<String> result=null;
		try{
			result = Files.readAllLines(Paths.get(filepath));
		}catch(Exception ex){
			
		}
		
		return result;
	}
}
