package pages;

import org.openqa.selenium.By;

import hooks.TestNgHooks;

public class ContactsPage extends TestNgHooks{
	
	public ContactsPage clickNewOnContactsPage() {
		click(getDriver().findElement(By.xpath("//span[@command='contact|NoRelationship|HomePageGrid|Mscrm.NewRecordFromGrid']")));
		return this;
	}

	public ContactsPage selectPrimaryAccount() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		typeAndChoose(getDriver().findElement(By.id("parentcustomerid_ledit")), "CNECT");
		return this;
	}
	
}
