package TMS_Regression_Suite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Page_TMS {

	

	WebDriver driver;
	
    WebDriverWait wait;
	
    Utility util;
	
	/*
	public Base_Page_TMS(WebDriver driver) {
		this.driver=driver;	
	}
	*/
	
	
	/*
	public Base_Page_TMS(WebDriver driver ) {
		
		
		this.driver=driver;
		
	}
*/
    
WebElement ele;

	@BeforeMethod
	public void  launch() {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\Downloads\\chrome-win32\\chromedriver.exe");
	      driver =new  ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  driver.get("https://tms-qa.azurewebsites.net/account/login");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 }

	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {

	  if (ITestResult.FAILURE == result.getStatus()) {
		  
	    try {
	     util=new Utility(driver);
	     util.ScreenShot("filename");
	     Thread.sleep(20000);
	     System.out.println("Screenshot taken");
	     } catch (Exception e) {
         System.out.println("Exception while taking screenshot " + e.getMessage());
	    }
	  }
	  Thread.sleep(3000);
	  driver.quit();	
	}
	
	
	
}

	
	
	
	
	
	

