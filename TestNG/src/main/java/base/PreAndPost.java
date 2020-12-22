package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
 import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import events.WebDriverEvents;

 
public class PreAndPost extends WebDriverEvents
{
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
	public static Properties properties = new Properties();
 
    private static String reportFileName = "Test-Automaton-Report";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    static String timeStamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName+timeStamp+".html";
     
    
    @BeforeSuite
    public static void setUp()
    {
    	String fileName = getReportPath(reportFilepath);
    	htmlReporter = new ExtentHtmlReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
         
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Environment", "QA");
             
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setReportName("CRM Automation Test Results");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    
   	public void beforeMethod() throws FileNotFoundException, IOException {
   		properties.load(new FileInputStream(new File("./src/test/resources/environment.properties")));
   		
   		
   		/*ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("resources/chromedriver.exe");
        File f = new File("Driver");
        if (!f.exists()) {
            f.mkdirs();
        }
        File chromeDriver = new File("Driver" + File.separator + "chromedriver.exe");
        if (!chromeDriver.exists()) {
            chromeDriver.createNewFile();
            org.apache.commons.io.FileUtils.copyURLToFile(resource, chromeDriver);
        }*/
        //System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        
        
  
   		
   		ChromeOptions options = new ChromeOptions();
   		
   		if(properties.getProperty("Headless").equalsIgnoreCase("true"))
   			options.setHeadless(true);
   		
   		webdriver = new ChromeDriver(options);
   		driver = new EventFiringWebDriver(webdriver);
   		driver.register(this);

   		tlDriver.set(driver);		
   		getDriver().manage().window().maximize();

   		getDriver().get(properties.getProperty("URL"));
   		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
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
            System.out.println("Test results report directory already exists: " + path);
        }
		return reportFileLocation;
    }
   	    
   // @AfterMethod
    public void closeBrowser()
    {
    	try {
			getDriver().quit();
			//test.log(Status.PASS, "The opened browsers are closed");
		} catch (Exception e) {
			//test.log(Status.FAIL, "Unexpected error occured in Browser");
		}
    }
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }
}
