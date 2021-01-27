package testcases.Member;

import java.awt.AWTException;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_5476 {
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException, AWTException {
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()
		
		//Access Workplace> Accounts > Select  Active Members View>
		.clickWorkplace()
		.selectAccounts()	
		
		//Double Click on any record that has Entity code
		.chooseActiveMember(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))   
		
	
		.captureStatusDisplayedModify(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))		
		.typeAccountModify(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
		.clickSave();	
	}

}
