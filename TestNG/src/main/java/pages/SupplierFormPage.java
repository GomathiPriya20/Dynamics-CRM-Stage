package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import hooks.TestNgHooks;

public class SupplierFormPage extends TestNgHooks {

	public SupplierFormPage defaultAccountStatus() {
		verifyExactText((getDriver().findElement(By.id("Account Status_label"))),"Active");
		return this;
	}

	public SupplierFormPage defaultAccountType() {
		verifyExactText((getDriver().findElement(By.id("Account Type_label"))),"Supplier");
		return this;
	}

	// Existing Bug :  Not Defaulting  to Supplier .Hence Choose Manually.
	public SupplierFormPage selectAccountType() {
		click(getDriver().findElement(By.id("customertypecode")));
		selectDropDownUsingValue((((getDriver().findElement(By.id("customertypecode_i"))))),"123456004");
		return this;
	}

	public SupplierFormPage typeAccountName() {
		click(((getDriver().findElement(By.id("name_c")))));
		type(((getDriver().findElement(By.id("name_i")))),"Faridhah Supplier TP");
		return this;
	}

	public SupplierFormPage pickPremierStartDate() {
		click(((getDriver().findElement(By.id("ix_premiermemberstartdate_d")))));
		type(((getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")))),"07/11/2020");
		return this;
	}

	public SupplierFormPage selectBusinessClassification() {
		scrollDown(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(((getDriver().findElement(By.id("ix_businessclassification_lookupSearch")))));
		click(((getDriver().findElement(By.xpath("//span[text()='Service Agreement']")))));
		return this;
	}

	public SupplierFormPage clickSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")));
		Thread.sleep(3000);
		return this;

	}

	public SupplierFormPage crmNumberIsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}


	public SupplierFormPage clickIsTP() {
		scrollDown(getDriver().findElement(By.id("Is Top Parent_label")));
		return this;
	}


	public SupplierFormPage pickTPRD() {
		scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
		click(getDriver().findElement(By.id("ix_topparentrelationdate")));
		click(getDriver().findElement(By.id("ix_topparentrelationdate_iimg")));
		click(getDriver().findElement(By.id("tdToday")));	
		return this;
	}

	public SupplierFormPage typeStreet1() {
		click((getDriver().findElement(By.id("address1_line1"))));
		type((getDriver().findElement(By.id("address1_line1_i"))), "253 33rd St");
		return this;
	}

	public SupplierFormPage typeZipCode() {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		type((getDriver().findElement(By.id("address1_postalcode_i"))), "11010");
		return this;

	}
}
