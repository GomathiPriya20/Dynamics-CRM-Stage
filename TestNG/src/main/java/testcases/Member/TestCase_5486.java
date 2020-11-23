package testcases.Member;

//This class file for to verify GPO Member creation
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;


public class TestCase_5486 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 5486 : Create a new Non-GPO Member";
		testDescription = "Verify a new N0n-GPO Member can be created"; 
		category = "Member";
		authors = "Senthil, Faridhah";  
		dataSheetName = "Create Non-Gpo Member_TP_5486";
		//dataSheetName = "MasterData";
		nodes = "Create Non-GPO Member";

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
			String RecordStatusPublished1) throws InterruptedException  {
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
		.chooseRecordStatusWithoutPublished(RecordStatusPublished1)
		//.selectBusinessClassification(BusinessClassification)
		.clickSave()
		.entityCodeIsDisplayedWithoutFrame()
		.accountTypeIsVerified()
		.recordStatusIsVerified()
		.accountStatusIsVerified()
		.rostertTypeIsVerified()
        .directParentRelationIsVerified()
        .topParentRelationIsVerified();
				
	
	}

}
