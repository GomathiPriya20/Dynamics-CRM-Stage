package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7140 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{
		
		//1 Login to CRM using member supervisor / member credentials 
			new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		//2 Go to Workplace > Accounts > +New
			.clickWorkplace()
			.selectAccounts()
			.clickNewOnAccountsPage()
			.chooseMemberForm()
			
		//3. Account Name = Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
			
			//Click on save 
			.clickSave() 
			
		//4 Verify CRM Account # is generated 
			.crmNumberIsDisplayed()	
			
		// 5 Account  Type = Member
			.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))
			
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
			
			//Participation Type = Standard
			.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))
			
			//Direct Parent Entity Code = 673415
			//Entity code instead of name
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
			
			//Direct Parent Relation = Managed
			.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName))
			
			//Direct Parent Relation date = Today's Date
			.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
			
			//Top Parent Relation =  OLM
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
			 
			//Top Parent Relation Date = Today's Date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
			 
			//Click on Save 
			 .clickSave() 
			 
		//6 Street 1 = Any
			 .typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
			 
			//City = NY
			 .typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
			 
			//Country =USA
			 .typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
			 
			//Click on Save
			 .clickSave() 
			 
		//7Click the + icon on the Line of Business Grid
			 .clickLineOfBusiness()
			 
			//Line of Business =General GPO
			 .selectLineOfBusinessGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO", sDataSheetName))
			 
			//Classification Type = General GPO
			 .selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO", sDataSheetName))
			 
			//Start Date =Today's date
			 .selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate", sDataSheetName))
			 
			//Click on Save 
			 .clickLineOfBusinessSave()
			 
		//8 Record Status = Published
			 .chooseRecordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
			 
			//Click on Save 
			 .clickSave() 
			 
		//9 Verify Entity code is generated 
		//10 Verify "IS Corporate parent" field
		//11 Verify Corporate parent name in the form 
		//12 Verify "Is Food Service parent" field 
		//13 Verify Food Service parent name in the form 
		//14 Verify "Is Sponsor" field 
		//15 Verify Sponsor field 
		//16 Go to > and click on Membership entity and double click on the Top parent membership entity
		//17 Click on > and go to Audit history 
		//18 Verify "Is Member Add mail sent" flag turned from No to Yes 
		//19 Verify the timestamp on which the flag gets updated 
	
	}
}
