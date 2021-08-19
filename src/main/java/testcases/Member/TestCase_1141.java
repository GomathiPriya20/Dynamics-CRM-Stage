package testcases.Member;

import java.awt.AWTException;
import pages.LoginPage;
import utils.DataInputProvider;
public class TestCase_1141 {
	
//	Test Case 1141:Automation : Validate Business Key and BK Active fields.
	
	public static void createMemberTP(int iRowNumber, String sDataSheetName)throws Exception, InterruptedException, AWTException
	{		
		//1. Login to CRM as member supervisor
			new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
			.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
			.clickSignIn()
			
		//2.Go to Account and search for any account with BK Active as Yes and does not any child account ex. 1000194141
			.clickWorkplace()		
			.selectAccounts()
			.chooseActiveMember(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))	
			
		//3.Now change the BK active from Yes to No and save
			.selectBKfield()
			
			//Click on save
			.clickSave()
			
		//4.Go to Accounts and search for any account with BK Active No and its DP has BK active Ex. 2000424828
			.selectAccountss()
			.chooseActiveMember1(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))				
			
			
		//5. Now change the BK Active from No to Yes and save
			.selectBKfield()
			
			//Click on save
			.clickSave()
			
			//Data reset
				.selectBKfield()
			
				//Click on save
				.clickSave()
			
		//6.Go to Accounts and search for any account with BK Active is No and its DP has BK Active is No, ex. 2000444770
			.selectAccountss()
			.chooseActiveMember1(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber2", sDataSheetName))				
			
		//7.Now change the BK Active to Yes and Save
			.selectBKfield()
			
			//Click on save
			.clickSave()
			
			//Verify error message
			.verifyErrorMsgBKField(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
			
			//Click on ok 
			.clickOkInErrorMsgBKField()
			
			//data reset
			.selectBKfield()
			
		//8. Go to Accounts and search for any account with BK Active is Yes and it has child accounts with BK active as Yes ex.2000103171
			.selectAccountss()
			.chooseActiveMember1(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber3", sDataSheetName))	
			
		//9. Now change the BK Active to NO and save
			.selectBKfield()
			
			//Click on save
			.clickSave()
			
			//Verify error message
			.verifyErrorMsgBKField(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage1", sDataSheetName))
			
			//Click on ok 
			.clickOkInErrorMsgBKField()
			
			//data reset
			.selectBKfield()
		
			;
	}
}
