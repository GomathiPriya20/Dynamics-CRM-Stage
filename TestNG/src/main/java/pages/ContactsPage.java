package pages;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class ContactsPage extends WebDriverServiceImpl{
	
	public ContactsPage clickNewOnContactsPage() {
		click(getDriver().findElement(By.xpath("//span[@command='contact|NoRelationship|HomePageGrid|Mscrm.NewRecordFromGrid']")));
		return this;
	}

	public ContactsPage selectPrimaryAccount() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		typeAndChoose(getDriver().findElement(By.id("parentcustomerid_ledit")), "CNECT","Primary Account");
		return this;
	}
	
}
