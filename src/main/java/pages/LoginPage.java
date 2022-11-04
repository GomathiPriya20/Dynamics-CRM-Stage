package pages;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class LoginPage extends WebDriverServiceImpl{

	public LoginPage enterEmail(String email) {
		getDriver().findElement(By.tagName("body")).sendKeys(email);
		return this;
	}
	
	public LoginPage enterPassword() {
		
		return this;
	}

	
	public LoginPage getPage() {
		getDriver().get("https://crmstage.premierinc.com/main.aspx#7815483");
		return this;
	}
	public LoginPage typeUsername(String username) {
		type(getDriver().findElement(By.id("userNameInput")),username,"Username");
		return this;
	}
		
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(By.id("passwordInput")),password,"Password");
		return this;
	}

	public DashboardPage clickSignIn() throws InterruptedException {
		click(getDriver().findElement(By.id("submitButton")),"Submit");	
		Thread.sleep(5000);
		return new DashboardPage();
	}	
}
