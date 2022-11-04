package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utils.DataInputProvider;
//TFS ID_43707: Cloud: Verify Top Parent Relation should be OLM for Top parent


public class TestCase_43707 {

	@Test
	public void verifyTPOLM(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {

		// Login to CRM using member supervisor / member credentials 
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
		.typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()

		// Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()

		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1() 

		// Account  Type = Member
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

		.navigateToDoNotVerifyAddress()		

		//Participation Type = Standard
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))

		// Account  Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))


		//Is Top parent = Yes
		.changeTopParent()

		//Top parent relation = Affiliate
		.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		//Top parent relation date = Today's date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

		//Region = Any
		.selectRegion(DataInputProvider.getCellData_ColName(iRowNumber, "Region", sDataSheetName))

		//Top parent classification = Any
		.selectTopParentClassification(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentClassification", sDataSheetName))

		//Click on save
		.clickSave()

		//Verify Error message and click ok
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))

		//Click OK on Error message
		.ClickOkInErrorMessage()


		//Top parent relation = OLM
		.selectTopParentRelation("OLM")



		//Click on save
		.clickSave()

		;
		new DashboardPage()
		// Go to Workplace > Accounts > +New 
		.clickWorkplace()
		.selectAccounts()

		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1() 

		// Account  Type = Member
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))

		//Is Top parent = Yes
		.changeTopParent()

		//Top parent relation = Affiliate
		.selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

		//Top parent relation date = Today's date
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))

		//Click on save
		.clickSave()

		//Verify Error message and click ok
		.verifyErrorMessage(DataInputProvider.getCellData_ColName(iRowNumber, "ErrorMessage", sDataSheetName))

		//Click OK on Error message
		.ClickOkInErrorMessage()


		//Top parent relation = OLM
		.selectTopParentRelation("OLM")



		//Click on save
		.clickSave()


		;
	}	
}