package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_7139 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		//1 Login to CRM using member supervisor / member credentials 
			new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn();
		
		//2 Go to Workplace > Accounts and search for EIN 673415
		
		//3 Double click on the account and go to Sub accounts entity by clicking > on the top 
		
		//4 Click on Add new account 
		//5 Verify Direct parent and Top parent are populated 
		//6 Account Name = Any
			//Top Parent Relation =  OLM
			//Top Parent Relation Date = Today's Date
			//Click on save 
		//7 Verify CRM Account # is generated 
		//8 Account  Type = Member
			//Premier Start date = Today's Date
			//Class of Trade =Any
			//Business Classification = Auto populated
			//Account Status = Auto Populated to Active
			//Application Start Date = Today's Date
			//CAMS Flag = Yes
			//Participation Type = Standard
			//Direct Parent Relation = Managed
			//Direct Parent Relation date = Today's Date
			//DP exception reason = Any
			//Click on Save
		//9	Street 1 = Any
			//City = NY
			//Country =USA
			//Click on Save 
		//10 Click the + icon on the Line of Business Grid
			//On the Pop up window fill in the required fields
			//Line of Business =General GPO
			//Classification Type = General GPO
			//Start Date =Today's date
			//Click on Save 
		//11 Record Status = Published
			//Click on Save 
		//12 Verify Entity code is generated 
		//13 Verify "IS Corporate parent" field
		//14 Verify Corporate parent name in the form 
		//15 Verify "Is Food Service parent" field 
		//16 Verify Food Service parent name in the form 
		//17 Verify "Is Sponsor" field 
		//18 Verify Sponsor field 
		//19 Go to > and click on Membership entity and double click on the Top parent membership entity
		//20 Click on > and go to Audit history
		//21 Verify "Is Member Add mail sent" flag turned from No to Yes 
		//22 Verify the timestamp on which the flag gets updated 
	
	}
	
}
