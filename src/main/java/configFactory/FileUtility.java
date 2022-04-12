package configFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {


    private static  Properties applicationConfig (String fileName){
        Properties appProperties = new Properties();
        try{
            FileInputStream fis =null;
            fis = new FileInputStream(System.getProperty("user.dir")+fileName);
            appProperties.load(fis);

        }catch (Exception ex){
            ex.getStackTrace();
        }
        return appProperties;
    }

    public static Properties loadProperties(String filename){
        return applicationConfig(filename);
    }


}
