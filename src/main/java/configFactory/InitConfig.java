package configFactory;
import java.io.FileInputStream;
import java.util.Properties;

public class InitConfig implements ProjectConfig {
   private  Properties appConfig = null;
   private Properties browserConfig =null;
   private Properties browserstackConfig =null;
   private Properties gmailConfig = null;
   private Properties jenkinsConfig = null;
   private Properties jiraConfig =null;
   private Properties saucelabsConfig =null;
   private Properties slackConfig = null;
   private Properties testrailConfig = null;
   private Properties seleniumGridConfig =null;
    private Properties zeleniumConfig =null;
    private Properties lambdaTestConfig=null;
    private Properties cloudBrowserConfig=null;
   protected InitConfig(){
       appConfig= FileUtility.loadProperties("/Configuration/application.properties");
       browserConfig=FileUtility.loadProperties("/Configuration/browser.properties");
       browserstackConfig=FileUtility.loadProperties("/Configuration/browserstack.properties");
       saucelabsConfig=FileUtility.loadProperties("/Configuration/saucelab.properties");
       lambdaTestConfig=FileUtility.loadProperties("/Configuration/lambdatest.properties");
       cloudBrowserConfig=FileUtility.loadProperties("/Configuration/cloudBrowsers.properties");
       /*
       gmailConfig=FileUtility.loadProperties("/Configuration/gmail.properties");
       jenkinsConfig=FileUtility.loadProperties("/Configuration/jenkins.properties");
       jiraConfig=FileUtility.loadProperties("/Configuration/jira.properties");
       saucelabsConfig=FileUtility.loadProperties("/Configuration/saucelab.properties");
       slackConfig=FileUtility.loadProperties("/Configuration/slack.properties");
       testrailConfig=FileUtility.loadProperties("/Configuration/testrail.properties");
       seleniumGridConfig= FileUtility.loadProperties("/Configuration/seleniumgrid.properties");
       zeleniumConfig=FileUtility.loadProperties("/Configuration/zelenium.properties");*/
   }


    @Override
    public String getProperty(String propertyName, CONFIG fileType) {

        switch(fileType) {
            case APPLICATION:
                return appConfig.getProperty(propertyName);
            case BROWSER:
                return browserConfig.getProperty(propertyName);
            case BROWSERSTACK:
                return browserstackConfig.getProperty(propertyName);
            case GMAIL:
                return gmailConfig.getProperty(propertyName);
            case JENKINS:
                return jenkinsConfig.getProperty(propertyName);
            case JIRA:
                return jiraConfig.getProperty(propertyName);
            case SAUCELABS:
                return saucelabsConfig.getProperty(propertyName);
            case SLACK:
                return slackConfig.getProperty(propertyName);
            case TESTRAIL:
                return testrailConfig.getProperty(propertyName);
            case SELENIUMGRID:
                return seleniumGridConfig.getProperty(propertyName);
            case ZELENIUM:
                return zeleniumConfig.getProperty(propertyName);
            case LAMBDATEST:
                return lambdaTestConfig.getProperty(propertyName);
            case CLOUDBROWSERS:
            	return cloudBrowserConfig.getProperty(propertyName);
            default:
                return "File is not found";
        }
    }
}
