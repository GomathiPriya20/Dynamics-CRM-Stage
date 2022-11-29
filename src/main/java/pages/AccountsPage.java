package pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import services.WebDriverServiceImpl;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AccountsPage extends WebDriverServiceImpl {
	
	public NewAccountPage clickNewOnAccountsPage() throws InterruptedException { 
		getDriver().navigate().refresh();
		Thread.sleep(7000);
		click(getDriver().findElement(By.xpath("//*[@id='account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord']")),"New");
		return new NewAccountPage();
	}

  	public MemberFormPage chooseActiveMember(String CrmNumber) throws InterruptedException   {
  		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("crmGrid_findCriteria")),"Search creteria text box");
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber,"Find Criteria");
		click(getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")),"Find Creteria Search");
		Thread.sleep(6000);
		return new MemberFormPage();		
	}
  	
  
  	public  AccountsPage searchOnAccountsPage(String crmNumberInput) throws InterruptedException {	
  		switchToDefaultContent();
		try {
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(getDriver().findElement(By.id("crmGrid_findCriteria")),"Find Criteria");
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),crmNumberInput,"Find Criteria" );
		return this;
	}
  	
	public  AccountsPage searchOnAccountsPageNew(String crmNumberInput) throws InterruptedException {	
		try {
			switchToDefaultContent();
			switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(getDriver().findElement(By.id("crmGrid_findCriteria")),"Find Criteria");
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),crmNumberInput,"Find Criteria" );
		return this;
	}
  	
  	
	public AccountsPage navigatetoTerminatedAccountview() throws InterruptedException {
		try {
			switchToDefaultContent();
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(getDriver().findElement(By.xpath("//img[@alt='Select a view']")),"Select a View");
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Terminated Members')]")),"Find Criteria");
		return this;
	}
	
	
  	
	public  AccountsPage searchOnAccountsPage1(String crmNumberInput) throws InterruptedException {	
		try {
			switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(getDriver().findElement(By.id("crmGrid_findCriteria")),"Find Criteria");
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),crmNumberInput,"Find Criteria" );
		return this;
	}

	
	public  AccountsPage verifySearchAccountLocationType() throws InterruptedException {
		verifElementIsPresent(getDriver().findElements(By.xpath("//*[@id='gridBodyTable']/tbody/tr/td[5]//span")).size(), "Location Type");
		return this;
	}
  	public  MemberFormPage selectAccountFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.cssSelector("table#gridBodyTable>tbody>tr>td:nth-of-type(3)>nobr")));
		action.doubleClick(getDriver().findElement(By.cssSelector("table#gridBodyTable>tbody>tr>td:nth-of-type(3)>nobr"))).build().perform();	
		return new MemberFormPage();
	}
  	

  	public  SupplierFormPage selectSupplierAccountFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.xpath("//nobr[@class='gridcellpadding']")));
		action.doubleClick(getDriver().findElement(By.xpath("//nobr[@class='gridcellpadding']"))).build().perform();
		return new SupplierFormPage();
	}
}