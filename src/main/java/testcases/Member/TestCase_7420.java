package testcases.Member;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver.Driver;
import pages.LoginPage;
import pages.MemberFormPage;
import utils.DataInputProvider;
//TFS ID_ 7423:Create New Membership Provider with type "SOAR"

public class TestCase_7420 {

	  	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
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
		
		//3. Verify Membership provider field is defaulted to No 
			.defaultMembershipProvider()
		
		//4. Provide Account name = Any
			.typeMPAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
			
			//Change the Account type to Membership provider
			.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Plug in issue~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~			
			//save the record
			//.clickSave() 
			
			//Verify CRM Account # is generated 
			//.crmNumberIsDisplayedWithFrame1()	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
		//5. Verify Membership provider field automatically turned to Yes
			.verifyMembershipProviderYes()
		
		//6. Verify Membership provider type has below options 
			//Program, DSH, Aggregation Affiliation, Affiliate Group, SOAR, N/A 
			.verifyMembershipProviderTypeOptions(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderTypeOptions", sDataSheetName))
			
		//7. Choose Aggregation Affiliation and save the record
			.selectMembershipProviderType(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
			
			//save the record
			.clickSave() 
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
			//Verify CRM Account # is generated 
			.crmNumberIsDisplayedWithFrame1()	
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//8. Go to the Accounts and search for CRM# 1000155584
			.selectAccountss()
			.chooseActiveMember1(DataInputProvider.getCellData_ColName(iRowNumber, "CrmNumber", sDataSheetName))	
			
		//9. Go to Membership entity and click on Add new membership
			.selectMembershipEntity()
			.clickAddNewMembershipProvider()
			
		//10 Choose Membership type as "Aggregation Affiliation" and search for the CRM# we captured in Step#4 
			.selectMembershipProviderTypeInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderType", sDataSheetName))
			.typeCRMNumberInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(Driver.iTestCaseRowNumDriver, "CRMNumber",Driver.properties.getProperty("DriverSheetName")))
			
		//11. Provide any start date and click on save
			.selectMembershipProviderStartDateInAddNewMembershipProvider(DataInputProvider.getCellData_ColName(iRowNumber, "MembershipProviderStartDate", sDataSheetName))
		//	.clickAddNewMembershipProviderSave()
			
			;
	
	}
}
