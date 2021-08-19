package testcases.Login;

import org.testng.annotations.Test;
import pages.LoginPage;

public class GeneralLoginCheck {
		
	@Test(dataProvider ="fetchData",groups = "Login", enabled = true)

	public void login(String username, String password) throws InterruptedException {

		new LoginPage()
		.typeUsername(username)
		.typePassword(password)
		.clickSignIn()
		.clickUserIcon();
	}


}
