package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import hooks.TestNgHooks;

public class AccountsPage extends TestNgHooks {


	public NewAccountPage clickNewOnAccountsPage() {
		click(getDriver().findElement(By.id("account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord")));
		return new NewAccountPage();
	}
//	public AccountsPage chooseSelectView(String CrmNumber) throws InterruptedException   {
//		//crmGrid_findCriteria
//		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
//		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber);
//		
//					return this;
//	}
//	public AccountsPage searchForActiveMember(String CrmNumber) throws InterruptedException   {
//		//crmGrid_findCriteria
//		switchToDefaultContent();
//		click(getDriver().findElement(By.xpath("//table[@id='gridControlBarCompositeControl']//div/input[@id='crmGrid_findCriteria']")));
//		//xpath("//option[@title='My Active Members']"
//		//table[@id="gridControlBarCompositeControl"]//input[@id='crmGrid_findCriteria']
//		typeAndEnter(getDriver().findElement(By.xpath("//table[@id='gridControlBarCompositeControl']//div/input[@id='crmGrid_findCriteria']")),CrmNumber);
//		
//					return this;
//	}
  	public MemberFormPage chooseActiveMember(String CrmNumber) throws InterruptedException   {
		
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		//switchToDefaultContent();
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber);
		click(((getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")))));
		Thread.sleep(6000);
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		return new MemberFormPage();
		//return  MemberFormPage();
		
	}
  	

//	public AccountsPage selectActiveMember() throws InterruptedException   {
//		//switchToDefaultContent();
//		//switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
//		Thread.sleep(3000);
//		click(getDriver().findElement(By.id("crmMasthead")));
//		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
//		Thread.sleep(3000);
//		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_membership_AccountName")));
//	//	click(((getDriver().findElement(By.xpath("//option[@title='My Active Members']")))));
//		return this;
//	}
//	
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
