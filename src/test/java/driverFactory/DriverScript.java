package driverFactory;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.FunctionLibrary;
import utilities.ExcelFileUtil;

public class DriverScript {

	public static WebDriver driver;
	String ExcelPath = "./FileInput/Controller_lyst9505.xlsx";
	String outputpath = "./FileOutput/test_resultdata.xlsx";
	String sheetname = "MasterTestCases";
	
	ExtentReports reports;
	ExtentTest logger;
	
	public void startTest() throws Throwable {
	

		ExcelFileUtil xl = new ExcelFileUtil(ExcelPath);
		reports = new ExtentReports("./target/DemoReports/Reports/.html");
		
		for(int i=1; i<=xl.rowCount(sheetname);i++) {
			
			String Execution_Status = xl.getCellData(sheetname, i, 2);
			String status = "";
			
			if(Execution_Status.equalsIgnoreCase("y")) {
				
				String module_nane = xl.getCellData(sheetname, i, 1);
				logger =reports.startTest(module_nane);
				
				for(int j=1;j<=xl.rowCount(module_nane);j++) {
					
					String description = xl.getCellData(module_nane, j, 0);

					String Object_Type = xl.getCellData(module_nane, j, 1);

					String Locator_Type = xl.getCellData(module_nane, j, 2);

					String Locator_Value = xl.getCellData(module_nane, j, 3);

					String Test_Data = xl.getCellData(module_nane, j, 4);
					try {
					
					if(Object_Type.equalsIgnoreCase("startBrowser")) {
						
						driver = FunctionLibrary.startBrowswer();
						logger.log(LogStatus.INFO, description);
					}
					
					if(Object_Type.equalsIgnoreCase("openUrl")) {
						
						FunctionLibrary.openUrl(driver);
						logger.log(LogStatus.INFO, description);
					}
					
					if(Object_Type.equalsIgnoreCase("waitForElement")) {
						
						FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(LogStatus.INFO, description);
					}
					
					if(Object_Type.equalsIgnoreCase("typeAction")) {
						
						FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(LogStatus.INFO, description);
					}
					
					if(Object_Type.equalsIgnoreCase("clickAction")) {
						
						FunctionLibrary.clickAction(driver,Locator_Type, Locator_Value);
						logger.log(LogStatus.INFO, description);
					}
					
										
					if(Object_Type.equalsIgnoreCase("closeBrowser")) {
						
						FunctionLibrary.closeBrowser(driver);
						logger.log(LogStatus.INFO, description);
					}
					
					
					
					if(Object_Type.equalsIgnoreCase("product_Sort")) {
						
						FunctionLibrary.product_Sort(driver, Locator_Type, Locator_Value);
						logger.log(LogStatus.INFO, description);
					}
					
					
					xl.setCelldata(module_nane, j, 5, outputpath, "Pass");
					status = "True";
				
					
					}
					catch(Throwable t){
						
						System.out.println(t.getMessage());
						xl.setCelldata(module_nane, j, 5, outputpath, "Fail");
						status="False";
					
					}
					
					if(status.equalsIgnoreCase("True")) {
						xl.setCelldata(sheetname, i, 3, outputpath, "Pass");
						logger.log(LogStatus.PASS, description);
						
					}
					if(status.equalsIgnoreCase("False")) {
						xl.setCelldata(sheetname, i, 3, outputpath, "Fail");
						logger.log(LogStatus.FAIL, description);
					}
				}
				
				reports.endTest(logger);
				reports.flush();
			
			}
			
			else {
				
				xl.setCelldata(sheetname, i, 3, outputpath, "Blocked");
			}
			
}
	}
}
