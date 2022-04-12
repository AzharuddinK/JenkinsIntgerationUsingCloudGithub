package driverfactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dataProvider.CsvFileReader;
import utility.Xls_Reader;



public class TestUtil{
	
	//Using HashTable
	@DataProvider
	public static Object[][] getTestdataUsingTable(Xls_Reader xls,String testCaseName){
	    
	    Object[][] data=null;
	    Hashtable<String,String> table =null;
	    
	    //Find number of columns in xls
	    int numofcols=0;
	    while(!xls.getCellData(testCaseName, numofcols, 1).equals("")){
	        
	        numofcols++; 
	    }
	    
	    System.out.println("Number of Columns are : " + numofcols);
	    //Find number of rows in xls
	    int numofrows=0;
	    while(!xls.getCellData(testCaseName, 0, numofrows+2).equals("")){      
	    	//numofrow+2 is given as we need to start from 2nd row.First row is column Heading
	       //System.out.println(xls.getCellData("TestData", 0, numofrows));  
	        numofrows++;
	        
	    }
	    
	    System.out.println("Number of rows are : " + numofrows) ;
	    // initialising data object with number of rows and one column.The data of one row will be put in one column of Hashtable
	    
	    data= new Object[numofrows][1];    //The column will be 1 only as we will put data in hash table.
	        
	    // Putting data in data Object        
	    for(int row=2;row<numofrows+2;row++ ){
	        table=new Hashtable<String,String>();
	        for(int col=0;col<numofcols;col++){
	            
	            table.put(xls.getCellData(testCaseName, col, 1),xls.getCellData(testCaseName, col, row) );
	            
	        }
	        
	        data[row-2][0]= table;
	        
	    }
	    
	    return data;
	}
	
	
	//Starts from 3 row
	@DataProvider
	public static Object[][] getMultipleIterationFrom3rdRow(Xls_Reader xls,String testCaseName){
		 Object[][] data=null;
		    Hashtable<String,String> table =null;
		    
		    //Find number of columns in xls
		    int numofcols=0;
		    while(!xls.getCellData(testCaseName, numofcols, 1).equals("")){
		        
		        numofcols++;
		        
		    }
		    
		    System.out.println("Number of Columns are : " + numofcols);
		    //Find number of rows in xls
		    int numofrows=1;
		    while(!xls.getCellData(testCaseName, 0, numofrows+3).equals("")){      
		    	//numofrow+2 is given as we need to start from 2nd row.First row is column Heading
		       //System.out.println(xls.getCellData("TestData", 0, numofrows));  
		        numofrows++;
		        
		    }
		    
		    System.out.println("Number of rows are : " + numofrows) ;
		    // initialising data object with number of rows and one column.The data of one row will be put in one column of Hashtable
		    
		    data= new Object[numofrows][1];    //The column will be 1 only as we will put data in hash table.
		        
		    // Putting data in data Object        
		    for(int row=3;row<=numofrows+2;row++ ){
		        table=new Hashtable<String,String>();
		        for(int col=0;col<numofcols;col++){
		            
		            table.put(xls.getCellData(testCaseName, col, 1),xls.getCellData(testCaseName, col, row) );
		            
	        }
		        
		        data[row-3][0]= table;
		        
		    }
		    
		    
		    return data;
	}

	//Using Hashmap
	@DataProvider
	public static Object[][] getTestDataUsingMap(Xls_Reader xls,String testCaseName) {

		Object[][] data = null;
		//Xls_Reader xls = new Xls_Reader(excelPath);

		HashMap<String, String> table = null;

		// Find number of columns in xls
		int numofcols = 0;
		while (!xls.getCellData(testCaseName, numofcols, 1).equals("")) {

			numofcols++;

		}

		System.out.println("Number of Columns are : " + numofcols);
		// Find number of rows in xls
		int numofrows = 0;
		while (!xls.getCellData(testCaseName, 0, numofrows + 2).equals("")) {
			// numofrow+2 is given as we need to start from 2nd row.First row is
			// column Heading
			// System.out.println(xls.getCellData("TestData", 0, numofrows));
			numofrows++;

		}

		System.out.println("Number of rows are : " + numofrows);
		// initialising data object with number of rows and one column.The data
		// of one row will be put in one column of Hashtable

		data = new Object[numofrows][1]; // The column will be 1 only as we will
											// put data in hash table.

		// Putting data in data Object
		for (int row = 2; row < numofrows + 2; row++) {
			table = new HashMap<String, String>();
			for (int col = 0; col < numofcols; col++) {
				table.put(xls.getCellData(testCaseName, col, 1), xls.getCellData(testCaseName, col, row));
			}
			data[row - 2][0] = table;
		}

		return data;
	}
	
	// Return the data from a testcase sheet in 2 dimensional array
	//old way of returning data using data provider
		public static Object[][] getData(Xls_Reader xls, String testCaseName) {
			// if the sheet is not present
			if (!xls.isSheetExist(testCaseName)) {
				xls = null;
				return new Object[1][0];
			}

			int rows = xls.getRowCount(testCaseName);
			int cols = xls.getColumnCount(testCaseName);
			System.out.println("Rows are  " + rows);
			System.out.println("Columns are " + cols);

			Object[][] data = new Object[rows - 1][cols - 3];
			for (int rowNum = 2; rowNum <= rows; rowNum++) {
				for (int colNum = 0; colNum < cols - 3; colNum++) {
					System.out.println(xls.getCellData(testCaseName, colNum, rowNum));
					data[rowNum - 2][colNum] = xls.getCellData(testCaseName, colNum, rowNum);
				}
				System.out.println();

			}
			return data;
		}
		
		
		
		@DataProvider(name = "ExcelDP")
		public static Object[][] excelDP(Method m, ITestContext iTestContext) {
			String name = m.getName();
			Xls_Reader xls_reader = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
			return TestUtil.getTestdataUsingTable(xls_reader,name);
		}
		
		@DataProvider(name = "ExcelDP1")
		public static Object[][] excelDP1(ITestContext iTestContext) {
			Xls_Reader xls_reader = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
			return TestUtil.getTestdataUsingTable(xls_reader,iTestContext.getAllTestMethods()[0].getInstance().getClass().getSimpleName());
		}
		
		public static Object[][] customDP(String className) {
			System.out.println(className);
			Xls_Reader xls_reader = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
			return TestUtil.getTestdataUsingTable(xls_reader,className);
		}
			
		
		
		
		//JSON DATA PROVIDER
	    @SuppressWarnings("unchecked")
		public static Object[][] jsonDataProvider(String filename) throws IOException {
	  	    List<Map<String, String>> listOfParamMaps = new ArrayList<Map<String, String>>();
	        Jsonb jsonb = JsonbBuilder.create();
	        Path pathRaw = Paths.get(filename);
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
	    
	    @DataProvider(name="json")
		public static Object[][] getJsonData(Class<?> cl, ITestContext iTestContext) throws IOException{
			String name = cl.getSimpleName();
			return TestUtil.jsonDataProvider(name);
		}

		@DataProvider(name="jsonDP")
		public static Object[][] getJsonData1(Method m, ITestContext iTestContext) throws IOException{
			String methodName = m.getName();
			return TestUtil.csvDataProvider(methodName);
		}
		
		
		
		
		
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
		
		@DataProvider(name="csvDataProvider")
		public static Object[][] getCSVData(Method m, ITestContext iTestContext) throws IOException{
			String methodName = m.getName();
			return TestUtil.csvDataProvider(methodName);
		}
		
		@DataProvider(name="csvDataProvider1")
		public static Object[][] getCSVData(Class<?> cl, ITestContext iTestContext) throws IOException{
			String name = cl.getSimpleName();
			return TestUtil.csvDataProvider(name);
		}
	
		@DataProvider(name="csvDataProvider1")
		public static Object[][] getCSVData(String filename) throws IOException{
			return TestUtil.csvDataProvider(filename);
		}
		
}
