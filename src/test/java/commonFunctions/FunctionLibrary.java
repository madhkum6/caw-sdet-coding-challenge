package commonFunctions;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.PropertyFileUtil;

public class FunctionLibrary {
	
public static WebDriver driver;
	
	public static WebDriver startBrowswer() throws Throwable {
		
		if(PropertyFileUtil.getKeyValue("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(PropertyFileUtil.getKeyValue("Browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser value not matching");
		}
		
		return driver;

	}
	
	public static void openUrl(WebDriver driver) throws Throwable {
		
		driver.get(PropertyFileUtil.getKeyValue("Url"));
		
	}
	
	public static void waitForElement(WebDriver driver, String Locator_Type, String Locator_Value, String Test_Data) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Test_Data)));
		
		if(Locator_Type.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locator_Value)));
			
		}
		if(Locator_Type.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Locator_Value)));
			
		}
		if(Locator_Type.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_Value)));
			
		}
	
	}
	
	public static void typeAction(WebDriver driver, String Locator_Type, String Locator_Value, String Test_Data) {
		
		if(Locator_Type.equalsIgnoreCase("id")) {

			driver.findElement(By.id(Locator_Value)).clear();
			driver.findElement(By.id(Locator_Value)).sendKeys(Test_Data);
		}
		else if(Locator_Type.equalsIgnoreCase("name")) {
			
			driver.findElement(By.name(Locator_Value)).clear();
			driver.findElement(By.name(Locator_Value)).sendKeys(Test_Data);
		}
		else if (Locator_Type.equalsIgnoreCase("xpath")) {
			
			driver.findElement(By.xpath(Locator_Value)).clear();
			driver.findElement(By.xpath(Locator_Value)).sendKeys(Test_Data);
		}
	
	}
	
	public static void clickAction(WebDriver driver, String Locator_Type, String Locator_Value) {
		
		if(Locator_Type.equalsIgnoreCase("id")) {
			
			driver.findElement(By.id(Locator_Value)).sendKeys(Keys.ENTER);;
		}
		if(Locator_Type.equalsIgnoreCase("name")) {
			
			driver.findElement(By.name(Locator_Value)).click();
		}
		if(Locator_Type.equalsIgnoreCase("xpath")) {
	
			driver.findElement(By.xpath(Locator_Value)).click();
		}
	
	}
	
	public static void closeBrowser(WebDriver driver) {
		
		driver.close();
		
	}
	
	public static void product_Sort(WebDriver driver, String Locator_Type, String Locator_Value) throws Throwable {
		
		Select item_list = new Select(driver.findElement(By.xpath(Locator_Value)));
		
		item_list.selectByIndex(0);
		Thread.sleep(10);
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).click();
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("madhusudan");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("848101");
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		
		item_list.selectByIndex(1);
		Thread.sleep(10);
		
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).click();
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("madhusudan");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("848101");
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		
		
		item_list.selectByIndex(2);
		Thread.sleep(10);
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).click();
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("madhusudan");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("848101");
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		
		item_list.selectByIndex(3);
		Thread.sleep(10);
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).click();
		driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("madhusudan");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("848101");
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
			
	}
	
	
	
	

}