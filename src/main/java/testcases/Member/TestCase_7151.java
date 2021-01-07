package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;

//Test Case 7151:Create new Bill to account - New Member form and Save it as prospect first

public class TestCase_7151 {

	  	
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
			
			//Store/Location type = Mail to
			.chooseLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "LocationType", sDataSheetName))	
					
			//CAMS Flag = Yes
			.changeCAMSFlag()
			
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
				
				 //Click on Save 
				// .clickSave() 
				
			//7. Record Status = Published
			.chooseRecordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
				
				//Click on Save 
				.clickSave() 
				
			//8. Verify Entity code is generated 
			.entityCodeIsDisplayedWithFrame1()
				
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
			
			//15  Go to > and click on Membership entity and double click on the Top parent membership entity
			.selectMembershipEntity()
			.doubleClickOnTopParentInMembershipLocationType()
			.verifytopParentMembershipEntity(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyTopParent", sDataSheetName));

	}
}