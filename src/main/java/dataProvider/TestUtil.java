package dataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class TestUtil {
	
	//CSV DATA PROVIDER
	public static Object[][] csvDataProvider(String filename) throws IOException {

		//get Map<String,Map<String,String>
		Map<String, Map<String, String>> data = CsvFileReader.getCSVData(filename);
		//create 2D Array where column size is fixed to 1 
		Object[][] obj = new Object[data.size()][1];
		//iterate map and store into 2d Array
		for (int i = 0; i < data.size(); i++) {
			obj[i][0] = data.get(String.valueOf(i + 1));
		}
		return obj;  // return 2d Array
	}
	
	//JSON DATA PROVIDER
	  @SuppressWarnings("unchecked")
		public static Object[][] jsonDataProvider(String filename) throws IOException {
	  	    List<Map<String, String>> listOfParamMaps = new ArrayList<Map<String, String>>();
	        Jsonb jsonb = JsonbBuilder.create();
	        Path pathRaw = Paths.get(System.getProperty("user.dir")+"/TestData/"+filename+".json");
	        Map<String, String> stringMap = new HashMap<>();
	     
	        try (BufferedReader br = Files.newBufferedReader(pathRaw, StandardCharsets.UTF_8)) {

	            String line;
	            while ((line = br.readLine()) != null) {
	                stringMap = jsonb.fromJson(line, HashMap.class);
	                listOfParamMaps.add(stringMap);
	            }
	            
	        }
	        
	        Object[][] objecttoreturn = new Object[listOfParamMaps.size()][1];
			for (int i = 0; i < listOfParamMaps.size(); i++) {
				objecttoreturn[i][0] = listOfParamMaps.get(i);
			}
			return objecttoreturn;
	    }
	
	@DataProvider(name="csvDataProvider")
	public static Object[][] getCSVData(Method m, ITestContext iTestContext) throws IOException{
		String methodName = m.getName();
		return TestUtil.csvDataProvider(methodName);
	}
	
	@DataProvider(name="csvDataProvider1")
	public static Object[][] getCSVData1(Class<?> cl, ITestContext iTestContext) throws IOException{
		String name = cl.getSimpleName();
		return TestUtil.csvDataProvider(name);
	}

  
    
    @DataProvider(name="jsonUsingClassName")
	public static Object[][] getJsonData(Class<?> cl, ITestContext iTestContext) throws IOException{
		String name = cl.getSimpleName();
		return TestUtil.jsonDataProvider(name);
	}

	@DataProvider(name="jsonUsingMethodName")
	public static Object[][] getJsonData(Method m, ITestContext iTestContext) throws IOException{
		String methodName = m.getName();
		return TestUtil.jsonDataProvider(methodName);
	}
}
