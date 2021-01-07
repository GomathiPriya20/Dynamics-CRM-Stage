package testcases.Member;

import java.awt.AWTException;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_1141 {
	
	
	
//	@Test()
	public static void createMemberTP(int iRowNumber, String sDataSheetName)throws Exception, InterruptedException, AWTException
	{				
			new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
			.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
			.clickSignIn()
			.clickWorkplace()
			.selectAccounts()
			.chooseActiveMemberWithFrame(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))	
			.selectBKfieldNoToYes()
			.clickSave()
			.clickSaveForError()
			.clickSaveForOk()
			.selectBKfieldNo()
			.clickSave()
			.clickSaveForOk()
			.selectBKfieldNoToYes()
			.clickSave()
			.clickClose1()			
			.chooseActiveMember1(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber1", sDataSheetName))
			.selectBKfieldNo()
			.clickSave()
			.clickClose1()
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
