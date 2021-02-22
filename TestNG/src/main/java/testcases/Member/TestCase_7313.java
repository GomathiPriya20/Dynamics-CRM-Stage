package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_7312: Add and update Primary contact to a Member account

public class TestCase_7313 {
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM as Limited member 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2. Access Workplace> Accounts >+New
		.clickWorkplace()
			.selectAccounts()
			.clickNewOnAccountsPage()
			.chooseMemberFormwithFrame1()
			
		//3. Verify Account status field value at the top
			.defaultAccountStatusHeader()
		
		//4. Verify Account status field in the form
			.defaultAccountStatus()
		
		//5. Change the form view to Member entry form
			.chooseMemberEntryForm()
		
		//6. Verify Account status field value at the top 
			.defaultAccountStatusHeader()
			
		//7. Verify Account status field in the form
			.defaultAccountStatus()	;
		
	}
}