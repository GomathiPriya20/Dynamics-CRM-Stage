package testcases.Member;


import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;



public class TestCase_1141 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 1141 : Validate Business Key";
		testDescription = "Verify Validate Business Key with BK Active field"; 
		category = "Member";
		authors = "Senthil";  
		dataSheetName = "Validate Business Key and BK Active fields_TP_1141";
		nodes = "Validate Business Key";

	}

	@BeforeMethod()
	public void startLogin() {		
		
	}
	
	
	@Test(dataProvider ="fetchData", groups ="Member", enabled=true)
	public void createMemberTP(String username, String password,String CrmNumber,String CrmNumber1,String AccountName,
			String PremierStartDate,String BusinessClassification,
			String ClassOfTrade,String ApplicationDate,String ParticipationType
			) throws InterruptedException, AWTException {
		new LoginPage()
		.typeUsername(username)
  	    .typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.chooseActiveMember(CrmNumber)
	//	.selectSubaccount();
		.selectBKfieldNoToYes()
		.clickSave()
		.clickSaveForError()
		.clickSaveForOk()
		.selectBKfieldNo()
		.clickSave()
		.clickSaveForOk()
		.selectBKfieldNoToYes()
		.clickSave()
		.clickClose1()
		//.selectAccountss()
		.chooseActiveMember1(CrmNumber1)
		.selectBKfieldNo()
		.clickSave()
		.clickClose1()
		.clickNewOnAccountsPage1()
		.chooseMemberForm()
		.typeAccountName(AccountName)
		
		.pickPremierStartDate(PremierStartDate)
		.selectBusinessClassification(BusinessClassification)
		.selectClassOfTrade(ClassOfTrade)
		.defaultAccountStatus()
		.chooseApplicationDate(ApplicationDate)
		.selectParticipationType(ParticipationType)
		//.defaultAccountType(AccountType)
		
		.selectBKfieldNoToYes()
		.clickSave()
		.selectBKfieldNoToYes()
		.clickSave()
		.selectBKfieldNoToYes()
		.clickSave()
		.businessKeyIsVerified();
		
		
		
		
//		.chooseMemberForm()
//		.typeAccountName()
//		.pickPremierStartDate()
//		.selectBusinessClassification()
//		.selectClassOfTrade()
//		.defaultAccountStatus()
//		.chooseApplicationDate()
//		.selectParticipationType()
//		.chooseRecordstatus()
//		.defaultAccountType()
		//.clickSave()
//		.typeStreet1()
//		.typeCountry()
//		.typeZipCode()
//		.selectDirectParent()
//		.selectDirectParentRelation() 
//		.selectDirectParentRelationDate()
//		.typeDPReason()
//		 .selectTopParentRelation()
//		.selectTopParentRelationDate()
//		 .typeTPReason()
//		.clickSave()
//		.crmNumberIsDisplayed()					
//		.clickLineOfBusiness()
//		.selectLineOfBusinessGeneralGPO()
//		.selectLineOfClassificationGeneralGPO()
//		.selectLineOfBusinessStartDate()
//		.clickLineOfBusinessSave()
//		.chooseRecordStatusPublished()
//		.selectBusinessClassification()
//		.clickSave();
	
	}

}
