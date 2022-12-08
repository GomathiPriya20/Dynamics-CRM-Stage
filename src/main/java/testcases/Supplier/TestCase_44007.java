package testcases.Supplier;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utils.DataInputProvider;

//TFS ID_44007:Test Case 8772 : Verify if member/member supervisor/Supplier/Supplier supervisor/Limited member can edit the primary account of a contact


public class TestCase_44007 {


	@Test()

	public void updatePrimaryAccount(int iRowNumber, String sDataSheetName) throws Exception {
		//Access Login Page
		new LoginPage()	

		//Type the Username
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))

		//Type the password
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))

		//Click on SignIn button
		.clickSignIn()

		//Click on Workplace tab
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount", sDataSheetName))
		.clickSave()

		.verifyPrimaryAccount(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccountName", sDataSheetName))
;
		
		new DashboardPage()
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact1(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount1", sDataSheetName))
		.clickSave()
		.signOut()
		.pageRefresh()
		;

		new LoginPage()	
		.getPage()
		//Type the Username
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username2", sDataSheetName))

		//Type the password
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))

		//Click on SignIn button
		.clickSignIn()

		//Click on Workplace tab
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact1(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount", sDataSheetName))
		.clickSave()

		.verifyPrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccountName", sDataSheetName))
;
		
		new DashboardPage()
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact1(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount1", sDataSheetName))
		.clickSave()
		.signOut()
		.pageRefresh()
		;
		
		new LoginPage()	
		.getPage()
		//Type the Username
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username3", sDataSheetName))

		//Type the password
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))

		//Click on SignIn button
		.clickSignIn()

		//Click on Workplace tab
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact1(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount", sDataSheetName))
		.clickSave()

		.verifyPrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccountName", sDataSheetName))
;
		
		new DashboardPage()
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact1(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount1", sDataSheetName))
		.clickSave()
		.signOut()
		.pageRefresh()
		;
		
		new LoginPage()	
		.getPage()
		//Type the Username
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username4", sDataSheetName))

		//Type the password
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))

		//Click on SignIn button
		.clickSignIn()

		//Click on Workplace tab
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact1(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount", sDataSheetName))
		.clickSave()

		.verifyPrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccountName", sDataSheetName))
;
		
		new DashboardPage()
		.clickWorkplace()

		.selectContacts()

		//2. Go to any active contact which has an active contact account association
		.chooseActiveContact1(DataInputProvider.getCellData_ColName(iRowNumber, "activeContact", sDataSheetName))

		.updatePrimaryAccount0(DataInputProvider.getCellData_ColName(iRowNumber, "primaryAccount1", sDataSheetName))
		.clickSave()
		.signOut()
		.pageRefresh()
		;
	}


}