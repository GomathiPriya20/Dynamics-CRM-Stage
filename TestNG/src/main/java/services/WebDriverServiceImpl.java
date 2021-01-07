package services;

import events.WebDriverEvents;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import base.WebDriverService;
import driver.Driver;




public class WebDriverServiceImpl extends WebDriverEvents implements WebDriverService{

	private ExtentTest reporter;
	public static String screenshotPath;
	static MediaEntityModelProvider img;

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public ExtentTest setReport()
	{
		this.reporter = Driver.test;
		return reporter;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static String getScreenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		screenshotPath = System.getProperty("user.dir") +"/Screenshots/"+java.time.LocalDate.now()+"/"+System.currentTimeMillis()+".png";
		File destination = new File(screenshotPath);
		FileUtils.copyFile(source, destination);  
		return screenshotPath;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static MediaEntityModelProvider screenshotCapture() 
	{
		try {
			img= MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public WebElement locateElement(String locator, String locValue)  {
		try {
			switch (locator) {
			case "id": return getDriver().findElement(By.id(locValue));
			case "name": return getDriver().findElement(By.name(locValue));
			case "class": return getDriver().findElement(By.className(locValue));
			case "link" : return getDriver().findElement(By.linkText(locValue));
			case "xpath": return getDriver().findElement(By.xpath(locValue));		
			default: break;
			}

		} catch (NoSuchElementException e) {
			setReport().log(Status.FAIL, "The element with locator "+locator+" not found ");
			throw e;

		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while finding  "+locator+" with the value "+locValue);
			throw e;
		}
		return null;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public WebElement locateElement(String locValue) {
		return getDriver().findElement(By.id(locValue));
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void type(WebElement ele, String data)  {
		try {
			ele.clear();
			ele.sendKeys(data);
			//setReport().log(Status.PASS, "The data: "+data+" successfully entered in : "+ele);
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+" could not be entered in  : "+ele, screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+" in "+ele, screenshotCapture());	
			throw e;
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	

	public void clearAndType(WebElement ele, String data)  {
		try {
			//ele.clear();
			ele.sendKeys(Keys.BACK_SPACE);
			ele.sendKeys(data);			
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+" could not be entered in  : "+ele, screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+" in "+ele, screenshotCapture());	
			throw e;
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	public void typeAndChoose(WebElement ele, String data)  {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.TAB);
			setReport().log(Status.PASS, "The data: "+data+" entered successfully in  :"+ele,screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+" could not be entered in the field :"+ele,screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+" in the field :"+ele,screenshotCapture());
			throw e;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void clickAndChoose(WebElement ele, String data)  {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.valueOf(data));
			setReport().log(Status.PASS, "The data: "+data+"entered successfully in the field :"+ele,screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+"could not be entered in the field :"+ele,screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+"in the field :"+ele);
			throw e;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	

	public void typeAndEnter(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.ENTER);
			setReport().log(Status.PASS, "The data: "+data+" entered successfully in the field :"+ele,screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, "The data: "+data+"could not be entered in the field :"+ele,screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while entering  "+data+"in the field :"+ele,screenshotCapture());
			throw e;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void click(WebElement ele)  {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 15);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
			setReport().log(Status.PASS, text+" is clicked",screenshotCapture());
			System.out.println("Text in click method 1 "+text);	
		}
		catch (InvalidElementStateException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL,text+" could not be clicked", screenshotCapture());	
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field : "+text,screenshotCapture());		
		} 

	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();			
			setReport().log(Status.PASS, text+" is clicked",screenshotCapture());
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, text+" could not be clicked",screenshotCapture());
			e.printStackTrace();

		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field : "+text,screenshotCapture());		
			e.printStackTrace();
			throw e;
		} 
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
			setReport().log(Status.PASS, bReturn+" is displayed",screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, ele+"could not be found",screenshotCapture());
			throw e;
		}
		return bReturn;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  getDriver().getTitle();
			setReport().log(Status.PASS, "The Title: "+bReturn+" is displayed",screenshotCapture());

		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown Exception Occured While fetching Title",screenshotCapture());
			throw e;
		} 
		return bReturn;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn= ele.getAttribute(attribute);
				setReport().log(Status.PASS, " The Attribute: "+ bReturn+" is displayed",screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, ele+"could not be found",screenshotCapture());
			throw e;
		} 
		return bReturn;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			setReport().log(Status.PASS, ele+" is selected with text "+value,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL,  ele+" could not be selected",screenshotCapture());
			throw e;
		}

	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			setReport().log(Status.PASS, ele+" is selected with index "+index,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "The element: "+ele+"could not be selected",screenshotCapture());
			throw e;
		} 

	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public boolean verifyExactTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				setReport().log(Status.PASS, "The title of the page matches with the value : "+title,screenshotCapture());
				bReturn= true;
			}else {
				setReport().log(Status.FAIL, "The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the title",screenshotCapture());
			throw e;
		} 
		return bReturn;
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public boolean verifyPartialTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().contains(title)) {
				setReport().log(Status.PASS, "The title of the page matches with the value : "+title,screenshotCapture());
				bReturn= true;
			}else {
				setReport().log(Status.FAIL, "The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the title",screenshotCapture());
			throw e;
		} 
		return bReturn;		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				setReport().log(Status.PASS, "The text :"+getText(ele)+" matches with the value :"+expectedText,screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The text :"+getText(ele)+" did not match with the value :"+expectedText,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the Text",screenshotCapture());
			throw e;
		} 

	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				setReport().log(Status.PASS, "The expected text contains the actual "+expectedText,screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The expected text does not contain the actual "+expectedText,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the Text",screenshotCapture());
			throw e;
		} 
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				setReport().log(Status.PASS, "The expected attribute : "+attribute+" value matches the actual : "+value,screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The expected attribute : "+attribute+" value does not matches the actual : "+value,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the attribute",screenshotCapture());
			throw e;
		} 

	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				setReport().log(Status.PASS, "The expected attribute : "+attribute+" value contains the actual : "+value,screenshotCapture());
			}else {
				setReport().log(Status.FAIL, "The expected attribute : "+attribute+" value does not contains the actual : "+value,screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "Unknown exception occured while verifying the attribute",screenshotCapture());
			throw e;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				setReport().log(Status.PASS, ele+" is selected",screenshotCapture());
			} else {
				setReport().log(Status.FAIL, ele+" is not selected",screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException : \"+e.getMessage()",screenshotCapture());
			throw e;

		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				setReport().log(Status.PASS, ele+" is visible",screenshotCapture());
			} else {
				setReport().log(Status.FAIL, ele+" is not visible",screenshotCapture());
			}
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException : \"+e.getMessage()",screenshotCapture());
			throw e;
		} 
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = getDriver().getWindowHandles();
			List<String> allHandles = new ArrayList<String>();
			allHandles.addAll(allWindowHandles);
			getDriver().switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			setReport().log(Status.FAIL, "The driver could not move to the given window by index "+index,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			throw e;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void switchToFrame(WebElement ele) {
		try {
			getDriver().switchTo().frame(ele);
			setReport().log(Status.PASS, "switch In to the Frame "+ele,screenshotCapture());
		} catch (NoSuchFrameException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			throw e;
		} 
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void switchToDefaultContent() {
		try {
			getDriver().switchTo().defaultContent();
			setReport().log(Status.PASS, "switch out to Default Content ",screenshotCapture());
		} catch (NoSuchFrameException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException"+e.getMessage(),screenshotCapture());
			throw e;
		} 

	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.accept();
			setReport().log(Status.PASS, "The alert "+ text+" is accepted",screenshotCapture());	
		} catch (NoAlertPresentException e) {
			setReport().log(Status.PASS, "There is no alert present",screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException "+e.getMessage(),screenshotCapture());
			throw e;
		}  
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			setReport().log(Status.PASS, "The alert "+ text+" is dismissed",screenshotCapture());
		} catch (NoAlertPresentException e) {
			setReport().log(Status.PASS, "There is no alert present",screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException  "+e.getMessage(),screenshotCapture());
			throw e;
		} 

	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			setReport().log(Status.FAIL, "There is no alert present",screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "WebDriverException "+e.getMessage(),screenshotCapture());
			throw e;
		} 
		return text;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void closeActiveBrowser() {
		try {
			getDriver().close();
			setReport().log(Status.PASS, "The browser is closed",screenshotCapture());
		} catch (Exception e) {
			setReport().log(Status.FAIL, "The browser could not be closed",screenshotCapture());
			throw e;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void closeAllBrowsers() {
		try {
			getDriver().quit();
			setReport().log(Status.PASS, "The opened browsers are closed");
		} catch (Exception e) {
			setReport().log(Status.FAIL, "Unexpected error occured in Browser",screenshotCapture());
			throw e;
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			setReport().log(Status.PASS, "The dropdown "+ ele  +" is selected with text : "+value,screenshotCapture());
		} catch (WebDriverException e) {
			setReport().log(Status.FAIL, "The dropdown "+ele+ " could not be found",screenshotCapture());
			throw e;
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void scrollDown(WebElement ele) {
		String text = "";
		try {
			((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();	
			setReport().log(Status.PASS, text+" is clicked 3",screenshotCapture());
			System.out.println("Text in click method"+text);
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, text+ " could not be clicked",screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field :"+text,screenshotCapture());
			throw e;
		} 
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public void scrollUp(WebElement ele) {
		String text = "";
		try {
			((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
			WebDriverWait wait = new WebDriverWait(getDriver(), 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
			setReport().log(Status.PASS, text+" is clicked 3",screenshotCapture());
			System.out.println("Text in click method"+text);
		} catch (InvalidElementStateException e) {
			setReport().log(Status.FAIL, text+ " could not be clicked",screenshotCapture());
			throw e;
		} catch (WebDriverException e) {
			e.printStackTrace();
			setReport().log(Status.FAIL, "Unknown exception occured while clicking in the field :"+text,screenshotCapture());
			throw e;
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@Override
	public void waitForLoaderToDisapper() {
		// TODO Auto-generated method stub
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}

