package testcases.Member;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataInputProvider;

public class TestCase_1111 {
	
	
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
		
			
		//3. Account Name
		.typeAccountName(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName", sDataSheetName))
		
		//4. Account Name 2
		.typeAccountName2(DataInputProvider.getCellData_ColName(iRowNumber, "AccountName2", sDataSheetName))
		
		//5. Premier Start Date
		.pickPremierStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "PremierStartDate", sDataSheetName))
		
		//6. Primary Contact
		.AddMemberPrimaryContact(DataInputProvider.getCellData_ColName(iRowNumber, "PrimaryContactName", sDataSheetName))
		
		//7.Class of Trade =Any
		.selectClassOfTrade(DataInputProvider.getCellData_ColName(iRowNumber, "ClassOfTrade", sDataSheetName))
		
		
		//12. Application Start Date = Today's Date
		.chooseApplicationDate(DataInputProvider.getCellData_ColName(iRowNumber, "ApplicationDate", sDataSheetName))
				
		// Group - Auto populates
		.verifyGroup(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyGroup", sDataSheetName))
		
		//8. FacilityType
		.verifyFacilityType(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyFacilityType", sDataSheetName))
		
		//9.Business Classification =Any
		.verifyBusinessClassification(DataInputProvider.getCellData_ColName(iRowNumber, "BusinessClassification", sDataSheetName))	
		
		//10. Premier Owner
		.verifyPremierOwner(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyPremierOwner", sDataSheetName))
		
		//11. Account Status = Auto Populated to Active
		.verifyAccountStatus(DataInputProvider.getCellData_ColName(iRowNumber, "AcountStatus", sDataSheetName))	
		
		//13. CAMS flag
		.verifyCAMSFlag(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyCAMSFlag", sDataSheetName))
		
		//14.Exclude From Roaster
		.verifyExcludeFromRoaster(DataInputProvider.getCellData_ColName(iRowNumber, "ExcludeFromRoaster", sDataSheetName))
		
		//15. Participation Type = Standard
		.selectParticipationType(DataInputProvider.getCellData_ColName(iRowNumber, "ParticipationType", sDataSheetName))
		
		
		//16. BK Active
		.verifyBKActive(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyBKActive", sDataSheetName))
		
		//17. SupplierRecord
		.AddSupplierRecord(DataInputProvider.getCellData_ColName(iRowNumber, "SupplierRecord", sDataSheetName))
		
		
		//18. Ownership
		.selectOwnership(DataInputProvider.getCellData_ColName(iRowNumber, "Ownership", sDataSheetName))
		
		//Stock symbol
		.typeStockSymbol(DataInputProvider.getCellData_ColName(iRowNumber, "Stocksymbol", sDataSheetName))
		
		//Exchange 
		.typeExchange(DataInputProvider.getCellData_ColName(iRowNumber, "Exchange", sDataSheetName))
		
		//IsPaymentEntity
		.changeIsPaymentEntity()
		.verifyIsPaymentEntity(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsPaymentEntity", sDataSheetName))
		
		//PaymentEntity
		.addPaymentEntity(DataInputProvider.getCellData_ColName(iRowNumber, "PaymentEntity", sDataSheetName))
			
		//CorporateRebate
		.selectCorporateRebate(DataInputProvider.getCellData_ColName(iRowNumber, "CorporateRebate", sDataSheetName))	
		
		//CorporateRebateStartDate
		.selectCorporateRebateFeeDate(DataInputProvider.getCellData_ColName(iRowNumber, "CorporateRebateFeeDate", sDataSheetName))
		
		/*//19. Require Manual AG =Yes
		.changeRequireManualAG()
		
		 //20. Select affiliate group =Affiliate NonAcute
		 .selectAffiliateGroup(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroup", sDataSheetName))
		 
		 //21. Enter affiliate group effective date = today's date
		 .selectAffiliateGroupEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "AffiliateGroupEffectiveDate", sDataSheetName))
		 */
				
		//22. Record Status = Published
	//	.chooseRecordStatusPublishedWithFrame1(DataInputProvider.getCellData_ColName(iRowNumber, "RecordStatusPublished", sDataSheetName))
		
		//23. Account  Type = Member
		.selectAccountType(DataInputProvider.getCellData_ColName(iRowNumber, "AccountType", sDataSheetName))
		
		//24. Record Change Status
		//.changeRecordStatus(DataInputProvider.getCellData_ColName(iRowNumber, "ChangeRecordStatus", sDataSheetName))
			
//Address Information
		
		//Store/Location type = Shipto
		.chooseLocationType(DataInputProvider.getCellData_ColName(iRowNumber, "LocationType", sDataSheetName))
		
		// Street 1 = Any
		.typeStreet1(DataInputProvider.getCellData_ColName(iRowNumber, "Street1", sDataSheetName))
		
		// Street 2 = Any
		.typeStreet2(DataInputProvider.getCellData_ColName(iRowNumber, "Street2", sDataSheetName))
		
		 //City = NY
		.typeCity(DataInputProvider.getCellData_ColName(iRowNumber, "City", sDataSheetName))
		
		 //Country =USA
		.typeCountry(DataInputProvider.getCellData_ColName(iRowNumber, "Country", sDataSheetName))
		
		//Delivery info
		.typeDeliveryInfo(DataInputProvider.getCellData_ColName(iRowNumber, "DeliveryInfo", sDataSheetName))
		
		//State
		.typeState(DataInputProvider.getCellData_ColName(iRowNumber, "State", sDataSheetName))
		
		//county
		.typeCounty(DataInputProvider.getCellData_ColName(iRowNumber, "County", sDataSheetName))
		
		//Type Zip code
		.typeZipCode(DataInputProvider.getCellData_ColName(iRowNumber, "ZipCode", sDataSheetName))
		
		//OverrideName
		.typeOverrideName(DataInputProvider.getCellData_ColName(iRowNumber, "OverrideName", sDataSheetName))

		//MainPhone
		.typeMainPhone(DataInputProvider.getCellData_ColName(iRowNumber, "MainPhone", sDataSheetName))	
		
		//OtherPhone
		.typeOtherPhone(DataInputProvider.getCellData_ColName(iRowNumber, "OtherPhone", sDataSheetName))
	
		//Fax
		.typeFax(DataInputProvider.getCellData_ColName(iRowNumber, "Fax", sDataSheetName))
		
		//Website
		.typeWebsite(DataInputProvider.getCellData_ColName(iRowNumber, "Website", sDataSheetName))
		
		
		//ReceiveDirectMail
		.verifyReceiveDirectMail(DataInputProvider.getCellData_ColName(iRowNumber, "ReceiveDirectMail", sDataSheetName))
		
		//FSRPTFlag
		.verifyFSRPTFlag(DataInputProvider.getCellData_ColName(iRowNumber, "FSRPTFlag", sDataSheetName))
		
		//DoNotVerifyAddress
		.verifyDoNotVerifyAddress(DataInputProvider.getCellData_ColName(iRowNumber, "DoNotVerifyAddress", sDataSheetName))
		
		//ExternalAddessID
		.verifyExternalAddessID(DataInputProvider.getCellData_ColName(iRowNumber, "ExternalAddessID", sDataSheetName))
		
		
//Membership Provider config

		//MembershipProvider
		
		//MembershipProviderType
		
		//MembershipAttributeCode


//Direct Parent
		
		////Direct Parent Entity Code = 673415
		.selectDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParent", sDataSheetName))
		
		//Direct Parent Relation = Managed
		.selectDirectParentRelationManaged(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelation", sDataSheetName)) 
		
		//Direct Parent Relation date = Today's Date
		.selectDirectParentRelationDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
		
		//DPExceptionReason
		.typeDPReason(DataInputProvider.getCellData_ColName(iRowNumber, "DPReason", sDataSheetName))
		
		
		
		
//Top Parent
		
		// Verify Direct parent and Top parent are populated 
		.verifyDirectParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyTopParent", sDataSheetName))
		
		//Top Parent Relation Date = Today's Date
		 .selectTopParentRelationDate( DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelationDate", sDataSheetName))
		 
		//Top parent classification = Any
		.selectTopParentClassification(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentClassification", sDataSheetName))
			
		//Top Parent Relation =  OLM
		 .selectTopParentRelation(DataInputProvider.getCellData_ColName(iRowNumber, "TopParentRelation", sDataSheetName))
			 
		// IsTopParent
		 .verifyIsTopParent(DataInputProvider.getCellData_ColName(iRowNumber, "IsTopParent", sDataSheetName))
		 
//Click on Save
		 
		 .clickSave() 
		 
//Fee Share
			
		//Fee share eligible		
		.changeFeeShareEligible1()
		
		//Fee share eligible date = Today's date
		.selectFeeShareEligibleStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "FeeShareEligibleStartDate", sDataSheetName))
				
//Sponsor
		 
		// Verify "Is Sponsor" field 
		.verifyIsSponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsSponsor", sDataSheetName))
			
		//14 Verify Sponsor field 
		.verifySponsor(DataInputProvider.getCellData_ColName(iRowNumber, "VerifySponsor", sDataSheetName))
		
//Corporate Parent
		
		// Verify "IS Corporate account" field
		.verifyIsCorporateAccount(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsCorporateAccount", sDataSheetName))
						
		// Verify Corporate parent name in the form
		.verifyCorporateParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyCorporateParentName", sDataSheetName))
		
		//CorpParentStartDate
		.VerifyCorpParenttartDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
		
		//CorpParentOverride
		.VerifyCorpParentOverride(DataInputProvider.getCellData_ColName(iRowNumber, "CorpParentOverride", sDataSheetName))
		
//Food service parent
		
		//Verify "Is Food Service parent" field 
		.verifyIsFoodServiceParent(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyIsFoodServiceParent", sDataSheetName))
				
		//Verify Food Service parent name in the form 
		.VerifyFoodServiceParentName(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyFoodServiceParentName", sDataSheetName))
				
		//FoodParentStartDate
		.VerifyFoodServiceStartDate(DataInputProvider.getCellData_ColName(iRowNumber, "DirectParentRelationDate", sDataSheetName))
		
		
		//FoodParentOverride
		.VerifyFSPOverride(DataInputProvider.getCellData_ColName(iRowNumber, "FSPOverride", sDataSheetName))
		
		
//FBO
		//Is FBO
		.VerifyFBO(DataInputProvider.getCellData_ColName(iRowNumber, "VerifyDirectParent", sDataSheetName))
		
		//16. Verify "Is FBO" field 
		.verifyIsFBO(DataInputProvider.getCellData_ColName(iRowNumber, "isFBO", sDataSheetName))
				
		//FBOManualOverride
		.VerifyFBOManualOverride(DataInputProvider.getCellData_ColName(iRowNumber, "FBOManualOverride", sDataSheetName))
		
		
		//FBOGPO
		.VerifyFBOGPO(DataInputProvider.getCellData_ColName(iRowNumber, "FBOGPO", sDataSheetName))
		
		
		//FBORelationDate
		
		//FBO Type = Any
		.selectFBOGPOType(DataInputProvider.getCellData_ColName(iRowNumber, "FBOType", sDataSheetName))
				
		//FBO effective date = Today's date
		.selectFBOEffectiveDate(DataInputProvider.getCellData_ColName(iRowNumber, "FBOEffectiveDate", sDataSheetName))
		
		//Click on Save 
		.clickSave() 
		
//Account numbers
		//CRM number
		.crmNumberIsDisplayedWithFrame1()	
		
	//Enter Hin
		
		//Select account number entity
		.selectAccountNumbers()
		
		//Click on add new account number in Account numbers entity
		.clickAddNewAccountNumberInAccountNumbers()
		
		//Select Account type
		.chooseAccountNumberTypeInAccountNumbersHIN()
		
		//Enter HIN Account number
		.typeAccountNumberHIN()
		
		//Click on Save and Close
		.clickSaveAndCloseInAccountNumbers()
		
	//Enter DEA
		//Click on add new account number in Account numbers entity
		.clickAddNewAccountNumberInAccountNumbers()
				
		//Select Account type
		.chooseAccountNumberTypeInAccountNumbersDEA()
					
		//Enter DEA account number
		.typeAccountNumberDEA()
		
		//Click on Save and Close
		.clickSaveAndCloseInAccountNumbers()
	
		//Click on Save 		
		//.clickSaveInAccountNumbers()
		
		.clickMemberName()
		
		//Click on Save 
		.clickSave() 
		
		//Verify DEA number
		.verifyDEA(DataInputProvider.getCellData_ColName(iRowNumber, "DEANumber", sDataSheetName))
		
		//Verify HIN
		.verifyHIN(DataInputProvider.getCellData_ColName(iRowNumber, "HIN", sDataSheetName))
		
		;	
	}
}
