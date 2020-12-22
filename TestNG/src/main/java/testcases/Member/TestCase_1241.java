package testcases.Member;


import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_1241 {


	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception,InterruptedException  {
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberForm()
		
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
		
		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
		.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "BusinessClassification", sDataSheetName))
		.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
		
		.defaultAccountStatus()
		
		.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))
		.chooseRoasterType()
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))
		
		.chooseRecordstatus(DataInputProvider.getCellData_ColName(iRowNumber, "Recordstatus", sDataSheetName))
		
		.defaultAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
		
		.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
		
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
		
		.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))
		
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
		
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
		
		.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 
		
		.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
		
		.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))
		
		 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
		 
		.selectTopParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
		
		.typeTPReason(DataInputProvider.getCellData_ColName(iRowNumber, "TPReason", sDataSheetName))
	
		.clickSave()
		.crmNumberIsDisplayed()	
		
		.chooseRecordStatusWithoutPublished(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished1", sDataSheetName));
	
	}

}
