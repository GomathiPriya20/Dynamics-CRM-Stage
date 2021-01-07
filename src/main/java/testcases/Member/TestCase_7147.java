package testcases.Member;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7147 {
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()
		
		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
		
		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.selectSubaccount()
		
		//4. Click on Add new account 
		.clickNewAccountInSubAccount()
		.chooseMemberFormInSubAccount()
		
		//5. Verify Direct parent and Top parent are populated 
		//.verifyDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyTopParent", sDataSheetName))
		//.verifyTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyDirectParent", sDataSheetName))
				
		//6. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
		
			//Top Parent Relation =  OLM
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
		
			//Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
			 
			//type TP reason
			 .typeTPReason(DataInputProvider.getCellData_ColName(iRowNumber, "TPReason", sDataSheetName))
		 
				//Click on save 
		 		 .clickSave() 
		 
		//7 Verify CRM Account # is generated 
		 .crmNumberIsDisplayedWithFrame0()
		
		//8. Account  Type = Member
		 .selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))
			//Premier Start date = Today's Date
		 .pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
		 
				//Class of Trade =Any
		 .selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
				//Business Classification = Auto populated
			.businessClassificationIsVerified()	
			
				//Account Status = Auto Populated to Active
			.defaultAccountStatus()	
				//Store/Location type = Shipto
			.chooseLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "LocationType", sDataSheetName))	
				//CAMS Flag = Yes
			.changeCAMSFlag()
			
			//Direct Parent Relation = Managed
			.selectDirectParentRelationMEF(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 
			
				//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
			
				//DP exception reason = Any
			.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))
			 
			
			//Click on Save 
			
			//9. Type street
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
			
				 //City = NY
				.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
				
				 //Country =USA
				//Type Zip code
				.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
								
				 //Click on Save 
				// .clickSave() 
			
			//10. Record Status = Published
			.chooseRecordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
				
				//Click on Save 
				.clickSave() 
				
			//11. Verify Entity code is generated 
			.entityCodeIsDisplayedWithFrame0()
			
			//9. Verify "IS Corporate account" field
			.verifyIsCorporateAccount(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsCorporateAccount", sDataSheetName))
			
			
			//10. Verify Corporate parent name in the form
			.verifyCorporateParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyCorporateParentName", sDataSheetName))
				
			//11. Verify "Is Food Service parent" field 
			.verifyIsFoodServiceParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsFoodServiceParent", sDataSheetName))
			
			//12 Verify Food Service parent name in the form 
			.VerifyFoodServiceParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyFoodServiceParentName", sDataSheetName))
				
			//13 Verify Sponsor field 
			.verifySponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifySponsor", sDataSheetName))
				
			//14 Verify "Is Sponsor" field 
			.verifyIsSponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsSponsor", sDataSheetName))
			.verifySponsorLocked();
		
	}

}
