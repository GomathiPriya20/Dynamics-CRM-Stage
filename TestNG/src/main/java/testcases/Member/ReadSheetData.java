//package testcases.Member;
//
//import java.io.IOException;
//import java.util.Map;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import hooks.TestNgHooks;
//import utils.DataInputProvider;
//import pages.LoginPage;
//
//public class ReadSheetData extends TestNgHooks{
//	
//	
//	@BeforeTest
//	public void setData() {
//		testCaseName = "TFS ID_ 1141 : Validate Business Key";
//		testDescription = "Verify Validate Business Key with BK Active field"; 
//		category = "Member";
//		authors = "Senthil";  
//		dataSheetName = "MasterData";
//		nodes = "Validate Business Key";
//
//	}
//	@BeforeMethod()
//	public void startLogin() {	
//		
//	}
//	
//@Test (dataProvider ="fetchData"/* groups ="Member", enabled=true*/)
//public void Test(Map mapdata) throws IOException {
//	DataInputProvider r = new DataInputProvider();
//	String val = r.getMapData("search");
//	System.out.println("Value of the keyword (search) is- "+val);


////public class ReadSheetData extends TestNgHooks{
//	public  void main(String[] args) throws IOException {
//		DataInputProvider r = new DataInputProvider();
//	//	String val = r.getMapData("search");
//		String val = r.getMapData("key");
//		System.out.println("Value of the keyword (search) is- "+val);
//   }
//}
//}