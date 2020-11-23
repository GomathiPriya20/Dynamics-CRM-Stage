package testcases.Member;

//This class file for to verify GPO Member creation
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;


public class TestCase_1241 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 1241 : Validate that a Non-GPO can only be changed to Member";
		testDescription = "Verify that a Non-GPO can only be changed to Member"; 
		category = "Member";
		authors = "Senthil";  
		dataSheetName = "Validate that a Non-GPO can only be changed to Member_TP_1241";
		//dataSheetName = "MasterData";
		nodes = "Validate that a Non-GPO can only be changed to Member";

	}

	@BeforeMethod()
	public void startLogin() {		
		
	}
	
	@Test(dataProvider ="fetchData", groups = "Member", enabled=true)
	public void createMemberTP(String username,String password,String AccountName,String PremierStartDate,String BusinessClassification,
			String ClassOfTrade,String ApplicationDate,String ParticipationType,String Recordstatus,
			String AccountType,String Street1,String Country,String City,String County,
			String ZipCode,String DirectParent,String DirectParentRelation,
			String DirectParentRelationDate,String DPReason,String TopParentRelation,
			String TopParentRelationDate,String TPReason,
			String RecordStatusPublished1,String ChangeAccountType,String ChangeAccountType1) throws InterruptedException  {
		new LoginPage()
		.typeUsername(username)
  	    .typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberForm()
		.typeAccountName(AccountName)
		.pickPremierStartDate(PremierStartDate)
		.selectBusinessClassification(BusinessClassification)
		.selectClassOfTrade(ClassOfTrade)
		.defaultAccountStatus()
		.chooseApplicationDate(ApplicationDate)
		.chooseRoasterType()
		.selectParticipationType(ParticipationType)
		.chooseRecordstatus(Recordstatus)
		.defaultAccountType(AccountType)
		//.clickSave()
		.typeStreet1(Street1)
		.typeCountry(Country)
		.typeCity(City)
		.typeCounty(County)
		.typeZipCode(ZipCode)
		.selectDirectParent(DirectParent)
		.selectDirectParentRelationManaged(DirectParentRelation) 
		.selectDirectParentRelationDate(DirectParentRelationDate)
		.typeDPReason(DPReason)
		 .selectTopParentRelation(TopParentRelation)
		.selectTopParentRelationDate(TopParentRelationDate)
		 .typeTPReason(TPReason)
		.clickSave()
		.crmNumberIsDisplayed()					
		.chooseRecordStatusWithoutPublished(RecordStatusPublished1);
	//	.selectBusinessClassification(BusinessClassification)
	//	.clickSave()
//		.changeAccountType(ChangeAccountType)
//		.clickSave()
//		.clickSaveForError();
//		.defaultAccountType(AccountType)
//		.clickSave();
//		.changeAccountTypenew(ChangeAccountType1)
//		.clickSave();
//		
//		.entityCodeIsDisplayedWithoutFrame()
//		.accountTypeIsVerified()
//		.recordStatusIsVerified()
//		.accountStatusIsVerified()
//		.rostertTypeIsVerified()
//        .directParentRelationIsVerified()
//        .topParentRelationIsVerified();
//				
	
	}

}
