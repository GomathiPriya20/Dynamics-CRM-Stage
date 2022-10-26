package pages;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.testng.Assert.assertNotNull;

//Test Case 7312:Add and update Primary contact to a Member account
import java.awt.AWTException;
import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class MemberFormPage extends WebDriverServiceImpl {

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Account Name
	public MemberFormPage typeAccountName(String AccountName) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("name_d")),"Account name");
		clearAndType(((getDriver().findElement(By.id("name_i")))),AccountName,"Account name");
		return this;
	}

	public MemberFormPage typeAccountNameWithIDName(String AccountName) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("name_d")),"Account name");
		type(((getDriver().findElement(By.id("name_d")))),AccountName,"Account name");
		return this;
	}
	public MemberFormPage typeMPAccountName(String AccountName) throws InterruptedException {
		Thread.sleep(3000);
		Random rand = new Random(); //instance of random class
		int upperbound = 999;
		int int_random = rand.nextInt(upperbound);
		click(getDriver().findElement(By.id("name_d")),"Account name");
		clearAndType(((getDriver().findElement(By.id("name_i")))),AccountName+int_random,"Account name");
		return this;
	}

	public MemberFormPage switchToSubAccount() throws InterruptedException {
		Thread.sleep(3000);
		switchToWindow(1);
		Thread.sleep(2000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		return this;
	}

	public MemberFormPage typeAccountNameEdit(String AccountName) throws InterruptedException {
		click(getDriver().findElement(By.id("name_i")),"Account name");
		type(((getDriver().findElement(By.id("name_i")))),AccountName,"Account name");
		return this;
	}
	public MemberFormPage verifyAccountNameIsEnabled() throws InterruptedException {
		Thread.sleep(10000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		verifyIsEnabled(getDriver().findElement(By.id("name_lock")),"Accoun name");
		return this;
	}

	public MemberFormPage typeAccountModify(String AccountName) throws InterruptedException {
		click(getDriver().findElement(By.id("name_d")),"Account name");
		Thread.sleep(3000);
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Account name 2
	public MemberFormPage typeAccountName2(String AccountName2) {
		click(getDriver().findElement(By.id("ix_hiscirostername")),"Account name");
		clearAndType(((getDriver().findElement(By.id("ix_hiscirostername_i")))),AccountName2,"Account name2");
		return this;
	}

	public MemberFormPage verifyAccountName2IsEnabled() {
		verifyIsEnabled(getDriver().findElement(By.id("ix_hiscirostername_lock")),"Account name2");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Premier Start Date
	public MemberFormPage pickPremierStartDate(String PremierStartDate)  {
		click(getDriver().findElement(By.id("ix_premiermemberstartdate_d")),"Premier Start Date");
		click(getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")),"Premier Start Date");
		type(getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")),PremierStartDate,"Premier Start Date");
		return this;
	}

	public MemberFormPage switchToFrame() {

		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		return this;
	}
	public MemberFormPage verifyPremierStartDateIsAutoPopulated() throws InterruptedException  {
		System.out.println("Test");
		scrollDown(getDriver().findElement(By.id("ix_premiermemberstartdate_d")));
		getTextValue(getDriver().findElement(By.id("ix_premiermemberstartdate_d")),"Premier Start Date");
		return this;
	}

	public MemberFormPage Scrollup() {
		scrollUp(getDriver().findElement(By.id("contentIFrame0")));
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage AddMemberPrimaryContact(String AddMemberPrimaryContact) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("primarycontactid")))));
		click(getDriver().findElement(By.id("primarycontactid")),"Primary Contact");
		typeAndChoose(((getDriver().findElement(By.id("primarycontactid_ledit")))),AddMemberPrimaryContact,"Primary Contact");
		Thread.sleep(2000);
		return this;
	}
	public MemberFormPage VerifyPrimaryContactValue(String verifyPrimaryContactValue) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		//	scrollDown(getDriver().findElement(By.id("primarycontactid_lookupValue")));
		verifyExactText((getDriver().findElement(By.xpath("//*[@id='primarycontactid_lookupValue']"))), verifyPrimaryContactValue,"Primary Contact");
		return this;
	}

	public MemberFormPage VerifyPrimaryContactValueWithoutFrame(String verifyPrimaryContactValue) throws InterruptedException {
		scrollUp(getDriver().findElement(By.id("primarycontactid")));
		verifyExactText((getDriver().findElement(By.xpath("//*[@id='primarycontactid']"))), verifyPrimaryContactValue,"Primary Contact");
		return this;
	}

	public MemberFormPage AddMemberPrimaryContactFromLookUp(String PrimaryContactLookUp) throws InterruptedException {

		scrollDown(getDriver().findElement(By.id("ix_premiermemberstartdate_d")));
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.xpath("//*[@id='primarycontactid_d']"))).perform();
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@id=\"primarycontactid_lookupSearchIcon\"]")),"Primary Contact");
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//span[contains(text(),'Look Up More Records')]")),"Look Up More Records");
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));

		click(getDriver().findElement(By.xpath("//*[@id='crmGrid_clearCriteriaImg']")),"Clear Criteria Img");
		type(getDriver().findElement(By.id("crmGrid_findCriteria")),PrimaryContactLookUp,"Primary Contact in LookUp");
		Thread.sleep(3000);

		click(getDriver().findElement(By.xpath("//*[@id='crmGrid_findCriteriaImg']")),"Find Criteria");

		click(getDriver().findElement(By.id("butBegin")),"Add");
		Thread.sleep(8000);
		switchToDefaultContent();
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage selectClassOfTrade(String ClassOfTrade) throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("ix_classoftradedetail_c")))));
		click(getDriver().findElement(By.id("ix_classoftradedetail_c")),"Class of Trade");
		type(((getDriver().findElement(By.id("ix_classoftradedetail_ledit")))),ClassOfTrade,"Class of Trade");
		getDriver().findElement(By.id("ix_classoftradedetail_ledit")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		return this;
	}
	public MemberFormPage verifyClassOfTradeIsEnabled() {
		scrollDown(((getDriver().findElement(By.id("ix_classoftradedetail_c")))));
		verifyIsEnabled(getDriver().findElement(By.id("ix_classoftradedetail_lock")),"Class of Trade");
		return this;

	}


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public MemberFormPage chooseApplicationDate(String ApplicationDate) {
		click(getDriver().findElement(By.id("ix_applicationstartdate")),"Application Start Date");
		type(((getDriver().findElement(By.id("ix_applicationstartdate_iDateInput")))),ApplicationDate, "Application Start Date");
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`~~~~~~~~~~~~~~~
	public MemberFormPage verifyGroup(String Group) {
		verifyExactText(getDriver().findElement(By.id("ix_group")),Group,"Group"); 
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage verifyFacilityType(String FacilityType) throws InterruptedException {
		verifyExactText(getDriver().findElement(By.id("ix_facilitytype")),FacilityType,"Facility Type"); 
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage verifyBusinessClassification(String BusinessClassification) {
		verifyExactText(getDriver().findElement(By.id("Business Classification_label")),BusinessClassification,"Business Classification"); 
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~```~~~~~~~~~
	public MemberFormPage verifyPremierOwner(String PremierOwner) {
		verifyExactText(getDriver().findElement(By.id("ix_premierowner")),PremierOwner,"Premier Owner"); 
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage verifyBKActive(String BKActive) {
		verifyExactText(getDriver().findElement(By.id("ix_donotroster")),BKActive,"BKActive"); 
		return this;
	}
	public MemberFormPage selectBKfield() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_bkactive")),"BK Active");
		return this; 
	}

	public MemberFormPage verifyErrorMsgBKField(String ErrMsg) throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		verifyPartialText(getDriver().findElement(By.id("ErrorMessage")),ErrMsg,"Error Message"); 

		return this;
	}

	public MemberFormPage clickOkInErrorMsgBKField() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("butBegin")),"Ok");
		Thread.sleep(3000);
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//Click on Save
	public MemberFormPage clickSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")),"Save");
		Thread.sleep(10000);
		Thread.sleep(10000);
		return this;	
	}


	public MemberFormPage clickSaveInAccountNumbers() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("savefooter_statuscontrol")),"Save");
		Thread.sleep(5000);	
		return this;
	}

	public MemberFormPage clickSaveAndClose() throws InterruptedException {
		click(getDriver().findElement(By.id("savefooter_statuscontrol")),"Save and Close");
		Thread.sleep(5000);
		return this;
	}

	public MemberFormPage scrollDownToPublish(){
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));

		scrollDown(getDriver().findElement(By.id("ix_recordstatus_i")));
		return this;
	}

	public MemberFormPage clickAddNewMembershipProviderSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")),"Save");	
		Thread.sleep(5000);
		return this;
	}
	public MemberFormPage clickSaveAndCloseInAccountNumbers() throws InterruptedException {
		switchToDefaultContent();
		Thread.sleep(3000);
		clickWithNoSnap(getDriver().findElement(By.xpath("//*[@id='ix_accountnumber|NoRelationship|Form|Mscrm.Form.ix_accountnumber.SaveAndClose']/span/a/span")));
		Thread.sleep(10000);
		getDriver().switchTo().window(mainPage);
		return this;
	}
	//*[@id="ix_accountnumber|NoRelationship|Form|Mscrm.Form.ix_accountnumber.SaveAndClose"]/span/a/span
	public MemberFormPage clickLineOfBusinessSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")),"Save");	
		Thread.sleep(5000);
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage crmNumberIsDisplayedWithFrame1() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		crmNumberIsDisplayed();
		return this;
	}

	public MemberFormPage crmNumberIsDisplayedWithFrame0() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		crmNumberIsDisplayed();
		return this;
	}

	public MemberFormPage crmNumberIsDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		String sCRMNumber = getTextValue(getDriver().findElement(By.id("CRM Account #_label")),"CRM Number");
		CRMNumber=sCRMNumber;
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		try {
			DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.properties.getProperty("DriverSheetName"));
			assertNotNull(sCRMNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage chooseActiveMember1(String CrmNumber1) throws InterruptedException   {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));	
		click(getDriver().findElement(By.id("crmGrid_findCriteria")),"Find Criteria");
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber1,"Find Criteria");
		click(((getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")))),"Search Icon");
		Thread.sleep(6000);
		return new MemberFormPage();
	}
	public MemberFormPage typeCRMNumberInAddNewMembershipProvider(String MembershipProvider) {
		click(getDriver().findElement(By.id("ix_membershipprovider")),"Membership Provider");
		type(getDriver().findElement(By.id("ix_membershipprovider_ledit")),MembershipProvider,"Membership Provider");
		return this;
	}

	public MemberFormPage typeInAddNewMembershipProvider(String MembershipProvider) {
		click(getDriver().findElement(By.id("ix_membershipprovider")),"Membership Provider");
		typeAndChoose(((getDriver().findElement(By.id("ix_membershipprovider_ledit")))),MembershipProvider,"Membership Provider");
		return this;
	}

	//*******************************************************************************************************************************************************************

	public MemberFormPage selectAccountType(String AccountType){
		click(getDriver().findElement(By.id("customertypecode_d")),"Account type");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),AccountType,"Account type");
		verifyExactText(getDriver().findElement(By.id("customertypecode_d")),AccountType,"Account type"); 
		return this;
	}
	public MemberFormPage selectAccountTypeWithFrame1(String AccountType){
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		selectAccountType(AccountType);
		return this;
	}
	//**********************************************************************************************************************************************************
	public MemberFormPage clickMemberName() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.xpath("//*[@id='TabNode_tab0Tab-main']/a/span/span")),"Member Name");
		Thread.sleep(5000);	
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage selectOwnership(String Ownership){
		click(getDriver().findElement(By.id("ix_corporaterebate_cl")),"Ownership");
		click(getDriver().findElement(By.id("ix_ownership")),"Ownership");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_ownership_i']")))),Ownership,"Ownership");
		verifyExactText(getDriver().findElement(By.id("ix_ownership")),Ownership,"Ownership"); 
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage changeRecordStatus(String ChangeRecordStatus){
		click(getDriver().findElement(By.id("ix_recordchangestatus")),"Change Record Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordchangestatus_d")))),ChangeRecordStatus,"Change Record Status");
		verifyExactText(getDriver().findElement(By.id("ix_recordchangestatus")),ChangeRecordStatus,"Change Record Status"); 
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage selectParticipationType(String ParticipationType) throws InterruptedException {
		Thread.sleep(5000);
		//scrollDown(((getDriver().findElement(By.id("ix_participationtype")))));
		//click(getDriver().findElement(By.id("ix_participationtype")),"Participation type");
		click(getDriver().findElement(By.id("ix_participationtype")),"Participation type");
		selectDropDownUsingVisibleText(getDriver().findElement(By.id("ix_participationtype_i")),ParticipationType,"Participation type");
		verifyExactText(getDriver().findElement(By.id("ix_participationtype")),ParticipationType,"Participation type"); 
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage selectParticipationTypeWithOutValidation(String ParticipationType) throws InterruptedException {
		Thread.sleep(5000);
		//scrollDown(((getDriver().findElement(By.id("ix_participationtype")))));
		//click(getDriver().findElement(By.id("ix_participationtype")),"Participation type");
		click(getDriver().findElement(By.id("ix_participationtype")),"Participation type");
		Thread.sleep(5000);
		selectDropDownUsingVisibleText(getDriver().findElement(By.id("ix_participationtype_i")),ParticipationType,"Participation type");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage selectDirectParent(String DirectParent) throws InterruptedException {
		Thread.sleep(10000);
		System.out.println(DirectParent);
		scrollDown(((getDriver().findElement(By.id("parentaccountid_c")))));
		click(getDriver().findElement(By.id("parentaccountid_ledit")),"Direct Parent");
		typeAndChoose(((getDriver().findElement(By.id("parentaccountid_ledit")))),DirectParent,"Direct Parent");
		return this;
	}

	public MemberFormPage selectDirectParentRelationManaged(String DirectParentRelation) {
		click(getDriver().findElement(By.xpath("//option[@title='Managed']")),"Direct Parent Relation Managed");	
		return this;
	}

	public MemberFormPage selectDirectParentRelationDate(String DirectParentRelationDate) {
		click(getDriver().findElement(By.id("ix_directparentrelationdate")),"Direct Parent Relation Date");
		type(((getDriver().findElement(By.id("ix_directparentrelationdate_iDateInput")))),DirectParentRelationDate, "Direct Parent Relation Date");
		return this;
	}
	public MemberFormPage verifyDirectParentRelationDate(String DirectParentRelationDate) {
		verifyExactText(((getDriver().findElement(By.id("ix_directparentrelationdate")))),DirectParentRelationDate, "Direct Parent Relation Date");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public MemberFormPage typeStockSymbol(String StockSymbol) {
		click(getDriver().findElement(By.id("ix_stocksymbol")),"Stock Symbol");
		type(((getDriver().findElement(By.id("ix_stocksymbol_i")))),StockSymbol, "Stock Symbol");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public MemberFormPage typeExchange(String Exchange) {
		click(getDriver().findElement(By.id("ix_exchange")),"Exchange");
		type(((getDriver().findElement(By.id("ix_exchange_i")))),Exchange, "Exchange");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
	public MemberFormPage selectTopParentRelation(String TopParentRelation) throws InterruptedException {
		click(getDriver().findElement(By.id("ix_topparentrelationship")),"Top Parent Relation");
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_topparentrelationship_i")))),TopParentRelation,"Top Parent Relation");
		verifyExactText(getDriver().findElement(By.id("ix_topparentrelationship")),TopParentRelation,"Top Parent Relation"); 
		return this;
	}

	public MemberFormPage selectTopParentRelationDate(String TopParentRelationDate) {
		click(getDriver().findElement(By.id("ix_topparentrelationdate")),"Top Parent Relation Date");
		type(getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")),TopParentRelationDate,"Top Parent Relation Date");
		return this;
	}

	public MemberFormPage verifyTopParentRelationDate(String TopParentRelationDate) {
		verifyExactText(getDriver().findElement(By.id("ix_topparentrelationdate")),TopParentRelationDate,"Top Parent Relation Date");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ADDRESSS DETAILS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage typeStreet1(String Street1) {
		scrollDown(getDriver().findElement(By.id("address1_line1")));
		click(getDriver().findElement(By.id("address1_line1")),"Street1");
		clearAndType(((getDriver().findElement(By.id("address1_line1_i")))),Street1, "Street1");
		return this;
	}
	public MemberFormPage verifyStreet1IsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line1")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line1_lock")),"Street1");
		return this;
	}

	public MemberFormPage verifyStreet2IsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line2")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line2_lock")),"Street2");
		return this;
	}
	public MemberFormPage typeStreet2(String Street2) {
		click(getDriver().findElement(By.id("address1_line2")),"Street2");
		clearAndType(((getDriver().findElement(By.id("address1_line2_i")))),Street2, "Street2");
		return this;
	}

	public MemberFormPage typeDeliveryInfo(String DeliveryInfo) {
		click(getDriver().findElement(By.id("address1_line3")),"Delivery Info");
		clearAndType(getDriver().findElement(By.id("address1_line3_i")),DeliveryInfo, "Delivery Info");
		return this;
	}
	public MemberFormPage verifyDeliveryInfoIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line3")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line3_lock")),"Delivery Info");
		return this;
	}

	public MemberFormPage typeState(String State) {
		click(getDriver().findElement(By.id("address1_stateorprovince")),"State");
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
		click(getDriver().findElement(By.id("telephone1")),"Main Phone");
		clearAndType(((getDriver().findElement(By.id("telephone1_i")))),MainPhone, "Main Phone");
		return this;
	}
	public MemberFormPage typeOtherPhone(String OtherPhone) {
		click(getDriver().findElement(By.id("telephone2")),"Other Phone");
		type(((getDriver().findElement(By.id("telephone2_i")))),OtherPhone, "Other Phone");
		return this;
	}
	public MemberFormPage typeOverrideName(String OverrideName) {
		click(getDriver().findElement(By.id("address1_name")),"OverrideName");
		type(((getDriver().findElement(By.id("address1_name_i")))),OverrideName, "OverrideName");
		return this;
	}
	public MemberFormPage typeFax(String Fax) {
		click(getDriver().findElement(By.id("fax")),"Fax");
		type(((getDriver().findElement(By.id("fax_i")))),Fax, "Fax");
		return this;
	}
	public MemberFormPage typeWebsite(String Website) {
		click(getDriver().findElement(By.id("websiteurl")),"Website");
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
		click(getDriver().findElement(By.id("address1_county")),"County");
		clearAndType((getDriver().findElement(By.id("address1_county_i"))),County,"County");
		return this;
	}


	public MemberFormPage typeCity(String City) {
		click(getDriver().findElement(By.id("address1_city")),"City");
		clearAndType((getDriver().findElement(By.id("address1_city_i"))),City,"City");
		return this;
	}
	public MemberFormPage verifyCityIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_city")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_city_lock")),"City");
		return this;
	}


	public MemberFormPage typeCountry(String Country) {
		click(getDriver().findElement(By.id("address1_country")),"Country");
		clearAndType((getDriver().findElement(By.id("address1_country_i"))),Country,"Country");
		return this;
	}

	public MemberFormPage verifyCountryIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_country")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_country_lock")),"Country");
		return this;
	}

	public MemberFormPage typeZipCode(String ZipCode) {
		click(getDriver().findElement(By.id("address1_postalcode")),"Zip Code");
		clearAndType((getDriver().findElement(By.id("address1_postalcode_i"))),ZipCode, "Zip Code");
		return this;
	}
	public MemberFormPage verifyZipIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_postalcode")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_postalcode_lock")),"ZipCode");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	public MemberFormPage selectBusinessClassification(String BusinessClassification)throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(getDriver().findElement(By.id("ix_businessclassification")),"Bussiness Clasification");
		typeAndChoose(((getDriver().findElement(By.id("ix_businessclassification_ledit")))),BusinessClassification,"Bussiness Clasification");
		Thread.sleep(3000);
		return this;                                                                                                                                                                                                                                
	}


	public MemberFormPage defaultAccountStatus() {
		verifyExactText((getDriver().findElement(By.id("ix_accountstatus"))),"Active","Account Status");
		return this;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~Membership Provider~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public MemberFormPage defaultMembershipProvider() {
		verifyExactText((getDriver().findElement(By.id("ix_membershipprovider"))),"No","Membership Provider");
		return this;
	}

	public MemberFormPage verifyMembershipProviderYes() {
		verifyExactText((getDriver().findElement(By.id("ix_membershipprovider"))),"Yes","Membership Provider");
		return this;
	}

	public MemberFormPage verifyMembershipProviderTypeOptions(String MembershipProviderType) {
		click(getDriver().findElement(By.id("ix_membershipprovidertype")),"Membership Provider Type");
		String[] MPList =MembershipProviderType.split(",");
		int size=MPList.length;
		for (int i = 0; i < size; i++)
		{	 
			verifyPartialText((getDriver().findElement(By.id("ix_membershipprovidertype"))),MPList[i],"Membership Provider Type");
		}
		return this;
	}

	public MemberFormPage selectMembershipProviderType(String MembershipProviderType) throws InterruptedException{
		Thread.sleep(5000);
		click(getDriver().findElement(By.id("ix_corporaterebate_cl")), "Corporate Rebate");
		click(getDriver().findElement(By.id("ix_membershipprovidertype")),"Membership Provider Type");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_membershipprovidertype_i']")))),MembershipProviderType,"Membership Provider Type");
		verifyExactText(getDriver().findElement(By.id("ix_membershipprovidertype")),MembershipProviderType,"Membership Provider Type"); 
		return this;
	}

	public MemberFormPage switchtoFrame1() {

		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public MemberFormPage verifyRecordChangeStatus(String verifyRecordChangeStatus) throws InterruptedException {
		Thread.sleep(10000);
		verifyExactText((getDriver().findElement(By.id("Record Change Status_label"))),verifyRecordChangeStatus,"Record Change Status");
		return this;
	}

	public MemberFormPage validateXMLFieldValues() {
		try{
			String filePath = "C:\\Users\\blogg\\Desktop\\input.xml";
			File file = new File(filePath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("account");
			int tLength = nodeList.getLength();


			for(int i=0; i<tLength; i++){
				Node node = nodeList.item(i);

				if(node.getNodeType()==Node.ELEMENT_NODE){
					Element element = (Element)node;
					System.out.println("Account No: "+element.getAttribute("acn"));
					System.out.println("First Name: "+element.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name: "+element.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Balance: "+element.getElementsByTagName("balance").item(0).getTextContent());
				}

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public MemberFormPage chooseRoasterType() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_donotroster_d")),"Roster Type");
		return this;
	}

	public MemberFormPage switchToFrameMember(String frame) throws InterruptedException   {
		switchToFrame(getDriver().findElement(By.id(frame)));
		return this;
	}
	//*************************************************************************************************************************
	public MemberFormPage clickLineOfBusiness() throws InterruptedException   {
		Thread.sleep(2000);
		click(getDriver().findElement(By.xpath("//*[@id=\'LineOfBusinessSubGrid_addImageButtonImage\']")),"Line Of Business");
		Thread.sleep(6000);
		return this;
	}

	public MemberFormPage clickLineOfBusinessWithFrame1() throws InterruptedException   {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		clickLineOfBusiness();
		return this;
	}
	public MemberFormPage clickLineOfBusinessWithFrame0() throws InterruptedException   {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		clickLineOfBusiness();
		return this;
	}
	//***************************************************************************************************************************************	

	public MemberFormPage selectLineOfBusinessGeneralGPO(String LineOfBusinessGeneralGPO) throws InterruptedException   {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		scrollDown(getDriver().findElement(By.id("ix_portfolio_c")));	
		click(getDriver().findElement(By.xpath("//option[@title='General GPO']")),"General GPO");
		return this;
	}

	public MemberFormPage selectLineOfBusiness(String LineOfBusiness) throws InterruptedException   {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_portfolio")),"Line of Bussiness");
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@id=\"ix_portfolio_i\"]")),LineOfBusiness,"LOB");
		verifyExactText(getDriver().findElement(By.xpath("//*[@id='ix_portfolio']")),LineOfBusiness,"LOB");
		return this;
	}
	public MemberFormPage selectLineOfClassificationGeneralGPO(String LineOfClassificationGeneralGPO) {
		click(getDriver().findElement(By.id("ix_classificationtypenew_c")),"Line of classification");
		click(getDriver().findElement(By.id("ix_classificationtypenew_c")),"Line of classification");
		type(((getDriver().findElement(By.id("ix_classificationtypenew_ledit")))),LineOfClassificationGeneralGPO,"Line of classification");
		return this;
	}

	public MemberFormPage selectLineOfBusinessStartDate(String LineOfBusinessStartDate) {
		click(getDriver().findElement(By.id("ix_startdate")),"Line of Bussiness Start Date");
		type(((getDriver().findElement(By.id("ix_startdate_iDateInput")))),LineOfBusinessStartDate,"Line of Bussiness Start Date");
		return this;
	}


	public MemberFormPage scrollDownFromTPRelation() {

		click(getDriver().findElement(By.id("ix_regionnew_cl")),"region");
		click(getDriver().findElement(By.id("ix_applicationstartdate_cl")),"Application Starte date");
		click(getDriver().findElement(By.id("ix_affiliategroup_cl")),"AG");
		click(getDriver().findElement(By.id("ix_affiliategroupeffectivedate_cl")),"AG");

		return this;
	}

	public MemberFormPage chooseRecordStatusPublishedWithFrame1(String RecordStatusPublished) throws InterruptedException {
		
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));

		chooseRecordStatusPublished(RecordStatusPublished);
		return this;
	}

	public MemberFormPage chooseRecordStatusPublished(String RecordStatusPublished) throws InterruptedException {
		Thread.sleep(10000);

		scrollDown(((getDriver().findElement(By.xpath("//*[@id='ix_recordstatus']")))));
		//click(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		Thread.sleep(10000);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatusPublished, "Record Status");	
		verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),RecordStatusPublished,"Record Status"); 
		return this;
	}

	/*
	 * public MemberFormPage chooseRecordStatusPublished(String
	 * RecordStatusPublished) throws InterruptedException { Thread.sleep(6000);
	 * 
	 * scrollDown(((getDriver().findElement(By.xpath("//*[@id='ix_recordstatus']")))
	 * )); click(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
	 * Thread.sleep(10000); Select Actions a = new Actions(getDriver());
	 * a.moveToElement(getDriver().findElement(By.xpath(
	 * "//option[contains(text(),'Published')]"))). click(). build().perform();
	 * //verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),
	 * RecordStatusPublished,"Record Status"); return this; }
	 */

	public MemberFormPage chooseRecordStatusPublishedWithFrame0(String RecordStatusPublished) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		chooseRecordStatusPublished(RecordStatusPublished);
		return this;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage entityCodeIsDisplayedWithFrame1() throws InterruptedException {
		Thread.sleep(6000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		entityCodeIsDisplayed();
		return this;
	}

	public MemberFormPage createSubAccount(String countofSubaccount) throws InterruptedException {

		int count=Integer.parseInt(countofSubaccount);

		for(int i=2;i<=count+1;i++) {
			new DashboardPage()
			//2. Go to Workplace > Accounts > +New 
			.clickWorkplace()
			.selectAccounts()
			.clickNewOnAccountsPage()
			.chooseMemberFormwithFrame1()

			//3. Account Name = Any
			
			.typeAccountName("Mani sub 26OCT_"+i)

			//Click on save 			
			.clickSave() 

			//4. Verify CRM Account # is generated 
			.crmNumberIsDisplayedWithFrame1()	

			//5. Account Type = Member
			.selectAccountType("Member")

			//Premier Start date = Today's Date
			//.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))

			//Class of Trade =Any
			.selectClassOfTrade("Auditorium/Museum")

			//Business Classification = Auto populated
			.businessClassificationIsVerified()	

			//Account Status = Auto Populated to Active
			.defaultAccountStatus()	

			//Application Start Date = Today's Date
			.chooseApplicationDate("9/13/2022")

			//CAMS Flag = Yes
			.changeCAMSFlag()

			//Participation Type = Standard
			.selectParticipationType("Standard")

			//Direct Parent Entity Code = 673415
			
			.selectDirectParent(entityCode)

			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged("Managed") 

			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate("9/13/2022")

			//Top Parent Relation =  OLM
			.selectTopParentRelation("Affiliate")

			// Top Parent Relation Date = Today's Date
			.selectTopParentRelationDate( "9/13/2022")

			//Click on Save 
			// .clickSave() 

			//6. Street 1 = Any
			.typeStreet1("253 33rd St")

			//City = NY
			.typeCity("NY")

			//Country =USA
			.typeCountry("USA")

			//
			.typeCounty("USA")

			//Click on Save 
			// .clickSave() 

			//7.  Click the + icon on the Line of Business Grid
			.clickLineOfBusiness()

			// Line of Business =General GPO
			.selectLineOfBusinessGeneralGPO("General GPO")

			// Classification Type = General GPO
			.selectLineOfClassificationGeneralGPO("General GPO")

			// Start Date =Today's date
			.selectLineOfBusinessStartDate("9/13/2022")

			// Click on LOB Save 
			.clickLineOfBusinessSave()

			//Click on Save 
			.clickSave() 
			//Add Membership provider
			.clickAddNewPremierMembershipWithFrame1()

			// Choose Membership type 
			.selectMembershipProviderType1("Premier")
			.typeInAddNewMembershipProvider("National")

			//Provide any start date and click on save
			.selectMembershipProviderStartDateInAddNewMembershipProvider("9/13/2022")
			.clickAddNewMembershipProviderSave()
			//8. Record Status = Published
			.chooseRecordStatusPublishedWithFrame1("Published")

			//Click on Save 
			.clickSave() 

			//9. Verify Entity code is generated 
			.entityCodeIsDisplayedWithFrame1();

		}

		return this;
	}
	public MemberFormPage entityCodeIsDisplayedWithFrame0() throws InterruptedException {
		Thread.sleep(6000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		entityCodeIsDisplayed();
		return this;
	}


	public MemberFormPage verifyDirectParentIsEmpty() {
		verifyNullValue(getDriver().findElement(By.id("header_parentaccountid")),"Direct Parent in header"); 
		return this;
	}

	public MemberFormPage verifyToParentIsEmpty() {
		verifyNullValue(getDriver().findElement(By.id("header_ix_topparent")),"Top Parent in header"); 
		return this;
	}

	public MemberFormPage entityCodeIsDisplayed() throws InterruptedException {
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		entityCode=getTextValue(getDriver().findElement(By.id("Entity Code_label")),"Entity Code");
		System.out.println(entityCode);
		assertNotNull(entityCode);
		return this;
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public MemberFormPage verifyIsCorporateAccount(String VerifyIsCorporateAccount) {
		verifyExactText(getDriver().findElement(By.id("Is Corporate Account_label")),VerifyIsCorporateAccount,"Is Corporate Account"); 
		return this;
	}
	public MemberFormPage AddSupplierRecord(String SupplierRecord) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("ix_supplierrecordid")))));
		click(getDriver().findElement(By.id("ix_supplierrecordid")),"Supplier Record");
		typeAndChoose(((getDriver().findElement(By.id("ix_supplierrecordid_ledit")))),SupplierRecord,"Supplier Record");
		Thread.sleep(2000);
		return this;
	}

	public MemberFormPage defaultAccountStatusHeader() {
		try {
			Thread.sleep(3000);
			verifyExactText((getDriver().findElement(By.id("header_ix_accountstatus"))),"Active","Account Status in Header");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public MemberFormPage verifyAccountStatus(String AcountStatus) {
		verifyExactText((getDriver().findElement(By.id("ix_accountstatus"))),AcountStatus,"Account Status");
		return this;
	}
	public MemberFormPage verifyAccountStatusWithFrame1(String AcountStatus) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		verifyExactText((getDriver().findElement(By.id("ix_accountstatus"))),AcountStatus,"Account Status");
		return this;
	}

	public MemberFormPage selectAccountStatus(String AcountStatus) throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_corporaterebate_cl")),"Account Status");
		click(getDriver().findElement(By.xpath("//*[@id='ix_accountstatus']")),"Account Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_accountstatus_i']")))),AcountStatus,"Account Status");
		verifyExactText((getDriver().findElement(By.xpath("//*[@id='ix_accountstatus']"))),AcountStatus,"Account Status");
		return this;
	}

	public MemberFormPage verifyCorporateParentName(String VerifyCorporateParentName) {
	
		verifyExactText(getDriver().findElement(By.id("ix_corporateparentname_lookupValue")),VerifyCorporateParentName,"Corporate Parent Name"); 
		return this;
	}

	public MemberFormPage verifyIsFoodServiceParent(String VerifyIsFoodServiceParent) {
		verifyExactText(getDriver().findElement(By.id("Is Food Service Parent_label")),VerifyIsFoodServiceParent,"Is Food Service Parent"); 
		return this;
	}

	public MemberFormPage VerifyFoodServiceParentName(String VerifyFoodServiceParentName) {
		verifyExactText(getDriver().findElement(By.id("ix_foodserviceparentname_lookupValue")),VerifyFoodServiceParentName,"Food Service Parent Name"); 
		return this;
	}

	public MemberFormPage VerifyFoodServiceStartDate(String FoodServiceStartDate) {
		verifyExactText(getDriver().findElement(By.id("Food Service Parent Start Date_label")),FoodServiceStartDate,"Food Service Parent Start Date"); 
		return this;
	}

	public MemberFormPage VerifyFSPOverride(String FSPOverride) {
		verifyExactText(getDriver().findElement(By.id("ix_foodserviceparentoverride")),FSPOverride,"Food Service Parent Override"); 
		return this;
	}

	public MemberFormPage VerifyCorpParenttartDate(String CorpParenttartDate) {
		verifyExactText(getDriver().findElement(By.id("ix_corporateparentstartdate")),CorpParenttartDate,"Corporate Parent Start Date"); 
		return this;
	}
	public MemberFormPage VerifyCorpParentOverride(String CorpParentOverride) {
		verifyExactText(getDriver().findElement(By.id("ix_corporateparentoverride")),CorpParentOverride,"Corporate Parent Override"); 
		return this;
	}

	public MemberFormPage VerifyFBO(String FBO) {
		verifyExactText(getDriver().findElement(By.id("ix_fbo")),FBO,"FBO"); 
		return this;
	}
	public MemberFormPage VerifyFBORD(String FBORD) {
		verifyExactText(getDriver().findElement(By.id("ix_fborelationdate")),FBORD,"FBO Relation Date"); 
		return this;
	}

	//*[@id="ix_fborelationdate"]

	public MemberFormPage VerifyFBOManualOverride(String FBOManualOverride) {
		verifyExactText(getDriver().findElement(By.id("ix_fbomanualoverride")),FBOManualOverride,"FBO Manual Override"); 
		return this;
	}
	public MemberFormPage VerifyFBOGPO(String FBOGPO) {
		verifyExactText(getDriver().findElement(By.id("ix_fbogpo")),FBOGPO,"FBO GPO"); 
		return this;
	}

	public MemberFormPage verifySponsor(String VerifySponsor) {
		verifyExactText(getDriver().findElement(By.id("ix_sponsor_lookupValue")),VerifySponsor,"Sponsor"); 
		return this;
	}
	public MemberFormPage verifyIsSponsor(String VerifyIsSponsor) {
		verifyExactText(getDriver().findElement(By.id("ix_issponsor")),VerifyIsSponsor,"Is Sponsor"); 
		return this;
	}

	public MemberFormPage verifyIsSponsorwithFrame1(String VerifyIsSponsor) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		verifyExactText(getDriver().findElement(By.id("ix_issponsor")),VerifyIsSponsor,"Is Sponsor"); 
		return this;
	}

	public MemberFormPage verifyCAMSFlag(String VerifyCAMSFlag) {
		verifyExactText(getDriver().findElement(By.id("ix_camsflag")),VerifyCAMSFlag,"CAMS Flag"); 
		return this;
	}

	public MemberFormPage verifyExcludeFromRoaster(String ExcludeFromRoaster) {
		verifyExactText(getDriver().findElement(By.id("ix_donotroster")),ExcludeFromRoaster,"Exclude From Roaster"); 
		return this;
	}

	public MemberFormPage changeCAMSFlag() {
		click(getDriver().findElement(By.id("ix_camsflag")),"CAMS Flag"); 
		return this;
	}

	public MemberFormPage changeIsPaymentEntity() {
		click(getDriver().findElement(By.id("ix_ispaymententity")),"Is Payment Entity"); 
		return this;
	}


	public MemberFormPage selectMembershipEndReason(String EndReason) {
		click(getDriver().findElement(By.id("ix_endreason")),"End Reason");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_endreason_i")))),EndReason,"End Reason");
		return this;
	}
	public MemberFormPage typeMembershipEndDate(String EndDate) throws InterruptedException {
		Thread.sleep(1000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_enddate")),"End Date");
		clearAndType(((getDriver().findElement(By.id("ix_enddate_iDateInput")))),EndDate,"End Date");
		return this;
	}
	public MemberFormPage clickMembershipSaveAndClose() {
		switchToDefaultContent();
		click(getDriver().findElement(By.xpath("//*[@id='ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.SaveAndClose']/span/a/span")),"Save and Close");
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));

		return this;
	}
	public MemberFormPage verifyPremierEndDateIsNull() {
		verifyNullValue(getDriver().findElement(By.id("ix_premiermemberenddate")),"Premier End Date"); 
		return this;
	}
	public MemberFormPage verifyPremierEndDate(String PremierEndDate) {
		verifyExactText(getDriver().findElement(By.id("ix_premiermemberenddate")),PremierEndDate,"Premier End Date");
		return this;
	}
	public MemberFormPage verifyPremierStartDate(String PremierStartDate) {
		verifyExactText(getDriver().findElement(By.id("ix_premiermemberstartdate_d")),PremierStartDate,"Premier Start Date");
		return this;
	}


	public MemberFormPage verifyAffiliateGroup(String AffiliateGroup) {
		verifyExactText(getDriver().findElement(By.id("ix_affiliategroup")),AffiliateGroup,"Affiliate Group");
		return this;
	}
	public MemberFormPage verifyAgEffectiveDate(String AgEffectiveDate) {
		verifyExactText(getDriver().findElement(By.id("ix_affiliategroupeffectivedate")),AgEffectiveDate,"Affiliate Group Effective Date");
		return this;
	}

	public MemberFormPage verifyAffiliateGroupIsNotNull() {
		getTextValue(getDriver().findElement(By.id("ix_affiliategroup")),"Affiliate Group");
		return this;
	}
	public MemberFormPage verifyAgEffectiveDateIsNotNull() {
		getTextValue(getDriver().findElement(By.id("ix_affiliategroupeffectivedate")),"Affiliate Group Effective Date");
		return this;
	}
	public MemberFormPage verifyAgEffectiveDateIsNull() {
		verifyNullValue(getDriver().findElement(By.id("ix_affiliategroupeffectivedate")),"AG Effective Date"); 
		return this;
	}

	public MemberFormPage verifyAffiliateGroupIsNull() {
		verifyNullValue(getDriver().findElement(By.id("ix_affiliategroup")),"Affiliate Group"); 
		return this;
	}

	public MemberFormPage verifyEntityCode(String verifyEntityCode) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		Assert.assertTrue(getTextValue(getDriver().findElement(By.xpath("//*[@id='Entity Code_label']")),"Entity Code").equals(verifyEntityCode));
		return this;
	}
	public MemberFormPage verifyEntityCodeFrame0(String verifyEntityCode) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		verifyExactText(getDriver().findElement(By.id("Entity Code_label")), verifyEntityCode,"Entity code");
		return this;
	}
	public MemberFormPage verifyMainAccountEntityCode(String verifyEntityCode) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		Assert.assertFalse(getTextValue(getDriver().findElement(By.id("Entity Code_label")),"Entity Code").equals(verifyEntityCode));
		return this;
	}


	public MemberFormPage verifyIsPaymentEntity(String IsPaymentEntity) {
		verifyExactText(getDriver().findElement(By.id("ix_ispaymententity")),IsPaymentEntity,"Is Payment Entity"); 
		return this;
	}

	public MemberFormPage addPaymentEntity(String AddPaymentEntity) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("ix_paymententityid")))));
		click(getDriver().findElement(By.id("ix_paymententityid")),"Payment Entity");
		typeAndChoose(((getDriver().findElement(By.id("ix_paymententityid_ledit")))),AddPaymentEntity,"Add Payment Entity");
		Thread.sleep(2000);
		return this;
	}

	public MemberFormPage selectMembershipEntity() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")),"Tab Node");
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_membership_AccountName")),"Membership Entity");
		Thread.sleep(3000);
		return this;
	}

	public MemberFormPage navigateToGeneralTab() throws InterruptedException {

		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.xpath("//h1[@title='Return to form']")),"Tab Node");
		Thread.sleep(3000);
		switchToDefaultContent();
		return this;
	}

	public MemberFormPage doubleClickOnTopParentInMembershipWithFrame0() throws InterruptedException {	
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr[5]/td[2]/nobr"))).
		doubleClick().
		build().perform();
		Thread.sleep(3000);
		return this;
	}

	public MemberFormPage clickCloseButton() {
		switchToDefaultContent();
		click(getDriver().findElement(By.xpath("//img[@class='closeButton']")),"Close Button");
		return this;
	}
	public MemberFormPage doubleClickOnNationalMembership() throws InterruptedException {	

		List<WebElement> entitycode= getDriver().findElements(By.id("contentIFrame1"));
		if(entitycode.size()>0) {
			switchToFrame(getDriver().findElement(By.id("contentIFrame1")));

		}
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@title='Open National' and @class='ms-crm-List-Link']")),"National","Membership Provider");
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("(//*[@id='gridBodyTable']/tbody/tr/td[@rawlookupitemname=\"National\"])"))).doubleClick().build().perform();
		Thread.sleep(3000);
		//verifyExactText(getDriver().findElement(By.xpath("//*[@id='Membership Provider_label']")),"National","Membership Entity");
		return this;
	}
	public MemberFormPage doubleClickOnNationalMembershipWithFrame0() throws InterruptedException {	
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		verifyExactText(getDriver().findElement(By.xpath("//*[@title='Open National' and @class='ms-crm-List-Link']")),"National","Membership Provider");
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr[2]/td[2]/nobr/span"))).doubleClick().build().perform();
		Thread.sleep(3000);
		//verifyExactText(getDriver().findElement(By.xpath("//*[@id='Membership Provider_label']")),"National","Membership Entity");
		return this;
	}

	public MemberFormPage doubleClickOnTopParentInMembershipLocationType() throws InterruptedException {	
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[3]/nobr"))).
		doubleClick().
		build().perform();
		Thread.sleep(3000);
		return this;
	}

	public MemberFormPage verifytopParentMembershipEntity(String TopParent) {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		verifyExactText(getDriver().findElement(By.id("FormTitle")),TopParent,"Top Parent");
		return this;
	}

	//	public MemberFormPage selectTPAuditHistory() throws InterruptedException {
	//		switchToDefaultContent();
	//		click(getDriver().findElement(By.id("TabNode_tab0Tab")),"Tab Node");
	//		Thread.sleep(2000);
	//		click(getDriver().findElement(By.id("Node_navAudit")),"Audi History");
	//		Thread.sleep(2000);
	//		return this;
	//	}
	//	public MemberFormPage verifyTimeStampInTPMembershipAuditHistory() { 
	//		getTextValue(getDriver().findElement(By.xpath("//*[@id='gridBodyTable']/tbody/tr[2]/td[2]/div")),"Time in Top Parent Membersihp Audit History"); 
	//		return this;
	//	}
	//
	//	public MemberFormPage verifyIsMemberAddMailSentwithFrame0() {
	//		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
	//		switchToFrame(getDriver().findElement(By.id("areaAuditFrame")));
	//		verifyExactText(getDriver().findElement(By.xpath("(//*[contains(@id,'ix_ismemberaddmailsent_cell')])[1]")),"Is Member Add mail sent","Audit History"); 
	//		verifyExactText(getDriver().findElement(By.xpath("(//*[contains(@id,'ix_ismemberaddmailsent_newvalue')])[1]")),"Yes","Is add mail sent"); 
	//		return this;
	//	}
	//	
	//	public MemberFormPage verifyIsMemberAddMailSentwithFrame01() {
	//		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
	//		switchToFrame(getDriver().findElement(By.id("areaAuditFrame")));
	//		verifyExactText(getDriver().findElement(By.xpath("(//*[contains(@id,'ix_ismemberaddmailsent_cell')])[1]")),"Is Member Add mail sent","Audit History"); 
	//		verifyExactText(getDriver().findElement(By.xpath("(//*[contains(@id,'ix_ismemberaddmailsent_newvalue')])[1]")),"Yes","Is add mail sent"); 
	//		return this;
	//	}

	public MemberFormPage changeTopParent() {
		click(getDriver().findElement(By.id("ix_istopparent")),"Top Parent"); 
		return this;
	}
	public MemberFormPage verifyIsTopParent(String IsTopParent) {
		verifyExactText(getDriver().findElement(By.id("ix_istopparent")),IsTopParent,"Is Top Parent"); 
		return this;
	}

	public MemberFormPage pageRefresh() {
		getDriver().navigate().refresh();
		return this;
	}
	public MemberFormPage selectRegion(String Region) {
		click(getDriver().findElement(By.id("ix_regionnew")),"Region");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_regionnew_i")))),Region,"Region");
		verifyExactText(getDriver().findElement(By.id("ix_regionnew")),Region,"Region"); 
		return this;
	}

	public MemberFormPage verifyDirectParentRelation() { 
		getTextValue(getDriver().findElement(By.id("ix_parentrelationship")),"Direct Parent Relation"); 
		return this;
	}
	public MemberFormPage selectTopParentClassification(String TopParentClassification) {
		click(getDriver().findElement(By.id("ix_topparentclassification")),"Top Parent Classification");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_topparentclassification_i")))),TopParentClassification,"Top Parent Classification");
		verifyExactText(getDriver().findElement(By.id("ix_topparentclassification")),TopParentClassification,"Top Parent Classification"); 
		return this;
	}

	public MemberFormPage selectCorporateRebate(String CorporateRebate) {
		click(getDriver().findElement(By.id("ix_corporaterebatefeedate_cl")),"Corporate Rebate");
		click(getDriver().findElement(By.id("ix_corporaterebate")),"CorporateRebate");
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@id='ix_corporaterebate_i']")),CorporateRebate,"Corporate Rebate");
		verifyExactText(getDriver().findElement(By.id("ix_corporaterebate")),CorporateRebate,"Corporate Rebate"); 
		return this;
	}

	public MemberFormPage changeFeeShareEligible() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("ix_feeshareeligible")),"Fee Share Eligible"); 
		return this;
	}

	public MemberFormPage changeFeeShareEligible1() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_feeshareeligible")),"Fee Share Eligible"); 
		return this;
	}

	public MemberFormPage selectFeeShareEligibleStartDate(String FeeShareEligibleDate) {
		click(getDriver().findElement(By.id("ix_feeshareeligibledate")),"Fee Share Eligible Start Date");
		type(((getDriver().findElement(By.id("ix_feeshareeligibledate_iDateInput")))),FeeShareEligibleDate,"Fee Share Eligible Start Date");
		return this;
	}
	public MemberFormPage selectCorporateRebateFeeDate(String CorporateRebateFeeDate) {
		click(getDriver().findElement(By.id("ix_corporaterebatefeedate")),"Corporate Rebate Start Date");
		type(((getDriver().findElement(By.id("ix_corporaterebatefeedate_iDateInput")))),CorporateRebateFeeDate,"Corporate Rebate Start Date");
		return this;
	}

	public MemberFormPage selectFBOGPOType(String FBOType) {
		click(getDriver().findElement(By.id("ix_fbotype")),"FBO GPO Type");
		selectDropDownUsingVisibleText((getDriver().findElement(By.xpath("//*[@id='ix_fbotype_i']"))),"Owner","FBO GPO Type");
		verifyExactText(getDriver().findElement(By.id("ix_fbotype")),FBOType,"FBO GPO Type"); 
		return this;
	}
	public MemberFormPage selectFBOEffectiveDate(String FBOEffectiveDate) {
		click(getDriver().findElement(By.id("ix_fbotypeeffectivedate")),"FBO Start Date");
		type(((getDriver().findElement(By.id("ix_fbotypeeffectivedate_iDateInput")))),FBOEffectiveDate,"FBO Start Date");
		return this;
	}
	public MemberFormPage verifyIsFBO(String isFBO) { 
		verifyExactText(getDriver().findElement(By.id("ix_isfbo")),isFBO, "Is FBO"); 
		return this;
	}

	public MemberFormPage verifyDirectParentRelation(String DirectParentRelation) { 
		verifyExactText(getDriver().findElement(By.id("ix_parentrelationship")),DirectParentRelation,"Direct Parent Relation"); 
		return this;
	}

	public MemberFormPage changeRequireManualAG() throws InterruptedException {
		click(getDriver().findElement(By.id("ix_affiliategroup_cl")),"AffiliateGropu");
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_requiremanualagassignment")),"Require Manual AG"); 
		return this;
	}

	public MemberFormPage selectAffiliateGroupEffectiveDate(String AffiliateGroupEffectiveDate) {
		click(getDriver().findElement(By.id("ix_affiliategroupeffectivedate")),"Affiliate Group Effective Date");
		type(getDriver().findElement(By.id("ix_affiliategroupeffectivedate_iDateInput")),AffiliateGroupEffectiveDate,"Affiliate Group Effective Date");
		return this;
	}

	public MemberFormPage selectAffiliateGroup(String AffiliateGroup) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("ix_affiliategroup_c")))));
		click(getDriver().findElement(By.id("ix_affiliategroup_ledit")),"Affiliate Group");
		typeAndChoose(getDriver().findElement(By.id("ix_affiliategroup_ledit")),AffiliateGroup,"Affiliate Group");
		return this;
	}

	public MemberFormPage chooseLocationType(String LocationType) throws InterruptedException   {	
		click(getDriver().findElement(By.id("ix_locationtype")),"Location Type");
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(getDriver().findElement(By.id("ix_locationtype_i")),LocationType,"Location Type");
		verifyExactText(getDriver().findElement(By.id("ix_locationtype")),LocationType,"Location type"); 
		return new MemberFormPage();
	}
	public MemberFormPage chooseLocationTypeNull() throws InterruptedException   {	
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_locationtype")),"Location Type");
		Thread.sleep(1000);
		selectDropDownUsingIndex(getDriver().findElement(By.id("ix_locationtype_i")),0,"Location Type");
		return new MemberFormPage();
	}

	public MemberFormPage selectSubaccount() throws InterruptedException {	
		Thread.sleep(3000);
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")),"Tab Node");
		Thread.sleep(1000);		
		click(getDriver().findElement(By.id("Node_navSubAccts")),"Sub Account");	
		return this;
	}

	public MemberFormPage selectAccountNumbers() throws InterruptedException {	
		Thread.sleep(3000);
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")),"Tab Node");
		Thread.sleep(1000);		
		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_accountnumber_Account")),"Account Numbers");	
		return this;
	}

	public MemberFormPage clickAddNewAccountNumberInAccountNumbers() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_accountnumber_AccountFrame")));
		click(getDriver().findElement(By.id("ix_accountnumber|OneToMany|SubGridAssociated|Mscrm.SubGrid.ix_accountnumber.AddNewStandard")),"Add");
		return this;
	}
	public MemberFormPage clickAddNewMembershipProvider() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		click(getDriver().findElement(By.id("ix_membership|OneToMany|SubGridAssociated|Mscrm.SubGrid.ix_membership.AddNewStandard")),"Add");
		return this;
	}

	public MemberFormPage clickAddNewPremierMembershipWithFrame1() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		//scrollDown(((getDriver().findElement(By.id("MembershipSubGrid_addImageButtonImage")))));
		click(getDriver().findElement(By.id("MembershipSubGrid_addImageButtonImage")),"Add");
		Thread.sleep(6000);
		return this;
	}

	public MemberFormPage clickAddNewPremierMembership() throws InterruptedException {
		//scrollDown(((getDriver().findElement(By.id("MembershipSubGrid_addImageButtonImage")))));
		click(getDriver().findElement(By.id("MembershipSubGrid_addImageButtonImage")),"Add");
		Thread.sleep(6000);
		return this;
	}

	public MemberFormPage clickAddNewPremierMembershipWithFrame0() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("MembershipSubGrid_addImageButtonImage")),"Add");
		Thread.sleep(6000);
		return this;
	}

	public MemberFormPage selectMembershipProviderTypeInAddNewMembershipProvider(String MembershipProviderType){
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_membershiptype")),"Membership Provider Type");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_membershiptype_i']")))),MembershipProviderType,"Membership Provider Type");
		return this;
	}


	public MemberFormPage selectMembershipProviderType1(String MembershipProviderType) throws InterruptedException{
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(getDriver().findElement(By.id("ix_membershiptype")),"Membership Provider Type");
		//selectDropDownUsingIndex(getDriver().findElement(By.id("ix_membershiptype_i")),15);
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_membershiptype_i']")))),MembershipProviderType,"Membership Provider Type");
		return this;
	}


	public MemberFormPage verifyNoRecordsFoundMsgInMPInAddMP() throws InterruptedException {
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.id("ix_membershipprovider"))).perform();
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//img[@id='ix_membershipprovider_i']")),"Membership Provider");
		Thread.sleep(3000);
		verifyPartialAttribute(getDriver().findElement(By.xpath("//span[contains(text(),'No records found')]")),"title","No records found.","Membership Provider Lookup"); 
		return this;
	}

	public MemberFormPage selectMembershipProviderStartDateInAddNewMembershipProvider(String LineOfBusinessStartDate) {
		click(getDriver().findElement(By.id("ix_startdate_d")),"Start Date");
		type(((getDriver().findElement(By.id("ix_startdate_iDateInput")))),LineOfBusinessStartDate,"Start Date");
		return this;
	}

	public MemberFormPage selectMembershipProviderInAddNewMembershipProvider(String LineOfBusinessStartDate) {
		click(getDriver().findElement(By.id("ix_membershipprovider")),"Membership Provider");
		type(((getDriver().findElement(By.id("ix_membershipprovider_ledit")))),LineOfBusinessStartDate,"Membership Provider");
		return this;
	}


	public MemberFormPage chooseAccountNumberTypeInAccountNumbersHIN() {
		try {
			Thread.sleep(2000);
			mainPage=getDriver().getWindowHandle();
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.id("ix_accountnumbertype")),"Account Numbers Type");
			//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_accountnumbertype_i")))),AccountNumberType,"Account Numbers Type");
			selectDropDownUsingIndex(getDriver().findElement(By.id("ix_accountnumbertype_i")),7,"Account Number Type");
			verifyExactText(getDriver().findElement(By.id("ix_accountnumbertype")),"HIN","Account Numbers Type"); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public MemberFormPage chooseAccountNumberTypeInAccountNumbersDEA() {
		try {
			Thread.sleep(2000);
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.id("ix_accountnumbertype")),"Account Numbers Type");
			//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_accountnumbertype_i")))),AccountNumberType,"Account Numbers Type");
			selectDropDownUsingIndex(getDriver().findElement(By.id("ix_accountnumbertype_i")),1,"Account Number Type");
			//verifyExactText(getDriver().findElement(By.id("ix_accountnumbertype")),AccountNumberType,"Account Numbers Type"); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}


	public MemberFormPage typeAccountNumberDEA() {
		int min=1111111;
		int max=9999999;
		String chars = "abcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		char c = chars.charAt(rnd.nextInt(chars.length()));	
		int randomInt = (int)(Math.random() * (max - min + 1) + min);
		int num=0;
		String strSum=Integer.toString(randomInt);
		strSum=c+"f"+strSum;
		for (int i=2;i<strSum.length()-1;i+=2)
		{
			char ch=strSum.charAt(i);
			int n=Integer.parseInt(Character.toString(ch));
			num+=n;
		}
		int num1=0;
		for (int i1=3;i1<strSum.length()-1;i1+=2)
		{
			char ch1=strSum.charAt(i1);
			int n1=Integer.parseInt(Character.toString(ch1));
			num1+=n1;
		}
		int num3=num1*2;
		int num2=num+num3;
		String strDEAChaneck=Integer.toString(num2);
		char ch2=strDEAChaneck.charAt(1);
		String DEA="";
		for (int i2=0;i2<strSum.length()-1;i2++)
		{
			DEA+=strSum.charAt(i2);
		}
		String DEANum=DEA+ch2;
		click(getDriver().findElement(By.id("ix_number_d")),"Number");
		type(((getDriver().findElement(By.id("ix_number_i")))),DEANum,"DEA Account Number");
		try {
			DataInputProvider.setCellData(DEANum.toString(), Driver.iTestCaseRowNum, "DEANumber",Driver.sCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}


	public MemberFormPage typeAccountNumberHIN() {
		int min=111111111;
		int max=999999999;
		//Random randomGenerator = new Random();
		int randomInt = (int)(Math.random() * (max - min + 1) + min);
		String AccNumHIN=String.valueOf(randomInt);
		click(getDriver().findElement(By.id("ix_number_d")),"Number");
		type(((getDriver().findElement(By.id("ix_number_i")))),AccNumHIN,"HIN Account Number");
		try {
			DataInputProvider.setCellData(AccNumHIN.toString(), Driver.iTestCaseRowNum, "HIN",Driver.sCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public MemberFormPage clickNewAccountInSubAccount() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("areaSubAcctsFrame")));
		click(getDriver().findElement(By.id("account|OneToMany|SubGridAssociated|Mscrm.SubGrid.account.AddNewStandard")),"New");
		Thread.sleep(5000);
		return this;
	}


	public MemberFormPage clickNewAccountInSubAccount0() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		switchToFrame(getDriver().findElement(By.id("areaSubAcctsFrame")));
		click(getDriver().findElement(By.id("account|OneToMany|SubGridAssociated|Mscrm.SubGrid.account.AddNewStandard")),"New");
		Thread.sleep(5000);
		return this;
	}

	public NewAccountPage clickNewOnAccountsPage() {
		click(getDriver().findElement(By.id("account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord")),"New");
		return new NewAccountPage();
	}

	public MemberFormPage verifyDirectParent(String TopParent) {
		System.out.println(getDriver().findElement(By.id("parentaccountid")).getText());
		verifyExactText((getDriver().findElement(By.id("parentaccountid"))),TopParent,"Top Parent");
		return this;
	}


	public MemberFormPage verifySupplierFormIsDisplayed() {
		verifyExactText((getDriver().findElement(By.id("header_crmFormSelector"))),"Account : Supplier Form","Form");
		return this;
	}

	public MemberFormPage verifyDEA(String DEA) throws InterruptedException {
		pageRefresh();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		verifyExactText((getDriver().findElement(By.id("DEA_label"))),DEA,"DEA");
		return this;
	}

	public MemberFormPage verifyHIN(String HIN) {
		verifyExactText((getDriver().findElement(By.id("HIN_label"))),HIN,"HIN");
		return this;
	}


	public MemberFormPage verifyTopParent(String DirectParent) {
		verifyExactText((getDriver().findElement(By.id("ix_topparent"))),DirectParent,"Direct Parent");
		return this;
	}

	public MemberFormPage typeDPReason(String DPReason) {
		click(getDriver().findElement(By.id("ix_dpexceptionreason")),"DP Reason");
		type(((getDriver().findElement(By.id("ix_dpexceptionreason_i")))),DPReason,"DP Reason");
		return this;
	}

	public MemberFormPage verifyIsCorporateAccountLocked() {
		verifyDisplayed(getDriver().findElement(By.id("ix_iscorporateaccount_lock")),"Is Corporate Account Lock");
		return this;
	}

	public MemberFormPage verifyIsFoodServiceParentLocked() {
		verifyDisplayed(getDriver().findElement(By.id("ix_isfoodserviceparent_lock")),"Food Service Parent Lock");
		return this;
	}
	public MemberFormPage verifyIsFBOLocked() {
		verifyDisplayed(getDriver().findElement(By.id("ix_isfbo_lock")), "FBO lock");
		return this;
	}

	public MemberFormPage verifySponsorLocked() {
		verifyDisplayed(getDriver().findElement(By.id("ix_sponsor_lock")),"Sponsor lock");
		return this;
	}
	
	public MemberFormPage verifyAccountTypeLocked() {
		verifyDisplayed(getDriver().findElement(By.xpath("//label[contains(@id,'Account Type_label')]//parent::div[contains(@class,'Locked')]")),"Account type lock");
		return this;
	}
	
	
	
	

	public MemberFormPage chooseMemberEntryFormInSubAccount() {
		try {
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")),"Form Selector");
			click(getDriver().findElement(By.xpath("//span[@title='Member Entry Form']")),"Member Entry Form");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public MemberFormPage switchToNewWindow() {
		try {
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public MemberFormPage chooseMemberEntryForm() {
		click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")),"Form Selector");
		click(getDriver().findElement(By.xpath("//span[@title='Member Entry Form']")),"Member Entry Form");
		return new MemberFormPage();
	}

	public MemberFormPage chooseMemberEntryFormWithFrame0() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		chooseMemberEntryForm();
		Thread.sleep(1000);
		return new MemberFormPage();
	}

	public MemberFormPage chooseMemberFormInSubAccount() {
		try {
			Thread.sleep(3000);
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")),"Form Selector");
			Thread.sleep(1000);
			clickwithout(getDriver().findElement(By.xpath("//*[@id=\"Dialog_0\"]/div/ul/li/a[2]/span/nobr/span")),"Member Form");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	public MemberFormPage chooseRecordStatus(String RecordStatus) throws InterruptedException {
		click(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatus,"Record Status");
		getDriver().findElement(By.id("ix_recordstatus")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),RecordStatus,"Record Status"); 
		Thread.sleep(3000);
		return this;	
	}


	public MemberFormPage chooseRecordStatusDraftWithFrame1(String RecordStatus) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		chooseRecordStatusDraft();
		return this;	
	}

	public MemberFormPage chooseRecordStatusDraft() throws InterruptedException {
		//scrollDown(getDriver().findElement(By.id("ix_recordstatus")));
		click(getDriver().findElement(By.id("ix_recordstatus")),"Record Status");
		selectDropDownUsingIndex(((getDriver().findElement(By.id("ix_recordstatus_i")))),0,"Record Status");
		getDriver().findElement(By.id("ix_recordstatus")).sendKeys(Keys.TAB);
		verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),"Draft","Record Status"); 
		Thread.sleep(3000);
		return this;	
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public MemberFormPage selectDirectParentRelationMEF(String DirectParentRelation) throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("ix_parentrelationship")),"Direct Parent Relation");
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_parentrelationship_i")))),DirectParentRelation,"Direct Parent Relation");
		verifyExactText(getDriver().findElement(By.id("ix_parentrelationship")),DirectParentRelation,"Direct Parent Relation"); 
		return this;
	}

	public MemberFormPage typeCountryMEF(String Country) {
		click(getDriver().findElement(By.id("address1_country_d")),"Country");
		type(getDriver().findElement(By.id("address1_country_d")),Country,"Country");
		return this;
	}

	public MemberFormPage typeTPReason(String TPReason) {
		click(getDriver().findElement(By.id("ix_tpexceptionreason")),"TP Reason");
		type(((getDriver().findElement(By.id("ix_tpexceptionreason_i")))),TPReason,"TP Reason");
		return this;
	}	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public MemberFormPage selectAccountss() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.xpath("//span[text()='Accounts']")),"Accounts");
		Thread.sleep(3000);
		return new MemberFormPage();
	}

	public MemberFormPage entityCodeIsDisplayedWithoutFrame() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		getTextValue(getDriver().findElement(By.id("Entity Code_label")),"Entity Code");
		return this;
	}

	public MemberFormPage businessClassificationIsVerified() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Business Classification_label').innerHTML").toString();
		getTextValue(getDriver().findElement(By.id("ix_businessclassification")),"Business Classification");
		return this;
	}


	public MemberFormPage scrollDown(String webElement) {
		click(getDriver().findElement(By.id("ix_premiermemberstartdate_cl")),"Premier Start Date");
		return this;
	}
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
