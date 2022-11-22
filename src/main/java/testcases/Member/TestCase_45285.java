package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_45285:Verify whether the TPR is getting saved properly when DP change to different hierarchy

public class TestCase_45285 {


	@Test
	public void verifyDPChangeMessage(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		
		  .searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber,
		  "CrmNumber", sDataSheetName))
		  
		  //3.Double click on the account and go to Sub accounts entity by clicking >on the top 
		  .selectAccountFromSearchResults() 
		  .chooseMemberForm() 
		  .clickSave()
		  
		  .navigateToRecordStatus() 
		  .chooseRecordStatusPublishedWithFrame1("Draft")
		  .clickSave() 
		  .clickSaveinDuplicatePopup() 
		  .switchToFrame1()
		  .selectMembershipEntity()
		  .navigateToGeneralTab() 
		  .clickSave()
		  .updateDirectParent1() 
		  .updateDPwithoutScrolldonw("635436")
		  
		  .typeDPReason("Test") 
		  .clickSave()
		  
		  //6. //Top Parent Relation = OLM 
		  .selectTopParentRelationWithoutClick("OLM")
		  
		  .selectTopParentRelationDate("11/22/2022") 
		  .typeTPReason("Test")
		  .chooseRecordStatusPublishedWithFrame1("Published") 
		  .clickSave()
		  .verifyPartialdescriptionMessage("This account has sub accounts that will be changed as well.") 
		  .ClickOkInErrorMessage() 
		  .clickSaveinDuplicatePopup()
		  .clickSave()
		  .verifyENorrorMessage() 
		  ;
		  new DashboardPage()
		  
		  //2.Go to Workplace > Accounts and search for EIN 673415 
		  .clickWorkplace() 
		  .selectAccounts()
		  .searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber,"CrmNumber", sDataSheetName))
		  
		  //3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		  .selectAccountFromSearchResults()
		  .navigateToRecordStatus0()
		  .chooseRecordStatusPublishedWithFrame0("Draft")
		  .clickSave()
		  .clickSaveinDuplicatePopup() 
		  .switchToFrame1() 
		  .selectMembershipEntity()
		  .navigateToGeneralTab0() 
		  .clickSave() 
		  .updateDirectParent()
		  .updateDPwithoutScrolldonw("838463")
		  
		  .typeDPReason("Test") .clickSave()
		  
		  //6. //Top Parent Relation = OLM
		  .selectTopParentRelationWithoutClick0("Affiliate")
		  
		  
		  .typeTPReason("Test") 
		  .chooseRecordStatusPublishedWithFrame0("Published")
		  .clickSave()
		  .verifyPartialdescriptionMessage("This account has sub accounts that will be changed as well.")
		  .ClickOkInErrorMessage() 
		  .clickSaveinDuplicatePopup()
		 
		;

		new DashboardPage()
		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberEntryFormWithFrame1()

		//3. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

		//Click on save 			
		.clickSave() 

		//4. Verify CRM Account # is generated 
		.crmNumberIsDisplayedWithFrame1()	

		//5. Account Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

		//Premier Start date = Today's Date
		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))

		//Class of Trade =Any
		.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))

		//Business Classification = Auto populated
		.businessClassificationIsVerified()	

		//Account Status = Auto Populated to Active
		.defaultAccountStatus()	

		//Application Start Date = Today's Date
		.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))

		//CAMS Flag = Yes
		.changeCAMSFlag()

		//Participation Type = Standard
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))

		//Direct Parent Entity Code = 673415
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))

		//Direct Parent Relation = Managed
		.selectDirectParentRelationMEF(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 

		//Direct Parent Relation date = Today's Date
		.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))

		// Top Parent Relation Date = Today's Date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

		//Top Parent Relation =  OLM
		.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))


		//Click on Save 
		// .clickSave() 

		//6. Street 1 = Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))

		//City = NY
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))

		//Type Zip code
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))

		//Country =USA
		.typeCountryMEF(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))

		//Click on Save 
		.clickSave() 



		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MultiGPO Update~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
		//Add Membership provider
		.clickAddNewPremierMembershipWithFrame1()

		// Choose Membership type 
		.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
		.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider", sDataSheetName))

		//Provide any start date and click on save
		.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate", sDataSheetName))
		.clickAddNewMembershipProviderSave()
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		//7.  Click the + icon on the Line of Business Grid
		.clickLineOfBusinessWithFrame1()

		// Line of Business =General GPO
		.selectLineOfBusinessGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO", sDataSheetName))

		// Classification Type = General GPO
		.selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO", sDataSheetName))

		// Start Date =Today's date
		.selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate", sDataSheetName))

		// Click on LOB Save 
		.clickLineOfBusinessSave()

		//Click on Save 
		.clickSave() 
		//8. Record Status = Published
		.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 


		//9. Verify Entity code is generated 
		.entityCodeIsDisplayedWithFrame1()

		.selectMembershipEntity()
		.navigateToGeneralTab()
		.updateDirectParent1()
		.updateDPwithoutScrolldonw("635436")
		.selectTopParentRelationDate("11/22/2022")
		.typeDPReason("Test")
		.clickSave()

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelation("OLM")


		.typeTPReason("Test")
		.chooseRecordStatusPublishedWithFrame1("Published")
		.clickSave()
		.verifyENorrorMessage()
		;
	}
}
