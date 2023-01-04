package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//Test case 45334:Verify whether "Provider Select: MD" Field is available in Member and Member Entry Forms. 

public class TestCase_45334 {


	@Test
	public void verifyTerminatedStatus(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

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
				.navigateToExcludeFromRoster()
				.verifyProviderSelect()
				.selectProviderSelect("Provider Select: MD")
				.clickSave()
				;
				
				new DashboardPage()
				.clickWorkplace()
				.selectAccounts()
				.clickNewOnAccountsPage()
				.chooseMemberEntryFormWithFrame1()
				.typeAccountName("Test")
				.clickSave()
				.navigateToExcludeFromRoster()
				.verifyProviderSelect()
				.selectProviderSelect("Provider Select: MD")
				.clickSave()
				;
				
				new DashboardPage()
				.clickWorkplace()
				.selectAccounts()
				.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))
				.selectAccountFromSearchResults()
				.navigateToExcludeFromRoster0()
				.verifyProviderSelect()
				.selectProviderSelect("Provider Select: MD Grandfathered")
				.clickSave()
				
				;

	}
}
