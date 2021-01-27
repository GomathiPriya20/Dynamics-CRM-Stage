package pages;


import org.openqa.selenium.By;

import services.WebDriverServiceImpl;

import org.openqa.selenium.interactions.Actions;

public class AccountsPage extends WebDriverServiceImpl {
	
	public NewAccountPage clickNewOnAccountsPage() {
		
		try {
			getDriver().navigate().refresh();
			Thread.sleep(3000);
			click(getDriver().findElement(By.xpath("//*[@id='account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord']")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new NewAccountPage();
	}

  	public MemberFormPage chooseActiveMember(String CrmNumber) throws InterruptedException   {
  		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber,"Find Criteria");
		click(((getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")))));
		Thread.sleep(6000);
		return new MemberFormPage();		
	}

  	public  AccountsPage searchOnAccountsPage(String crmNumberInput) throws InterruptedException {	
		try {
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),crmNumberInput,"Find Criteria" );
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