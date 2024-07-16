package TMS_Regression_Suite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ONB_Regression_Suite extends Base_Page_TMS {

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
	 * SalesSubmit_theRMG(): This method is use to submit the RMG onboard by Sales.
	 * 
	 * Steps:
	 *  1. Open the Browser
	 *  2. Login the application(Sales)
	 *  3. Successfully open the Dashboard page
	 *  4. Click on Onboards
	 *  5. Click on Add New
	 *  6. Add all Mandatory placement details
	 *  7. Add Client details
	 *  8. Add Mandatory End Client details
	 *  9. Add Consultant details
	 * 10. Click On save button
	 * 11. Click on Submit button
	 * 12. Get the toaster message.
	 * 13. Successfully submit the RMG onboards
	 * 14. Close the browser
	 * 
	 */
	
	@Test(priority = 1, description = "Submit RMG Onboards")
	public void Sales_Submit_theOnboard() throws InterruptedException {

		ExtentTest log = extent.createTest("Submit RMG Onboards by Sales").assignCategory("Submit the RMG Onboard");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Sales@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/onboards']"));
		ele1.click();
		Thread.sleep(5000);
		log.info("Click on Onboards Icon");
		log.pass("Successfully click on Onboards Icon");

		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		// Mandatory Placement Details
		// Implement select class for handling the dropdown
		WebElement Branch_drp = driver.findElement(By.xpath("//select[@title='Select Branch']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Branch_drp);
		Select select = new Select(Branch_drp);
		Thread.sleep(2000);

		select.selectByIndex(1);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Branch dropdown");
		log.pass("Successfully click on Branch dropdown and select the field");

		driver.findElement(By.xpath("//input[@formcontrolname='title'][@id='formrow-firstname-input']"))
				.sendKeys("Automation Testing");
		log.info("Input the Title in textbox");
		log.pass("Successfully input the Title in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='recruiterName']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='leadName']")).sendKeys("Suresham");
		log.info("Input the Lead Name in textbox");
		log.pass("Successfully input the Lead Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='managerName']")).sendKeys("Nitin Vable");
		log.info("Input the Manager Name in textbox");
		log.pass("Successfully input the Manager Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='selectionDate']")).sendKeys("07/19/2024");
		log.info("Select the Selection Dat");
		log.pass("Successfully Select the Selection Date");

		driver.findElement(By.xpath("//input[@formcontrolname='tentativeStartDate']")).sendKeys("07/26/2024");
		log.info("Select the Tentative Start Date");
		log.pass("Successfully select the Tentative Start Date");

		driver.findElement(By.xpath("//input[@formcontrolname='billRate']")).clear();
		log.pass("Clear the text field");
		driver.findElement(By.xpath("//input[@formcontrolname='billRate']")).sendKeys("54");
		log.info("Input the Bill Rate in textbox");
		log.pass("Successfully input the Bill Rate in textbox");

		// Mandatory Client Details

		// Implement select class for handling the dropdown
		WebElement Clientname_drp = driver.findElement(By.xpath("//select[@id='form-clients']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Clientname_drp);
		Select s = new Select(Clientname_drp);
		Thread.sleep(2000);

		s.selectByIndex(4);
		Thread.sleep(2000);
		log.info("Using Select class handling the Client Name dropdown");
		log.pass("Successfully click on Client Name dropdown and select the field");

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[2]/div/div[4]/div/div[2]/div/div/div/button"))
				.click();
		Thread.sleep(2000);
		log.info("Click on '+' button to add a Contacts");
		log.pass("Successfully click on '+' button to add a Contacts");

		// Implement select class for handling the dropdown
		WebElement Clientcontact_drp = driver.findElement(By.xpath("//select[@id='form-client-contact']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Clientcontact_drp);
		Select st = new Select(Clientcontact_drp);
		Thread.sleep(2000);

		st.selectByIndex(1);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Client Contact dropdown");
		log.pass("Successfully click on Client Contact dropdown and select the field");

		// Mandatory End Client Details

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[2]/div/div[6]/div/div[1]/div[1]/input"))
				.sendKeys("Prem");
		log.info("Input the End Client Name in text box");
		log.pass("Successfully input the End Client Name in text box");

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[2]/div/div[6]/div/div[1]/div[4]/input"))
				.sendKeys("Hyderabad");
		log.info("Input the End Client Address in text box");
		log.pass("Successfully Input the End Client Address in text box");

		// Implement select class for handling the dropdown
		WebElement Consultantemp_drp = driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[2]/div/div[7]/div/div/div[1]/select"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Consultantemp_drp);
		Select sel = new Select(Consultantemp_drp);
		Thread.sleep(2000);

		sel.selectByIndex(1);
		Thread.sleep(2000);
		log.info("Using Select class handling the Consultant Employer dropdown");
		log.pass("Successfully click on Consultant Employer dropdown and select the field");

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[2]/div/div[7]/div/div/div[2]/input"))
				.sendKeys("Nagesh");
		Thread.sleep(3000);
		log.info("Input the Consultant Name in text box");
		log.pass("Successfully Input the Consultant Name in text box");

		driver.findElement(By.xpath("//div[@class='col-4']//input[@id='formrow-firstname-input']"))
				.sendKeys("9876543210");
		Thread.sleep(4000);
		log.info("Input the Consultant Phone Number in text box");
		log.pass("Successfully Input the Consultant Phone Number in text box");

		WebElement savebtn = driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[1]/div/div/div/div/div/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", savebtn);
		log.info("Click on Save button");
		log.pass("Successfully click on Save button");

		driver.findElement(By.xpath("//button[text()=' Submit ']")).click();
		Thread.sleep(2000);
		log.info("Click on Submit button");
		log.pass("Successfully click on Submit button");

		// Find the dynamic element using any suitable locator
		WebElement submitOnboard_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String submitOnboard_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", submitOnboard_toaster);

		// Print the text to the console
		System.out.println("Reject the Invoice toaster message: " + submitOnboard_toaster_text);
		log.info("Get Submit the RMG onboard toaster message");
		log.pass("Successfully Get Submit the RMG onboard toaster message in console");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully submit the RMG onboards by Sales.");
	}

	/*
	 * SalesManager_Approve_theOnboard(): This method is use to approve the RMG onboard by Sales Manager.
	 * 
	 * Steps:
	 *  1. Open the Browser.
	 *  2. Login the application(Sales Manager).
	 *  3. Successfully open the Dashboard page.
	 *  4. Click on Onboards.
	 *  5. Select Submitted Onboard.
	 *  6. Click on Approve button.
	 *  7. Get successful toaster message.
	 */
	@Test(priority = 2, description = "Approve the RMG onboard")
	public void SalesManager_Approve_theOnboard() throws InterruptedException {

		ExtentTest log = extent.createTest("Approve RMG Onboard by SalesManager")
				.assignCategory("Approve the RMG Onboard");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("salesmanager@testing.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/onboards']"));
		ele1.click();
		Thread.sleep(5000);
		log.info("Click on Onboards Icon");
		log.pass("Successfully click on Onboards Icon");

		driver.findElement(By.xpath("//a[contains(text(),'OB')]")).click();
		Thread.sleep(2000);
		log.info("Click on Approve button");
		log.pass("Successfully click on Approve button");

		driver.findElement(By.xpath("//button[text()=' Approve ']")).click();
		Thread.sleep(2000);
		log.info("Click on Approve button");
		log.pass("Successfully click on Approve button");

		// Find the dynamic element using any suitable locator
		WebElement submitOnboard_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String submitOnboard_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", submitOnboard_toaster);

		// Print the text to the console
		System.out.println("Reject the Invoice toaster message: " + submitOnboard_toaster_text);
		log.info("Get Approve the RMG Onboard toaster message");
		log.pass("Successfully Get Approve the RMG Onboard message in console");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Approve the RMG onboards by Sales Manager.");
	}

	/*
	 * SalesContract_Complete_theOnboard(): This method is use to complete the RMG onboard by Sales Contract.
	 * 
	 * Steps:
	 *  1. Open the Browser.
	 *  2. Login the application(Sales Contract).
	 *  3. Successfully open the Dashboard page.
	 *  4. Click on Onboards.
	 *  5. Select Approved Onboard.
	 *  6. Click on Initiate button.
	 *  7. Click on In Process button.
	 *  8. Click on Complete button.
	 *  9. Get successful toaster message.
	 */
	@Test(priority = 3, description = "Complete the RMG onboard")
	public void SalesContract_Complete_theOnboard() throws InterruptedException {

		ExtentTest log = extent.createTest("Complete RMG Onboard by SalesContracts")
				.assignCategory("Complete the RMG Onboard");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("contracts@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/onboards']"));
		ele1.click();
		Thread.sleep(5000);
		log.info("Click on Onboards Icon");
		log.pass("Successfully click on Onboards Icon");

		driver.findElement(By.xpath("//a[contains(text(),'OB')]")).click();
		Thread.sleep(2000);
		log.info("Select the Onboard");
		log.pass("Successfully Select the onboard");

		driver.findElement(By.xpath("//button[text()=' Initiate ']")).click();
		Thread.sleep(2000);
		log.info("Click on Initiate button");
		log.pass("Successfully click on Initiate button");

		driver.findElement(By.xpath("//button[text()=' In Process ']")).click();
		Thread.sleep(2000);
		log.info("Click on In Process button");
		log.pass("Successfully click on In Process button");

		driver.findElement(By.xpath("//button[text()=' Complete ']")).click();
		Thread.sleep(2000);
		log.info("Click on Complete button");
		log.pass("Successfully click on Complete button");

		// Find the dynamic element using any suitable locator
		WebElement submitOnboard_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String submitOnboard_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", submitOnboard_toaster);

		// Print the text to the console
		System.out.println("Reject the Invoice toaster message: " + submitOnboard_toaster_text);
		log.info("Get Complete RMG ONB toaster message");
		log.pass("Successfully Get Complete RMG ONB toaster message in console");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Complete the RMG onboards by Sales Contracts.");
	}
	
	/*
	 * RecruitmentSubmit_theTalentSolutions(): This method is use to submit the RMG onboard.
	 * 
	 * Steps:
	 *  1. Open the Browser
	 *  2. Login the application(Recruitment)
	 *  3. Successfully open the Dashboard page
	 *  4. Click on Onboards
	 *  5. Click on Add New
	 *  6. Add all Mandatory placement details
	 *  7. Add Client details
	 *  8. Add Mandatory End Client details
	 *  9. Add Consultant details
	 * 10. Click On save button
	 * 11. Click on Submit button
	 * 12. Get the toaster message.
	 * 13. Successfully submit the RMG onboards
	 * 14. Close the browser
	 * 
	 */
	
	@Test(priority = 4, description = "Submit Talent Solution Onboards")
	public void Recruitment_Submit_theOnboard() throws InterruptedException {

		ExtentTest log = extent.createTest("Submit Talent Solution Onboard by Recruitment")
				.assignCategory("Submit the Talent Solution Onboard");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Recruitment@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/onboards']"));
		ele1.click();
		Thread.sleep(5000);
		log.info("Click on Onboards Icon");
		log.pass("Successfully click on Onboards Icon");

		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		// Mandatory Placement Details
		// Implement select class for handling the dropdown
		WebElement Branch_drp = driver.findElement(By.xpath("//select[@title='Select Branch']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Branch_drp);
		Select select = new Select(Branch_drp);
		Thread.sleep(2000);

		select.selectByIndex(1);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Branch dropdown");
		log.pass("Successfully click on Branch dropdown and select the field");

		driver.findElement(By.xpath("//input[@formcontrolname='title'][@id='formrow-firstname-input']"))
				.sendKeys("Automation Testing");
		log.info("Input the Title in textbox");
		log.pass("Successfully input the Title in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='recruiterName']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='leadName']")).sendKeys("Suresham");
		log.info("Input the Lead Name in textbox");
		log.pass("Successfully input the Lead Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='managerName']")).sendKeys("Nitin Vable");
		log.info("Input the Manager Name in textbox");
		log.pass("Successfully input the Manager Name in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='selectionDate']")).sendKeys("07/19/2024");
		log.info("Select the Selection Dat");
		log.pass("Successfully Select the Selection Date");

		driver.findElement(By.xpath("//input[@formcontrolname='tentativeStartDate']")).sendKeys("07/26/2024");
		log.info("Select the Tentative Start Date");
		log.pass("Successfully select the Tentative Start Date");

		driver.findElement(By.xpath("//input[@formcontrolname='billRate']")).clear();
		log.pass("Clear the text field");
		driver.findElement(By.xpath("//input[@formcontrolname='billRate']")).sendKeys("54");
		log.info("Input the Bill Rate in textbox");
		log.pass("Successfully input the Bill Rate in textbox");

		// Mandatory Client Details

		// Implement select class for handling the dropdown
		WebElement Clientname_drp = driver.findElement(By.xpath("//select[@id='form-clients']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Clientname_drp);
		Select s = new Select(Clientname_drp);
		Thread.sleep(2000);

		s.selectByIndex(4);
		Thread.sleep(2000);
		log.info("Using Select class handling the Client Name dropdown");
		log.pass("Successfully click on Client Name dropdown and select the field");

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[2]/div/div[4]/div/div[2]/div/div/div/button"))
				.click();
		Thread.sleep(2000);
		log.info("Click on '+' button to add a Contacts");
		log.pass("Successfully click on '+' button to add a Contacts");

		// Implement select class for handling the dropdown
		WebElement Clientcontact_drp = driver.findElement(By.xpath("//select[@id='form-client-contact']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Clientcontact_drp);
		Select st = new Select(Clientcontact_drp);
		Thread.sleep(2000);

		st.selectByIndex(1);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Client Contact dropdown");
		log.pass("Successfully click on Client Contact dropdown and select the field");

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[2]/div/div[6]/div/div[1]/div[1]/input"))
				.sendKeys("Prem Talent");
		log.info("Input the End Client Name in text box");
		log.pass("Successfully input the End Client Name in text box");

		driver.findElement(By.xpath("//div[@class='col-md-4 mb-2']//input[@id='formrow-firstname-input']"))
				.sendKeys("Prem Talent");
		log.info("Input the Consultant Name in text box");
		log.pass("Successfully input the Consultant Name in text box");

		driver.findElement(By.xpath("//div[@class='col-4']//input[@id='formrow-firstname-input']"))
				.sendKeys("7894561230");
		log.info("Input the Consultant Phone in text box");
		log.pass("Successfully input the Consultant Phone in text box");

		// //input[@formcontrolname='email']
		driver.findElement(By.xpath(
				"//*[@id=\"layout-wrapper\"]/div/div/app-onboard-new/div/form/div[2]/div/div[7]/div/div[1]/div[3]/input"))
				.sendKeys("abc@gmail.com");
		log.info("Input the Consultant Email in text box");
		log.pass("Successfully input the Consultant Email in text box");

		// Implement select class for handling the dropdown
		WebElement visaStatus_drp = driver.findElement(By.xpath(
				"//select[@class='form-select ng-untouched ng-pristine ng-valid'][@formcontrolname='visaStatus']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", visaStatus_drp);
		Select selec = new Select(visaStatus_drp);
		Thread.sleep(2000);

		selec.selectByIndex(2);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Visa Status dropdown");
		log.pass("Successfully click on Visa Status dropdown and select the field");

		driver.findElement(By.xpath("//input[@formcontrolname='payStubRate']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='payStubRate']")).sendKeys("654");
		log.info("Input the Consultant Pay Stub Rate in text box");
		log.pass("Successfully input the Consultant Pay Stub Rate in text box");

		driver.findElement(By.xpath("//input[@placeholder='000-00-0000']")).sendKeys("123654789");
		log.info("Input the SSN Number in text box");
		log.pass("Successfully input the SSN Number in text box");

		driver.findElement(By.xpath("//input[@formcontrolname='dateOfBirth']")).sendKeys("10/28/2024");
		log.info("Select the Consultant Date Of Birth");
		log.pass("Successfully select the Consultant Date of Birth");

		driver.findElement(By.xpath("//div[@class='col-md-12 mb-2']//input[@type='text']")).sendKeys("Hyderabad");
		log.info("Input the Consultant Address in text box");
		log.pass("Successfully input the Consultant Address in text box");

		WebElement savebtn = driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-onboard-new/div/form/div[1]/div/div/div/div/div/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", savebtn);
		log.info("Click on Save button");
		log.pass("Successfully click on Save button");

		driver.findElement(By.xpath("//button[text()=' Submit ']")).click();
		Thread.sleep(2000);
		log.info("Click on Submit button");
		log.pass("Successfully click on Submit button");

		// Find the dynamic element using any suitable locator (example: id)
		WebElement submitOnboard_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String submitOnboard_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", submitOnboard_toaster);

		// Print the text to the console
		System.out.println("Submit Onboard toaster message: " + submitOnboard_toaster_text);
		log.info("Get submitted Onboard toaster message");
		log.pass("Successfully Get submitted onboard toaster message in console");

		driver.navigate().refresh();

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully submit the Talent Solution Onboard by Recruitment.");
	}

	/*
	 * RecruitmentManager_Approve_theOnboard(): This method is use to approve the Talent Solution onboard by Recruitment Manager.
	 * 
	 * Steps:
	 *  1. Open the Browser.
	 *  2. Login the application(Recruitment Manager).
	 *  3. Successfully open the Dashboard page.
	 *  4. Click on Onboards.
	 *  5. Select Submitted Onboard.
	 *  6. Click on Approve button.
	 *  7. Get successful toaster message.
	 */
	@Test(priority = 5, description = "Approve the Talent Solution onboard")
	public void RecruitmentManager_Approve_theOnboard() throws InterruptedException {

		ExtentTest log = extent.createTest("Approve Talent Solution Onboard by Recruitment Manager")
				.assignCategory("Approve the Talent Solution Onboard");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("recruitmentmanager@testing.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/onboards']"));
		ele1.click();
		Thread.sleep(5000);
		log.info("Click on Onboards Icon");
		log.pass("Successfully click on Onboards Icon");

		driver.findElement(By.xpath("//a[contains(text(),'OB')]")).click();
		Thread.sleep(2000);
		log.info("Click on Approve button");
		log.pass("Successfully click on Approve button");

		driver.findElement(By.xpath("//button[text()=' Approve ']")).click();
		Thread.sleep(2000);
		log.info("Click on Approve button");
		log.pass("Successfully click on Approve button");

		// Find the dynamic element using any suitable locator
		WebElement submitOnboard_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String submitOnboard_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", submitOnboard_toaster);

		// Print the text to the console
		System.out.println("Approve Talent Solution onboard toaster message: " + submitOnboard_toaster_text);
		log.info("Get Approve the Talent Solution Onboard toaster message");
		log.pass("Successfully Get Approve the Talent Solution Onboard message in console");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Approve the Talent Solution onboard by Recruitment Manager.");
	}

	/*
	 * RecrutimentContract_Complete_theOnboard(): This method is use to complete the Talent Solution onboard by Recruitment Contract.
	 * 
	 * Steps:
	 *  1. Open the Browser.
	 *  2. Login the application(Recruitment Contract).
	 *  3. Successfully open the Dashboard page.
	 *  4. Click on Onboards.
	 *  5. Select Approved Onboard.
	 *  6. Click on Initiate button.
	 *  7. Click on In Process button.
	 *  8. Click on Complete button.
	 *  9. Get successful toaster message.
	 *  
	 */
	@Test(priority = 6, description = "Complete the Talent Solution onboard")
	public void RecrutimentContract_Complete_theOnboard() throws InterruptedException {

		ExtentTest log = extent.createTest("Complete Talent Solution Onboard by Contracts Recruitment")
				.assignCategory("Complete the Talent Solution Onboard");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("contracts@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/onboards']"));
		ele1.click();
		Thread.sleep(5000);
		log.info("Click on Onboards Icon");
		log.pass("Successfully click on Onboards Icon");

		driver.findElement(By.xpath("//a[contains(text(),'OB')]")).click();
		Thread.sleep(2000);
		log.info("Select the Onboard");
		log.pass("Successfully Select the onboard");

		driver.findElement(By.xpath("//button[text()=' Initiate ']")).click();
		Thread.sleep(2000);
		log.info("Click on Initiate button");
		log.pass("Successfully click on Initiate button");

		driver.findElement(By.xpath("//button[text()=' In Process ']")).click();
		Thread.sleep(2000);
		log.info("Click on In Process button");
		log.pass("Successfully click on In Process button");

		driver.findElement(By.xpath("//button[text()=' Complete ']")).click();
		Thread.sleep(2000);
		log.info("Click on Complete button");
		log.pass("Successfully click on Complete button");

		// Find the dynamic element using any suitable locator
		WebElement submitOnboard_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String submitOnboard_toaster_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", submitOnboard_toaster);

		// Print the text to the console
		System.out.println("Reject the Invoice toaster message: " + submitOnboard_toaster_text);
		log.info("Get Complete RMG ONB toaster message");
		log.pass("Successfully Get Complete RMG ONB toaster message in console");

		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Complete the RMG onboards by Sales Contracts.");
	}
}
