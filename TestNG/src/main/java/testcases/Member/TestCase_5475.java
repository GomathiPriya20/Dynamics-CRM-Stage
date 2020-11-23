package testcases.Member;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
//This class file for to verify GPO Member creation
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;


public class TestCase_5475 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 5475 : Create a new GPO Member";
		
		testDescription = "Verify a new GPO Member can be created"; 
		category = "Member";
		authors = "Senthil, Faridhah";  
		dataSheetName = "CreateMember_TP_5475";
	//	dataSheetName = "MasterData";
		nodes = "Create GPO Member";
		
		

	}

	@BeforeMethod
	public void startLogin() {		
		
	}
	  	
	@Test(dataProvider ="fetchData", groups = "Member", enabled=true)
	
	public void createMemberTP(String username,String password,String AccountName,String PremierStartDate,String BusinessClassification,
			String ClassOfTrade,String ApplicationDate,String ParticipationType,String Recordstatus,
			String AccountType,String Street1,String Country,String City,String County,
			String ZipCode,String DirectParent,String DirectParentRelation,
			String DirectParentRelationDate,String DPReason,String TopParentRelation,
			String TopParentRelationDate,String TPReason,String LineOfBusinessGeneralGPO,String LineOfClassificationGeneralGPO,
			String LineOfBusinessStartDate,String RecordStatusPublished /*String RecordStatusPublished1,
			String SelectEndDate,String EndReason,String CrmNumber,String ChangeAccountType,
			String ChangeAccountType1*/) throws InterruptedException  {
		new LoginPage()
	//	.getTestId5475(TestId)
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
		.selectParticipationType(ParticipationType)
		.chooseRecordstatus(Recordstatus)
		.defaultAccountType(AccountType)
		//.clickSave()
		.typeStreet1(Street1)
		.typeCountry(Country)
		.typeCity(City)
		.typeCounty(County)
		.typeZipCode(ZipCode)
		//.clickSave()
		.selectDirectParent(DirectParent)
		.selectDirectParentRelationAffiliated(DirectParentRelation) 
		.selectDirectParentRelationDate(DirectParentRelationDate)
		.typeDPReason(DPReason)
		 .selectTopParentRelation(TopParentRelation)
		.selectTopParentRelationDate(TopParentRelationDate)
		 .typeTPReason(TPReason)
		.clickSave()
		.crmNumberIsDisplayed()	
		.clickLineOfBusiness()
		.selectLineOfBusinessGeneralGPO(LineOfBusinessGeneralGPO)
		.selectLineOfClassificationGeneralGPO(LineOfClassificationGeneralGPO)
		.selectLineOfBusinessStartDate(LineOfBusinessStartDate)
		.clickLineOfBusinessSave()
		//.selectBusinessClassification(BusinessClassification)
		.chooseRecordStatusPublished(RecordStatusPublished)
	//	.selectBusinessClassification(BusinessClassification)
		.clickSave() 
		.entityCodeIsDisplayedWithFrame()
		.businessClassificationIsVerified()
		.accountTypeIsVerified()
		.recordStatusIsVerified()
		.accountStatusIsVerified();
	
	}
}
