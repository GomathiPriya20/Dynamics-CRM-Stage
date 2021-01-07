package pages;


import org.openqa.selenium.By;
import services.WebDriverServiceImpl;
import org.openqa.selenium.interactions.Actions;

public class AccountsPage extends WebDriverServiceImpl {


	public NewAccountPage clickNewOnAccountsPage() {
		click(getDriver().findElement(By.id("account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord")));
		return new NewAccountPage();
	}
	
	
	public MemberFormPage chooseActiveMemberWithFrame(String CrmNumber) throws InterruptedException   {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		chooseActiveMember(CrmNumber);
		return new MemberFormPage();		
	}


  	public MemberFormPage chooseActiveMember(String CrmNumber) throws InterruptedException   {
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber);
		click(((getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")))));
		Thread.sleep(6000);
		return new MemberFormPage();		
	}
  	
  	public  AccountsPage searchOnAccountsPageWithFrame(String ActiveMember1) throws InterruptedException {
  		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
  		searchOnAccountsPage(ActiveMember1);
  		return this;
  	}
  		
  	public  AccountsPage searchOnAccountsPage(String ActiveMember1) throws InterruptedException {
  		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),ActiveMember1 );
		return this;
	}
  	public  MemberFormPage selectAccountFromSearchResults() throws InterruptedException {	
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.cssSelector("table#gridBodyTable>tbody>tr>td:nth-of-type(3)>nobr")));
		action.doubleClick(getDriver().findElement(By.cssSelector("table#gridBodyTable>tbody>tr>td:nth-of-type(3)>nobr"))).build().perform();	
		return new MemberFormPage();
	}

	

	

}
