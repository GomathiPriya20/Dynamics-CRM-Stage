package pages;




import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import org.junit.Assert; 


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;

import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class SupplierFormPage extends WebDriverServiceImpl{

	public SupplierFormPage defaultAccountStatus(String defaultAccountStatus) {
		verifyExactText((getDriver().findElement(By.id("Account Status_label"))),defaultAccountStatus);
		return this;
	}

	public SupplierFormPage chooseAccountStatus() throws InterruptedException {
		click(getDriver().findElement(By.id("Account Status_label")));
		click(getDriver().findElement(By.xpath("//option[@title='Inactive']")));
		Thread.sleep(3000);
		return this;
	}
	//*****Method to verify Business Process Error when Supplier Account Status is made Inactive*****//	
	public SupplierFormPage verifyInactiveAccountStatusError(String expectedAccountStatusErrorText) {
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		getText((getDriver().findElement(By.id("ErrorTitle"))));
		verifyExactText((getDriver().findElement(By.xpath("//h3[text()='Supplier cannot be made Inactive']"))), expectedAccountStatusErrorText);
		return this;
	}

	public SupplierFormPage defaultAccountType(String defaultAccountType) {
		verifyExactText((getDriver().findElement(By.id("Account Type_label"))),defaultAccountType);
		return this;
	}

	
	public SupplierFormPage recordChangeStatus(String recordChangeStatus) {
		verifyExactText((getDriver().findElement(By.id("Record Change Status_label"))),recordChangeStatus);
		return this;
	}
		
	public SupplierFormPage verifyRecordChangeStatus(String verifyRecordChangeStatus) {
		verifyExactText((getDriver().findElement(By.id("Record Change Status_label"))),verifyRecordChangeStatus);
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
	

	public SupplierFormPage verifyAccountName(String verifyAccountName) throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));			
		verifyExactText(((getDriver().findElement(By.id("name")))),verifyAccountName);
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

	public SupplierFormPage addSupplierPrimaryContact(String addSupplierPrimaryContact) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("primarycontactid")))));
		click(((getDriver().findElement(By.id("primarycontactid")))));
		typeAndChoose(((getDriver().findElement(By.id("primarycontactid_ledit")))),addSupplierPrimaryContact);
		Thread.sleep(2000);
		return this;
	}

	public SupplierFormPage verifyPrimaryContactValue(String verifyPrimaryContactValue) throws InterruptedException {
		verifyExactText((getDriver().findElement(By.id("primarycontactid_lookupValue"))), verifyPrimaryContactValue);
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
		String sCRMNumber = getText(((getDriver().findElement(By.id("CRM Account #_label")))));;
		try {
			DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber");
			assertNotNull(sCRMNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}


	public SupplierFormPage entityCodeIsDisplayed() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		String entityCode = getText(((getDriver().findElement(By.id("Entity Code_label")))));
		assertNotNull(entityCode);
		return this;
	}
	
	public SupplierFormPage verifyEntityCode(String verifyEntityCode) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		 verifyExactText(getDriver().findElement(By.id("Entity Code_label")), verifyEntityCode);
		return this;
	}
	
	public SupplierFormPage verifyMainAccountEntityCode(String verifyEntityCode) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		Assert.assertFalse(getText(((getDriver().findElement(By.id("Entity Code_label"))))).equals(verifyEntityCode));
		return this;
	}


	public SupplierFormPage clickIsTPYes() {
		scrollDown(getDriver().findElement(By.id("Is Top Parent_label")));
		verifyExactText(getDriver().findElement(By.id("Is Top Parent_label")), "Yes");
		getAttribute(getDriver().findElement(By.id("ix_topparent_lock")), "id");
		return this;
	}
	
	public SupplierFormPage clickIsTPNo() {
		verifyExactText(getDriver().findElement(By.id("Is Top Parent_label")), "No");
		getAttribute(getDriver().findElement(By.id("ix_topparent_lock")), "id");
		return this;
	}


	public SupplierFormPage pickTPRD(String selectTPRelationDate) throws InterruptedException {
		scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),selectTPRelationDate);
		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
		return this;
	}


	public SupplierFormPage selectDirectParent(String directParent) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("parentaccountid_c")))));
		click(((getDriver().findElement(By.id("parentaccountid_ledit")))));
		typeAndChoose(((getDriver().findElement(By.id("parentaccountid_ledit")))),directParent);
		return this;
	}
	
	public SupplierFormPage verifyDPValue(String verifyDPValue) throws InterruptedException {
		verifyExactText(((getDriver().findElement(By.id("parentaccountid_lookupValue")))),verifyDPValue);
		return this;
	}

	public SupplierFormPage selectDPParentRelationDate(String selectDPRelationDate) throws InterruptedException {
		click(((getDriver().findElement(By.id("ix_directparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_directparentrelationdate_iDateInput")))),selectDPRelationDate);
		click(((getDriver().findElement(By.id("ix_directparentrelationdate")))));
		return this;
	}

	public SupplierFormPage storeLocationType(String storeLocationType) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_locationtype")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_locationtype_i")))),storeLocationType);
		click((getDriver().findElement(By.id("ix_locationtype"))));
		verifyExactText(((getDriver().findElement(By.xpath("//option[text()='Ship To']")))),storeLocationType);
		return this;
	}
	
	
	public SupplierFormPage storeLocationTypeBlank() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_locationtype")));
		selectDropDownUsingIndex(((getDriver().findElement(By.id("ix_locationtype_i")))),0);
		click((getDriver().findElement(By.id("ix_locationtype"))));
		return this;
	}
	
	public SupplierFormPage typeStreet1(String street1) {
		scrollUp(((getDriver().findElement(By.id("address1_line1")))));
		click((getDriver().findElement(By.id("address1_line1"))));
		type((getDriver().findElement(By.id("address1_line1_i"))), street1);
		return this;
	}

	public SupplierFormPage typeZipCode(String zipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		type((getDriver().findElement(By.id("address1_postalcode_i"))), zipCode);
		return this;

	}

	public SupplierFormPage updateStreet1(String street1) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click((getDriver().findElement(By.id("address1_line1"))));
		clearAndType((getDriver().findElement(By.id("address1_line1_i"))), street1);
		return this;
	}
		
	public SupplierFormPage updateZipCode(String zipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		clearAndType((getDriver().findElement(By.id("address1_postalcode_i"))), zipCode);
		return this;
	}
	
	public SupplierFormPage recordStatusPublished(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(2000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatusPublished);
		Thread.sleep(2000);
		return this;
	}

	public SupplierFormPage verifyRecordStatus() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		scrollUp(((getDriver().findElement(By.id("ix_recordstatus")))));
		String rs=getText(((getDriver().findElement(By.id("ix_recordstatus")))));
		verifyExactText((getDriver().findElement(By.id("ix_recordstatus"))),rs);
		return this;
	}
	
	public SupplierFormPage recordStatusDraft() throws InterruptedException {
		Thread.sleep(3000);
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingIndex(((getDriver().findElement(By.id("ix_recordstatus_i")))),0);
		Thread.sleep(2000);
		return this;
	}
	public SupplierFormPage recordStatusLock(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(2000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));	
		scrollUp((getDriver().findElement(By.id("ix_recordstatus"))));
		getAttribute(getDriver().findElement(By.id("ix_recordstatus_lock")), "id");
		return this;
	}
		
	public SupplierFormPage existingRecordStatusDraftToPublished(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(2000);
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		getText(((getDriver().findElement(By.id("ix_recordstatus")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatusPublished);
		Thread.sleep(2000);
		return this;
	}

}





