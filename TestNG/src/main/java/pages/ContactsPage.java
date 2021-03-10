package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class ContactsPage extends WebDriverServiceImpl{
	
	public ContactsPage clickNewOnContactsPage() {
		click(getDriver().findElement(By.xpath("//span[@command='contact|NoRelationship|HomePageGrid|Mscrm.NewRecordFromGrid']")));
		return this;
	}

	public ContactsPage typeContactName(String firstName,String lastName) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		
		//Click on Full name
		click(getDriver().findElement(By.id("fullname")));
		
		//Type first name
		click(getDriver().findElement(By.id("fullname_compositionLinkControl_firstname")));
		clearAndType(((getDriver().findElement(By.id("fullname_compositionLinkControl_firstname_i")))),firstName, "First Name");
	
		//Type second name
		click(getDriver().findElement(By.id("fullname_compositionLinkControl_lastname")));
		clearAndType(((getDriver().findElement(By.id("fullname_compositionLinkControl_lastname_i")))),lastName, "Last Name");
	
		//Click on done
		click(getDriver().findElement(By.id("fullname_compositionLinkControl_flyoutLoadingArea-confirm")));
		return this;
	}

	public ContactsPage selectPrimaryAccount(String primaryAccount) {
		click(getDriver().findElement(By.id("parentcustomerid")));
		typeAndChoose(getDriver().findElement(By.id("parentcustomerid_ledit")), primaryAccount,"Primary Account");
		return this;
	}
	
	public ContactsPage AddMemberPrimaryContactFromLookUp(String PrimaryContactLookUp) throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		Actions action = new Actions(getDriver());	
		Thread.sleep(3000);
		action.moveToElement(getDriver().findElement(By.id("parentcustomerid"))).perform();
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//img[@id='parentcustomerid_i']")));
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Look Up More Records')]")));
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		
		click(getDriver().findElement(By.xpath("//*[@id='crmGrid_clearCriteriaImg']")));
		type(getDriver().findElement(By.id("crmGrid_findCriteria")),PrimaryContactLookUp,"Primary Contact in LookUp");
		Thread.sleep(3000);
		
		click(getDriver().findElement(By.xpath("//*[@id='crmGrid_findCriteriaImg']")));
	
		click(getDriver().findElement(By.id("butBegin")));
		Thread.sleep(2000);
		return this;
	}
	

	public ContactsPage clickOnContactDeactivate() throws InterruptedException {
		click(getDriver().findElement(By.xpath("//*[@id='contact|NoRelationship|Form|Mscrm.Form.contact.Deactivate']/span/a/span")));
		Thread.sleep(10000);
		return this;
	}
	
	
	public ContactsPage clickConfirmDeactivation() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("ok_id")));
		Thread.sleep(10000);
		return this;
	}
	public ContactsPage clickSave() throws InterruptedException {
		click(getDriver().findElement(By.id("savefooter_statuscontrol")));
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage isInnovatixContactIDDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		String sCRMNumber = getTextValue(((getDriver().findElement(By.id("ix_innovatixcontactid")))));;
		js.executeScript("return document.getElementById('ix_innovatixcontactid').innerHTML").toString();
		 try {
				DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.properties.getProperty("DriverSheetName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return this;
	}
	
	public ContactsPage chooseRecordStatus(String recordStatus) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_recordstatus")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),recordStatus,"Record Status");
		getDriver().findElement(By.id("ix_recordstatus")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),recordStatus,"Record Status"); 
		Thread.sleep(3000);
		return this;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~AccountAssocoation~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ContactsPage clicAddContatAccountAssociation() throws InterruptedException {
		Thread.sleep(5000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("ContactAccountAssociation_addImageButtonImage")));
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage typeAccountInCAA(String account) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_account")));
		typeAndChoose(getDriver().findElement(By.id("ix_account_ledit")), account,"Account");
		return this;
	}
	
	public ContactsPage clickSaveInContactAccountAssociation() throws InterruptedException {
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")));
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage clickGridViewInContactAccountAssociation() throws InterruptedException {
		//scrollDown(((getDriver().findElement(By.id("ContactAccountAssociation_openAssociatedGridViewImageButtonImage")))));
		click(getDriver().findElement(By.xpath("//*[@id='ContactAccountAssociation_openAssociatedGridViewImageButtonImage']")));
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage clickCAAAssociatedViewAndSelectContactInactiveView() throws InterruptedException {
		Thread.sleep(1000);
		switchToFrame(getDriver().findElement(By.id("area_ix_contact_ix_contactaccountassociation_ContactFrame")));
		click(getDriver().findElement(By.id("crmGrid_ix_contact_ix_contactaccountassociation_Contact_SavedNewQuerySelector")));
		click(getDriver().findElement(By.xpath("//*[@id='Dialog_0']/div/ul/li[5]")));
		Thread.sleep(10000);
		return this;
	}
	public ContactsPage clickCAAAssociatedViewAndSelectContactSubGridView() throws InterruptedException {
		Thread.sleep(1000);
		switchToFrame(getDriver().findElement(By.id("area_ix_contact_ix_contactaccountassociation_ContactFrame")));
		click(getDriver().findElement(By.id("crmGrid_ix_contact_ix_contactaccountassociation_Contact_SavedNewQuerySelector")));
		click(getDriver().findElement(By.xpath("//*[@id='Dialog_0']/div/ul/li[4]")));
		Thread.sleep(10000);
		return this;
	}
	public ContactsPage verifyContactAccAssoTerminationReasonInSubGridView(String terminationReason) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[6]/nobr")),terminationReason,"Termination Reason in Contact Account Association Sub Grid View"); 
		return this;
	}
			
	public ContactsPage verifyContactAccAssoRelatioEndDateInSubGridView(String relatioshipEndDate) {
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[5]/div")),relatioshipEndDate,"Relationship End Date in Contact Account Association Sub Grid View"); 
		return this;
	}
	
	public ContactsPage doubleClickOnContactAccountAssociationRecordInSubGridView() throws InterruptedException {
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[6]/nobr"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	public ContactsPage doubleClickOnContactAccountAssociationRecordInactiveView() throws InterruptedException {
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id='crmGrid_ix_contact_ix_contactaccountassociation_Contact_divDataArea']/div/table/tbody/tr/td[5]/div"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage chooseContactTerminationReason(String contactTerminationReason) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_terminationreason")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_terminationreason_i")))),contactTerminationReason,"Termination Reason");
		getDriver().findElement(By.id("ix_terminationreason")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_terminationreason")),contactTerminationReason,"Termination Reason"); 
		Thread.sleep(3000);
		return this;
	}
	
	
	public ContactsPage typeContactRelationshipEndDate(String contactRelationshipEndDate) {
		click((getDriver().findElement(By.id("ix_relationshipenddate"))));
		clearAndType(((getDriver().findElement(By.id("ix_relationshipenddate_iDateInput")))),contactRelationshipEndDate, "Relationship End Date");
		return this;
	}
	
	public ContactsPage verifyContactRecordStatus(String contactRecordStatus) throws InterruptedException {	
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		//scrollDown(((getDriver().findElement(By.id("tab_2_header_image_div")))));
		scrollDown(getDriver().findElement(By.xpath("//*[@id='Status_label']")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='Status_label']")),contactRecordStatus,"Contact Record Status"); 
		return this;
	}
	
	
	public ContactsPage doubleClickOnContactAccountAssociationRecord() throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[4]/div"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage doubleClickOnContactAccountAssociationRecordWithFrame1() throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[4]/div"))).
	      doubleClick().
	      build().perform();
		Thread.sleep(3000);
		return this;
		}
	  
			
			
	public ContactsPage typeContactEndDate(String contactEndDate) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click((getDriver().findElement(By.id("ix_contactenddate"))));
		clearAndType(((getDriver().findElement(By.id("ix_contactenddate_iDateInput")))),contactEndDate, "Contact End Date");
		return this;
	}
	
	
	public ContactsPage clickSaveDuplicateDetected() throws InterruptedException {
		Thread.sleep(5000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("butBegin")));
		Thread.sleep(10000);
		switchToDefaultContent();
		return this;
	}

	public ContactsPage verifyContactRecordStatusInCAA(String contactRecordStatus) throws InterruptedException {	
		Thread.sleep(5000);
		switchToDefaultContent();
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		scrollDown(((getDriver().findElement(By.id("tab_2_header_image_div")))));
		scrollDown(((getDriver().findElement(By.id("Status_label")))));
		verifyExactText(getDriver().findElement(By.id("Status_label")),contactRecordStatus,"Contact Record Status"); 
		return this;
	}
	
	public ContactsPage verifyContactAccAssoIsCreated(String account) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactAccountAssociation_divDataArea']/div/table/tbody/tr/td[3]/nobr")),account,"Contact Account Association Grid"); 
		return this;
	}
	//*[@id="gridBodyTable"]/tbody/tr/td[5]/div
	
	public ContactsPage verifyContactAccAssoRelationshipEndDate(String account) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactAccountAssociation_divDataArea']/div/table/tbody/tr/td[5]/div")),account,"Contact Account Association Grid"); 
		return this;
	}

	public ContactsPage verifyErrorMsgForDuplicateCAA(String ErrMsg) throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		verifyPartialText(getDriver().findElement(By.id("ErrorMessage")),ErrMsg,"Error Message"); 
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage clickOkErrorMsgForDuplicateCAA() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("butBegin")));
		Thread.sleep(3000);
		return this;
	}
	
	public ContactsPage clickCloseInCAA() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("closeButton")));
		Thread.sleep(3000);
		return this;
	}
	
	

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Job Function~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public ContactsPage clicAddJobFunction() throws InterruptedException {
		click(getDriver().findElement(By.id("ContactJobFunctionSubgrid_addImageButtonImage")));
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage typeJobFunction(String jobFunction) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_jobfunctionnew")));
		typeAndChoose(getDriver().findElement(By.id("ix_jobfunctionnew_ledit")), jobFunction,"Job Function");
		return this;
	}
	
	public ContactsPage verifyJobFunctionIsCreated(String jobFunction) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/div/table/tbody/tr/td[3]/nobr")),jobFunction,"Job Function Grid"); 
		return this;
	}
	
	public ContactsPage verifyDuplicateJobFunctionIsCreated(String jobFunction) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/div/table/tbody/tr[2]/td[3]/nobr")),jobFunction,"Job Function Grid"); 
		return this;
	}
	
	public ContactsPage clickSaveInJobFunction() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")));
		Thread.sleep(10000);
		return this;
	}
	public ContactsPage verifyJobFunctionTerminationStatus(String terminationStatus) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/div/table/tbody/tr/td[4]")),terminationStatus,"Termination Status in Job Function Grid"); 
		return this;
	}
	
	public ContactsPage verifyJobFunctionHasNoRecords(String noRecordAlert) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactJobFunctionSubgrid_divDataArea']/table/tbody/tr/td/div[2]")),noRecordAlert,"Job Function Grid"); 
		return this;
	}
	//
	public ContactsPage verifyErrorInJobFunction() {	
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@id='ix_jobfunctionnew_warnSpan']")),"Error in Job Function");
		return this;
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Communication/Publication~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public ContactsPage clicAddCommunicationPublication() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("ContactCommunicationSubgrid_addImageButtonImage")));
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage typeCommunicationPublication(String communicationPublication) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_communicationpublication")));
		typeAndChoose(getDriver().findElement(By.id("ix_communicationpublication_ledit")), communicationPublication,"Communication Publication");
		return this;
	}
	
	public ContactsPage clickSaveInCommunicationPublication() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")));
		Thread.sleep(10000);
		return this;
	}
	
	public ContactsPage pageRefresh() throws InterruptedException {
		getDriver().navigate().refresh();
		Thread.sleep(10000);		
		return this;
	}
	public ContactsPage chooseActiveContact(String CrmNumber1) throws InterruptedException   {
	    switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));	
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber1,"Find Criteria");
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id='gridBodyTable']/tbody/tr/td[4]/nobr"))).
	      doubleClick().
	      build().perform();	      
		Thread.sleep(6000);
		return this;
	}
	public ContactsPage verifyCommPublicationsIsCreated(String communicationPublication) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/div/table/tbody/tr/td[3]/nobr")),communicationPublication,"Communication Publications Grid"); 
		return this;
	}	
	
	public ContactsPage verifyDuplicateCommPublicationsIsCreated(String communicationPublication) {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/div/table/tbody/tr[2]/td[3]/nobr")),communicationPublication,"Communication Publications Grid"); 
		return this;
	}
	
	public ContactsPage verifyCommunicationPublicationsTerminationStatus(String terminationStatus) {	
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/div/table/tbody/tr/td[4]")),terminationStatus,"Termination Status in Communication Publications Grid"); 
	return this;
	}
	
	public ContactsPage verifyErrorInCommPublivationn() {	
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		verifyDisplayed(getDriver().findElement(By.xpath("//*[@id='ix_communicationpublication_warnSpan']")),"Error in Job Function");
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ix_communicationpublication_warnSpan']")),"Test","Termination Status in Communication Publications Grid"); 
		return this;
	}

	public ContactsPage verifyCommunicationPublicationsHasNoRecord(String noRecordAlert) {	
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ContactCommunicationSubgrid_divDataArea']/table/tbody/tr/td/div[2]")),noRecordAlert,"Communication Publications Grid"); 
	return this;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//Address Details
/*	
	public ContactsPage typeStreet1(String Street1) {
		scrollDown(getDriver().findElement(By.id("address1_line1")));
		click((getDriver().findElement(By.id("address1_line1"))));
		clearAndType(((getDriver().findElement(By.id("address1_line1_i")))),Street1, "Street1");
		return this;
	}
	

	public MemberFormPage verifyStreet2IsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line2")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line2_lock")),"Street2");
		return this;
	}
	public MemberFormPage typeStreet2(String Street2) {
		click((getDriver().findElement(By.id("address1_line2"))));
		clearAndType(((getDriver().findElement(By.id("address1_line2_i")))),Street2, "Street2");
		return this;
	}
	
	public MemberFormPage typeDeliveryInfo(String DeliveryInfo) {
		click((getDriver().findElement(By.id("address1_line3"))));
		clearAndType(((getDriver().findElement(By.id("address1_line3_i")))),DeliveryInfo, "Delivery Info");
		return this;
	}
	public MemberFormPage verifyDeliveryInfoIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line3")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line3_lock")),"Delivery Info");
		return this;
	}

	public MemberFormPage typeState(String State) {
		click((getDriver().findElement(By.id("address1_stateorprovince"))));
		clearAndType(((getDriver().findElement(By.id("address1_stateorprovince_i")))),State, "State");
		return this;
	}
	public MemberFormPage verifyStateIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_stateorprovince")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_stateorprovince_lock")),"State");
		return this;
	}
	public MemberFormPage verifyMainPhoneIsEnabled() {
		scrollDown(getDriver().findElement(By.id("telephone1")));
		verifyIsEnabled(getDriver().findElement(By.id("telephone1_lock")),"Main Phone");
		return this;
	}
	public MemberFormPage verifyReferredByIsEnabled() {
		scrollDown(getDriver().findElement(By.id("ix_referredby")));
		verifyIsEnabled(getDriver().findElement(By.id("ix_referredby_lock")),"Main Phone");
		return this;
	}
	
	
	public MemberFormPage typeMainPhone(String MainPhone) {
		click((getDriver().findElement(By.id("telephone1"))));
		clearAndType(((getDriver().findElement(By.id("telephone1_i")))),MainPhone, "Main Phone");
		return this;
	}
	public MemberFormPage typeOtherPhone(String OtherPhone) {
		click((getDriver().findElement(By.id("telephone2"))));
		type(((getDriver().findElement(By.id("telephone2_i")))),OtherPhone, "Other Phone");
		return this;
	}
	public MemberFormPage typeOverrideName(String OverrideName) {
		click((getDriver().findElement(By.id("address1_name"))));
		type(((getDriver().findElement(By.id("address1_name_i")))),OverrideName, "OverrideName");
		return this;
	}
	public MemberFormPage typeFax(String Fax) {
		click((getDriver().findElement(By.id("fax"))));
		type(((getDriver().findElement(By.id("fax_i")))),Fax, "Fax");
		return this;
	}
	public MemberFormPage typeWebsite(String Website) {
		click((getDriver().findElement(By.id("websiteurl"))));
		type(((getDriver().findElement(By.id("websiteurl_i")))),Website, "Website");
		return this;
	}
	public MemberFormPage verifyReceiveDirectMail(String ReceiveDirectMail) {
		verifyExactText(getDriver().findElement(By.id("ix_receivedirectmail")),ReceiveDirectMail,"Receive Direct Mail"); 
		return this;
	}
	public MemberFormPage verifyFSRPTFlag(String FSRPTFlag) {
		verifyExactText(getDriver().findElement(By.id("ix_receivedirectmail")),FSRPTFlag,"FSRPT Flag"); 
		return this;
	}
	public MemberFormPage verifyDoNotVerifyAddress(String DoNotVerifyAddress) {
		verifyExactText(getDriver().findElement(By.id("ix_donotverifyaddress")),DoNotVerifyAddress,"Do Not Verify Address"); 
		return this;
	}
	public MemberFormPage verifyExternalAddessID(String ExternalAddessID) {
		verifyExactText(getDriver().findElement(By.id("ix_donotverifyaddress")),ExternalAddessID,"External Addess ID"); 
		return this;
	}
	public MemberFormPage verifyCountyIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_county")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_county_lock")),"County");
		return this;
	}
	
	public MemberFormPage typeCounty(String County) {
		click((getDriver().findElement(By.id("address1_county"))));
		clearAndType((getDriver().findElement(By.id("address1_county_i"))),County,"County");
		return this;
	}
	
	
	public MemberFormPage typeCity(String City) {
		click((getDriver().findElement(By.id("address1_city"))));
		clearAndType((getDriver().findElement(By.id("address1_city_i"))),City,"City");
		return this;
	}
	public MemberFormPage verifyCityIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_city")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_city_lock")),"City");
		return this;
	}

	
	public MemberFormPage typeCountry(String Country) {
		click((getDriver().findElement(By.id("address1_country"))));
		clearAndType((getDriver().findElement(By.id("address1_country_i"))),Country,"Country");
		return this;
	}
	
	public MemberFormPage verifyCountryIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_country")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_country_lock")),"Country");
		return this;
	}
	
	public MemberFormPage typeZipCode(String ZipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		clearAndType((getDriver().findElement(By.id("address1_postalcode_i"))),ZipCode, "ZipCode");
		return this;
	}
	public MemberFormPage verifyZipIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_postalcode")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_postalcode_lock")),"ZipCode");
		return this;
	}*/
}
