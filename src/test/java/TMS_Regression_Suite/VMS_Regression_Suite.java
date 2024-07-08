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

public class VMS_Regression_Suite extends Base_Page_TMS {

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
	 * Supplier_Submit_theInvoice(): This method is used to Submit the invoice.
	 * 
	 * Steps: 
	 * 
	 *      1. Open the browser 
	 *      2. Login the application(Supplier) 
	 *      3. Successfully open Dashboard page 
	 *      4. Click on Invoices 
	 *      5. Click on Add New 
	 *      6. Input All Mandatory fields
	 *      7. Click on Submit button 
	 *      8. Successfully submit the invoice
	 *      9. Capture URN Number 
	 *      10. Click on Close button. 
	 *      11. Close the browser.
	 */

	@Test(priority = 1, description = "Submit the invoice")
	public void Supplier_Submit_theInvoice() throws InterruptedException {

		ExtentTest log = extent.createTest("Submit the invoice by supplier").assignCategory("Submit the invoice");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automationsupplier@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/invoices']"));
		ele1.click();
		Thread.sleep(2000);
		log.info("Click on Invoices Icon");
		log.pass("Successfully click on Invoices Icon");

		driver.findElement(By.xpath("//a[text()=' Add New ']")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");

		// Implement select class for handling the dropdown
		WebElement WorkOrder_drp = driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-new/div/div/div/form/div[1]/div/select"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", WorkOrder_drp);
		Select select = new Select(WorkOrder_drp);
		Thread.sleep(2000);

		select.selectByIndex(1);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Work Orders dropdown");
		log.pass("Successfully click on Work Orders dropdown");

		// Implement select class for handling the dropdown
		WebElement InvoiceType_drp = driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/app-vertical/div/div/div/app-new/div/div/div/form/div[2]/div[1]/select"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", InvoiceType_drp);
		Select st = new Select(InvoiceType_drp);
		// Thread.sleep(2000);

		st.selectByIndex(2);
		// Thread.sleep(2000);
		log.info("Using Select class handling the Invoice Type dropdown");
		log.pass("Successfully click on Invoice Type dropdown");

		driver.findElement(By.xpath("//input[@placeholder='Invoice No.']")).sendKeys("95874");
		log.info("Input the Invoice number in textbox");
		log.pass("Successfully input the Invoice number in textbox");

		driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).sendKeys("02/15/2024");
		log.info("Select the Start Date");
		log.pass("Successfully Select the Start Date");

		driver.findElement(By.xpath("//input[@formcontrolname='endDate']")).sendKeys("03/07/2024");
		log.info("Select the End Date");
		log.pass("Successfully Select the End Date");

		driver.findElement(By.xpath("//input[@id='form-totalAmount']")).sendKeys("26");
		log.info("Input the Total Amount in textbox");
		log.pass("Successfully input the Total Amount in textbox");

		WebElement elemenTOclick = driver.findElement(By.xpath("//button[@type='submit'][text()=' Submit ']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elemenTOclick).click().perform();

//		try {
//			WebElement submit_btn=driver.findElement(By.xpath("//button[text()=' Submit ']"));
//			submit_btn.click();
//        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
//            // Handle the exception
//            System.out.println("Element click intercepted. Handling the exception...");
//        }
		log.info("Click on Submit button");
		log.pass("Successfully click on Submit button");

		// Find the dynamic element using any suitable locator (example: id)
		WebElement dynamicElement = driver.findElement(By.xpath("//p[contains(text(),'SAGEIT-')]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String dynamicElementText = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", dynamicElement);

		// Print the text to the console
		System.out.println("Dynamic Element Text: " + dynamicElementText);
		log.info("Get the dynamic URN value and print in console");
		log.pass("Successfully Get the dynamic URN value and print in console");

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(2000);
		log.info("Click on Close button");
		log.pass("Successfully click on Close button");

		driver.close();
		log.pass("Successfully close the browser.");
		log.pass("Successfully Submit the Invoice by Supplier");
	}

	/*
	 * Accounts_Paid_theInvoice(): This method is used to Accept, In Process, Paid the Invoice by Accounts.
	 *
	 */
	@Test(priority = 2, description = "Paid the invoice")
	public void Accounts_Paid_theInvoice() throws InterruptedException {

		ExtentTest log = extent.createTest("Accept, In Process, Paid the Invoice by Accounts")
				.assignCategory("Accept, In Process, Paid the Invoice");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automationaccounts@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/invoices']")); // //i[@class='bbx bx bx-detail
																					// ng-star-inserted']
		ele1.click();
		Thread.sleep(2000);
		log.info("Click on Invoices Icon");
		log.pass("Successfully click on Invoices Icon"); // //p[contains(text(),'SAGEIT-')]

		driver.findElement(By.xpath("//a[contains(text(),'SAGEIT-')]")).click();
		Thread.sleep(2000);
		log.info("Click on URN Hyperlink");
		log.pass("Successfully click on URN Hyperlink");

		driver.findElement(By.xpath("//button[text()=' Accept ']")).click(); // //button[text()=' In Process ']
		Thread.sleep(2000);
		log.info("Click on Accept button");
		log.pass("Successfully Accept the invoice");

		driver.findElement(By.xpath("//button[text()=' In Process ']")).click();
		Thread.sleep(2000);
		log.info("Click on Accept button");
		log.pass("Successfully Reject the Invoice");

		driver.findElement(By.xpath("//button[text()=' Paid ']")).click();
		Thread.sleep(2000);
		log.info("Click on Paid button");
		log.pass("Successfully Paid the Invoice");

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(2000);
		log.info("Click on Close button");
		log.pass("Successfully click on Close button");

		driver.close();
		log.pass("Successfully close the browser.");
		log.pass("Successfully Paid the Invoice");

	}

	/*
	 * Accounts_Reject_theInvoice(): This method is used to Reject the Invoice by Accounts.
	 *
	 */
	@Test(priority = 3, description = "Reject the invoice")
	public void Accounts_Reject_theInvoice() throws InterruptedException {

		ExtentTest log = extent.createTest("Reject the invoice by Accounts").assignCategory("Reject the invoice");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automationaccounts@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/invoices']")); // //i[@class='bbx bx bx-detail
																					// ng-star-inserted']
		ele1.click();
		Thread.sleep(2000);
		log.info("Click on Invoices Icon");
		log.pass("Successfully click on Invoices Icon");

		driver.findElement(By.xpath("//a[contains(text(),'SAGEIT-')]")).click();
		Thread.sleep(2000);
		log.info("Click on URN Hyperlink");
		log.pass("Successfully click on URN Hyperlink");

		driver.findElement(By.xpath("//button[text()=' Reject ']")).click();
		Thread.sleep(2000);
		log.info("Click on Reject button");
		log.pass("Successfully click on Reject button");

		// Implement select class for handling the dropdown
		WebElement Rejectreason_drp = driver.findElement(By.xpath("//*[@id=\"form-rejectionreason\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Rejectreason_drp);
		Select select = new Select(Rejectreason_drp);
		Thread.sleep(2000);

		select.selectByIndex(1);
		// Thread.sleep(2000);
		log.info("Using Select class handling Reject Reason dropdown present on Popup");
		log.pass("Successfully click on Reject Reason dropdown present on Popup");

		driver.findElement(By.xpath("//button[@type='button'][text()=' Reject ']")).click();
		Thread.sleep(2000);
		log.info("Click on Reject button present on Reject Invoice with reason POP up");
		log.pass("Successfully click on Reject button present on Reject Invoice with reason POP up");

		// Find the dynamic element using any suitable locator (example: id)
		WebElement reject_toaster = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));

		// Use JavaScriptExecutor to retrieve text of the element
		String reject_toast_text = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].textContent;", reject_toaster);

		// Print the text to the console
		System.out.println("Reject the Invoice toaster message: " + reject_toast_text);
		log.info("Get reject the Invoice toaster message");
		log.pass("Successfully Get the Reject the Invoice toaster message in console");

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(2000);
		log.info("Click on Close button");
		log.pass("Successfully click on Close button");

		driver.close();
		log.pass("Successfully close the browser.");
		log.pass("Successfully Reject the Invoice by Accounts");
	}

	/*
	 * Supplier_Resubmit_theInvoice(): This method is used to Resubmit the Invoice by Supplier.
	 *
	 */
	@Test(priority = 4, description = "Resubmit the Invoice")
	public void Supplier_Resubmit_theInvoice() throws InterruptedException {

		ExtentTest log = extent.createTest("Resubmit the invoice by Supplier").assignCategory("Resubmit the invoice");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automationsupplier@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/invoices']")); // //i[@class='bbx bx bx-detail
																					// ng-star-inserted']
		ele1.click();
		Thread.sleep(2000);
		log.info("Click on Invoices Icon");
		log.pass("Successfully click on Invoices Icon");

		driver.findElement(By.xpath("//a[contains(text(),'SAGEIT-')]")).click();
		Thread.sleep(2000);
		log.info("Click on URN Number Hyperlink");
		log.pass("Successfully click on URN Number Hyperlink");

		driver.findElement(By.xpath("//button[text()='Edit']")).click();
		Thread.sleep(2000);
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit button");

		driver.findElement(By.xpath("//textarea[@id='form-comment']")).sendKeys("Resubmit the Invoice");
		log.info("Input the Comment for Resubmit the Invoice in textbox");
		log.pass("Successfully input the Comment for Resubmit the Invoice in textbox"); //

		driver.findElement(By.xpath("//button[text()='Close']")).click();
		Thread.sleep(2000);
		log.info("Click on Close button");
		log.pass("Successfully click on Close button");

		driver.close();
		log.pass("Successfully close the browser.");
		log.pass("Successfully Resubmit the Invoice by Supplier");
	}
}
	
	
	
