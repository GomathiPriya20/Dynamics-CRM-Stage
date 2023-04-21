package testcases.Member;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataInputProvider;
//TFS ID_ 7491:Create New Business Partner account using member supervisor

public class TestCase_7491 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2. Go to Account and click on +New button 
		.clickWorkplace()
			.selectAccounts()
			.clickNewOnAccountsPage()
			.chooseMemberFormwithFrame1()
		//3 
			//Street 1= Any
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
				
			 //City = Any
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
					
			//Country =USA
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
					
			//
			.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))
			
			//Enter Account name = Any
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
			
			//Account type = Business partner
			.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))

			//Direct Parent = 1000039759
			.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
			
			//TP relation - Affiliated
			 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))

			//DPRD = Current date
			 .selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
				
			//TPRD =  Current date
			 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
			
			 //then save the form
			.clickSave() 
			
			//Verify CRM numbers is generated
			.crmNumberIsDisplayedWithFrame1()	
			
		//4. Verify Form layout is changed from Member to Supplier 
			.verifySupplierFormIsDisplayed()
			
		//5.Change the record status from Draft to Publish and save 
			.chooseRecordStatusPublished(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
			.clickSave() 			
			
		//6. Capture the CRM# and Entity code
			.crmNumberIsDisplayedWithFrame1()	
			.entityCodeIsDisplayed()
			;
	}
}
