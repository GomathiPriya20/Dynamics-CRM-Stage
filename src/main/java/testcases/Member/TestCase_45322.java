package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_45322: Verify TP exception reason should not be mandatory when creating new member with DP is same as TP

public class TestCase_45322 {

	@Test
	public void verifyTPExceptioReason(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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

		//4. Street 1 = Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))

		//City = NY
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))

		//Country =USA
		.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))

		//
		.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))

		//Click on Save 
		// .clickSave()  

		//3. Account  Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

		//Account name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

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


		//Is Top parent = Yes
		.changeTopParent()

		//Top Parent Relation Date = Today's Date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

		//Participation Type = Standard
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))

		//Direct Parent Relation = Owned(Auto populated)
		.verifyDirectParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName))

		//Region = Any
		.selectRegion(DataInputProvider.getCellData_ColName(iRowNumber, "Region", sDataSheetName))

		//Top parent classification = Any
		.selectTopParentClassification(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentClassification", sDataSheetName))

		//Top Parent Relation =  OLM
		.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		//Require Manual AG =Yes
		.changeRequireManualAG()

		//Select affiliate group =Affiliate NonAcute
		.selectAffiliateGroup(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroup", sDataSheetName))

		//Enter affiliate group effective date = today's date
		.selectAffiliateGroupEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroupEffectiveDate", sDataSheetName))

		//Click on Save
		.clickSave() 


		//5. Fee share eligible = Yes
		.changeFeeShareEligible1()

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
		.clickAddNewPremierMembershipWithFrame1()

		// Choose Membership type 
		.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
		.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider", sDataSheetName))

		//Provide any start date and click on save
		.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate", sDataSheetName))
		.clickAddNewMembershipProviderSave()
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		//6.  Click the + icon on the Line of Business Grid
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
		//7. Record Status = Published
		.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 

		//8. Verify Entity code is generated 
		.entityCodeIsDisplayedWithFrame1()
		.selectSubaccount()

		//4. Click on Add new account 
		.clickNewAccountInSubAccount()
		.switchToSubAccount()

		//Select member form
		.chooseMemberFormInSubAccount()

		//6. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))


		//Direct Parent Relation = Managed
		.selectDirectParentRelationMEF(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 

		//Direct Parent Relation date = Today's Date
		.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))

		//6.	//Top Parent Relation =  OLM
		.selectTopParentRelation0(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		//Top Parent Relation Date = Today's Date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

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
		// .clickSave() 

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
		.navigateToRecordStatus0()
		.changeRequireManualAG()
		.selectAffiliateGroup(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroup", sDataSheetName))
		.selectAffiliateGroupEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroupEffectiveDate", sDataSheetName))
		
		//11 Record Status = Published
		.chooseRecordStatusPublishedWithFrame0(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		//Click on Save 
		.clickSave() 

		//12 Verify Entity code is generated 
		.entityCodeIsDisplayedWithFrame0()

		;
	}
}
