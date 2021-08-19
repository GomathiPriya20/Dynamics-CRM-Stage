package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS_ID_ 7485:Verify on "Update" following fields in Limited Member ,"Record status" should get changed to Need Approval.

public class TestCase_7485 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM as Limited member 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2. Go to Workplace >> Take Any Member Account 
		.clickWorkplace()
		.selectAccounts()		
		.chooseActiveMember(DataInputProvider.getCellData_ColName(Driver.iTestCaseRowNumDriver-1, "CRMNumber",Driver.properties.getProperty("DriverSheetName")))     		

		//3.Verify following Fields are editable in Opened Member Account 
			//Account Name
			.verifyAccountNameIsEnabled()
		
			//Account Name 2
			.verifyAccountName2IsEnabled()
			
			//Class of Trade
			.verifyClassOfTradeIsEnabled()
			
			//Street 1
			.verifyStreet1IsEnabled()
			
			//Street 2
			.verifyStreet2IsEnabled()
			
			//Delivery Info
			.verifyDeliveryInfoIsEnabled()
			
			//City
			.verifyCityIsEnabled()
			
			//State/Province
			.verifyStateIsEnabled()
			
			//County
			.verifyCountyIsEnabled()
			
			//Country
			.verifyCountryIsEnabled()
			
			//Zip/Postal Code
			.verifyZipIsEnabled()
			
			//Main Phone Number
			.verifyMainPhoneIsEnabled()
			
			//Referred By
			.verifyReferredByIsEnabled()
			
			
		//4.On Update/change the following fields in Member Account :                                                                                                   

			//Account Name
			.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
			
			//Account Name 2
			.typeAccountName2(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName2", sDataSheetName))

			//Class of Trade
		//	.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
			
			//Street 1
			.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
			
			//Street 2
			.typeStreet2(DataInputProvider.getCellData_ColName(iRowNumber, "Street2", sDataSheetName))

			//Delivery Info
			.typeDeliveryInfo(DataInputProvider.getCellData_ColName(iRowNumber, "DeliveryInfo", sDataSheetName))

			//City
			.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))

			//State/Province
			.typeState(DataInputProvider.getCellData_ColName(iRowNumber, "State", sDataSheetName))
			
			//County
			.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))
			
			//Country
			.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
			
			//Zip/Postal Code
			.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
			
			//Main Phone Number
			//.typeMainPhone(DataInputProvider.getCellData_ColName(iRowNumber, "MainPhone", sDataSheetName))	

			
		//5. Click  on Save after updating the following fields. 
		.clickSave() 
			
		//6.Verify and Observe the Record status field after updating following fields. 
		.verifyRecordChangeStatus(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyRecordChangeStatus", sDataSheetName))
		
		;
	
	}
}
