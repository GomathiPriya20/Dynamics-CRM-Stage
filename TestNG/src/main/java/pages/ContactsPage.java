package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import services.WebDriverServiceImpl;

public class ContactsPage extends WebDriverServiceImpl{
	
	public ContactsPage clickNewOnContactsPage() {
		click(getDriver().findElement(By.xpath("//span[@command='contact|NoRelationship|HomePageGrid|Mscrm.NewRecordFromGrid']")));
		return this;
	}

	public ContactsPage selectPrimaryAccount() {
		switchToFrame(getDriver().findElement(By.id("contentIFrame1")));
		typeAndChoose(getDriver().findElement(By.id("parentcustomerid_ledit")), "CNECT","Primary Account");
		return this;
	}
	
	public ContactsPage chooseRecordStatus(String RecordStatus) throws InterruptedException {
		Thread.sleep(3000);
		click(((getDriver().findElement(By.id("ix_recordstatus")))));
		selectDropDownUsingVisibleText(((getDriver().findElement(By.id("ix_recordstatus_i")))),RecordStatus,"Record Status");
		getDriver().findElement(By.id("ix_recordstatus")).sendKeys(Keys.TAB);
		//verifyExactText(getDriver().findElement(By.id("ix_recordstatus")),RecordStatus,"Record Status"); 
		Thread.sleep(3000);
		return this;
	}
	
	
//Address Details
	
	public ContactsPage typeStreet1(String Street1) {
		scrollDown(getDriver().findElement(By.id("address1_line1")));
		click((getDriver().findElement(By.id("address1_line1"))));
		clearAndType(((getDriver().findElement(By.id("address1_line1_i")))),Street1, "Street1");
		return this;
	}
	
	/*
	public MemberFormPage verifyStreet2IsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line2")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line2_lock")),"Street2");
		return this;
	}
	public MemberFormPage typeStreet2(String Street2) {
		click((getDriver().findElement(By.id("address1_line2"))));
		clearAndType(((getDriver().findElement(By.id("address1_line2_i")))),Street2, "Street2");
		return this;
	}
	
	public MemberFormPage typeDeliveryInfo(String DeliveryInfo) {
		click((getDriver().findElement(By.id("address1_line3"))));
		clearAndType(((getDriver().findElement(By.id("address1_line3_i")))),DeliveryInfo, "Delivery Info");
		return this;
	}
	public MemberFormPage verifyDeliveryInfoIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_line3")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_line3_lock")),"Delivery Info");
		return this;
	}

	public MemberFormPage typeState(String State) {
		click((getDriver().findElement(By.id("address1_stateorprovince"))));
		clearAndType(((getDriver().findElement(By.id("address1_stateorprovince_i")))),State, "State");
		return this;
	}
	public MemberFormPage verifyStateIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_stateorprovince")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_stateorprovince_lock")),"State");
		return this;
	}
	public MemberFormPage verifyMainPhoneIsEnabled() {
		scrollDown(getDriver().findElement(By.id("telephone1")));
		verifyIsEnabled(getDriver().findElement(By.id("telephone1_lock")),"Main Phone");
		return this;
	}
	public MemberFormPage verifyReferredByIsEnabled() {
		scrollDown(getDriver().findElement(By.id("ix_referredby")));
		verifyIsEnabled(getDriver().findElement(By.id("ix_referredby_lock")),"Main Phone");
		return this;
	}
	
	
	public MemberFormPage typeMainPhone(String MainPhone) {
		click((getDriver().findElement(By.id("telephone1"))));
		clearAndType(((getDriver().findElement(By.id("telephone1_i")))),MainPhone, "Main Phone");
		return this;
	}
	public MemberFormPage typeOtherPhone(String OtherPhone) {
		click((getDriver().findElement(By.id("telephone2"))));
		type(((getDriver().findElement(By.id("telephone2_i")))),OtherPhone, "Other Phone");
		return this;
	}
	public MemberFormPage typeOverrideName(String OverrideName) {
		click((getDriver().findElement(By.id("address1_name"))));
		type(((getDriver().findElement(By.id("address1_name_i")))),OverrideName, "OverrideName");
		return this;
	}
	public MemberFormPage typeFax(String Fax) {
		click((getDriver().findElement(By.id("fax"))));
		type(((getDriver().findElement(By.id("fax_i")))),Fax, "Fax");
		return this;
	}
	public MemberFormPage typeWebsite(String Website) {
		click((getDriver().findElement(By.id("websiteurl"))));
		type(((getDriver().findElement(By.id("websiteurl_i")))),Website, "Website");
		return this;
	}
	public MemberFormPage verifyReceiveDirectMail(String ReceiveDirectMail) {
		verifyExactText(getDriver().findElement(By.id("ix_receivedirectmail")),ReceiveDirectMail,"Receive Direct Mail"); 
		return this;
	}
	public MemberFormPage verifyFSRPTFlag(String FSRPTFlag) {
		verifyExactText(getDriver().findElement(By.id("ix_receivedirectmail")),FSRPTFlag,"FSRPT Flag"); 
		return this;
	}
	public MemberFormPage verifyDoNotVerifyAddress(String DoNotVerifyAddress) {
		verifyExactText(getDriver().findElement(By.id("ix_donotverifyaddress")),DoNotVerifyAddress,"Do Not Verify Address"); 
		return this;
	}
	public MemberFormPage verifyExternalAddessID(String ExternalAddessID) {
		verifyExactText(getDriver().findElement(By.id("ix_donotverifyaddress")),ExternalAddessID,"External Addess ID"); 
		return this;
	}
	public MemberFormPage verifyCountyIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_county")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_county_lock")),"County");
		return this;
	}
	
	public MemberFormPage typeCounty(String County) {
		click((getDriver().findElement(By.id("address1_county"))));
		clearAndType((getDriver().findElement(By.id("address1_county_i"))),County,"County");
		return this;
	}
	
	
	public MemberFormPage typeCity(String City) {
		click((getDriver().findElement(By.id("address1_city"))));
		clearAndType((getDriver().findElement(By.id("address1_city_i"))),City,"City");
		return this;
	}
	public MemberFormPage verifyCityIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_city")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_city_lock")),"City");
		return this;
	}

	
	public MemberFormPage typeCountry(String Country) {
		click((getDriver().findElement(By.id("address1_country"))));
		clearAndType((getDriver().findElement(By.id("address1_country_i"))),Country,"Country");
		return this;
	}
	
	public MemberFormPage verifyCountryIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_country")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_country_lock")),"Country");
		return this;
	}
	
	public MemberFormPage typeZipCode(String ZipCode) {
		click((getDriver().findElement(By.id("address1_postalcode"))));
		clearAndType((getDriver().findElement(By.id("address1_postalcode_i"))),ZipCode, "ZipCode");
		return this;
	}
	public MemberFormPage verifyZipIsEnabled() {
		scrollDown(getDriver().findElement(By.id("address1_postalcode")));
		verifyIsEnabled(getDriver().findElement(By.id("address1_postalcode_lock")),"ZipCode");
		return this;
	}*/
}
