package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_7143:Create new Top Parent member - New Member form and Save it as prospect first


public class TestCase_7143 {

	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickService()
		.selectWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1() 

		//3. Account  Type = Member
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

		//Is Top parent = Yes
		.changeTopParent()

		//Top parent relation = Affiliate
		.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		//Top parent relation date = Today's date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

		//Click on save
		.clickSave() 

		//4. Verify CRM Account # is generated 
		.crmNumberIsDisplayedWithFrame1()	


		//5. Account  Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

		//Premier Start date = Today's Date
		//	.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))

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

		//Direct Parent Relation = Owned(Auto populated)
		.verifyDirectParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName))

		//Region = Any
		.selectRegion(DataInputProvider.getCellData_ColName(iRowNumber, "Region", sDataSheetName))

		//Top parent classification = Any
		.selectTopParentClassification(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentClassification", sDataSheetName))
		//Require Manual AG =Yes
		.changeRequireManualAG()

		//Select affiliate group =Affiliate NonAcute
		.selectAffiliateGroup(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroup", sDataSheetName))

		//Enter affiliate group effective date = today's date
		.selectAffiliateGroupEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroupEffectiveDate", sDataSheetName))


		//Click on Save
		//.clickSave() 

		//6. Street 1 = Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))

		//City = NY
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))

		//Country =USA
		.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))

		//
		.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))

		//Click on Save 
		.clickSave() 


		//7. Refresh the page to unlock the Fee share eligible field 
		.pageRefresh()

		//8. Fee share eligible = Yes
		.changeFeeShareEligible()

		//Fee share eligible date = Today's date
		.selectFeeShareEligibleStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "FeeShareEligibleStartDate", sDataSheetName))

		//FBO Type = Any
		.selectFBOGPOType(DataInputProvider.getCellData_ColName(iRowNumber, "FBOType", sDataSheetName))

		//FBO effective date = Today's date
		.selectFBOEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "FBOEffectiveDate", sDataSheetName))

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
		//9.  Click the + icon on the Line of Business Grid
				.clickLineOfBusinessWithFrame0()

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

		//10. Record Status = Published
		.chooseRecordStatusPublishedWithFrame0(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 

		//11. Verify Entity code is generated 
		.entityCodeIsDisplayedWithFrame0()

		//Verify Premier start date is auto populated
		.verifyPremierStartDateIsAutoPopulated()

		.verifyAffiliateGroupIsNotNull()
		.verifyAgEffectiveDateIsNotNull()

		.verifyDirectParentIsEmpty()
		.verifyToParentIsEmpty()

		//12. Verify "IS Corporate account" field
		.verifyIsCorporateAccount(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsCorporateAccount", sDataSheetName))	
		.verifyIsCorporateAccountLocked()

		//13. Verify Corporate parent name in the form
		.verifyCorporateParentName("")

		//14. Verify "Is Food Service parent" field 
		.verifyIsFoodServiceParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsFoodServiceParent", sDataSheetName))
		.verifyIsFoodServiceParentLocked()

		//15 Verify Food Service parent name in the form 
		.VerifyFoodServiceParentName("")

		//16. Verify "Is FBO" field 
		.verifyIsFBO(DataInputProvider.getCellData_ColName(iRowNumber, "isFBO", sDataSheetName))
		.verifyIsFBOLocked()

		//17. Verify "Is Sponsor" field 
		.verifyIsSponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsSponsor", sDataSheetName))

		//18. Verify "Is Sponsor" field 
		.verifySponsor("")
		.verifySponsorLocked();

	}	
}