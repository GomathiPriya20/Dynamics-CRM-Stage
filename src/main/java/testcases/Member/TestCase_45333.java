package testcases.Member;
import org.testng.annotations.Test;

import pages.LoginPage;

import utils.DataInputProvider;

//TFS ID_45333:Verify new field "NAICS Code" is added in member form 


public class TestCase_45333 {


	@Test
	public void verifyNAICSCode(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1()
		.typeAccountName("Test")
		.clickSave()
		.navigateToNAICSCode()
		.selectNAICSCode("11111")
		.verifyIndustry()
		;
		

	}
}