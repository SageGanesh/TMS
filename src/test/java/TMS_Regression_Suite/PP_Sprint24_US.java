package TMS_Regression_Suite;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PP_Sprint24_US extends Base_Page_TMS {

	WebDriverWait wait;

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Html_Report/Extentreport1.html");

	@BeforeTest
	public void Report_setup() {
		spark.config().setDocumentTitle("html_report");
		spark.config().setTheme(Theme.STANDARD);
		extent.attachReporter(spark);
	}

	@AfterTest
	public void report_flush() {
		extent.flush();
	}

	/*
	 * Add/Update End Client By Requirement agent(): This method is use update the
	   end client by Requirement Agent.
	 * 
	 * Steps: 
	 * 1. Open the Browser 
	 * 2. Login the application(Requirement Agent) 
	 * 3.Successfully open the Requirement list 
	 * 4. Click On Job Code 
	 * 5. Click on Edit button 
	 * 6. Input End Client Name 
	 * 7. Click on Add Item 
	 * 8. Click on Save 
	 * 9.Authentication PopUp came. 
	 * 10. Click on Yes, change it! button 
	 * 11. Get the confirmation toaster 
	 * 12. Close the browser
	 * 
	 */

	@Test(priority = 1, description = "Update End Client")
	public void Candidate_Backout_StatusChange() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("End Client changed by Requirement Agent")
				.assignCategory("Update End Client");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("RequirementAgent@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//i[@class='bx dripicons-view-list ng-star-inserted']"));
		ele1.click();
		Thread.sleep(10000);
		log.info("Click on Requirements Icon");
		log.pass("Successfully click on Requirements Icon");

		driver.findElement(By.xpath("//u[normalize-space()='JPC - 79924']")).click();
		log.info("Click on Job Code");
		log.pass("Successfully click on Job Code");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("Automation HCL 02");
		log.info("Input new End Client");
		log.pass("Successfully Input new End Client");

		driver.findElement(By.xpath("//span[@class='ng-tag-label']")).click();
		log.info("Click on Add Item button");
		log.pass("Successfully click on Add Item button");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		Thread.sleep(1000);
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//button[normalize-space()='Yes, change it!']")).click();
		Thread.sleep(1000);
		log.info("Click on Yes, change it! button");
		log.pass("Successfully Click on Yes, change it! button");

		WebElement EndClient_updatetstr = driver.findElement(By.xpath("//div[@id='toast-container']"));

		// Use JavaScriptExecutor to retrieve text of the element
		String EndClient_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", EndClient_updatetstr);

		// Print the text to the console
		System.out.println("End Client Updated toaster message: " + EndClient_toaster_text);
		log.info("Get End Client Updated toaster message");
		log.pass("Successfully Get End Client Updated toaster message in console");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Add/Update End Client");

	}
}
