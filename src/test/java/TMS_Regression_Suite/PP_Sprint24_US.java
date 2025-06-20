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
	
	/*
	 * Add New Work Authorization by Admin Panel: This method is use to add new Work
	   Authorization and verify it is coming in Applicant WA drop down.
	 * 
	 * Steps: 
	 * 1. Open the Browser 
	 * 2. Login the application(Admin Role)
	 * 3. Successfully open the Dashboard page 
	 * 4. Click on Admin Settings 
	 * 5. Click on Work Authorizations
	 * 6. Click on Add New button
	 * 7. Input Work Authorization Name
	 * 8. Confirmation Pop-up came
	 * 9. Click on Applicants icon 
	 *10. Click on Add New button 
	 *11. Verify in WA dropdown, created WA is there or not
	 *12. Close the browser
	 * 
	 */
	
	@Test(priority = 2, description = "Add new Work Authorization using Admin Panel")
	public void AdminPanel_AddWorkAuthorization() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Add new Work Authorization using Admin Panel")
				.assignCategory("Add Work Authorization using Admin Panel");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@root.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123Pa$$word!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//i[@class='fa fa-cogs ng-star-inserted']"));
		ele1.click();
		Thread.sleep(3000);
		log.info("Click on Admin Settings Icon");
		log.pass("Successfully click on Admin Settings Icon");

		// driver.findElement(By.xpath("//a[normalize-space()='Work
		// Authorizations']")).click();
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Work Authorizations']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(5000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		driver.findElement(By.xpath("//a[normalize-space()='Add New']")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		driver.findElement(By.xpath("//input[@id='form-name']")).sendKeys("Automation WA03");
		Thread.sleep(2000);
		log.info("Input Work Authorization Name in textbox");
		log.pass("Successfully input the Work Authorization Name in textbox");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		WebElement element1 = driver.findElement(By.xpath("//a[@href='/applicants']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();
		Thread.sleep(5000);
		log.info("Click on Applicants Icon");
		log.pass("Successfully click on Applicants Icon");

		driver.findElement(By.xpath("//a[contains(text(),'Add New')]")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		By dropdownLocator = By.xpath("//select[@id='form-workAuthorization']");
		String expectedOption = "Automation WA03";

		// Verify this field is present in QA drop down or not.
		WebElement dropdownElement = driver.findElement(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		List<WebElement> options = dropdown.getOptions();

		boolean optionFound = false;
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(expectedOption.trim())) {
				optionFound = true;
				break;
			}
		}

		// Assert and log result
		if (optionFound) {
			log.pass(expectedOption + "' is present in the Work Authorization dropdown.");
		} else {
			log.fail(expectedOption + "' is NOT present in the Work Authorization dropdown.");
			Assert.fail(expectedOption + "' is not present in the Work Authorization dropdown.");
		}

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Add/Update End Client");
	}
}
