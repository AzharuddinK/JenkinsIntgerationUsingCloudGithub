package dataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvFileReader {

	

	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws IOException {
		/*String CSVFILEPATH =System.getProperty("user.dir")+"/testData"+"/"+"login"+".csv";
		File file = new File(CSVFILEPATH);
		byte[] bytes = FileUtils.readFileToByteArray(file);
		String data = new String(bytes);
		System.out.println(data);

		data = StringUtils.replaceAll(data, "\r", "");
		String[] dataArray = data.split("\n");

		String keys = dataArray[0];

		Map<String, Map<String, String>> outermap = new HashMap<>();

		List<String> keysfromfile = new ArrayList<>();
		String[] keyArr = keys.split(",");
		keysfromfile.addAll(Arrays.asList(keyArr));
		keysfromfile.remove(0);

		for (int d = 1; d < dataArray.length; d++) {
			Map<String, String> mp = new HashMap<>();
			List<String> row = new ArrayList<>();
			String[] rowArr = dataArray[d].split(",");
			row.addAll(Arrays.asList(rowArr));
			String keyfortestcase = row.get(0);
			row.remove(0);
			for (int i = 0; i < keysfromfile.size(); i++) {
				mp.put(keysfromfile.get(i).trim(), row.get(i).trim());
			}
			outermap.put(keyfortestcase, mp);
		}*/
		
		String CSVFILEPATH =System.getProperty("user.dir")+"/TestData"+"/"+"login"+".csv";
		System.out.println(CSVFILEPATH);
		

	}

	public static Map<String, Map<String, String>> getCSVData(String filename) throws IOException {
		String CSVFILEPATH =System.getProperty("user.dir")+"/TestData"+"/"+filename+".csv";
		System.out.println(CSVFILEPATH);
		//Read CSV File
		File file = new File(CSVFILEPATH);
		//covert into byte Array
		byte[] bytes = FileUtils.readFileToByteArray(file);
		//conver into Entire byte array to String
		String data = new String(bytes);
	//	System.out.println(data);
		//replace all carriage return if any 
		data = data.replaceAll("\r", "");
		//split line into arrays
		String[] dataArray = data.split("\n");
		//get the key[header values]
		String keys = dataArray[0];
		//outer map will store first column as key and store other values of rows into value as Map<String,String>
		Map<String, Map<String, String>> outermap = new HashMap<>();
       // Create List of headers except first column value of header row
		List<String> listOfHeaders = new ArrayList<>();
		//store all header column values in string array
		String[] keyArr = keys.split(",");
		//add all string array as list and remove 0th element
		listOfHeaders.addAll(Arrays.asList(keyArr));
		listOfHeaders.remove(0);

		//iterate entire data array which starts from 2nd row
		for (int d = 1; d < dataArray.length; d++) {
			Map<String, String> mp = new HashMap<>();
			List<String> row = new ArrayList<>();
			String[] rowArr = dataArray[d].split(",");
			row.addAll(Arrays.asList(rowArr));
			String keyfortestcase = row.get(0);
			row.remove(0);
			//put all values of each row using header as key
			for (int i = 0; i < listOfHeaders.size(); i++) {
				mp.put(listOfHeaders.get(i).trim(), row.get(i).trim());
			}
			//store every row data into outermap with key as first coulmn of data and remaining as values as map<String,String>
			outermap.put(keyfortestcase, mp);
		}

		return outermap;
	}

    @DataProvider(name="newdp1")
	public static Object[][] csvDataProvider(String filename) throws IOException {

		//get Map<String,Map<String,String>
		Map<String, Map<String, String>> data = getCSVData("user");
		//create 2D Array where column size is fixed to 1 
		Object[][] obj = new Object[data.size()][1];
		//iterate map and store into 2d Array
		for (int i = 0; i < data.size(); i++) {
			obj[i][0] = data.get(String.valueOf(i + 1));
		}
		return obj;  // return 2d Array
	}
    
    @DataProvider(name="newdp")
 	public static Object[][] csvDataProvider(String filename,String filepath) throws IOException {

 		//get Map<String,Map<String,String>
 		Map<String, Map<String, String>> data = getCSVData("user");
 		//create 2D Array where column size is fixed to 1 
 		Object[][] obj = new Object[data.size()][1];
 		//iterate map and store into 2d Array
 		for (int i = 0; i < data.size(); i++) {
 			obj[i][0] = data.get(String.valueOf(i + 1));
 		}
 		return obj;  // return 2d Array
 	}
	
	
	@Test(dataProvider = "newdp1")
	public void test(Map<String, String> data) {
		System.out.println(data.get("username"));
		System.out.println(data.get("password"));
		System.out.println(data.get("email"));
		System.out.println("===================");
	}

}
