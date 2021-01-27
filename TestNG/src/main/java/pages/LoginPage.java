package pages;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class LoginPage extends WebDriverServiceImpl{


	public LoginPage typeUsername(String username) {
		type(getDriver().findElement(By.id("userNameInput")),username,"Username");
		return this;
	}
		
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(By.id("passwordInput")),password,"Password");
		return this;
	}

	public DashboardPage clickSignIn() throws InterruptedException {
		click(getDriver().findElement(By.id("submitButton")));	 
		return new DashboardPage();
	}	
}
