package pages;

import org.openqa.selenium.By;
import services.WebDriverServiceImpl;

public class NewAccountPage extends WebDriverServiceImpl {

	public SupplierFormPage chooseSupplierForm() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")),"Form Selector");
		click(getDriver().findElement(By.xpath("//span[@title='Supplier Form']")),"Supplier Form");
		return new SupplierFormPage();
	}
	
	public MemberFormPage chooseMemberFormwithFrame1() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		chooseMemberForm();
		return new MemberFormPage();
	}
		
	public MemberFormPage chooseMemberForm() {
		click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")),"Form Selector");
		click(getDriver().findElement(By.xpath("//span[@title='Member Form']")),"Member Form");
		return new MemberFormPage();
	}
	public MemberFormPage chooseMemberEntryFormWithFrame1() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		chooseMemberEntryForm();	
		return new MemberFormPage();
	}
	
		public MemberFormPage chooseMemberEntryForm() {
			click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")),"Form Selector");
			click(getDriver().findElement(By.xpath("//span[@title='Member Entry Form']")),"Member Entry Form");
			return new MemberFormPage();
	}
		public AccountsPage chooseActiveMember() {
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.xpath("//span[@title()='Select a view']")),"Select a view");
			return new AccountsPage();
	}

}
