package pages;

import static org.testng.Assert.assertNotNull;
import org.junit.Assert; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class SupplierFormPage extends WebDriverServiceImpl{

	public SupplierFormPage defaultAccountStatus(String defaultAccountStatus) {
		verifyExactText((getDriver().findElement(By.id("Account Status_label"))),defaultAccountStatus,"Account Status");
		return this;
	}

	public SupplierFormPage chooseAccountStatus() throws InterruptedException {
		click(getDriver().findElement(By.id("Account Status_label")),"Account Status");
		click(getDriver().findElement(By.xpath("//option[@title='Inactive']")),"Account Status");
		Thread.sleep(3000);
		return this;
	}
	//*****Method to verify Business Process Error when Supplier Account Status is made Inactive*****//	
	public SupplierFormPage verifyInactiveAccountStatusError(String expectedAccountStatusErrorText) {
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		getTextValue(getDriver().findElement(By.id("ErrorTitle")),"Error Window");
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
		click(getDriver().findElement(By.id("customertypecode")),"Account Type");
		selectDropDownUsingValue((((getDriver().findElement(By.id("customertypecode_i"))))),"Account Type");
		return this;
	}

	public SupplierFormPage typeAccountName(String accountName) {
		click(getDriver().findElement(By.id("name_c")),"Account Name");
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
		click(getDriver().findElement(By.id("ix_premiermemberstartdate_d")),"Premier Start Date");
		type(getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")),premierStartDate,"Premier Start Date");
		return this;
	}

	public SupplierFormPage selectBusinessClassification(String businessClassification) throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(getDriver().findElement(By.id("ix_businessclassification_cl")),"Business Classification");
		typeAndChoose(getDriver().findElement(By.id("ix_businessclassification_ledit")),businessClassification,"BusinessClassification");
		Thread.sleep(3000);
		return this;
	}

	public SupplierFormPage addSupplierPrimaryContact(String addSupplierPrimaryContact) throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("primarycontactid")))));
		click(getDriver().findElement(By.id("primarycontactid")),"Primary Contact");
		typeAndChoose(getDriver().findElement(By.id("primarycontactid_ledit")),addSupplierPrimaryContact,"Primary Contact");
		Thread.sleep(2000);
		return this;
	}

	public SupplierFormPage verifyPrimaryContactValue(String verifyPrimaryContactValue) throws InterruptedException {
		verifyExactText(getDriver().findElement(By.id("primarycontactid_lookupValue")), verifyPrimaryContactValue,"Primary Contact");
		return this;
	}

	public SupplierFormPage clickSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")),"Save");
		Thread.sleep(3000);
		return this;

	}

	public SupplierFormPage crmNumberIsDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		String sCRMNumber = getTextValue(getDriver().findElement(By.id("CRM Account #_label")),"CRM Number");;
		try {
			DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.sCategory);
			assertNotNull(sCRMNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public SupplierFormPage entityCodeIsDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		String entityCode = getTextValue(getDriver().findElement(By.id("Entity Code_label")),"Entity Code");
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
		Assert.assertFalse(getTextValue(getDriver().findElement(By.id("Entity Code_label")),"Entity Code").equals(verifyEntityCode));
		return this;
	}


	public SupplierFormPage clickIsTPYes() {
		scrollDown(getDriver().findElement(By.id("Is Top Parent_label")));
		verifyExactText(getDriver().findElement(By.id("Is Top Parent_label")), "Yes","Is Top Parent");
		getAttribute(getDriver().findElement(By.id("ix_topparent_lock")), "id","Is Top Parent");
		return this;
	}
	
	public SupplierFormPage clickIsTPNo() {
		verifyExactText(getDriver().findElement(By.id("Is Top Parent_label")), "No","Is Top Parent");
		getAttribute(getDriver().findElement(By.id("ix_topparent_lock")), "id","Is Top PArent");
		return this;
	}


public SupplierFormPage pickTPRDClear() throws InterruptedException {
		//scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
		getDriver().findElement(By.id("ix_topparentrelationdate")).click();
		getDriver().findElement(By.id("ix_topparentrelationdate")).clear();
		return this;
	} 
	public SupplierFormPage pickTPRD(String selectTPRelationDate) throws InterruptedException {
		scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
		click(getDriver().findElement(By.id("ix_topparentrelationdate")),"Top Parent Relation Date");
		type(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),selectTPRelationDate,"Top Parent Relation Date");
		click(getDriver().findElement(By.id("ix_topparentrelationdate")),"Top Parent Relation Date");
		return this;
	}
	
	public SupplierFormPage pickTPRDEdit(String selectTPRelationDate) throws InterruptedException {
			scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
			click(getDriver().findElement(By.id("ix_topparentrelationdate")),"Top Parent Relation Date");
			clearAndType(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),selectTPRelationDate,"Top Parent Relation Date");
			click(getDriver().findElement(By.id("ix_topparentrelationdate")),"Top Parent Relation Date");
			return this;
		}
	
	

	public SupplierFormPage selectDirectParent(String directParent) throws InterruptedException {
		
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("parentaccountid_c")))));
		click(getDriver().findElement(By.id("parentaccountid_ledit")),"Direct Parent");
		typeAndChoose(((getDriver().findElement(By.id("parentaccountid_ledit")))),directParent,"Direct Parent");
		return this;
	}
	
	public SupplierFormPage verifyDPValue(String verifyDPValue) throws InterruptedException {
		verifyExactText(((getDriver().findElement(By.id("parentaccountid_lookupValue")))),verifyDPValue,"Direct Parent");
		return this;
	}

	public SupplierFormPage selectDPParentRelationDate(String selectDPRelationDate) throws InterruptedException {
		click(getDriver().findElement(By.id("ix_directparentrelationdate")),"DPRD");
		type(((getDriver().findElement(By.id("ix_directparentrelationdate_iDateInput")))),selectDPRelationDate,"Direct Parent Relation Date");
		click(getDriver().findElement(By.id("ix_directparentrelationdate")),"DPRD");
		return this;
	}

	public SupplierFormPage storeLocationType(String storeLocationType) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		storeLocationTypeWithOutFrame(storeLocationType);
		return this;
	}
	
	public SupplierFormPage storeLocationTypeWithOutFrame(String storeLocationType) {
		click(getDriver().findElement(By.id("ix_locationtype")),"Location Type");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_locationtype_i")))),storeLocationType,"Store Location Type");
		getDriver().findElement(By.id("ix_locationtype")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_locationtype")),storeLocationType,"Location type"); 	
		//verifyExactText(((getDriver().findElement(By.xpath("//option[text()='Ship To']")))),storeLocationType,"Location Type");
		return this;
	}
	
	public SupplierFormPage storeLocationTypeBlank() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_locationtype")),"Location Type");
		selectDropDownUsingIndex(((getDriver().findElement(By.id("ix_locationtype_i")))),0,"Location Type");
		click(getDriver().findElement(By.id("ix_locationtype")),"Locaton Type");
		return this;
	}
	
	public SupplierFormPage typeStreet1(String street1) {
		scrollUp(((getDriver().findElement(By.id("address1_line1")))));
		click(getDriver().findElement(By.id("address1_line1")),"Street");
		type((getDriver().findElement(By.id("address1_line1_i"))), street1,"Street");
		return this;
	}

	public SupplierFormPage typeZipCode(String zipCode) {
		click(getDriver().findElement(By.id("address1_postalcode")),"Zip Code");
		type((getDriver().findElement(By.id("address1_postalcode_i"))), zipCode,"Zip Code");
		return this;

	}

	public SupplierFormPage updateStreet1(String street1) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("address1_line1")),"Street1");
		clearAndType((getDriver().findElement(By.id("address1_line1_i"))), street1,"Street1");
		return this;
	}
		
	public SupplierFormPage updateZipCode(String zipCode) {
		click(getDriver().findElement(By.id("address1_postalcode")),"Zip code");
		clearAndType((getDriver().findElement(By.id("address1_postalcode_i"))), zipCode,"Zip code");
		return this;
	}
	
	public SupplierFormPage recordStatusPublished(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		click(getDriver().findElement(By.id("ix_recordstatus_i")),"Record Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatusPublished,"Record Status");
		Thread.sleep(2000);
		return this;
	}

	public SupplierFormPage verifyRecordStatus() throws InterruptedException {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		scrollUp(((getDriver().findElement(By.id("ix_recordstatus")))));
		String rs=getTextValue(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		verifyExactText((getDriver().findElement(By.id("ix_recordstatus"))),rs,"Record Status");
		return this;
	}
	
	public SupplierFormPage recordStatusDraft() throws InterruptedException {
		Thread.sleep(3000);
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_recordstatus_d")),"Record Status");
		selectDropDownUsingIndex(((getDriver().findElement(By.id("ix_recordstatus_i")))),0,"Record Status");
		Thread.sleep(2000);
		return this;
	}
	public SupplierFormPage recordStatusLock(String recordStatusPublished) throws InterruptedException {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));	
		scrollUp((getDriver().findElement(By.id("ix_recordstatus"))));
		getAttribute(getDriver().findElement(By.id("ix_recordstatus_lock")), "id","Record Status Lock");
		return this;
	}
		
	public SupplierFormPage existingRecordStatusDraftToPublished(String recordStatusPublished) throws InterruptedException {
		click(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		getTextValue(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatusPublished,"Record Status");
		Thread.sleep(2000);
		return this;
	}
	
	//Account name 2
	public SupplierFormPage typeAccountName2(String AccountName2) {
		click(getDriver().findElement(By.id("ix_hiscirostername")),"AccountName2");
		type(((getDriver().findElement(By.id("ix_hiscirostername_i")))),AccountName2,"Account name2");
		return this;
	}
	public SupplierFormPage verifyCAMSFlag(String VerifyCAMSFlag) {
		verifyExactText(getDriver().findElement(By.id("ix_camsflag")),VerifyCAMSFlag,"CAMS Flag"); 
		return this;
	}
	
	
	public SupplierFormPage selectOwnership(String Ownership){
		click(getDriver().findElement(By.id("ix_ownership")),Ownership);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_ownership_i']")))),Ownership,"Ownership");
		verifyExactText(getDriver().findElement(By.id("ix_ownership")),Ownership,"Ownership"); 
		return this;
	}
	
	public SupplierFormPage typeStockSymbol(String StockSymbol) {
		click(getDriver().findElement(By.id("ix_stocksymbol")),"Stock Symbol");
		type(getDriver().findElement(By.id("ix_stocksymbol_i")),StockSymbol, "Stock Symbol");
		return this;
	}
	
	public SupplierFormPage typeExchange(String Exchange) {
		click(getDriver().findElement(By.id("ix_exchange")),Exchange);
		type(getDriver().findElement(By.id("ix_exchange_i")),Exchange, "Exchange");
		return this;
	}
	
	public SupplierFormPage typeOverrideName(String OverrideName) {
		click(getDriver().findElement(By.id("address1_name")),"OverrideName");
		type(getDriver().findElement(By.id("address1_name_i")),OverrideName, "OverrideName");
		return this;
	}

	public SupplierFormPage typeStreet2(String Street2) {
		click(getDriver().findElement(By.id("address1_line2")),"Street2");
		type(getDriver().findElement(By.id("address1_line2_i")),Street2, "Street2");
		return this;
	}
	
	public SupplierFormPage typeDeliveryInfo(String DeliveryInfo) {
		click(getDriver().findElement(By.id("address1_line3")),"Delivery Info");
		type(getDriver().findElement(By.id("address1_line3_i")),DeliveryInfo, "Delivery Info");
		return this;
	}
	public SupplierFormPage typeState(String State) {
		click(getDriver().findElement(By.id("address1_stateorprovince")),"State");
		type(getDriver().findElement(By.id("address1_stateorprovince_i")),State, "State");
		return this;
	}

	
	public SupplierFormPage typeMainPhone(String MainPhone) {
		click(getDriver().findElement(By.id("telephone1")),"Teephone");
		type(getDriver().findElement(By.id("telephone1_i")),MainPhone, "Main Phone");
		return this;
	}

	
	public SupplierFormPage typeCity(String City) {
		click(getDriver().findElement(By.id("address1_city")),"City");
		type(getDriver().findElement(By.id("address1_city_i")),City,"City");
		return this;
	}
	
	public SupplierFormPage typeCounty(String County) {
		click(getDriver().findElement(By.id("address1_country")),"Country");
		type(getDriver().findElement(By.id("address1_country_i")),County,"County");
		return this;
	}
	
	public SupplierFormPage typeCountry(String Country) {
		click(getDriver().findElement(By.id("address1_county")),"County");
		type((getDriver().findElement(By.id("address1_county_i"))),Country,"Country");
		return this;
	}
	
	public SupplierFormPage typeFax(String Fax) {
		click(getDriver().findElement(By.id("fax")),"Fax");
		type(getDriver().findElement(By.id("fax_i")),Fax, "Fax");
		return this;
	}
	public SupplierFormPage typeWebsite(String Website) {
		click(getDriver().findElement(By.id("websiteurl")),"Website");
		type(((getDriver().findElement(By.id("websiteurl_i")))),Website, "Website");
		return this;
	}
	public SupplierFormPage verifyReceiveDirectMail(String ReceiveDirectMail) {
		verifyExactText(getDriver().findElement(By.id("ix_receivedirectmail")),ReceiveDirectMail,"Receive Direct Mail"); 
		return this;
	}
	
	public SupplierFormPage verifyDoNotVerifyAddress(String DoNotVerifyAddress) {
		verifyExactText(getDriver().findElement(By.id("ix_donotverifyaddress")),DoNotVerifyAddress,"Do Not Verify Address"); 
		return this;
	}
	public SupplierFormPage verifyIsTopParent(String IsTopParent) {
		verifyExactText(getDriver().findElement(By.id("ix_istopparent")),IsTopParent,"Is Top Parent"); 
		return this;
	}
	public SupplierFormPage verifyTopParent(String TopParent) {
		verifyExactText((getDriver().findElement(By.id("parentaccountid"))),TopParent,"Top Parent");
		return this;
	}

	public SupplierFormPage addMemberRecord(String MemberRecord) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("ix_memberrecordid")))));
		click(getDriver().findElement(By.id("ix_memberrecordid")),"Member Record");
		typeAndChoose(((getDriver().findElement(By.id("ix_memberrecordid_ledit")))),MemberRecord,"Member Record");
		Thread.sleep(2000);
		return this;
	}
	
	public SupplierFormPage verifyHIBCC(String VerifyHIBCC) {
		verifyExactText(getDriver().findElement(By.id("ix_hibccsubsc")),VerifyHIBCC,"HIBCC Subsec"); 
		return this;
	}

	public SupplierFormPage verifyNoNewProducts(String VerifyNoNewProducts) {
		verifyExactText(getDriver().findElement(By.id("ix_nonewproducts")),VerifyNoNewProducts,"No New Products"); 
		return this;
	}

}





