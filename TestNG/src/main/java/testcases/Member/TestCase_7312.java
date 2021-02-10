package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_7312: Add and update Primary contact to a Member account

public class TestCase_7312 {
	
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
		
		
		//3. Fill in the mandatory fields below
			//Account Name =Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
			
			//Account  Type = Member
			.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))
			
			//Premier Start date = Today's Date
			.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
			
			//Primary contact = 7000331193
			.AddMemberPrimaryContact(DataInputProvider.getCellData_ColName(iRowNumber, "PrimaryContact", sDataSheetName))
			
			
			//Participation Type = Standard
			.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))
			
			//Business Classification =Any
			.businessClassificationIsVerified()	
			
			//Class of Trade =Any
			.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
			
			//Account Status = Auto Populated to Active
			.defaultAccountStatus()	
			
			//Application Start Date = Today's Date
			.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))
			
			//Direct Parent Entity Code = 831908
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
			
			//Direct Parent Relation = Any
			.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 
			
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
			
			//DP Exception Reason =Any
			.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))
			
			//Top Parent Relation =  Affiliate
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
			 
			//Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
			 
			//Record Status = Draft
			 .chooseRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "Recordstatus", sDataSheetName))
			 
			//Click on Save
			 //.clickSave() 
			 
			 // Street 1 = Any
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
			
			 //City = NY
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
			
			 //Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
			
			//
			.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))
			
			//Type Zip code
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))

			//Click on Save
			.clickSave() 
		
		//4.  Click the + icon on the Line of Business Grid
		.clickLineOfBusinessWithFrame1()
			
			// Line of Business =General GPO
			.selectLineOfBusinessGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO", sDataSheetName))
			
			// Classification Type = General GPO
			.selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO", sDataSheetName))
			
			// Start Date =Today's date
			.selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate", sDataSheetName))
			
			// Click on LOB Save 
			.clickLineOfBusinessSave()
		
			//Record Status = Published
			.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
				
			//Click on Save 
			.clickSave() 
			
		//5. Verify the Primary contact name displayed in the field
		.VerifyPrimaryContactValue(DataInputProvider.getCellData_ColName(iRowNumber, "PrimaryContactName", sDataSheetName))
			
			
		//6. Click on the primary contact lookup and click on lookup for more records
		//7. Search the Contact ID - 7000133221 and click on Add
		.AddMemberPrimaryContactFromLookUp(DataInputProvider.getCellData_ColName(iRowNumber, "PrimaryContactLookUp", sDataSheetName))
		
		
		//8. Verify the newly updated Primary contact name is displayed in the form
		.VerifyPrimaryContactValue(DataInputProvider.getCellData_ColName(iRowNumber, "PrimaryContactNameLookUp", sDataSheetName));
	}
}
