package pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import driver.Driver;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;


//this code start account information fields
public class MemberFormPage extends WebDriverServiceImpl {

	public MemberFormPage typeAccountName(String AccountName) {
		//click(((getDriver().findElement(By.id("name_d")))));
//		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("name_d")))));
		type(((getDriver().findElement(By.id("name_i")))),AccountName);
		//click(getDriver().findElement(By.id("name_d")));
		return this;
	}
	public MemberFormPage typeAccountNameEdit(String AccountName) throws InterruptedException {
		//click(((getDriver().findElement(By.id("name_d")))));
//		Thread.sleep(3000); //table[@class="ms-crm-FormSection"]//div[@id="name"]
		//switchToDefaultContent();
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(3000);
//		click(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//div[@id='name']")))));
//		type(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//div[@id='name']")))),AccountName);
//		click(((getDriver().findElement(By.xpath("//option[@title='Managed']")))));
//		click(((getDriver().findElement(By.id("name_d")))));
		click(((getDriver().findElement(By.id("name_i")))));
		type(((getDriver().findElement(By.id("name_i")))),AccountName);
		//click(getDriver().findElement(By.id("name_d")));
		return this;
	}
	public MemberFormPage typeAccountModify(String AccountName) throws InterruptedException {
//		click(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//label[@id='Account Name_label'/div[1]]")))));
//		click(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//span[@id='name_fieldChangeIndicatorImage']")))));
//		type(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//label[@id='Account Name_label'/div[1]]")))),AccountName);
		//Account Name_label,name_i,Account Name_label,name_d,Account Name 2_label
	//	Thread.sleep(3000);
		click(getDriver().findElement(By.id("name_d")));
	//	click(getDriver().findElement(By.id("Account Name_label")));
		Thread.sleep(3000);
	//	type(getDriver().findElement(By.id("name_d")),AccountName);
		return this;
	}
	public MemberFormPage typeAccountModify1(String AccountName) throws InterruptedException {
//		click(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//label[@id='Account Name_label'/div[1]]")))));
//		click(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//span[@id='name_fieldChangeIndicatorImage']")))));
//		type(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//label[@id='Account Name_label'/div[1]]")))),AccountName);
		//Account Name_label,name_i,Account Name_label,name_d,Account Name 2_label
	//	Thread.sleep(3000); ms-crm-div-NotVisible
		click(getDriver().findElement(By.id("Account Name 2_label")));
	//	click(getDriver().findElement(By.id("Account Name_label")));
		Thread.sleep(3000);
		type(getDriver().findElement(By.id("Account Name 2_label")),AccountName);
		return this;
	}
//	public MemberFormPage accountNameDisplayed() throws InterruptedException {
//		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
//	    switchToDefaultContent();
//		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor)getDriver();
//		js.executeScript("return document.getElementById('name_label').innerHTML").toString();
//		getText(((getDriver().findElement(By.id("name_label")))));
//		return this;
//	}
	public MemberFormPage pickPremierStartDate(String PremierStartDate)  {
		click(((getDriver().findElement(By.id("ix_premiermemberstartdate_d")))));
		click(((getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")))));
		type(((getDriver().findElement(By.id("ix_premiermemberstartdate_iDateInput")))),PremierStartDate);
		return this;
	}
	public MemberFormPage selectBusinessClassification(String BusinessClassification)throws InterruptedException {
		
		scrollDown(((getDriver().findElement(By.id("ix_businessclassification_cl")))));
		click(((getDriver().findElement(By.id("ix_businessclassification")))));
		//Thread.sleep(5000);
		typeAndChoose(((getDriver().findElement(By.id("ix_businessclassification_ledit")))),BusinessClassification);
		Thread.sleep(3000);
		return this;                                                                                                                                                                                                                                
	}
	
	public MemberFormPage selectClassOfTrade(String ClassOfTrade) {
		scrollDown(((getDriver().findElement(By.id("ix_classoftradedetail_c")))));
		click(((getDriver().findElement(By.id("ix_classoftradedetail_c")))));
		type(((getDriver().findElement(By.id("ix_classoftradedetail_ledit")))),ClassOfTrade);

		return this;
	}
	public MemberFormPage defaultAccountStatus() {
		verifyExactText((getDriver().findElement(By.id("ix_accountstatus"))),"Active");
		return this;
	}
	public MemberFormPage chooseApplicationDate(String ApplicationDate) {
		click(((getDriver().findElement(By.id("ix_applicationstartdate")))));
		type(((getDriver().findElement(By.id("ix_applicationstartdate_iDateInput")))),ApplicationDate);
		return this;
	}
	public MemberFormPage chooseRoasterType() throws InterruptedException {
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("ix_donotroster_d")))));
		//type(((getDriver().findElement(By.id("ix_applicationstartdate_iDateInput")))),ApplicationDate);
		return this;
	}

	//ix_donotroster_i

	public MemberFormPage selectParticipationType(String ParticipationType) {

		click(((getDriver().findElement(By.id("ix_participationtype")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_participationtype_i")))),ParticipationType);
		return this;
	}
	
	public MemberFormPage selectBKfieldNoToYes() throws InterruptedException {
		
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		//scrollDown(((getDriver().findElement(By.id("ix_bkactive_d")))));

		click(((getDriver().findElement(By.id("ix_bkactive")))));
		//click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")));
		//Thread.sleep(10000);
		//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_participationtype_i")))),ParticipationType);
		return this; 
	}
	
public MemberFormPage selectBKfieldNo() throws InterruptedException {
		
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		scrollDown(((getDriver().findElement(By.id("ix_bkactive_d")))));

		click(((getDriver().findElement(By.id("ix_bkactive")))));
		//click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")));
		//Thread.sleep(10000);
		//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_participationtype_i")))),ParticipationType);
		return this; 
	}
	
	public MemberFormPage selectSubaccount() throws InterruptedException { 
		
		switchToDefaultContent();
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("TabNode_tab0Tab")))));
		
	//	click(getDriver().findElement(By.xpath("//span[title()='Negotiatus']")));
        
        click(((getDriver().findElement(By.id("Node_navSubAccts")))));
		//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_participationtype_i")))),ParticipationType);
		return this;
	}

	public MemberFormPage chooseRecordstatus(String Recordstatus) throws InterruptedException {
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
				return this;
	}
	public MemberFormPage chooseRecordstatusForModify(String Recordstatus) throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		//switchToDefaultContent();  ix_recordstatus
			//	Thread.sleep(3000);
		//scrollDown(((getDriver().findElement(By.id("Record Status_label")))));
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		type(((getDriver().findElement(By.id("ix_recordstatus_i")))),Recordstatus);
				return this;
	}

	public MemberFormPage defaultAccountType(String AccountType){
		click(((getDriver().findElement(By.id("customertypecode_d")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),AccountType);
		return this;
	}
     
	public MemberFormPage typeStreet1(String Street1) {
		click((getDriver().findElement(By.id("address1_line1"))));
		type(((getDriver().findElement(By.id("address1_line1_i")))),Street1);
		return this;
	}

	public MemberFormPage typeCountry(String Country) {
		click((getDriver().findElement(By.id("address1_county"))));
		type((getDriver().findElement(By.id("address1_county_i"))),Country);
		return this;
	}
	
	
	public MemberFormPage typeCity(String City) {
		click((getDriver().findElement(By.id("address1_city"))));
		type((getDriver().findElement(By.id("address1_city_i"))),City);
		return this;
	}
	public MemberFormPage typeCounty(String County) {
		click((getDriver().findElement(By.id("address1_country"))));
		type((getDriver().findElement(By.id("address1_country_i"))),County);
		return this;
	}
	
	

	public MemberFormPage typeZipCode(String ZipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		type((getDriver().findElement(By.id("address1_postalcode_i"))),ZipCode);
		return this;

	}


	//After click save  start direct parent information field

	public MemberFormPage selectDirectParent(String DirectParent) throws InterruptedException {
		Thread.sleep(3000);
		scrollDown(((getDriver().findElement(By.id("parentaccountid_c")))));
		click(((getDriver().findElement(By.id("parentaccountid_ledit")))));
		typeAndChoose(((getDriver().findElement(By.id("parentaccountid_ledit")))),DirectParent);
		return this;
	}

	public MemberFormPage selectDirectParentRelationManaged(String DirectParentRelation) {
		//scrollDown(((getDriver().findElement(By.id("ix_parentrelationship_i")))));
		click(((getDriver().findElement(By.xpath("//option[@title='Managed']")))));
//		click(getDriver().findElement(By.id("ix_parentrelationship_i")));
//    typeAndChoose(getDriver().findElement(By.id("ix_parentrelationship_iDiv")),DirectParentRelation);
		//click(getDriver().findElement(By.id("ix_parentrelationship_i")));
		
		return this;
	}
	
	public MemberFormPage selectDirectParentRelationAffiliated(String DirectParentRelation) {
		//scrollDown(((getDriver().findElement(By.id("ix_parentrelationship_i")))));
		click(((getDriver().findElement(By.xpath("//option[@title='Affiliated']")))));
//		click(getDriver().findElement(By.id("ix_parentrelationship_i")));
//    typeAndChoose(getDriver().findElement(By.id("ix_parentrelationship_iDiv")),DirectParentRelation);
		//click(getDriver().findElement(By.id("ix_parentrelationship_i")));
		
		return this;
	}


	public MemberFormPage selectDirectParentRelationDate(String DirectParentRelationDate) {
		click(((getDriver().findElement(By.id("ix_directparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_directparentrelationdate_iDateInput")))),DirectParentRelationDate);
		return this;
	}
	public MemberFormPage typeDPReason(String DPReason) {
		click(((getDriver().findElement(By.id("ix_dpexceptionreason")))));
		type(((getDriver().findElement(By.id("ix_dpexceptionreason_i")))),DPReason);
		return this;
	}

	public MemberFormPage selectTopParentRelation(String TopParentRelation) {
		click(getDriver().findElement(By.id("ix_topparentrelationship")));
		
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_topparentrelationship_i")))),TopParentRelation);
		
		return this;
	}
	
	public MemberFormPage selectTopParentRelationDate(String TopParentRelationDate) {
		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
		type(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),TopParentRelationDate);
		return this;
	}
	public MemberFormPage typeTPReason(String TPReason) {
		click(((getDriver().findElement(By.id("ix_tpexceptionreason")))));
		type(((getDriver().findElement(By.id("ix_tpexceptionreason_i")))),TPReason);
		return this;
	}

	//This code for address information fields

	
	public MemberFormPage clickSave() throws InterruptedException {
		switchToDefaultContent();
		click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.Save")));
		Thread.sleep(8000);
		return this;

	}
	
	public MemberFormPage clickSaveForError() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("ErrorTitle")));
		//verifyExactText(getDriver().findElement(By.id("ErrorTitle")),BusinessProcessError); 
		Thread.sleep(3000);
		return this;

	}
	
	public MemberFormPage clickSaveForOk() throws InterruptedException {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("InlineDialog_Iframe")));
		click(getDriver().findElement(By.id("butBegin")));
		//verifyExactText(getDriver().findElement(By.id("ErrorTitle")),BusinessProcessError); 
		Thread.sleep(3000);
		return this;

	}
	
	public MemberFormPage clickSaveAndClose() throws InterruptedException {
//		switchToDefaultContent();
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(3000);
		//click(getDriver().findElement(By.id("account|NoRelationship|Form|Mscrm.Form.account.SaveAndClose")));
		click(getDriver().findElement(By.id("savefooter_statuscontrol")));
//		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
//		Thread.sleep(3000);  savefooter_statuscontrol
		//click(getDriver().findElement(By.id("//div[@id='crmRibbonManager']//li[@id='ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.SaveAndClose']")));
		////div[@id="crmRibbonManager"]//li[@id="ix_membership|NoRelationship|Form|Mscrm.Form.ix_membership.SaveAndClose"]
		//xpath("//option[@title='General GPO']")))));
		Thread.sleep(8000);
		return this;

	}
  
  	
	public MemberFormPage crmNumberIsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		getText(((getDriver().findElement(By.id("CRM Account #_label")))));
		String sCRMNumber = getText(((getDriver().findElement(By.id("CRM Account #_label")))));;
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		try {
			DataInputProvider.setCellData(sCRMNumber.toString(), Driver.iTestCaseRowNumDriver, "CRMNumber");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}
	

	
	public MemberFormPage entityCodeIsDisplayedWithFrame() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Entity Code_label")))));
		return this;
	}
	public MemberFormPage entityCodeIsDisplayedWithoutFrame() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Entity Code_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Entity Code_label")))));
		return this;
	}
	
	public MemberFormPage businessClassificationIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Business Classification_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Business Classification_label")))));
		return this;
	}
	
	public MemberFormPage accountStatusIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Status_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Account Status_label")))));
		return this;
	}
	
	public MemberFormPage recordStatusIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Record Status_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Record Status_label")))));
		return this;
	}
	
	public MemberFormPage accountTypeIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Type_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Account Type_label")))));
		return this;
	}
	
	 public MemberFormPage rostertTypeIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1"))); Exclude from Roster_label,Do not Roster_label
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Exclude from Roster_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Exclude from Roster_label")))));
		return this;
	}
	public MemberFormPage directParentRelationIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Direct Parent Relation_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Direct Parent Relation_label")))));
		return this;
	}
	public MemberFormPage topParentRelationIsVerified() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Top Parent Relation_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Top Parent Relation_label")))));
		return this;
	}
//	public MemberFormPage switchWindow() {
//		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
//		JavascriptExecutor js = (JavascriptExecutor)getDriver();
//		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
//		getText(((getDriver().findElement(By.id("CRM Account #_label")))));
//		return this;
//	}

	//	public MemberForm clickIsTP() {
	//		click(getDriver().findElement(By.id("Is Top Parent_label")));
	//		return this;
	//	}


	//	public MemberForm pickTPRD() {
	//		scrollDown(getDriver().findElement(By.id("ix_topparentrelationdate")));
	//		click(getDriver().findElement(By.id("ix_topparentrelationdate")));
	//		click(getDriver().findElement(By.id("ix_topparentrelationdate_i")));
	//		click(getDriver().findElement(By.id("tdToday")));
	//		click(((getDriver().findElement(By.id("ix_topparentrelationdate")))));
	//		type(((getDriver().findElement(By.id("ix_topparentrelationdate_iDateInput")))),"07/11/2020");
	//		return this;
	//	}

	//This line start line of business fields information
	public MemberFormPage clickLineOfBusiness() throws InterruptedException   {
		Thread.sleep(3000);
		click((getDriver().findElement(By.id("LineOfBusinessSubGrid_addImageButtonImage"))));
		return this;
	}
	
	public MemberFormPage selectLineOfBusinessGeneralGPO(String LineOfBusinessGeneralGPO) throws InterruptedException   {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		scrollDown(getDriver().findElement(By.id("ix_portfolio_c")));
		
		click(((getDriver().findElement(By.xpath("//option[@title='General GPO']")))));
		return this;
	}
//	public MemberFormPage selectActiveMember() throws InterruptedException   {
//		//switchToDefaultContent();
//		//switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
//		Thread.sleep(3000);
//		click(getDriver().findElement(By.id("crmMasthead")));
//		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
//		Thread.sleep(3000);
//		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_membership_AccountName")));
//	//	click(((getDriver().findElement(By.xpath("//option[@title='My Active Members']")))));
//		return this;
//	}
	public MemberFormPage selectLineOfClassificationGeneralGPO(String LineOfClassificationGeneralGPO) {
		click(getDriver().findElement(By.id("ix_classificationtypenew_c")));
		click(((getDriver().findElement(By.id("ix_classificationtypenew_c")))));
		type(((getDriver().findElement(By.id("ix_classificationtypenew_ledit")))),LineOfClassificationGeneralGPO);
		
		return this;
	}
	
	public MemberFormPage selectLineOfBusinessStartDate(String LineOfBusinessStartDate) {
		click(((getDriver().findElement(By.id("ix_startdate")))));
		type(((getDriver().findElement(By.id("ix_startdate_iDateInput")))),LineOfBusinessStartDate);
		return this;
	}
	public MemberFormPage clickLineOfBusinessSave() throws InterruptedException {
		switchToDefaultContent();
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("globalquickcreate_save_button_NavBarGloablQuickCreate")));
		
		return this;
	}
	public MemberFormPage chooseRecordStatusPublished(String RecordStatusPublished) throws InterruptedException {
		//switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		//scrollDown(((getDriver().findElement(By.id("Record Status_label")))));
		//ix_recordstatus_i,
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatusPublished);
	//	Thread.sleep(5000);
		return this;
	}
	public MemberFormPage chooseRecordStatusWithoutPublished(String RecordStatusPublished1) throws InterruptedException {
		//switchToDefaultContent();
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		//scrollDown(((getDriver().findElement(By.id("Record Status_label")))));
		//ix_recordstatus_i,
		click(((getDriver().findElement(By.id("ix_recordstatus_i")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatusPublished1);
		
		Thread.sleep(5000);
		return this;
	}
	public MemberFormPage selectActiveMember(String ViewSelector) throws InterruptedException   {
		//switchToDefaultContent(); id="crmGrid_SavedNewQuerySelectorTD" crmGrid_SavedNewQuerySelector
		//switchToFrame(getDriver().findElement(By.id("NavBarGloablQuickCreate")));
		//id="gridControlBarCompositeControl"
		//switchToDefaultContent();
		//Thread.sleep(4000);

		//switchToFrame(getDriver().findElement(By.id("contentIFrame2")));
//		JavascriptExecutor js = (JavascriptExecutor)getDriver();
//		Thread.sleep(3000);
		//click(getDriver().findElement(By.xpath("//span[@title()='Select a view']")));
		//class="ms-crm-View-icon ms-crm-ViewSelector-dropdown-icon-associated-lite keyboardFocusClass"
		//ms-crm-View-icon-associated-lite ms-crm-ImageStrip-Dropdown_Arrow
		
		//click(getDriver().findElement(By.id("gridControlBarCompositeControl")));
		click(getDriver().findElement(By.id("SearchNode")));
		type(getDriver().findElement(By.id("SearchNode")),ViewSelector);
		//click(getDriver().findElement(By.className("ms-crm-View-icon ms-crm-ViewSelector-dropdown-icon-associated-lite keyboardFocusClass")));
	 //  type(getDriver().findElement(By.id("crmGrid_SavedNewQuerySelector")),ViewSelector);
//		click(((getDriver().findElement(By.xpath("//option[@title='My Active Members']")))));
		//click(getDriver().findElement(By.class("ms-crm-List-Sortable")));
		return this;
	}
	
//	public MemberFormPage chooseActiveMember(String CrmNumber) throws InterruptedException   {
//		//crmGrid_findCriteria
//		Thread.sleep(3000);
//		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
//		
//		click(getDriver().findElement(By.id("crmGrid_findHintText")));
//		typeAndEnter(getDriver().findElement(By.id("crmGrid_findHintText")),CrmNumber);
//		
//					return this;
//	}
	public MemberFormPage selectActiveMember() throws InterruptedException {
	//	Thread.sleep(3000);
		//implicitlyWait(30,TimeUnit.SECONDS) ;
		switchToDefaultContent();
		//click(getDriver().findElement(By.id("crmMasthead")));
		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
		
		Thread.sleep(3000);
		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_membership_AccountName")));
		Thread.sleep(3000);
		
   	return this;
		
	}
	public MemberFormPage selectPremierMember() throws InterruptedException {
			//Thread.sleep(3000);
			//implicitlyWait(30,TimeUnit.SECONDS) ;
			//switchToDefaultContent();
			//click(getDriver().findElement(By.id("crmMasthead")));
			switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
			click(getDriver().findElement(By.xpath("//table[@id='gridBodyTable']/following-sibiling:://nobr/span[@aria-label='Premier']/following-sibling:://nobr//li/span/span/span[2]")));
			//table[@id='gridBodyTable']
			
			//table[@id="gridBodyTable"]/tbody/tr[2]/td[2]/nobr{@aria-label="Premier"}
			//table[@id='gridBodyTable']//nobr/span[@aria-label='Premier']
			
			
	   	return this;
			
		}
	
	
	public MemberFormPage accountNameDisplayed() throws InterruptedException {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		switchToDefaultContent();
	//	Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Name_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Account Name_label")))));
		return this;
	}
	
	public MemberFormPage address1Line1Displayed() throws InterruptedException {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		
		switchToDefaultContent();
		//Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Street 1_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Street 1_label")))));
		return this;
	}
	public MemberFormPage recordStatusDisplayed() {
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Record Status_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Record Status_label")))));
		return this;
	}
	
	public MemberFormPage recordStatusDisplayedModify(String Recordstatus) throws InterruptedException {
	//	switchToWindow(-1); selectDropDownUsingVisibleText id="Record Status_label"
//		switchToDefaultContent();
//		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		
		//clickAndTpe(((getDriver().findElement(By.id("Record Status_label")))));
//		Thread.sleep(3000);
//		click(((getDriver().findElement(By.id("Record Status_label")))));
//		verifyExactText(((getDriver().findElement(By.id("Record Status_label")))),"Published");
		
		//selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_label")))),Recordstatus);
		//type(((getDriver().findElement(By.id("ix_recordstatus_label")))),Recordstatus);
//		JavascriptExecutor js = (JavascriptExecutor)getDriver();
//		js.executeScript("return document.getElementById('Record Status_label').innerHTML").toString();
//		getText(((getDriver().findElement(By.id("Record Status_label")))));
		return this;
	}
	public MemberFormPage selectMembershipEntity() throws InterruptedException {

		switchToDefaultContent();
		click(getDriver().findElement(By.id("TabNode_tab0Tab")));
		click(getDriver().findElement(By.id("Node_nav_ix_account_ix_membership_AccountName")));
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
//		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("Record Status_label")))));
		typeAndEnter(((getDriver().findElement(By.id("Record Status_label")))),"Draft");
	//	click(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//label[@id='Record Status_label'/div[1]]")))));
//		switchToDefaultContent();
//		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		//switchToFrame(getDriver().findElement(By.id("area_ix_account_ix_membership_AccountNameFrame")));
//		Actions action = new Actions(getDriver());
//		action.click(((getDriver().findElement(By.id("Record Status_label")))));
		//action.keyDown(Recordstatus);
		//action.sendKeys(Recordstatus);
		return this ;

	}
	
	public MemberFormPage captureStatusDisplayedModify(String Recordstatus) throws InterruptedException, AWTException {
		Thread.sleep(3000);
	//	click(((getDriver().findElement(By.id("Record Status_label")))));
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Record Status_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Record Status_label")))));
		
				return this ;

	}

	public MemberFormPage selectEndDate(String SelectEndDate) throws InterruptedException  {
		Thread.sleep(3000);
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(((getDriver().findElement(By.id("ix_enddate")))));
		click(((getDriver().findElement(By.id("ix_enddate_iDateInput")))));
		//type(((getDriver().findElement(By.id("ix_enddate")))),SelectEndDate);
		type(((getDriver().findElement(By.id("ix_enddate_iDateInput")))),SelectEndDate);
		return this;
	}
	public MemberFormPage selectEndReasonChange(String EndReason) throws InterruptedException {
	//	scrollDown(((getDriver().findElement(By.id("ix_endreason_i")))));
		click(((getDriver().findElement(By.id("ix_endreason")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_endreason_i")))),EndReason);
		
		//Thread.sleep(3000);
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		//switchToDefaultContent();
		//click(((getDriver().findElement(By.xpath("//table[@class='ms-crm-FormSection']//select[@id='ix_endreason_i']")))));
		//table[@class='ms-crm-FormSection']//select[@id="ix_endreason_i"]
		return this;
	}
//public MemberFormPage chooseActiveMember(String CrmNumber) throws InterruptedException   {
//		
//		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
//		//switchToDefaultContent();
//		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
//		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber);
//		click(((getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")))));
//		Thread.sleep(6000);
//		return this;
//		//return new MemberFormPage();
//	}
	public MemberFormPage verifyMumberTeriminated() throws InterruptedException {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Account Status_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Account Status_label")))));
		return this;
	}
public MemberFormPage chooseActiveMember1(String CrmNumber1) throws InterruptedException   {
	    switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		
		click(getDriver().findElement(By.id("crmGrid_findCriteria")));
		typeAndEnter(getDriver().findElement(By.id("crmGrid_findCriteria")),CrmNumber1);
		click(((getDriver().findElement(By.xpath("//table//a[@href='javascript:;']")))));
		Thread.sleep(6000);
		//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		return new MemberFormPage();
		//return  MemberFormPage();  
		
	}
	public MemberFormPage selectAccountss() throws InterruptedException {
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
		getText(((getDriver().findElement(By.id("Business Key_label")))));
		return this;
	}
	public MemberFormPage changeAccountType(String ChangeAccountType){
		click(((getDriver().findElement(By.id("customertypecode_d")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),ChangeAccountType);
		return this;
	}
	public MemberFormPage changeAccountTypenew(String ChangeAccountType1){
		switchToDefaultContent();
		click(((getDriver().findElement(By.id("customertypecode_d")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),ChangeAccountType1);
		return this;
	}
	public MemberFormPage melissaFiedlIsDisplayed() {
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('ix_melissaaddresskey_cl').innerHTML").toString();
		getText(((getDriver().findElement(By.id("ix_melissaaddresskey_cl")))));
		return this;
	}
	public MemberFormPage address1IsDisplayed() {
		//Street 1_label
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('Street 1_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("Street 1_label")))));
		return this;
	}
	public MemberFormPage address2IsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}
	public MemberFormPage cityIsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}
	public MemberFormPage countryIsDisplayed() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("return document.getElementById('CRM Account #_label').innerHTML").toString();
		getText(((getDriver().findElement(By.id("CRM Account #_label")))));
		return this;
	}
public MemberFormPage chooseLocationType(String LocationTpe) throws InterruptedException   {
		
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		click(getDriver().findElement(By.id("ix_locationtype")));
		Thread.sleep(3000);
		selectDropDownUsingVisibleText(getDriver().findElement(By.id("ix_locationtype_i")),LocationTpe);
		
		return new MemberFormPage();
		
	}

public MemberFormPage manualOverrideIsDisplayed() {
	switchToDefaultContent();
	switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	js.executeScript("return document.getElementById('FBO Manual Override_label').innerHTML").toString();
	getText(((getDriver().findElement(By.id("FBO Manual Override_label")))));
	return this;
}
public MemberFormPage manualOverrideIsDisplayed1() {
	//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	js.executeScript("return document.getElementById('ix_fbomanualoverride_cl').innerHTML").toString();
	getText(((getDriver().findElement(By.id("ix_fbomanualoverride_cl")))));
	return this;
}
public MemberFormPage feeshareeligibleIsDisplayed1() {
	//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	js.executeScript("return document.getElementById('ix_fbomanualoverride_cl').innerHTML").toString();
	getText(((getDriver().findElement(By.id("ix_fbomanualoverride_cl")))));
	return this;
}
public MemberFormPage clickSystem() throws InterruptedException{
	//switchToDefaultContent();//tab_5_headerText_anchor,tab_5_header_h2
	switchToFrame(getDriver().findElement(By.id("contentIFrame0")));
	scrollDown(((getDriver().findElement(By.id("tab_5_header_h2")))));
	click(((getDriver().findElement(By.id("tab_5_header_h2")))));
	Thread.sleep(3000);
//	selectDropDownUsingVisibleText(((getDriver().findElement(By.id("customertypecode_i")))),ChangeAccountType1);
	return this;
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public MemberFormPage CAMSFlag() {
	//switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
	JavascriptExecutor js = (JavascriptExecutor)getDriver();
	js.executeScript("return document.getElementById('ix_fbomanualoverride_cl').innerHTML").toString();
	getText(((getDriver().findElement(By.id("ix_fbomanualoverride_cl")))));
	return this;
}

}
