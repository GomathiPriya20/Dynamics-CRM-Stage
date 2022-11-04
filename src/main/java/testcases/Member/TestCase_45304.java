package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_45304:Verify if the State field in address only accept two characters or blank values, no numeric and/or special characters

public class TestCase_45304 {


	@Test
	public void verifyStateFeild(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException 
	{

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName)) 
		.clickSignIn()

		//2.Go to Workplace > Accounts and search for EIN 673415 
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPage(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))

		//3.Double click on the account and go to Sub accounts entity by clicking > on the top 
		.selectAccountFromSearchResults()
		.navigateToDoNotVerifyAddress()
		.selectDoNotVerifyAddress("Yes")
		.typeState("state")
		.clickSave() 
		.verifyPartialErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))
		.ClickOkInErrorMessage()
		
		.switchToFrame1Index()
		
		.typeState("12")
		.clickSave() 
		.verifyPartialErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage1", sDataSheetName))
		.ClickOkInErrorMessage()
		
		.switchToFrame1Index()
		.typeState("!@")
		.clickSave() 
		.verifyPartialErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage1", sDataSheetName))
		.ClickOkInErrorMessage()
		
		;
	}

}