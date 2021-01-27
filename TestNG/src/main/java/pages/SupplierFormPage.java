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
		verifyExactText((getDriver().findElement(By.id("Account Status_label"))),defaultAccountStatus,"Account Status");
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
		getTextValue((getDriver().findElement(By.id("ErrorTitle"))));
		verifyExactText((getDriver().findElement(By.xpath("//h3[text()='Supplier cannot be made Inactive']"))), expectedAccountStatusErrorText,"In Active Account Status Error");
		return this;
	}

	public SupplierFormPage defaultAccountType(String defaultAccountType) {
		verifyExactText((getDriver().findElement(By.id("Account Type_label"))),defaultAccountType,"Account Type");
		return this;
	}

	
	public SupplierFormPage recordChangeStatus(String recordChangeStatus) {
		verifyExactText((getDriver().findElement(By.id("Record Change Status_label"))),recordChangeStatus," Record Change Status");
		return this;
	}
		
	public SupplierFormPage verifyRecordChangeStatus(String verifyRecordChangeStatus) {
		verifyExactText((getDriver().findElement(By.id("Record Change Status_label"))),verifyRecordChangeStatus,"Record Change Status");
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
		type(((getDriver().findElement(By.id("name_i")))),accountName,"Account Name");
		return this;
	}
	

	public SupplierFormPage verifyAccountName(String verifyAccountName) throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));			
		verifyExactText(((getDriver().findElement(By.id("name")))),verifyAccountName,"Account Name");
		return this;
	}

	public SupplierFormPage pickPremierStartDate(String premierStartDate) {
		click(((getDriver().findElement(By.id("ix_premiermemberstartdate_d")))));
		type(((getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")))),premierStartDate,"Premier Start Date");
		return this;
	}

	public SupplierFormPage selectBusinessClassification(String businessClassification) throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		typeAndChoose(((getDriver().findElement(By.id("ix_businessclassification_ledit")))),businessClassification,"BusinessClassification");
		Thread.sleep(3000);
		return this;
	}

	public SupplierFormPage addSupplierPrimaryContact(String addSupplierPrimaryContact) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("primarycontactid")))));
		click(((getDriver().findElement(By.id("primarycontactid")))));
		typeAndChoose(((getDriver().findElement(By.id("primarycontactid_ledit")))),addSupplierPrimaryContact,"Primary Contact");
		Thread.sleep(2000);
		return this;
	}

	public SupplierFormPage verifyPrimaryContactValue(String verifyPrimaryContactValue) throws InterruptedException {
		verifyExactText((getDriver().findElement(By.id("primarycontactid_lookupValue"))), verifyPrimaryContactValue,"Primary Contact");
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
		String sCRMNumber = getTextValue(((getDriver().findElement(By.id("CRM Account #_label")))));;
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
		String entityCode = getTextValue(((getDriver().findElement(By.id("Entity Code_label")))));
		assertNotNull(entityCode);
		return this;
	}
	
	public SupplierFormPage verifyEntityCode(String verifyEntityCode) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		 verifyExactText(getDriver().findElement(By.id("Entity Code_label")), verifyEntityCode,"Entity code");
		return this;
	}
	
	public SupplierFormPage verifyMainAccountEntityCode(String verifyEntityCode) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		Assert.assertFalse(getTextValue(((getDriver().findElement(By.id("Entity Code_label"))))).equals(verifyEntityCode));
		return this;
	}


	public SupplierFormPage clickIsTPYes() {
		scrollDown(getDriver().findElement(By.id("Is Top Parent_label")));
		verifyExactText(getDriver().findElement(By.id("Is Top Parent_label")), "Yes","Is Top Parent");
		getAttribute(getDriver().findElement(By.id("ix_topparent_lock")), "id");
		return this;
	}
	
	public SupplierFormPage clickIsTPNo() {
		verifyExactText(getDriver().findElement(By.id("Is Top Parent_label")), "No","Is Top Parent");
		getAttribute(getDriver().findElement(By.id("ix_topparent_lock")), "id");
		return this;
	}


public SupplierFormPage pickTPRDClear() throws InterruptedException {
		//scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
		getDriver().findElement(By.id("ix_topparentrelationdate")).click();
		getDriver().findElement(By.id("ix_topparentrelationdate")).clear();
		return this;
	} 
	public SupplierFormPage pickTPRD(String selectTPRelationDate) throws InterruptedException {
	Thread.sleep(2000);
		scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),selectTPRelationDate,"Top Parent Relation Date");
		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
		return this;
	}
	
	public SupplierFormPage pickTPRDEdit(String selectTPRelationDate) throws InterruptedException {
		Thread.sleep(2000);
			scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
			click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
			clearAndType(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),selectTPRelationDate,"Top Parent Relation Date");
			click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
			return this;
		}
	
	

	public SupplierFormPage selectDirectParent(String directParent) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("parentaccountid_c")))));
		click(((getDriver().findElement(By.id("parentaccountid_ledit")))));
		typeAndChoose(((getDriver().findElement(By.id("parentaccountid_ledit")))),directParent,"Direct Parent");
		return this;
	}
	
	public SupplierFormPage verifyDPValue(String verifyDPValue) throws InterruptedException {
		verifyExactText(((getDriver().findElement(By.id("parentaccountid_lookupValue")))),verifyDPValue,"Direct Parent");
		return this;
	}

	public SupplierFormPage selectDPParentRelationDate(String selectDPRelationDate) throws InterruptedException {
		click(((getDriver().findElement(By.id("ix_directparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_directparentrelationdate_iDateInput")))),selectDPRelationDate,"Direct Parent Relation Date");
		click(((getDriver().findElement(By.id("ix_directparentrelationdate")))));
		return this;
	}

	public SupplierFormPage storeLocationType(String storeLocationType) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		storeLocationTypeWithOutFrame(storeLocationType);
		return this;
	}
	
	public SupplierFormPage storeLocationTypeWithOutFrame(String storeLocationType) {
		click(getDriver().findElement(By.id("ix_locationtype")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_locationtype_i")))),storeLocationType,"Store Location Type");
		getDriver().findElement(By.id("ix_locationtype")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_locationtype")),storeLocationType,"Location type"); 	
		//verifyExactText(((getDriver().findElement(By.xpath("//option[text()='Ship To']")))),storeLocationType,"Location Type");
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
		type((getDriver().findElement(By.id("address1_line1_i"))), street1,"Street");
		return this;
	}

	public SupplierFormPage typeZipCode(String zipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		type((getDriver().findElement(By.id("address1_postalcode_i"))), zipCode,"Zip Code");
		return this;

	}

	public SupplierFormPage updateStreet1(String street1) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click((getDriver().findElement(By.id("address1_line1"))));
		clearAndType((getDriver().findElement(By.id("address1_line1_i"))), street1,"Street1");
		return this;
	}
		
	public SupplierFormPage updateZipCode(String zipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		clearAndType((getDriver().findElement(By.id("address1_postalcode_i"))), zipCode,"Zip code");
		return this;
	}
	
	public SupplierFormPage recordStatusPublished(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(2000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatusPublished,"Record Status");
		Thread.sleep(2000);
		return this;
	}

	public SupplierFormPage verifyRecordStatus() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		scrollUp(((getDriver().findElement(By.id("ix_recordstatus")))));
		String rs=getTextValue(((getDriver().findElement(By.id("ix_recordstatus")))));
		verifyExactText((getDriver().findElement(By.id("ix_recordstatus"))),rs,"Record Status");
		return this;
	}
	
	public SupplierFormPage recordStatusDraft() throws InterruptedException {
		Thread.sleep(3000);
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_recordstatus_d")))));
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
		getTextValue(((getDriver().findElement(By.id("ix_recordstatus")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatusPublished,"Record Status");
		Thread.sleep(2000);
		return this;
	}

}





