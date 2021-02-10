package testcases.Member;

import java.awt.AWTException;
import pages.LoginPage;
import utils.DataInputProvider;
public class TestCase_1141 {
	
//	Test Case 1141:Automation : Validate Business Key and BK Active fields.
	
	public static void createMemberTP(int iRowNumber, String sDataSheetName)throws Exception, InterruptedException, AWTException
	{		
		//1. Find or create a Member Account that is a Direct Parent of another Member or Non-GPO Account.  
			//DP's BK Active = No
			//Child's BK Active = No
			new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
			.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
			.clickSignIn()
			.clickWorkplace()		
			.selectAccounts()
			.chooseActiveMember(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))	
			
			
		//2.Set the Child Member Account's BK Active field to Yes and click the Save Button.
			.selectBKfieldNoToYes()
			.clickSave()
			.verifyErrorMsgBKField()
			.clickOkInErrorMsgBKField()
			.selectBKfieldNo()
			.clickSave()
			.clickOkInErrorMsgBKField()
		//3.Set the Direct Parent (DP) Member Account's BK Active field to Yes and click the Save Button..
	//		.selectBKfieldNoToYes()
			.clickSave()
			.clickClose1()	
			
		//4. Set the Child Member Account's BK Active field to Yes and click the Save Button.	
			.chooseActiveMember1(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))
			.selectBKfieldNo()
			.clickSave()
			.clickClose1()
			
		//7. Create a new Member Account and set BK Active to Yes.
			.clickNewOnAccountsPage1()
			.chooseMemberForm()
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))		
			.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
			.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "BusinessClassification", sDataSheetName))
			.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
			.defaultAccountStatus()
			.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))
			.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))		
			.selectBKfieldNoToYes()
			.clickSave()
			.selectBKfieldNoToYes()
			.clickSave()
			.selectBKfieldNoToYes()
			.clickSave()
			.businessKeyIsVerified();
	}

}
