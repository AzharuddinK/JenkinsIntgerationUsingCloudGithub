package managers;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
    private static String reportFileName = "Test-Automaton-Report"+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
  
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
    	Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("dd:MMM:yyyy:HH:mm:ss");
	    String file=ft.format(dNow);
	    String filename=file.toString().replace(":","_").replace(" ","_")+".html";
	    if(System.getProperty("report")==null){
	    	 filename="SSP-SRM"+"_Automation_Report_"+filename;
	    }else{
	    	 filename=System.getProperty("report")+"_Automation_Report_"+filename;
	    }
	   
	if(extent==null)
	{   
		extent=new ExtentReports("target/surefire-reports/executionReports/"+filename,true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
		//optional
		//extent.addSystemInfo("Selenium",CONFIG.getProperty("SeleniumVersion"));
		//extent.addSystemInfo("Environment",CONFIG.getProperty("Env"));
	}
	
	return extent;
    }
     
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
}
