package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//Test case 45332: Verify whether "Cater" is available in the "Participation Type" Field in Member Form and Member Entry Form.

public class TestCase_45332 {


	@Test
	public void verifyParticipationType(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1()

		//3. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

		//Click on Save 
		.clickSave() 

		//Account Status = Auto Populated to Terminated
		.selectAccountStatus1WithoutVerify("Active")	

		//Select Participation type
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))  

		//Click on Save 
		.clickSave() 
		;

		new DashboardPage()
		.clickWorkplace()
		.selectAccounts()
		.searchOnAccountsPageNew(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))
		.selectAccountFromSearchResults()

		//Account Status = Auto Populated to Terminated
		.selectAccountStatusWithoutVerify("Active")	


		//Select Participation type
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))  


		//Click on Save 
		.clickSave() 

		.clickOkInErrorMsgBKField()

		//Account Status = Auto Populated to Terminated
		.selectAccountStatusWithoutVerify("Inactive")	

		//Account Status = Auto Populated to Terminated
		.selectAccountStatusWithoutVerify("Active")	

		//Select Participation type
		.selectParticipationType("Pharmacy")  


		//Click on Save 
		.clickSave() 
		;

		//1. Login to CRM using member supervisor / member credentials 
		new DashboardPage()
		//2. Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberEntryFormWithFrame1()

		//3. Account Name = Any
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

		//Click on Save 
		.clickSave() 
		//Account Status = Auto Populated to Terminated
		.selectAccountStatus1WithoutVerify("Active")	


		//Select Participation type
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))  

		//Click on Save 
		.clickSave() 
		;



	}
}
