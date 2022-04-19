package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//Test Case 7149:Create new Shipto account for conversion scenario - New Member form and Save it as member first

public class TestCase_7149 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
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
		//	.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
			
			//Class of Trade =Any
			.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
			
			//Business Classification = Auto populated
			.businessClassificationIsVerified()	
			
			//Account Status = Auto Populated to Active
			.defaultAccountStatus()	
			
			//Store/Location type = Shipto
			.chooseLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "LocationType", sDataSheetName))
			
			//Direct Parent Entity Code = 673415
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
			
			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 
			
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName)) 
			
			//Top Parent Relation =  OLM
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
			 
			//Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
		
			//Click on save 			
			.clickSave() 
		
		//5. Record Status = Published
		.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
			
			//Click on Save 
			.clickSave() 
	
		
		//6.Verify Entity code is same as DP's entity code  
		.verifyEntityCode(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
		
		.selectMembershipEntity()
		.doubleClickOnNationalMembership()
		.clickMembershipSaveAndClose()
		
		
		//Verify Premier start date is auto populated
		.verifyPremierStartDateIsAutoPopulated()
		
		.verifyAgEffectiveDateIsNull()
		.verifyAffiliateGroupIsNull()
		
		//7. Verify "IS Corporate account" field
		.verifyIsCorporateAccount(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsCorporateAccount", sDataSheetName))
		
		
		//8. Verify Corporate parent name in the form
		.verifyCorporateParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyCorporateParentName", sDataSheetName))
		
		//9. Verify "Is Food Service parent" field 
		.verifyIsFoodServiceParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsFoodServiceParent", sDataSheetName))
		
		//10 Verify Food Service parent name in the form 
		.VerifyFoodServiceParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyFoodServiceParentName", sDataSheetName))
		
		//11 Verify Sponsor field 
		.verifySponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifySponsor", sDataSheetName))
		
		//12 Verify "Is Sponsor" field 
		.verifyIsSponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsSponsor", sDataSheetName));
	
	}
}
