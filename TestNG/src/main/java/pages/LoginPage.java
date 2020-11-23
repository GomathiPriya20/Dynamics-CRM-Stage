package pages;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import base.PreAndPost;
import hooks.TestNgHooks;

public class LoginPage extends TestNgHooks{


	public LoginPage typeUsername(String username) {
		type(getDriver().findElement(By.id("userNameInput")),username);
		return this;
	}
	
		
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(By.id("passwordInput")),password);
		return this;
	}

	public DashboardPage clickSignIn() throws InterruptedException {
		click(getDriver().findElement(By.id("submitButton")));	 
		return new DashboardPage();
	}


	


	
}
