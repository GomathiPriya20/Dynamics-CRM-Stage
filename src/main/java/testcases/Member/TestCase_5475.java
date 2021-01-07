package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_5475 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		new LoginPage()
		.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
		.clickSignIn()
		.clickWorkplace()
		.selectAccounts()
		.clickNewOnAccountsPage()
		.chooseMemberFormwithFrame1()
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))	
		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
		.selectBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "BusinessClassification", sDataSheetName))
		.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
		.defaultAccountStatus()
		.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))
		.chooseRecordstatus(DataInputProvider.getCellData_ColName(iRowNumber, "Recordstatus", sDataSheetName))
		
		//Select default account type
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))
		
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
		
		.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
		
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
		
		.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))
		
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
		
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
	
		.selectDirectParentRelationAffiliated(	DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 
		
		.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
		
		.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))
		
		 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
		
		.selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
		
		 .typeTPReason(DataInputProvider.getCellData_ColName(iRowNumber, "TPReason", sDataSheetName))
		.clickSave()
		.crmNumberIsDisplayed()	
		.clickLineOfBusiness()
		
		.selectLineOfBusinessGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessGeneralGPO", sDataSheetName))
		
		.selectLineOfClassificationGeneralGPO(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfClassificationGeneralGPO", sDataSheetName))
		
		.selectLineOfBusinessStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "LineOfBusinessStartDate", sDataSheetName))
		.clickLineOfBusinessSave()

		.chooseRecordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))

		.clickSave() 
		.entityCodeIsDisplayedWithFrame1()
		.businessClassificationIsVerified()
		.accountTypeIsVerified()
		.recordStatusIsVerified()
		.accountStatusIsVerified();	
	}
}
