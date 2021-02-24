package testcases.Contacts;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_5491 {
	
	
	@Test
	public void createMemberTP(int iRowNumber, String sDataSheetName) throws Exception, InterruptedException  {
		
		//1. Login to CRM using member supervisor / member credentials 
		new LoginPage()
			.typeUsername(DataInputProvider.getCellData_ColName(iRowNumber, "username", sDataSheetName))
	  	    .typePassword(DataInputProvider.getCellData_ColName(iRowNumber, "password", sDataSheetName))  
			.clickSignIn()
		
		//2. Go to Workplace > Contacts > +New 
		.clickWorkplace()	
		.selectContacts()
		.clickNewOnContactsPage()
		
		//Select record status
	    .chooseRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatus", sDataSheetName))  
	    
	    
//Address details
	    
		 // Street 1 = Any
		 .typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
		 
		//Add Primary contact
		.selectPrimaryAccount();
		
						
		
	}


}
