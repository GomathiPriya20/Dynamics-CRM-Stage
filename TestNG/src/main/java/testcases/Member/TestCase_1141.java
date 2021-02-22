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
			.selectBKfieldNo()
			
		//4.Go to Accounts and search for any account with BK Active No and its DP has BK active Ex. 2000424828
			.selectAccountss()
			.chooseActiveMember1(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))				
			
			
		//5. Now change the BK Active from No to Yes and save
			.selectBKfieldNoToYes()
			
		//6.Go to Accounts and search for any account with BK Active is No and its DP has BK Active is No, ex. 2000444770
			
		//7.Now change the BK Active to Yes and Save
			
		
		//8. Go to Accounts and search for any account with BK Active is Yes and it has child accounts with BK active as Yes ex.2000103171
			
		//9. Now change the BK Active to NO and save
			
			
			
	/*		
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
			.businessKeyIsVerified()
			*/
			;
	}

}
