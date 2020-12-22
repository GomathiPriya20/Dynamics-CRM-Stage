package testcases.Contacts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class TestCase_5491 {
	
	@Test(dataProvider ="fetchData", groups = "Contacts", enabled=true)

	public void createSupplierTP(String username, String password) throws InterruptedException {
		new LoginPage()
		.typeUsername(username)
		.typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectContacts()
		.clickNewOnContactsPage()
		.selectPrimaryAccount();
		
						
		
	}


}
