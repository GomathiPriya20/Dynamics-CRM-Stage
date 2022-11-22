package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_44856:Verify whether On Changing Back and Forth "Is Top Parent", Corporate Parent Relation Date Should Not Be Changed

public class TestCase_44856 {


	@Test
	public void verifyCPRD(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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
		.navigateToisTopParent()
		.verifyIsTopParent("Yes")
		.VerifyCorpParenttartDate(DataInputProvider.getCellData_ColName(iRowNumber, "verifyFBORD", sDataSheetName))
		.changeTopParent()
		.SelectTopParent("No")
		.sendEscapeKey()
		.VerifyCorpParenttartDate(DataInputProvider.getCellData_ColName(iRowNumber, "verifyFBORD", sDataSheetName))
		
		;
	}
}
