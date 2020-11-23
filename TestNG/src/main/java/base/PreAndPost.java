package base;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class PreAndPost {

	public ChromeDriver driver;

	@BeforeMethod
	public void startApp() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

		System.out.println("Launching Browser");

		driver = new ChromeDriver();

		driver.manage().window().maximize();		

		driver.get("https://crmv9.premierinc.com/");

		System.out.println("Launching URL");

		/* driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); */
	}


	@AfterMethod 
	public void closeApp() { 
		driver.close();
	}


	@DataProvider()
	public Object[][] setData() {

		Object [][] data =new Object[2][2];
		data [0][0] = "corp\\crmtest01";
		data [0][1]="Premier1a";
		data [1][0] = "corp\\crmtest02";
		data [1][1]="Premier1a";

		return data;
	}

}
