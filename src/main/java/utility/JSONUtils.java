package utility;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

	
	@SuppressWarnings("unchecked")
	public static String getPassword(String username,String filename){
		HashMap<String, Object> map = null;
		try {
			map = new ObjectMapper().readValue(Paths.get(System.getProperty("user.dir")+"/TestData/"+filename).toFile(), HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return map.get(username).toString();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static String getData(String username,String filepath){
		HashMap<String, Object> map = null;
		try {
			map = new ObjectMapper().readValue(Paths.get(filepath).toFile(), HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return map.get(username).toString();
	}
	
	public static void writeObjects2JsonFile(Map<String, String> data, String pathFile) {
		ObjectMapper mapper = new ObjectMapper();

		File file = new File(pathFile);
		try {
			// Serialize Java object info JSON file.
			mapper.writeValue(file, data);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to write hashmap to json file.");
		}
		
	}
}
