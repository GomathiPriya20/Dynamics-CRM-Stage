package design;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverService {


	/**
	 * This method will locate the element using any given locator
	 * @param locator  - The locator by which the element to be found
	 * @param locValue - The locator value by which the element to be found
	 * @author Innovatix QA - GAVS
	 * @throws NoSuchElementException - When no element matches the given locator and the value, you will get this exception
	 */
	public WebElement locateElement(String locator, String locValue) ;	


	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Innovatix QA - GAVS
	 * @throws ElementNotVisibleException - Element not visible to interact 
	 */
	public void type(WebElement ele, String data) ;

	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Innovatix QA - GAVS
	 */
	public void click(WebElement ele);

	/**
	 * This method will get the text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Innovatix QA - GAVS
	 */
	public String getText(WebElement ele);

	/**
	 * This method will select the drop down visible text
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Innovatix QA - GAVS
	 */
	public void selectDropDownUsingVisibleText(WebElement ele, String value) ;

	/**
	 * This method will select the drop down using value
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value attribute to be selected from the dropdown 
	 * @author Innovatix QA - GAVS
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param index The index to be selected from the dropdown 
	 * @author Innovatix QA - GAVS
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index) ;

	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * @author Innovatix QA - GAVS
	 * @return boolean - True if the title matches else Not.
	 */
	public boolean verifyExactTitle(String expectedTitle);
	
	/**
	 * This method will verify browser actual title with expected text using contains
	 * @param title - The expected title of the browser
	 * @author Innovatix QA - GAVS
	 * @return boolean - True if the title matches partially else Not.
	 */
	public boolean verifyPartialTitle(String expectedTitle);


	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Innovatix QA - GAVS
	 */
	public void verifyExactText(WebElement ele, String expectedText);

	/**
	 * This method will verify given text contains actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Innovatix QA - GAVS
	 */
	public void verifyPartialText(WebElement ele, String expectedText);

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Innovatix QA - GAVS
	 */
	public void verifyExactAttribute(WebElement ele, String attribute, String value);

	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Innovatix QA - GAVS
	 */
	public void verifyPartialAttribute(WebElement ele, String attribute, String value);

	/**
	 * This method will verify if the element (Radio button, Checkbox)  is selected
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @author Innovatix QA - GAVS
	 */
	public void verifySelected(WebElement ele);

	/**
	 * This method will verify if the element is visible in the DOM
	 * @param ele   - The Webelement to be checked
	 * @author Innovatix QA - GAVS
	 */
	public void verifyDisplayed(WebElement ele);

	/**
	 * This method will switch to the Window of interest
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Innovatix QA - GAVS
	 */
	public void switchToWindow(int index);

	/**
	 * This method will switch to the specific frame
	 * @param ele   - The Webelement (frame) to be switched
	 * @author Innovatix QA - GAVS
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will accept the alert opened
	 * @author Innovatix QA - GAVS
	 */
	public void acceptAlert();

	/**
	 * This method will dismiss the alert opened
	 * @author Innovatix QA - GAVS
	 */
	public void dismissAlert();

	/**
	 * This method will return the text of the alert
	 * @author Innovatix QA - GAVS
	 */
	public String getAlertText();

	/**
	 * This method will close the active browser
	 * @author Innovatix QA - GAVS
	 */
	public void closeActiveBrowser();		

	/**
	 * This method will close all the browsers
	 * @author Innovatix QA - GAVS
	 */
	public void closeAllBrowsers();
	
	
	/**
	 * This method should wait for the loader to disappear (max time: 10 seconds)
	 * @author Innovatix QA
	 * @since July 7, 2020
	 * @exception
	 */
	
	public void waitForLoaderToDisapper();

}


