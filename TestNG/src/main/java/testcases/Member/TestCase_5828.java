package testcases.Member;


import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import events.TestNgListeners;
import hooks.TestNgHooks;
import pages.LoginPage;



public class TestCase_5828 extends TestNgHooks{


	@BeforeTest
	public void setData() {
		testCaseName = "TFS ID_ 5828 : Terminate existing GPO Member";
		testDescription = "Verify can Terminate existing GPO Member"; 
		category = "Member";
		authors = "Senthil";  
		dataSheetName = "TerminateGPOMember_TP_5828";
	//	dataSheetName = "MasterData";
		nodes = "Terminate existing GPO Member";

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
			String TopParentRelationDate,String TPReason,String LineOfBusinessGeneralGPO,String LineOfClassificationGeneralGPO,
			String LineOfBusinessStartDate,String RecordStatusPublished,String SelectEndDate,String EndReason,String ActiveMember1) throws InterruptedException, AWTException {
		new LoginPage()
		.typeUsername(username)
  	    .typePassword(password)
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(ActiveMember1)
		.selectAccountFromSearchResults()
		.selectMembershipEntity()
		.selectPremierPremierMembership()
		.selectEndDate(SelectEndDate)
		.selectEndReasonChange(EndReason)
		.clickSaveAndClose();
		//.clickSave();
		//.verifyMumberTeriminated();
		
		
//		 .chooseActiveMember(CrmNumber);
		//.chooseSelectView(ViewSelector);
		//.selectActiveMember(ViewSelector);
			
//		.clickNewOnAccountsPage()
//		.chooseMemberForm()
//		.typeAccountName(AccountName)
//		.pickPremierStartDate(PremierStartDate)
//		.selectBusinessClassification(BusinessClassification)
//		.selectClassOfTrade(ClassOfTrade)
//		.defaultAccountStatus()
//		.chooseApplicationDate(ApplicationDate)
//		.selectParticipationType(ParticipationType)
//		.chooseRecordstatus(Recordstatus)
//		.defaultAccountType(AccountType)
		//.clickSave()
//		.typeStreet1(Street1)
//		.typeCountry(Country)
//		.typeCity(City)
//		.typeCounty(County)
//		
//		.typeZipCode(ZipCode)
//		.selectDirectParent(DirectParent)
//		.selectDirectParentRelationAffiliated(DirectParentRelation) 
//		.selectDirectParentRelationDate(DirectParentRelationDate)
//		.typeDPReason(DPReason)
//		 .selectTopParentRelation(TopParentRelation)
//		.selectTopParentRelationDate(TopParentRelationDate)
//		 .typeTPReason(TPReason)
//		.clickSave()
//		.crmNumberIsDisplayed()	
//		
//		.clickLineOfBusiness()
//		.selectLineOfBusinessGeneralGPO(LineOfBusinessGeneralGPO)
//		.selectLineOfClassificationGeneralGPO(LineOfClassificationGeneralGPO)
//		.selectLineOfBusinessStartDate(LineOfBusinessStartDate)
//		.clickLineOfBusinessSave()
		//.selectBusinessClassification(BusinessClassification)
//		.chooseRecordStatusPublished(RecordStatusPublished)
//		.selectBusinessClassification(BusinessClassification)
//		.clickSave()
//		.entityCodeIsDisplayedWithFrame()
//		.selectActiveMember();
		//.selectPremierMember();
		//account deactivation
								
	}

}
