package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;
//TFS ID_11228: Cloud: Verify "This account is in Draft status." info text is displayed when there is a DP change and Record status is in draft

public class TestCase_11228 {

	WebDriverServiceImpl driverservice=new WebDriverServiceImpl();
	@Test
	public void verifyDraftStatus(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.selectSubaccount()

		//4. Click on Add new account 
		.clickNewAccountInSubAccount()
		.switchToSubAccount()

		//6. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))


		//Click on save 
		.clickSave()

		//Select member form
		.chooseMemberFormInSubAccount()

		//5. Verify Direct parent and Top parent are populated 
		.verifyDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyDirectParent", sDataSheetName))
		.verifyTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyTopParent", sDataSheetName))



		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelation0(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		//Top Parent Relation Date = Today's Date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

		//type TP reason
		.typeTPReason(DataInputProvider.getCellData_ColName(iRowNumber, "TPReason", sDataSheetName))

		//Click on save 
		.clickSave()


		//7. Verify CRM Account # is generated 
		.crmNumberIsDisplayedWithFrame0()	

		//8 Account  Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

		//Premier Start date = Today's Date
		//.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))

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

		//Direct Parent Relation = Managed
		.selectDirectParentRelationMEF(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 

		//Direct Parent Relation date = Today's Date
		.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))

		//DP exception reason = Any
		.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))

		//Click on Save 
		// .clickSave() 

		//9. Street 1 = Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))

		//City = NY
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))

		/* //Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))

			//
			.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))*/

		//Type Zip code
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))

		//Click on Save
		.clickSave() 

		.verifyDraftStatusMSG0()

		//10 Click the + icon on the Line of Business Grid		
		.clickLineOfBusiness()

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
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MultiGPO Update~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
		//Add Membership provider
		.clickAddNewPremierMembershipWithFrame0()

		// Choose Membership type
		.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
		.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider", sDataSheetName))

		//Provide any start date and click on save
		.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate", sDataSheetName))
		.clickAddNewMembershipProviderSave()
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
		//11 Record Status = Published
		.chooseRecordStatusPublishedWithFrame0(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 

		//12 Verify Entity code is generated 
		.entityCodeIsDisplayedWithFrame0()

		.verifyDraftStatusMSGNotDisplayed0()


		;

		//2. Go to Workplace > Accounts > +New 
		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(driverservice.CRMNumber)

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToRecordStatus()
		.chooseRecordStatusPublishedWithFrame1("Draft")
		.clickSave()
		.verifyDraftStatusMSGNotDisplayed0()

		
		;
	}
}
