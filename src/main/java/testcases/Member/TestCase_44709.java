package testcases.Member;
import org.testng.annotations.Test;

import pages.LoginPage;

import utils.DataInputProvider;

//TFS ID_44709:Validate Publish Rec Status and LOB


public class TestCase_44709 {


	@Test
	public void ValidateLOB(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
				new LoginPage()
				.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
				.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
				.clickSignIn()

				//2. Go to Workplace > Accounts > +New 
				.clickWorkplace()
				.selectAccounts()
				.clickNewOnAccountsPage()
				.chooseMemberFormwithFrame1()

				//3. Account Name = Any
				.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

				//Click on save 			
				.clickSave() 

				//4. Verify CRM Account # is generated 
				.crmNumberIsDisplayedWithFrame1()	

				//5. Account Type = Member
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

				//Direct Parent Entity Code = 673415
				.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))

				//Direct Parent Relation = Managed
				.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 

				//Direct Parent Relation date = Today's Date
				.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))

				//Top Parent Relation =  OLM
				.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

				// Top Parent Relation Date = Today's Date
				.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

				//Click on Save 
				// .clickSave() 

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
				//8. Record Status = Published

				.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

				//Click on Save 
				.clickSave() 
				
				.verifyPartialErrorMessage("LOB is required for the below Premier Membership Provider National")

				.ClickOkInErrorMessage()
				
				//8. Record Status = Draft

				.chooseRecordStatusPublishedWithFrame1("Draft")

				//Click on Save 
				.clickSave() 
				
				//Click the + icon on the Line of Business Grid
				.clickLineOfBusinessWithFrame1()

				//On the Pop up window fill in the required fields
				//Line of Business =Acurity
				.selectLineOfBusiness(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO", sDataSheetName))

				//Classification Type = Acurity
				.selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO", sDataSheetName))

				//Start Date =Today's date
				.selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate", sDataSheetName))

				//Click on Save 
				.clickLineOfBusinessSave()
				
				//Click on Save 
				.clickSave()
				
				
				.clickAddNewPremierMembershipWithFrame1()

				// Choose Membership type
				.selectMembershipProviderType1(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
				.typeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProvider1", sDataSheetName))

				//Provide any start date and click on save
				.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate1", sDataSheetName))
				.clickAddNewMembershipProviderSave()	

				
				//Click the + icon on the Line of Business Grid
				.clickLineOfBusinessWithFrame1()

				//On the Pop up window fill in the required fields
				//Line of Business =Acurity
				.selectLineOfBusiness(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO1", sDataSheetName))

				//Classification Type = Acurity
				.selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO1", sDataSheetName))

				//Start Date =Today's date
				.selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate1", sDataSheetName))

				//Click on Save 
				.clickLineOfBusinessSave()
				
				//Click on Save 
				.clickSave()
				//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				//8. Record Status = Published
				.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

				//Click on Save 
				.clickSave() 
				
				//9. Verify Entity code is generated 
				.entityCodeIsDisplayedWithFrame1()
				
				.navigateToLoBEntity()
				.selectLob(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO1", sDataSheetName))
				.enterLOBEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndDate", sDataSheetName))
				//Click on Save 
				.clickLOBSave()
				.verifyPartialErrorMessage("Can't end date the LOB from published account")
				.ClickOkInErrorMessage()
				.clearLOBEndDate()
				.deactivateLOB()
				.clickConfirmDeactivate()
				.verifyPartialErrorMessage("Can't deactivate the LOB from published account")
				.ClickOkInErrorMessage()
				.navigateToGeneralTabFromLOB()
				.navigateToRecordStatus()
				//8. Record Status = Draft

				.chooseRecordStatusPublishedWithFrame1("Draft")

				//Click on Save 
				.clickSave() 
				
				.navigateToLoBEntity()
				.selectLob(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO1", sDataSheetName))
				.enterLOBEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipEndDate", sDataSheetName))
				//Click on Save 
				.clickLOBSave()
				.navigateToGeneralTabFromLOB()
				.navigateToLoBEntity()
				.selectLob(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO", sDataSheetName))
				.deactivateLOB()
				.clickConfirmDeactivate()
				.navigateToGeneralTabFromLOB()
				.navigateToRecordStatus()
				//8. Record Status = Draft

				.chooseRecordStatusPublishedWithFrame1("Published")

				//Click on Save 
				.clickSave() 
				
				.verifyPartialErrorMessage("LOB is required for the below Premier Membership Provider")

				.ClickOkInErrorMessage()
				
				
		;

		
	}
}