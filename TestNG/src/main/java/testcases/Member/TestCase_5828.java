package testcases.Member;

import java.awt.AWTException;

import org.junit.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_5828{
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException, AWTException {
	
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "ActiveMember1", sDataSheetName))
		.selectAccountFromSearchResults()
		.selectMembershipEntity()
		.selectPremierPremierMembership()
		.selectEndDate(DataInputProvider.getCellData_ColName(iRowNumber, "SelectEndDate", sDataSheetName))		
		.selectEndReasonChange(DataInputProvider.getCellData_ColName(iRowNumber, "EndReason", sDataSheetName))
		.clickSaveAndClose();					
	}
}
