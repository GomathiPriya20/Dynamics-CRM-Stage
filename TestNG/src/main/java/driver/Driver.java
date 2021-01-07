package driver;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import base.PreAndPost;
import utils.DataInputProvider;

public class Driver extends PreAndPost{

	public static int iTestCaseRowNum;
	public static String sTestCaseID;
	public static Properties properties = new Properties();
	public static String sRunMode;
	public static String sCategory;
	public static Method[] aMethod;
	public static int iTestCaseRowNumDriver;
	public static String sReleaseCategory;

	@Test
	public void executeTestcase(ITestContext testContext)throws Exception,ClassNotFoundException
	{	
		properties.load(new FileInputStream(new File("./src/test/resources/environment.properties")));
		int currentCount = testContext.getAllTestMethods()[0].getCurrentInvocationCount();	

		//Read test case id and run-mode from Driver sheet
		sTestCaseID=DataInputProvider.getCellData_ColName(currentCount+1, properties.getProperty("ColTestCaseName"),properties.getProperty("DriverSheetName"));
		sRunMode=DataInputProvider.getCellData_ColName(currentCount+1, properties.getProperty("ColRunMode"),properties.getProperty("DriverSheetName"));
		iTestCaseRowNumDriver=DataInputProvider.getRowNum(properties.getProperty("DriverSheetName"), sTestCaseID);
		sCategory=DataInputProvider.getCellData_ColName(currentCount+1, properties.getProperty("ColCategory"),properties.getProperty("DriverSheetName"));
		sReleaseCategory=DataInputProvider.getCellData_ColName(currentCount+1, "ReleaseCategory",properties.getProperty("DriverSheetName"));

		//Get the row number of the test case which is marked as yes from actual category sheet 
		iTestCaseRowNum=DataInputProvider.getRowNum(sCategory, sTestCaseID);

		String name[]= sTestCaseID.split(":");
		String sTClassName[]=name[0].split("_");
		String sTestClassName="TestCase_".concat(sTClassName[1].trim());
		//Execute the test cases which are marked as yes in run mode column in driver sheet
		if (sCategory.equalsIgnoreCase("Member"))
		{
			sTestClassName="testcases.Member.".concat(sTestClassName);
		}
		else
		{
			sTestClassName="testcases.Supplier.".concat(sTestClassName);
		}	
		//Create instance of the class during run time
		Class<?> cls = Class.forName(sTestClassName);
		Object clsInstance = (Object) cls.getDeclaredConstructor().newInstance();
		test = extent.createTest(sTestCaseID);
		test.assignCategory(sCategory);
		test.assignCategory(sReleaseCategory);
		if (sRunMode.equalsIgnoreCase("Yes"))
		{	 
			// Get all methods of the class
			aMethod=clsInstance.getClass().getDeclaredMethods();
			beforeMethod();
			System.out.println(sTestCaseID+" is being executed");				
			aMethod[0].invoke(clsInstance,iTestCaseRowNum,sCategory);
			closeBrowser();			
		}

		else
		{
			throw new SkipException(sTestCaseID + "is not chosen for execution");
		}
	}

	@AfterMethod
	public void Reports(ITestResult result) throws Exception
	{
		try
		{
			String sTimeStamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
			if(result.getStatus() == ITestResult.FAILURE)
			{
				DataInputProvider.setCellData("Failed", iTestCaseRowNumDriver, "Result");
				DataInputProvider.setCellData(sTimeStamp, iTestCaseRowNumDriver, "TimeStamp");
				test.log(Status.FAIL, MarkupHelper.createLabel(sTestCaseID+" FAILED due to below issues:", ExtentColor.RED));
				test.fail(result.getThrowable());
			}	
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				System.out.println(result.getStatus());
				DataInputProvider.setCellData("PASSED", iTestCaseRowNumDriver, "Result");
				DataInputProvider.setCellData(sTimeStamp, iTestCaseRowNumDriver, "TimeStamp");
				test.log(Status.PASS, MarkupHelper.createLabel(sTestCaseID+" PASSED", ExtentColor.GREEN));
			}

			else if(result.getStatus() == ITestResult.SKIP) 
			{ DataInputProvider.setCellData("SKIPPED", iTestCaseRowNumDriver, "Result"); 
			DataInputProvider.setCellData(sTimeStamp, iTestCaseRowNumDriver, "TimeStamp"); 
			test.log(Status.SKIP,MarkupHelper.createLabel(sTestCaseID+" SKIPPED ", ExtentColor.ORANGE));
			}
			else
			{     	
				DataInputProvider.setCellData("Not Run", iTestCaseRowNumDriver, "Result");

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
