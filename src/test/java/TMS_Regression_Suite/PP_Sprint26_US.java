package TMS_Regression_Suite;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PP_Sprint26_US extends Base_Page_TMS {

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
	 * Add AdminPanel_AddHclRecruiter_Mapping(): This method is use to Add HCL Recruiter Mapping
	 * 
	 * Steps: 
	 * 1. Open the Browser 
	 * 2. Login the application(Admin Role)
	 * 3. Successfully open the Dashboard page 
	 * 4. Click on Admin Settings 
	 * 5. Click on HCL Recruiter Mapping
	 * 6. Click on Add New button
	 * 7. Input HCL Recruiter Name
	 * 8. Select SageIT Recruiter
	 * 9. SageIT Recruiter Email should be auto-populate
	 *10. Click on Save button 
	 *11. Verify Confirmation toaster for HCL Recruiter Mapping
	 *12. Verify confirmation toaster should be print in console
	 *13. Close the browser
	 * 
	 * 
	 */
	@Test(priority = 1, description = "Add new HCL Recruiter Mapping using Admin Panel")
	public void AdminPanel_AddHclRecruiter_Mapping() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Add new HCL Recruiter Mapping using Admin Panel")
				.assignCategory("Add HCL Recruiter Mapping using Admin Panel");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@root.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123Pa$$word!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("(//i[@class='fa fa-cogs ng-star-inserted'])[1]"));
		ele1.click();
		Thread.sleep(3000);
		log.info("Click on Admin Settings Icon");
		log.pass("Successfully click on Admin Settings Icon");

		// driver.findElement(By.xpath("//a[normalize-space()='Work
		// Authorizations']")).click();
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='HCL Recruiter Mapping']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(5000);
		log.info("Click on HCL Recruiter Mapping");
		log.pass("Successfully click on HCL Recruiter Mapping");

		driver.findElement(By.xpath("//a[normalize-space()='Add New']")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		driver.findElement(By.xpath("//input[@id='form-hclRecruiterName']")).sendKeys("Add Automation Recruiter");
		Thread.sleep(2000);
		log.info("Input HCL Recruiter Name in textbox");
		log.pass("Successfully input the HCL Recruiter Name in textbox");

		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("Abhinov Dara");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted']")).click();
		log.info("Select SageIT Recruiter");
		log.pass("Successfully input the HCL Recruiter Name in textbox");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		WebElement HclRecruiter_cnfstr = driver.findElement(By.xpath("//div[@id='toast-container']"));

		// Use JavaScriptExecutor to retrieve text of the element
		String HclRecruiter_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", HclRecruiter_cnfstr);

		// Print the text to the console
		System.out.println("HCL Recruiter Mapping toaster message: " + HclRecruiter_toaster_text);
		log.info("Get HCL Recruiter Mapping Confirmation toaster message");
		log.pass("Successfully Get HCL Recruiter Mapping Confirmation toaster message in console");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Add HCL Recruiter Mapping");
	}
}
