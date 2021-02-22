package pages;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//Test Case 7312:Add and update Primary contact to a Member account
import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class MemberFormPage extends WebDriverServiceImpl {
	
	//Account Name
	public MemberFormPage typeAccountName(String AccountName) {
		click(((getDriver().findElement(By.id("name_d")))));
		type(((getDriver().findElement(By.id("name_i")))),AccountName,"Account name");
		return this;
	}
	
	//Account name 2
	public MemberFormPage typeAccountName2(String AccountName2) {
		click(((getDriver().findElement(By.id("ix_hiscirostername")))));
		type(((getDriver().findElement(By.id("ix_hiscirostername_i")))),AccountName2,"Account name2");
		return this;
	}
	
	public MemberFormPage verifyAccountName2IsEnabled() {
		verifyIsEnabled(getDriver().findElement(By.id("ix_hiscirostername")),"Account name2");
		return this;
	}
	
	
	//Click on Save
	public MemberFormPage clickSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")));
		Thread.sleep(10000);
		return this;
	}
	
	public MemberFormPage clickSaveInAccountNumbers() throws InterruptedException {
		Thread.sleep(10000);	
		switchToDefaultContent();
		click(getDriver().findElement(By.id("savefooter_statuscontrol")));
		Thread.sleep(10000);	
		return this;
	}
	public MemberFormPage clickMemberName() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.xpath("//*[@id='TabNode_tab0Tab-main']/a/span/span")));
		Thread.sleep(10000);	
		return this;
	}
	
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
		String sCRMNumber = getTextValue(((getDriver().findElement(By.id("CRM Account #_label")))));;
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		 try {
				DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.properties.getProperty("DriverSheetName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return this;
	}
//*******************************************************************************************************************************************************************
	
	public MemberFormPage selectAccountType(String AccountType){
		click(((getDriver().findElement(By.id("customertypecode_d")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),AccountType,"Account type");
		verifyExactText(getDriver().findElement(By.id("customertypecode_d")),AccountType,"Account type"); 
		return this;
	}	
//**********************************************************************************************************************************************************
	
	
	public MemberFormPage selectOwnership(String Ownership){
		click(((getDriver().findElement(By.id("ix_corporaterebate_cl")))));
			click(((getDriver().findElement(By.id("ix_ownership")))));
			selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_ownership_i']")))),Ownership,"Ownership");
			verifyExactText(getDriver().findElement(By.id("ix_ownership")),Ownership,"Ownership"); 
		return this;
	}
	
	public MemberFormPage changeRecordStatus(String ChangeRecordStatus){
		click(((getDriver().findElement(By.id("ix_recordchangestatus")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordchangestatus_d")))),ChangeRecordStatus,"Change Record Status");
		verifyExactText(getDriver().findElement(By.id("ix_recordchangestatus")),ChangeRecordStatus,"Change Record Status"); 
		return this;
	}
	
	public MemberFormPage selectParticipationType(String ParticipationType) throws InterruptedException {
		Thread.sleep(10000);
		//scrollDown(((getDriver().findElement(By.id("ix_participationtype")))));
		//click(((getDriver().findElement(By.id("ix_participationtype_c")))));
		click(((getDriver().findElement(By.id("ix_participationtype")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_participationtype_i")))),ParticipationType,"Participation type");
		verifyExactText(getDriver().findElement(By.id("ix_participationtype")),ParticipationType,"Participation type"); 
		return this;
	}
	
	public MemberFormPage selectDirectParent(String DirectParent) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("parentaccountid_c")))));
		click(((getDriver().findElement(By.id("parentaccountid_ledit")))));
		typeAndChoose(((getDriver().findElement(By.id("parentaccountid_ledit")))),DirectParent,"Direct Parent");
		return this;
	}

	

	public MemberFormPage selectDirectParentRelationManaged(String DirectParentRelation) {
		click(((getDriver().findElement(By.xpath("//option[@title='Managed']")))));	
		return this;
	}

	public MemberFormPage selectDirectParentRelationDate(String DirectParentRelationDate) {
		click(((getDriver().findElement(By.id("ix_directparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_directparentrelationdate_iDateInput")))),DirectParentRelationDate, "Direct Parent Relation Date");
		return this;
	}
	
	public MemberFormPage typeStockSymbol(String StockSymbol) {
		click(((getDriver().findElement(By.id("ix_stocksymbol")))));
		type(((getDriver().findElement(By.id("ix_stocksymbol_i")))),StockSymbol, "Stock Symbol");
		return this;
	}
	
	public MemberFormPage typeExchange(String Exchange) {
		click(((getDriver().findElement(By.id("ix_exchange")))));
		type(((getDriver().findElement(By.id("ix_exchange_i")))),Exchange, "Exchange");
		return this;
	}
	
	
	

	public MemberFormPage selectTopParentRelation(String TopParentRelation) {
		click(getDriver().findElement(By.id("ix_topparentrelationship")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_topparentrelationship_i")))),TopParentRelation,"Top Parent Relation");
		verifyExactText(getDriver().findElement(By.id("ix_topparentrelationship")),TopParentRelation,"Top Parent Relation"); 
		return this;
	}

	public MemberFormPage selectTopParentRelationDate(String TopParentRelationDate) {
		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
		type(getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")),TopParentRelationDate,"Top Parent Relation Date");
		return this;
	}
	
	public MemberFormPage typeStreet1(String Street1) {
		scrollDown(getDriver().findElement(By.id("address1_line1")));
		click((getDriver().findElement(By.id("address1_line1"))));
		type(((getDriver().findElement(By.id("address1_line1_i")))),Street1, "Street1");
		return this;
	}
	public MemberFormPage verifyStreet1IsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line1")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line1")),"Street1");
		return this;
	}
	
	public MemberFormPage verifyStreet2IsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line2")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line2")),"Street2");
		return this;
	}
	public MemberFormPage typeStreet2(String Street2) {
		click((getDriver().findElement(By.id("address1_line2"))));
		type(((getDriver().findElement(By.id("address1_line2_i")))),Street2, "Street2");
		return this;
	}
	
	public MemberFormPage typeDeliveryInfo(String DeliveryInfo) {
		click((getDriver().findElement(By.id("address1_line3"))));
		type(((getDriver().findElement(By.id("address1_line3_i")))),DeliveryInfo, "Delivery Info");
		return this;
	}
	public MemberFormPage verifyDeliveryInfoIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line3")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line3")),"Delivery Info");
		return this;
	}

	public MemberFormPage typeState(String State) {
		click((getDriver().findElement(By.id("address1_stateorprovince"))));
		type(((getDriver().findElement(By.id("address1_stateorprovince_i")))),State, "State");
		return this;
	}
	public MemberFormPage verifyStateIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_stateorprovince")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_stateorprovince")),"State");
		return this;
	}
	public MemberFormPage verifyMainPhoneIsEnabled() {
		scrollDown(getDriver().findElement(By.id("telephone1")));
		verifyIsEnabled(getDriver().findElement(By.id("telephone1")),"Main Phone");
		return this;
	}

	
	public MemberFormPage typeMainPhone(String MainPhone) {
		click((getDriver().findElement(By.id("telephone1"))));
		type(((getDriver().findElement(By.id("telephone1_i")))),MainPhone, "Main Phone");
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
		verifyIsEnabled(getDriver().findElement(By.id("address1_county")),"County");
		return this;
	}
	
	public MemberFormPage typeCounty(String County) {
		click((getDriver().findElement(By.id("address1_county"))));
		type((getDriver().findElement(By.id("address1_county_i"))),County,"County");
		return this;
	}
	
	
	public MemberFormPage typeCity(String City) {
		click((getDriver().findElement(By.id("address1_city"))));
		type((getDriver().findElement(By.id("address1_city_i"))),City,"City");
		return this;
	}
	public MemberFormPage verifyCityIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_city")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_city")),"City");
		return this;
	}

	
	public MemberFormPage typeCountry(String Country) {
		click((getDriver().findElement(By.id("address1_country"))));
		type((getDriver().findElement(By.id("address1_country_i"))),Country,"Country");
		return this;
	}
	
	public MemberFormPage verifyCountryIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_country")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_country")),"Country");
		return this;
	}
	
	public MemberFormPage typeZipCode(String ZipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		type((getDriver().findElement(By.id("address1_postalcode_i"))),ZipCode, "ZipCode");
		return this;
	}
	public MemberFormPage verifyZipIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_postalcode")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_postalcode")),"ZipCode");
		return this;
	}
	
	
	public MemberFormPage chooseApplicationDate(String ApplicationDate) {
		click(((getDriver().findElement(By.id("ix_applicationstartdate")))));
		type(((getDriver().findElement(By.id("ix_applicationstartdate_iDateInput")))),ApplicationDate, "Application Start Date");
		return this;
	}
	
	public MemberFormPage pickPremierStartDate(String PremierStartDate)  {
		click(((getDriver().findElement(By.id("ix_premiermemberstartdate_d")))));
		click(((getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")))));
		type(((getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")))),PremierStartDate,"Premier Start Date");
		return this;
	}
	
	public MemberFormPage selectBusinessClassification(String BusinessClassification)throws InterruptedException {
		scrollDown(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(((getDriver().findElement(By.id("ix_businessclassification")))));
		typeAndChoose(((getDriver().findElement(By.id("ix_businessclassification_ledit")))),BusinessClassification,"Bussiness Clasification");
		Thread.sleep(3000);
		return this;                                                                                                                                                                                                                                
	}
	
	public MemberFormPage selectClassOfTrade(String ClassOfTrade) {
		scrollDown(((getDriver().findElement(By.id("ix_classoftradedetail_c")))));
		click(((getDriver().findElement(By.id("ix_classoftradedetail_c")))));
		type(((getDriver().findElement(By.id("ix_classoftradedetail_ledit")))),ClassOfTrade,"Class of Trade");
		return this;
	}
	public MemberFormPage verifyClassOfTradeIsEnabled() {
		scrollDown(((getDriver().findElement(By.id("ix_classoftradedetail_c")))));
		verifyIsEnabled(getDriver().findElement(By.id("ix_classoftradedetail_c")),"Class of Trade");
		return this;
	}
	
	public MemberFormPage defaultAccountStatus() {
		verifyExactText((getDriver().findElement(By.id("ix_accountstatus"))),"Active","Account Status");
		return this;
	}
	
	public MemberFormPage defaultMembershipProvider() {
		verifyExactText((getDriver().findElement(By.id("ix_membershipprovider"))),"No","Membership Provider");
		return this;
	}
	
	public MemberFormPage verifyMembershipProviderYes() {
		verifyExactText((getDriver().findElement(By.id("ix_membershipprovider"))),"Yes","Membership Provider");
		return this;
	}
	
	public MemberFormPage verifyMembershipProviderTypeOptions(String MembershipProviderType) {
		click(getDriver().findElement(By.id("ix_membershipprovidertype")));
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
		click(((getDriver().findElement(By.id("ix_corporaterebate_cl")))));
		click(((getDriver().findElement(By.id("ix_membershipprovidertype")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_membershipprovidertype_i']")))),MembershipProviderType,"Membership Provider Type");
		verifyExactText(getDriver().findElement(By.id("ix_membershipprovidertype")),MembershipProviderType,"Membership Provider Type"); 
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
	public MemberFormPage verifyRecordChangeStatus(String verifyRecordChangeStatus) {
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
		click(((getDriver().findElement(By.id("ix_donotroster_d")))));
		return this;
	}
	
	public MemberFormPage switchToFrameMember(String frame) throws InterruptedException   {
		switchToFrame(getDriver().findElement(By.id(frame)));
		return this;
	}
//*************************************************************************************************************************
	public MemberFormPage clickLineOfBusiness() throws InterruptedException   {
		Thread.sleep(6000);
		click((getDriver().findElement(By.xpath("//*[@id=\'LineOfBusinessSubGrid_addImageButtonImage\']"))));
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
		click(getDriver().findElement(By.xpath("//option[@title='General GPO']")));
		return this;
	}
	
	public MemberFormPage selectLineOfClassificationGeneralGPO(String LineOfClassificationGeneralGPO) {
		click(getDriver().findElement(By.id("ix_classificationtypenew_c")));
		click(((getDriver().findElement(By.id("ix_classificationtypenew_c")))));
		type(((getDriver().findElement(By.id("ix_classificationtypenew_ledit")))),LineOfClassificationGeneralGPO,"Line of classification");
		return this;
	}
	
	public MemberFormPage selectLineOfBusinessStartDate(String LineOfBusinessStartDate) {
		click(((getDriver().findElement(By.id("ix_startdate")))));
		type(((getDriver().findElement(By.id("ix_startdate_iDateInput")))),LineOfBusinessStartDate,"Line of Bussiness Start Date");
		return this;
	}
	public MemberFormPage clickLineOfBusinessSave() throws InterruptedException {
		switchToDefaultContent();
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")));	
		return this;
	}
	public MemberFormPage chooseRecordStatusPublishedWithFrame1(String RecordStatusPublished) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		chooseRecordStatusPublished(RecordStatusPublished);
		return this;
	}
	
	public MemberFormPage chooseRecordStatusPublished(String RecordStatusPublished) throws InterruptedException {
		Thread.sleep(9000);
		//scrollDown(((getDriver().findElement(By.id("ix_recordstatus")))));
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		//click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatusPublished, "Record Status");	
		verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),RecordStatusPublished,"Record Status"); 
		return this;
	}
		
	public MemberFormPage chooseRecordStatusPublishedWithFrame0(String RecordStatusPublished) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		chooseRecordStatusPublished(RecordStatusPublished);
		return this;
	}
	
	//***************************************************************************************************************************************
	public MemberFormPage entityCodeIsDisplayedWithFrame1() {
		try {
			Thread.sleep(2000);
			switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
			entityCodeIsDisplayed();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	public MemberFormPage entityCodeIsDisplayedWithFrame0() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		entityCodeIsDisplayed();
		return this;
	}

	public MemberFormPage entityCodeIsDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Entity Code_label")))));
		return this;
	}
	//***********************************************************************************************************************************************
	public MemberFormPage verifyIsCorporateAccount(String VerifyIsCorporateAccount) {
		verifyExactText(getDriver().findElement(By.id("Is Corporate Account_label")),VerifyIsCorporateAccount,"Is Corporate Account"); 
		return this;
	}
	public MemberFormPage AddSupplierRecord(String SupplierRecord) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("ix_supplierrecordid")))));
		click(((getDriver().findElement(By.id("ix_supplierrecordid")))));
		typeAndChoose(((getDriver().findElement(By.id("ix_supplierrecordid_ledit")))),SupplierRecord,"Supplier Record");
		Thread.sleep(2000);
		return this;
	}
	
	
	public MemberFormPage verifyGroup(String Group) {
		verifyExactText(getDriver().findElement(By.id("ix_group")),Group,"Group"); 
		return this;
	}
	public MemberFormPage verifyAccountStatus(String AcountStatus) {
		verifyExactText((getDriver().findElement(By.id("ix_accountstatus"))),AcountStatus,"Account Status");
		return this;
	}
	
	public MemberFormPage selectAccountStatus(String AcountStatus) throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_corporaterebate_cl")))));
		//scrollDown(getDriver().findElement(By.xpath("//*[@id='ix_accountstatus']")));
		click(getDriver().findElement(By.xpath("//*[@id='ix_accountstatus']")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_accountstatus_i']")))),AcountStatus,"Account Status");
		verifyExactText((getDriver().findElement(By.xpath("//*[@id='ix_accountstatus']"))),AcountStatus,"Account Status");
		return this;
	}
	
	public MemberFormPage verifyFacilityType(String FacilityType) throws InterruptedException {
		verifyExactText(getDriver().findElement(By.id("ix_facilitytype")),FacilityType,"Facility Type"); 
		return this;
	}
	
	public MemberFormPage verifyBusinessClassification(String BusinessClassification) {
		verifyExactText(getDriver().findElement(By.id("ix_businessclassification")),BusinessClassification,"Business Classification"); 
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
	
	public MemberFormPage verifyCAMSFlag(String VerifyCAMSFlag) {
		verifyExactText(getDriver().findElement(By.id("ix_camsflag")),VerifyCAMSFlag,"CAMS Flag"); 
		return this;
	}
	
	public MemberFormPage verifyPremierOwner(String PremierOwner) {
		verifyExactText(getDriver().findElement(By.id("ix_premierowner")),PremierOwner,"Premier Owner"); 
		return this;
	}
	
	public MemberFormPage verifyExcludeFromRoaster(String ExcludeFromRoaster) {
		verifyExactText(getDriver().findElement(By.id("ix_donotroster")),ExcludeFromRoaster,"Exclude From Roaster"); 
		return this;
	}
	
	public MemberFormPage verifyBKActive(String BKActive) {
		verifyExactText(getDriver().findElement(By.id("ix_donotroster")),BKActive,"BKActive"); 
		return this;
	}
	
	public MemberFormPage changeCAMSFlag() {
		click(getDriver().findElement(By.id("ix_camsflag"))); 
		return this;
	}
	
	public MemberFormPage changeIsPaymentEntity() {
		click(getDriver().findElement(By.id("ix_ispaymententity"))); 
		return this;
	}
	public MemberFormPage verifyIsPaymentEntity(String IsPaymentEntity) {
		verifyExactText(getDriver().findElement(By.id("ix_ispaymententity")),IsPaymentEntity,"Is Payment Entity"); 
		return this;
	}
	
	
	
	public MemberFormPage addPaymentEntity(String AddPaymentEntity) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("ix_paymententityid")))));
		click(((getDriver().findElement(By.id("ix_paymententityid")))));
		typeAndChoose(((getDriver().findElement(By.id("ix_paymententityid_ledit")))),AddPaymentEntity,"Add Payment Entity");
		Thread.sleep(2000);
		return this;
	}
	
	public MemberFormPage selectMembershipEntity() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_membership_AccountName")));
		Thread.sleep(3000);
		return this;
	}
	public MemberFormPage doubleClickOnTopParentInMembershipWithFrame0() throws InterruptedException {	
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
	
	public MemberFormPage doubleClickOnTopParentInMembership() throws InterruptedException {	
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
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
	
	public MemberFormPage doubleClickOnTopParentInMembershipLocationType() throws InterruptedException {	
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		Thread.sleep(3000);
		Actions a = new Actions(getDriver());
	      a.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr[4]/td[2]/nobr"))).
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
	
	public MemberFormPage selectTPAuditHistory() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
		Thread.sleep(2000);
		click(getDriver().findElement(By.id("Node_navAudit")));
		Thread.sleep(2000);
		return this;
	}
	public MemberFormPage verifyTimeStampInTPMembershipAuditHistory() { 
		getTextValue(((getDriver().findElement(By.xpath("//*[@id='gridBodyTable']/tbody/tr[2]/td[2]/div"))))); 
		return this;
	}

	public MemberFormPage verifyIsMemberAddMailSentwithFrame0() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		switchToFrame(getDriver().findElement(By.id("areaAuditFrame")));
		verifyExactText(getDriver().findElement(By.xpath("//*[contains(@id,'ix_ismemberaddmailsent_newvalue_')]")),"Yes","Is add mail sent"); 
		return this;
	}
	
	public MemberFormPage verifyIsMemberAddMailSent() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("areaAuditFrame")));
		verifyExactText(getDriver().findElement(By.xpath("//*[contains(@id,'ix_ismemberaddmailsent_newvalue_')]")),"Yes","Is add mail sent"); 
		return this;
	}
	
	public MemberFormPage changeTopParent() {
		click(getDriver().findElement(By.id("ix_istopparent"))); 
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
		click(getDriver().findElement(By.id("ix_regionnew")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_regionnew_i")))),Region,"Region");
		verifyExactText(getDriver().findElement(By.id("ix_regionnew")),Region,"Region"); 
		return this;
	}
	
	public MemberFormPage verifyDirectParentRelation() { 
		getTextValue(((getDriver().findElement(By.id("ix_parentrelationship"))))); 
		return this;
	}
	public MemberFormPage selectTopParentClassification(String TopParentClassification) {
		click(getDriver().findElement(By.id("ix_topparentclassification")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_topparentclassification_i")))),TopParentClassification,"Top Parent Classification");
		verifyExactText(getDriver().findElement(By.id("ix_topparentclassification")),TopParentClassification,"Top Parent Classification"); 
		return this;
	}
	
	public MemberFormPage selectCorporateRebate(String CorporateRebate) {
		click(((getDriver().findElement(By.id("ix_corporaterebatefeedate_cl")))));
		click(getDriver().findElement(By.id("ix_corporaterebate")));
		selectDropDownUsingVisibleText(getDriver().findElement(By.xpath("//*[@id='ix_corporaterebate_i']")),CorporateRebate,"Corporate Rebate");
		verifyExactText(getDriver().findElement(By.id("ix_corporaterebate")),CorporateRebate,"Corporate Rebate"); 
		return this;
	}
	
	
	public MemberFormPage changeFeeShareEligible() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(getDriver().findElement(By.id("ix_feeshareeligible"))); 
		return this;
	}
	
	public MemberFormPage changeFeeShareEligible1() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_feeshareeligible"))); 
		return this;
	}
	
	public MemberFormPage selectFeeShareEligibleStartDate(String FeeShareEligibleDate) {
		click(((getDriver().findElement(By.id("ix_feeshareeligibledate")))));
		type(((getDriver().findElement(By.id("ix_feeshareeligibledate_iDateInput")))),FeeShareEligibleDate,"Fee Share Eligible Start Date");
		return this;
	}
	public MemberFormPage selectCorporateRebateFeeDate(String CorporateRebateFeeDate) {
		click(((getDriver().findElement(By.id("ix_corporaterebatefeedate")))));
		type(((getDriver().findElement(By.id("ix_corporaterebatefeedate_iDateInput")))),CorporateRebateFeeDate,"Fee Share Eligible Start Date");
		return this;
	}
	
	
	
	
	
	public MemberFormPage selectFBOGPOType(String FBOType) {
		click(getDriver().findElement(By.id("ix_fbotype")));
		selectDropDownUsingVisibleText((getDriver().findElement(By.xpath("//*[@id='ix_fbotype_i']"))),"Owner","FBO GPO Type");
		verifyExactText(getDriver().findElement(By.id("ix_fbotype")),FBOType,"FBO GPO Type"); 
		return this;
	}
	public MemberFormPage selectFBOEffectiveDate(String FBOEffectiveDate) {
		click(((getDriver().findElement(By.id("ix_fbotypeeffectivedate")))));
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
	
	public MemberFormPage changeRequireManualAG() {
		click(getDriver().findElement(By.id("ix_requiremanualagassignment"))); 
		return this;
	}
	
	public MemberFormPage selectAffiliateGroupEffectiveDate(String AffiliateGroupEffectiveDate) {
		click(getDriver().findElement(By.id("ix_affiliategroupeffectivedate")));
		type(getDriver().findElement(By.id("ix_affiliategroupeffectivedate_iDateInput")),AffiliateGroupEffectiveDate,"Affiliate Group Effective Date");
		return this;
	}
	
	public MemberFormPage selectAffiliateGroup(String AffiliateGroup) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("ix_affiliategroup_c")))));
		click(getDriver().findElement(By.id("ix_affiliategroup_ledit")));
		typeAndChoose(getDriver().findElement(By.id("ix_affiliategroup_ledit")),AffiliateGroup,"Affiliate Group");
		return this;
	}
	
	public MemberFormPage chooseLocationType(String LocationType) throws InterruptedException   {	
		click(getDriver().findElement(By.id("ix_locationtype")));
		Thread.sleep(1000);
		selectDropDownUsingVisibleText(getDriver().findElement(By.id("ix_locationtype_i")),LocationType,"Location Type");
		verifyExactText(getDriver().findElement(By.id("ix_locationtype")),LocationType,"Location type"); 
		return new MemberFormPage();
	}
	public MemberFormPage chooseLocationTypeNull() throws InterruptedException   {	
		click(getDriver().findElement(By.id("ix_locationtype")));
		Thread.sleep(1000);
		selectDropDownUsingIndex(getDriver().findElement(By.id("ix_locationtype_i")),0);
		return new MemberFormPage();
	}
		
	public MemberFormPage selectSubaccount() throws InterruptedException {	
		switchToDefaultContent();
 		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("TabNode_tab0Tab")))));
		Thread.sleep(1000);		
	   click(((getDriver().findElement(By.id("Node_navSubAccts")))));	
		return this;
	}
	
	public MemberFormPage selectAccountNumbers() throws InterruptedException {	
		switchToDefaultContent();
 		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("TabNode_tab0Tab")))));
		Thread.sleep(1000);		
	   click(((getDriver().findElement(By.id("Node_nav_ix_account_ix_accountnumber_Account")))));	
		return this;
	}
	
	public MemberFormPage clickAddNewAccountNumberInAccountNumbers() throws InterruptedException {
		Thread.sleep(4000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_accountnumber_AccountFrame")));
		click(getDriver().findElement(By.id("ix_accountnumber|OneToMany|SubGridAssociated|Mscrm.SubGrid.ix_accountnumber.AddNewStandard")));
		return this;
	}
	public MemberFormPage clickAddNewMembershipProvider() throws InterruptedException {
		Thread.sleep(4000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		click(getDriver().findElement(By.id("ix_membership|OneToMany|SubGridAssociated|Mscrm.SubGrid.ix_membership.AddNewStandard")));
		return this;
	}
	
	
	public MemberFormPage selectMembershipProviderTypeInAddNewMembershipProvider(String MembershipProviderType){
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		click(((getDriver().findElement(By.id("ix_membershiptype")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.xpath("//*[@id='ix_membershiptype_i']")))),MembershipProviderType,"Membership Provider Type");
		
		return this;
	}
	
	public MemberFormPage typeCRMNumberInAddNewMembershipProvider(String MembershipProvider) {
		click(getDriver().findElement(By.id("ix_membershipprovider")));
		type(getDriver().findElement(By.id("ix_membershipprovider_ledit")),MembershipProvider,"Membership Provider");
		return this;
	}
	
	public MemberFormPage verifyNoRecordsFoundMsgInMPInAddMP() throws InterruptedException {
		Actions action = new Actions(getDriver());	
		Thread.sleep(3000);
		action.moveToElement(getDriver().findElement(By.id("ix_membershipprovider"))).perform();
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//img[@id='ix_membershipprovider_i']")));
		Thread.sleep(3000);
		verifyPartialAttribute(getDriver().findElement(By.xpath("//span[contains(text(),'No records found')]")),"title","No records found.","Membership Provider Lookup"); 
		return this;
	}
	
	public MemberFormPage selectMembershipProviderStartDateInAddNewMembershipProvider(String LineOfBusinessStartDate) {
		click(((getDriver().findElement(By.id("ix_startdate_d")))));
		type(((getDriver().findElement(By.id("ix_startdate_iDateInput")))),LineOfBusinessStartDate,"Start Date");
		return this;
	}
	public MemberFormPage clickAddNewMembershipProviderSave() throws InterruptedException {
		switchToDefaultContent();
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")));	
		return this;
	}
	public MemberFormPage selectMembershipProviderInAddNewMembershipProvider(String LineOfBusinessStartDate) {
		click(((getDriver().findElement(By.id("ix_membershipprovider")))));
		type(((getDriver().findElement(By.id("ix_membershipprovider_ledit")))),LineOfBusinessStartDate,"Membership Provider");
		return this;
	}
	

	public MemberFormPage chooseAccountNumberTypeInAccountNumbersHIN() {
		try {
			Thread.sleep(2000);
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.id("ix_accountnumbertype")));
			//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_accountnumbertype_i")))),AccountNumberType,"Account Numbers Type");
			selectDropDownUsingIndex(getDriver().findElement(By.id("ix_accountnumbertype_i")),7);
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
			click(getDriver().findElement(By.id("ix_accountnumbertype")));
			//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_accountnumbertype_i")))),AccountNumberType,"Account Numbers Type");
			selectDropDownUsingIndex(getDriver().findElement(By.id("ix_accountnumbertype_i")),1);
			//verifyExactText(getDriver().findElement(By.id("ix_accountnumbertype")),AccountNumberType,"Account Numbers Type"); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	
	public MemberFormPage typeAccountNumberDEA() {
		//click(((getDriver().findElement(By.id("ix_number_d")))));
		int min=1111111;
		int max=9999999;
		String chars = "abcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		char c = chars.charAt(rnd.nextInt(chars.length()));	
		int randomInt = (int)(Math.random() * (max - min + 1) + min);
		int num=0;
		String strSum=Integer.toString(randomInt);
		strSum=c+"k"+strSum;
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
		click(((getDriver().findElement(By.id("ix_number_d")))));
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
		System.out.println(randomInt);
		String AccNumHIN=String.valueOf(randomInt);
		click(getDriver().findElement(By.id("ix_number_d")));
		type(((getDriver().findElement(By.id("ix_number_i")))),AccNumHIN,"HIN Account Number");
		try {
			DataInputProvider.setCellData(AccNumHIN.toString(), Driver.iTestCaseRowNum, "HIN",Driver.sCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public MemberFormPage clickSaveAndCloseInAccountNumbers() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("ix_accountnumber|NoRelationship|Form|Mscrm.Form.ix_accountnumber.SaveAndClose")));
		Thread.sleep(10000);
		switchToWindow(0);
		return this;
	}
	
	public MemberFormPage clickNewAccountInSubAccount() {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("areaSubAcctsFrame")));
		click(getDriver().findElement(By.id("account|OneToMany|SubGridAssociated|Mscrm.SubGrid.account.AddNewStandard")));
		return this;
	}
	
	public NewAccountPage clickNewOnAccountsPage() {
		click(getDriver().findElement(By.id("account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord")));
		return new NewAccountPage();
	}
	
	public MemberFormPage verifyDirectParent(String TopParent) {
		verifyExactText((getDriver().findElement(By.id("parentaccountid"))),TopParent,"Top Parent");
		return this;
	}

	
	public MemberFormPage verifySupplierFormIsDisplayed() {
		verifyExactText((getDriver().findElement(By.id("header_crmFormSelector"))),"Account : Supplier Form","Form");
		return this;
	}

	public MemberFormPage verifyDEA(String DEA) throws InterruptedException {

		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(2000);
		verifyExactText((getDriver().findElement(By.id("ix_dea"))),DEA,"DEA");
		return this;
	}

	public MemberFormPage verifyHIN(String HIN) {
		verifyExactText((getDriver().findElement(By.id("ix_hin"))),HIN,"HIN");
		return this;
	}

	
	public MemberFormPage verifyTopParent(String DirectParent) {
		verifyExactText((getDriver().findElement(By.id("ix_topparent"))),DirectParent,"Direct Parent");
		return this;
	}
	
	public MemberFormPage typeDPReason(String DPReason) {
		click(((getDriver().findElement(By.id("ix_dpexceptionreason")))));
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
	
	public MemberFormPage chooseMemberEntryFormInSubAccount() {
		try {
			Thread.sleep(2000);
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")));
			click(getDriver().findElement(By.xpath("//span[@title='Member Entry Form']")));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
}

	
		public MemberFormPage chooseMemberEntryForm() {
			click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")));
			click(getDriver().findElement(By.xpath("//span[@title='Member Entry Form']")));
			return new MemberFormPage();
	}
	
	public MemberFormPage chooseMemberFormInSubAccount() {
		try {
			Thread.sleep(2000);
			switchToWindow(1);
			switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
			click(getDriver().findElement(By.xpath("(//span[@class='ms-crm-FormSelector'])[1]")));
			click(getDriver().findElement(By.xpath("//span[@title='Member Form']")));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	public MemberFormPage chooseRecordStatus(String RecordStatus) throws InterruptedException {
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatus,"Record Status");
		getDriver().findElement(By.id("ix_recordstatus")).sendKeys(Keys.TAB);
		//verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),RecordStatus,"Record Status"); 
		Thread.sleep(3000);
		return this;
	}
	
	public MemberFormPage AddMemberPrimaryContact(String AddMemberPrimaryContact) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("primarycontactid")))));
		click(((getDriver().findElement(By.id("primarycontactid")))));
		typeAndChoose(((getDriver().findElement(By.id("primarycontactid_ledit")))),AddMemberPrimaryContact,"Primary Contact");
		Thread.sleep(2000);
		return this;
	}
	
	

	public MemberFormPage VerifyPrimaryContactValue(String verifyPrimaryContactValue) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		scrollDown(getDriver().findElement(By.id("primarycontactid")));
		verifyExactText((getDriver().findElement(By.xpath("//*[@id='primarycontactid']"))), verifyPrimaryContactValue,"Primary Contact");
		return this;
	}
	
	public MemberFormPage AddMemberPrimaryContactFromLookUp(String PrimaryContactLookUp) throws InterruptedException {
		Actions action = new Actions(getDriver());	
		Thread.sleep(3000);
		action.moveToElement(getDriver().findElement(By.id("primarycontactid"))).perform();
		Thread.sleep(3000);
		click(getDriver().findElement(By.xpath("//img[@id='primarycontactid_i']")));
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
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public MemberFormPage selectDirectParentRelationMEF(String DirectParentRelation) {
		click(getDriver().findElement(By.id("ix_parentrelationship")));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_parentrelationship_i")))),DirectParentRelation,"Direct Parent Relation");
		verifyExactText(getDriver().findElement(By.id("ix_parentrelationship")),DirectParentRelation,"Direct Parent Relation"); 
		return this;
	}
	
	public MemberFormPage typeCountryMEF(String Country) {
		click((getDriver().findElement(By.id("address1_country_d"))));
		type(getDriver().findElement(By.id("address1_country_d")),Country,"Account Name");
		return this;
	}
	
	
	
	
	
	
	
	
//____________________________________________________________________________________________________________________________________________________________________________________________
	public MemberFormPage typeAccountNameEdit(String AccountName) throws InterruptedException {
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("name_i")))));
		type(((getDriver().findElement(By.id("name_i")))),AccountName,"Account name");
		return this;
	}
	public MemberFormPage verifyAccountNameIsEnabled() throws InterruptedException {
		verifyIsEnabled(getDriver().findElement(By.id("name_i")),"Accoun name");
		return this;
	}
	
	public MemberFormPage typeAccountModify(String AccountName) throws InterruptedException {
		click(getDriver().findElement(By.id("name_d")));
		Thread.sleep(3000);
		return this;
	}
	public MemberFormPage typeAccountModify1(String AccountName) throws InterruptedException {
		click(getDriver().findElement(By.id("Account Name 2_label")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.id("Account Name 2_label")),AccountName,"Account Name");
		return this;
	}

	public MemberFormPage selectBKfieldNoToYes() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_bkactive")))));
		return this; 
	}
	
public MemberFormPage selectBKfieldNo() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		scrollDown(((getDriver().findElement(By.id("ix_bkactive_d")))));
		click(((getDriver().findElement(By.id("ix_bkactive")))));
		return this; 
	}
	
	

	public MemberFormPage chooseRecordstatus(String Recordstatus) throws InterruptedException {
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
				return this;
	}
	public MemberFormPage chooseRecordstatusForModify(String Recordstatus) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		type(((getDriver().findElement(By.id("ix_recordstatus_i")))),Recordstatus,"Record status");
				return this;
	}
	public MemberFormPage selectDirectParentRelationAffiliated(String DirectParentRelation) {
		click(((getDriver().findElement(By.xpath("//option[@title='Affiliated']")))));
		return this;
	}


	public MemberFormPage typeTPReason(String TPReason) {
		click(((getDriver().findElement(By.id("ix_tpexceptionreason")))));
		type(((getDriver().findElement(By.id("ix_tpexceptionreason_i")))),TPReason,"TP Reason");
		return this;
	}

	public MemberFormPage verifyErrorMsgBKField() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("ErrorTitle")));
		Thread.sleep(3000);
		return this;
	}
	
	public MemberFormPage clickOkInErrorMsgBKField() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("butBegin")));
		Thread.sleep(3000);
		return this;
	}
	
	public MemberFormPage clickSaveAndClose() throws InterruptedException {
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("savefooter_statuscontrol")));
		Thread.sleep(8000);
		return this;
	}
  
	public MemberFormPage entityCodeIsDisplayedWithoutFrame() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Entity Code_label")))));
		return this;
	}
	
	public MemberFormPage businessClassificationIsVerified() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Business Classification_label').innerHTML").toString();
		getTextValue(getDriver().findElement(By.id("Business Classification_label")));
		return this;
	}
	
	public MemberFormPage accountStatusIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Status_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Account Status_label")))));
		return this;
	}
	
	public MemberFormPage recordStatusIsVerified() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Record Status_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Record Status_label")))));
		return this;
	}
	
	public MemberFormPage accountTypeIsVerified() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Type_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Account Type_label")))));
		return this;
	}
	
	 public MemberFormPage rostertTypeIsVerified() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Exclude from Roster_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Exclude from Roster_label")))));
		return this;
	}
	public MemberFormPage directParentRelationIsVerified() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Direct Parent Relation_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Direct Parent Relation_label")))));
		return this;
	}
	public MemberFormPage topParentRelationIsVerified() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Top Parent Relation_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Top Parent Relation_label")))));
		return this;
	}
	
	public MemberFormPage chooseRecordStatusWithoutPublished(String RecordStatusPublished1) throws InterruptedException {
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatusPublished1,"Record Status");
		verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),RecordStatusPublished1,"Record Status"); 
		Thread.sleep(5000);
		return this;
	}
	public MemberFormPage selectActiveMember(String ViewSelector) throws InterruptedException   {
		click(getDriver().findElement(By.id("SearchNode")));
		type(getDriver().findElement(By.id("SearchNode")),ViewSelector,"Active member");
		return this;
	}

	public MemberFormPage selectMember() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
		Thread.sleep(3000);
		return this;
	}

	public MemberFormPage selectActiveMember() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_membership_AccountName")));
		Thread.sleep(3000);
		return this;
	}
	public MemberFormPage selectPremierMember() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.xpath("//table[@id='gridBodyTable']/following-sibiling:://nobr/span[@aria-label='Premier']/following-sibling:://nobr//li/span/span/span[2]")));
	   	return this;	
	}
	
	public MemberFormPage accountNameDisplayed() throws InterruptedException {
		switchToDefaultContent();
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Name_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Account Name_label")))));
		return this;
	}
	
	public MemberFormPage address1Line1Displayed() throws InterruptedException {
		switchToDefaultContent();
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Street 1_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Street 1_label")))));
		return this;
	}
	public MemberFormPage recordStatusDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Record Status_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Record Status_label")))));
		return this;
	}
	
	public MemberFormPage selectAccountNumberEntity() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
		click(getDriver().findElement(By.xpath("//span[text()='Account Numbers']")));
		return this;
	}
	public MemberFormPage selectPremierPremierMembership() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());	
		action.moveToElement(getDriver().findElement(By.xpath("//table[@id='gridBodyTable']/tbody//tr[4]/td[2]/nobr//span[text()='Premier']")));
		action.doubleClick(getDriver().findElement(By.xpath("//table[@id='gridBodyTable']/tbody//tr[4]/td[2]/nobr//span[text()='Premier']"))).build().perform();
		return this;
	}
	
	public MemberFormPage selectStatusDisplayedModify() throws InterruptedException, AWTException {
		click(((getDriver().findElement(By.id("Record Status_label")))));
		typeAndEnter(((getDriver().findElement(By.id("Record Status_label")))),"Draft","Record Status");
		return this;
	}
	
	public MemberFormPage captureStatusDisplayedModify(String Recordstatus) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Record Status_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Record Status_label")))));
		return this ;
	}

	public MemberFormPage selectEndDate(String SelectEndDate) throws InterruptedException  {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_enddate")))));
		click(((getDriver().findElement(By.id("ix_enddate_iDateInput")))));
		type(((getDriver().findElement(By.id("ix_enddate_iDateInput")))),SelectEndDate,"End date");
		return this;
	}
	public MemberFormPage selectEndReasonChange(String EndReason) throws InterruptedException {
		click(((getDriver().findElement(By.id("ix_endreason")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_endreason_i")))),EndReason,"End Reason");
		verifyExactText(getDriver().findElement(By.id("ix_endreason")),EndReason,"End Reason"); 
		return this;
	}

	public MemberFormPage verifyMumberTeriminated() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Status_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Account Status_label")))));
		return this;
	}
public MemberFormPage chooseActiveMember1(String CrmNumber1) throws InterruptedException   {
	    switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));	
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber1,"Find Criteria");
		click(((getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")))));
		Thread.sleep(6000);
		return new MemberFormPage();
	}
	public MemberFormPage selectAccountss() throws InterruptedException {
		Thread.sleep(3000);
		switchToDefaultContent();
		click(getDriver().findElement(By.xpath("//span[text()='Accounts']")));
		Thread.sleep(3000);
		return new MemberFormPage();
		}
	public MemberFormPage clickClose1() throws InterruptedException {
		//switchToDefaultContent();
		click(getDriver().findElement(By.id("closeButton")));
		Thread.sleep(3000);
		return new MemberFormPage();
		}
	public NewAccountPage clickNewOnAccountsPage1() {
		click(getDriver().findElement(By.id("account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.NewRecord")));
		return new NewAccountPage();
	}
	public MemberFormPage businessKeyIsVerified() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Business Key_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Business Key_label")))));
		return this;
	}
	public MemberFormPage changeAccountType(String ChangeAccountType){
		click(((getDriver().findElement(By.id("customertypecode_d")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),ChangeAccountType,"Change Account Type");
		verifyExactText(getDriver().findElement(By.id("customertypecode_d")),ChangeAccountType,"Change Account Type"); 
		return this;
	}
	public MemberFormPage changeAccountTypenew(String ChangeAccountType1){
		switchToDefaultContent();
		click(((getDriver().findElement(By.id("customertypecode_d")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),ChangeAccountType1,"Change Account Type");
		verifyExactText(getDriver().findElement(By.id("customertypecode_d")),ChangeAccountType1,"Change Account Type"); 
		return this;
	}
	public MemberFormPage melissaFiedlIsDisplayed() {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('ix_melissaaddresskey_cl').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("ix_melissaaddresskey_cl")))));
		return this;
	}
	public MemberFormPage address1IsDisplayed() {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Street 1_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("Street 1_label")))));
		return this;
	}
	public MemberFormPage address2IsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}
	public MemberFormPage cityIsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}
	public MemberFormPage countryIsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getTextValue(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}

public MemberFormPage manualOverrideIsDisplayed() {
	switchToDefaultContent();
	switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	js.executeScript("return document.getElementById('FBO Manual Override_label').innerHTML").toString();
	getTextValue(((getDriver().findElement(By.id("FBO Manual Override_label")))));
	return this;
}
public MemberFormPage manualOverrideIsDisplayed1() {
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	js.executeScript("return document.getElementById('ix_fbomanualoverride_cl').innerHTML").toString();
	getTextValue(((getDriver().findElement(By.id("ix_fbomanualoverride_cl")))));
	return this;
}
public MemberFormPage feeshareeligibleIsDisplayed1() {	
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	js.executeScript("return document.getElementById('ix_fbomanualoverride_cl').innerHTML").toString();
	getTextValue(((getDriver().findElement(By.id("ix_fbomanualoverride_cl")))));
	return this;
}
public MemberFormPage clickSystem() throws InterruptedException{
	switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
	scrollDown(((getDriver().findElement(By.id("tab_5_header_h2")))));
	click(((getDriver().findElement(By.id("tab_5_header_h2")))));
	Thread.sleep(3000);
	return this;
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~





}
