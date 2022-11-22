package pages;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class DashboardPage extends WebDriverServiceImpl {


	public DashboardPage clickWorkplace() throws InterruptedException {	
		getDriver().navigate().refresh();
		Thread.sleep(5000);
		click(getDriver().findElement(By.id("TabWorkplace")),"Workplace");
		Thread.sleep(5000);
		
		return this;
	}

	public DashboardPage acceptallert() throws InterruptedException {
	getDriver().switchTo().alert().accept();
	return this;
	}
	
	public DashboardPage clickService() throws InterruptedException {	
	
		Thread.sleep(5000);
		click(getDriver().findElement(By.xpath("//span[@class='navTabButtonArrowDown']")),"Workplace");
		Thread.sleep(5000);
		return this;
	}

	public AccountsPage selectAccounts() throws InterruptedException {	
		click(getDriver().findElement(By.xpath("//span[text()='Accounts']")),"Accounts");
		Thread.sleep(10000);
		return new AccountsPage();
		}
	
	
	public DashboardPage selectWorkplace() throws InterruptedException {	
		click(getDriver().findElement(By.xpath("//span[@class='navActionButtonIcon']")),"Accounts");
		Thread.sleep(5000);
		return this;
		}
	
	
	public AccountsPage pageRefresh() throws InterruptedException {
		getDriver().navigate().refresh();
		return new AccountsPage();
	}
	
	public ContactsPage selectContacts() {	
		click(getDriver().findElement(By.xpath("//span[text()='Contacts']")),"Contacts");
		return new ContactsPage();
		}


	public DashboardPage clickUserIcon() {
		click(getDriver().findElement(By.className("navTabButtonUserInfoProfileImage")),"User info");
		click(getDriver().findElement(By.id("navTabButtonUserInfoDropDownId")),"User info");
		verifyPartialText(getDriver().findElement(By.id("navTabButtonUserInfoDropDownId")), "Test","User info");
		return this;
	}
	
}
