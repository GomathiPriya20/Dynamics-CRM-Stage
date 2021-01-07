package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import services.WebDriverServiceImpl;

public class SupplierFormPage extends WebDriverServiceImpl {

	public SupplierFormPage defaultAccountStatus(String defaultAccountStatus) {
		verifyExactText((getDriver().findElement(By.id("Account Status_label"))),defaultAccountStatus);
		return this;
	}

	public SupplierFormPage defaultAccountType(String defaultAccountType) {
		verifyExactText((getDriver().findElement(By.id("Account Type_label"))),defaultAccountType);
		return this;
	}

	// Existing Bug :  Not Defaulting  to Supplier .Hence Choose Manually.
	public SupplierFormPage selectAccountType() {
		click(getDriver().findElement(By.id("customertypecode")));
		selectDropDownUsingValue((((getDriver().findElement(By.id("customertypecode_i"))))),"123456004");
		return this;
	}

	public SupplierFormPage typeAccountName(String accountName) {
		click(((getDriver().findElement(By.id("name_c")))));
		type(((getDriver().findElement(By.id("name_i")))),accountName);
		return this;
	}

	public SupplierFormPage pickPremierStartDate(String premierStartDate) {
		click(((getDriver().findElement(By.id("ix_premiermemberstartdate_d")))));
		type(((getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")))),premierStartDate);
		return this;
	}

	public SupplierFormPage selectBusinessClassification(String businessClassification) throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		typeAndChoose(((getDriver().findElement(By.id("ix_businessclassification_ledit")))),businessClassification);
		Thread.sleep(3000);
		return this;
	}

	public SupplierFormPage clickSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")));
		Thread.sleep(3000);
		return this;

	}

	public SupplierFormPage crmNumberIsDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}
	
	
	public SupplierFormPage entityCodeIsDisplayed() throws InterruptedException {
		//switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		//switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Entity Code_label")))));
		return this;
	}


	public SupplierFormPage clickIsTP() {
		scrollDown(getDriver().findElement(By.id("Is Top Parent_label")));
		return this;
	}


	public SupplierFormPage pickTPRD(String selectTPRelationDate) {
		scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),selectTPRelationDate);
		return this;
	}

	public SupplierFormPage typeStreet1(String street1) {
		scrollDown(((getDriver().findElement(By.id("address1_line1")))));
		click((getDriver().findElement(By.id("address1_line1"))));
		type((getDriver().findElement(By.id("address1_line1_i"))), street1);
		return this;
	}

	public SupplierFormPage typeZipCode(String zipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		type((getDriver().findElement(By.id("address1_postalcode_i"))), zipCode);
		return this;

	}
	
	public SupplierFormPage recordStatusPublished(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatusPublished);
		Thread.sleep(2000);
		return this;
}
	
}
