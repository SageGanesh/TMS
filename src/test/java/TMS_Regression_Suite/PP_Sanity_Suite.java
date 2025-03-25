package TMS_Regression_Suite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PP_Sanity_Suite extends Base_Page_TMS {

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

	@Test(priority = 1, description = "Vendor Manager Add new Vendor")
	public void AddnewVendor_By_VendorManager() throws InterruptedException {

		ExtentTest log = extent.createTest("Vendor Manager Add new Vendor").assignCategory("Add new Vendor");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("VendorManager@sageitinc.com");
		// driver.findElement(By.xpath("//input[@placeholder='Enter
		// password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/vendors']"));
		ele1.click();
		Thread.sleep(2000);
		log.info("Click on Vendors Icon");
		log.pass("Successfully click on Vendors Icon");

		driver.findElement(By.xpath("//a[contains(text(),'Add New')]")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		driver.findElement(By.xpath("//input[@formcontrolname='vendorName']")).sendKeys("AutoVendor01");
		log.info("Input the Vendor Name in textbox");
		log.pass("Successfully input the Vendor Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='vendorPOCName']")).sendKeys("AutoPOCVendor01");
		log.info("Input the Vendor POC Name in textbox");
		log.pass("Successfully input the Vendor POC Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']")).sendKeys("9874563210");
		log.info("Input the Contact Number in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).sendKeys("Ramesham");
		log.info("Input the Email Address in textbox");
		log.pass("Successfully input the Email Address in textbox");

		// Tier Level Drop down
		// Implement select class for handling the dropdown
		WebElement TierLevel_drp = driver.findElement(By.xpath("//select[@id='form-tierRulesId']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", TierLevel_drp);
		Select s = new Select(TierLevel_drp);
		Thread.sleep(2000);

		s.selectByIndex(1);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Tier Level dropdown");
		log.pass("Successfully click on Tier Level dropdown and select the field");

		// Country Drop down
		// Implement select class for handling the dropdown
		WebElement Country_drp = driver.findElement(By.xpath("//select[@id='form-country']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Country_drp);
		Select st = new Select(Country_drp);
		Thread.sleep(2000);

		st.selectByIndex(2);
		log.info("Using Select class handling the Country dropdown");
		log.pass("Successfully click on Country dropdown and select the field");

		driver.findElement(By.xpath("//input[@formcontrolname='otherState']")).sendKeys("Telangana");
		log.info("Input the State in textbox");
		log.pass("Successfully input the Country in textbox");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@formcontrolname='city']")).sendKeys("Hyderabad");
		log.info("Input the City in textbox");
		log.pass("Successfully input the City in textbox");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@formcontrolname='zipCode']")).sendKeys("123456");
		log.info("Input the Zip Code in textbox");
		log.pass("Successfully input the Zip Code in textbox");
		Thread.sleep(2000);

		// //ng-multiselect-dropdown[@id='clientAssigned']

		// Client Assign Drop down
		// Implement select class for handling the dropdown
		WebElement Clients_drp = driver.findElement(By.xpath("(//span[@class='dropdown-btn'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Clients_drp);
		Select client = new Select(Clients_drp);
		Thread.sleep(2000);

		client.selectByIndex(2);
		log.info("Using Select class handling the Client Assign dropdown");
		log.pass("Successfully click on Client Assign dropdown and select the field");

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		log.info("Click on Save button");
		log.pass("Successfully click on save button");
		Thread.sleep(2000);

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Vendor Manager added new Vendor");
	}

	@Test(priority = 2, description = "Add New Applicant by Vendor")
	public void AddnewApplicant_By_Vendor() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Add New Applicant by Vendor").assignCategory("Add new Applicant");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mpathan@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/applicants']"));
		ele1.click();
		Thread.sleep(2000);
		log.info("Click on Applicants Icon");
		log.pass("Successfully click on Applicants Icon");

		driver.findElement(By.xpath("//a[contains(text(),'Add New')]")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		driver.findElement(By.xpath("//input[@formcontrolname='firstname']")).sendKeys("Automation");
		log.info("Input the Applicant First Name in textbox");
		log.pass("Successfully input the First Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='lastname']")).sendKeys("Applicant01");
		log.info("Input the Applicant Last Name in textbox");
		log.pass("Successfully input the Last Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='mobileNumber']")).sendKeys("9876543210");
		log.info("Input the Applicant Mobile Number in textbox");
		log.pass("Successfully input the Mobile Number in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("applicantemail");
		log.info("Input the Applicant Email Address in textbox");
		log.pass("Successfully input the Email Address in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='dateOfBirth']")).sendKeys("07/19/2000");
		log.info("Select the Date Of Birth");
		log.pass("Successfully Select the Date Of Birth");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement WorkAuthorization_drp = driver.findElement(By.xpath("//select[@id='form-workAuthorization']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", WorkAuthorization_drp);
		Select st = new Select(WorkAuthorization_drp);
		Thread.sleep(2000);

		st.selectByIndex(2);
		log.info("Using Select class handling the Work Authorization dropdown");
		log.pass("Successfully click on Work Authorization dropdown and select the field");

		driver.findElement(By.xpath("//input[@formcontrolname='workAuthorizationExpiryDate']")).sendKeys("07/19/2024");
		log.info("Select the Work Authorization Expiry Date");
		log.pass("Successfully Select the Work Authorization Expiry Date");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Upload']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", uploadButton);

		uploadButton.click();

		WebElement fileinputs = driver.findElement(By.xpath("//a[@class='upload-link ng-star-inserted']"));

		String filePath = "C:\\Users\\Mukhid Khan\\.ccd.pdf";

		StringSelection strSelection = new StringSelection(filePath);

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		clipboard.setContents(strSelection, null);

		Robot robot = new Robot();

		robot.delay(300);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.delay(200);

		robot.keyRelease(KeyEvent.VK_ENTER);

		log.info("Upload the resume from system");
		log.pass("Successfully Upload the resume from system");

		driver.findElement(By.xpath("//input[@formcontrolname='linkedInURL']"))
				.sendKeys("https://www.linkedin.com/in/upendra-kumar-barikee-156540342/");
		log.info("Input the LinkedIn URL in textbox");
		log.pass("Successfully Input the LinkedIn URL in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='skills']")).sendKeys("Automation Testing");
		log.info("Input the Skills in textbox");
		log.pass("Successfully Input the Skills in textbox");

		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		log.info("Click on Save button");
		log.pass("Successfully click on save button");
		Thread.sleep(2000);

		// Get Confirmation Toaster
		// Find the dynamic element using any suitable locator (example: id)
		WebElement AddNewApplicanT_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String AddNewApplicanT_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", AddNewApplicanT_toaster);

		// Print the text to the console
		System.out.println("Add New Applicant Confirmation Toaster Message: " + AddNewApplicanT_toaster_text);
		log.info("Get Added new Applicant toaster message");
		log.pass("Successfully Get Added new Applicant toaster message in console");

		driver.findElement(By.xpath("(//u[contains(text(),'CID')])[1]")).click();
		Thread.sleep(2000);
		log.info("Select the Latest Applicant");
		log.pass("Successfully Select the Applicant");

		driver.findElement(By.xpath("//a[normalize-space()='Submit to Requirements']")).click();
		Thread.sleep(2000);
		log.info("Click on Submit to Requirement button");
		log.pass("Successfully Click on Submit to Requirement button");

		driver.findElement(By.xpath("//input[@id='form-ceipalApplicantId']")).sendKeys("100");
		log.info("Input the Pay Rate in textbox");
		log.pass("Successfully input the Pay Rate in textbox");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Frequency_drp = driver.findElement(By.xpath("//select[@id='payRateFrequency']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Frequency_drp);
		Select fre = new Select(Frequency_drp);
		Thread.sleep(2000);

		fre.selectByIndex(2);
		log.info("Using Select class handling the Frequency dropdown");
		log.pass("Successfully click on Frequency dropdown and select the field");

		driver.findElement(By.xpath("(//input[@name='selectedRequirement'])[2]")).click();
		log.info("Select the Requirement");
		log.pass("Successfully select the requirement select the field");

		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		log.info("Select the Submit button");
		log.pass("Successfully select the Submit button");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Vendor Added new Applicant");

	}

	@Test(priority = 2, description = "Change Submission Status by Requirement Agent")
	public void RequiremetAgent_StatusChange() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Change Submission Status by Requirement Agent")
				.assignCategory("Change Sumission Status");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("RequirementAgent@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/sumissions']"));
		ele1.click();
		Thread.sleep(2000);
		log.info("Click on Subbmissions Icon");
		log.pass("Successfully click on Submissios Icon");

	}
}