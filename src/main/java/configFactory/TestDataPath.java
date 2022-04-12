package configFactory;
import java.util.Properties;

public class TestDataPath implements ProjectConfig{
    private Properties dataconfig = null;
    private String projectpath=System.getProperty("user.dir");
    protected TestDataPath(){
        dataconfig=FileUtility.loadProperties("/CONFIGURATION/testdata.properties");
    }


    @Override
    public String getProperty(String path, CONFIG fileType) {

        switch(fileType) {
            case TESTDATA:
                return projectpath+"/"+dataconfig.getProperty(path);
            default:
                return "File is not found";
        }
    }

    public static void getExcelSheetName(){

    }



}
