package testcases.Member;

import java.awt.AWTException;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_1148  {
	
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException, AWTException
	{
			new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))		
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
			.clickSignIn()
			.clickWorkplace()
			.selectAccounts()
			.chooseActiveMember(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))
			.address1IsDisplayed();	
	}
	
	
}
