package TMS_Regression_Suite;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PP_Regression_Suite extends Base_Page_TMS {

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

	@Test(priority = 1, description = "Candidate Bacokout")
	public void Candidate_Backout_StatusChange() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Candidate Bacokout Submission Status changed by Requirement Agent")
				.assignCategory("Candidate Backout Sumission Status");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("RequirementAgent@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/submissions']"));
		ele1.click();
		Thread.sleep(10000);
		log.info("Click on Subbmissions Icon");
		log.pass("Successfully click on Submissios Icon");

		driver.findElement(By.xpath("//u[normalize-space()='SID1276']")).click();
		log.info("Click on Submission ID");
		log.pass("Successfully click on Submissio ID");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp = driver.findElement(By.xpath("//button[contains(text(), ' Client Submission ')]"));// (//button[@id='dropdownBasic1'])[1]
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp);
		Thread.sleep(2000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Client Submission Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp1 = driver.findElement(By.xpath("//button[contains(text(), ' Candidate Backout ')]"));// (//button[@id='dropdownBasic1'])[1]
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp1);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Candidate Backout Stauts");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.close();
		log.pass("Successfully Close the browser");
	}

	@Test(priority = 2, description = "Rejected Candidate")
	public void Candidate_Rejected_StatusChange() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Candidate Rejected Submission Status changed by Requirement Agent")
				.assignCategory("Rejected Candidate Sumission Status");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("RequirementAgent@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/submissions']"));
		ele1.click();
		Thread.sleep(10000);
		log.info("Click on Subbmissions Icon");
		log.pass("Successfully click on Submissios Icon");

		driver.findElement(By.xpath("//u[normalize-space()='SID1277']")).click();
		log.info("Click on Submission ID");
		log.pass("Successfully click on Submissio ID");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp = driver.findElement(By.xpath("//button[contains(text(), ' Client Submission ')]"));// (//button[@id='dropdownBasic1'])[1]
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp);
		Thread.sleep(2000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Client Submission Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp1 = driver.findElement(By.xpath("//button[contains(text(), ' Rejected ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp1);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Rejected Status");

		WebElement Sub_Status_drp = driver.findElement(By.xpath("//button[contains(text(), ' AM Hold ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Sub_Status_drp);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Sub-Status dropdown");
		log.pass("Successfully Selected AM Hold Sub-Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.close();
		log.pass("Successfully Close the browser");
	}

	@Test(priority = 3, description = "Joined Candidate")
	public void Candidate_Joined_StatusChange() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Candidate Joined Submission Status changed by Requirement Agent")
				.assignCategory("Joined Candidate Sumission Status");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("RequirementAgent@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/submissions']"));
		ele1.click();
		Thread.sleep(10000);
		log.info("Click on Subbmissions Icon");
		log.pass("Successfully click on Submissios Icon");

		driver.findElement(By.xpath("//u[normalize-space()='SID1278']")).click();
		log.info("Click on Submission ID");
		log.pass("Successfully click on Submissio ID");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp = driver.findElement(By.xpath("//button[contains(text(), ' Client Submission ')]"));// (//button[@id='dropdownBasic1'])[1]
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp);
		Thread.sleep(2000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Client Submission Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		Thread.sleep(1000);
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp1 = driver.findElement(By.xpath("//button[contains(text(), ' Interview ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp1);
		Thread.sleep(4000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Interview Status");

		WebElement Sub_Status_drp = driver.findElement(By.xpath("//button[contains(text(), ' Client Interview ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Sub_Status_drp);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Sub-Status dropdown");
		log.pass("Successfully Selected Client Interview Sub-Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Cnf_Status_drpV = driver.findElement(By.xpath("//button[contains(text(), ' Confirmation ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Cnf_Status_drpV);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Confirmation Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Joined_Status_drpV = driver.findElement(By.xpath("//button[contains(text(), ' Joined ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Joined_Status_drpV);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully Selected Joined Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.close();
		log.pass("Successfully Close the browser");
	}

	@Test(priority = 4, description = "Not Joined Candidate")
	public void Candidate_Not_Joined_StatusChange() throws InterruptedException, AWTException {

		ExtentTest log = extent.createTest("Candidate Not Joined Submission Status changed by Requirement Agent")
				.assignCategory("Not Joined Candidate Sumission Status");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("RequirementAgent@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(8000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/submissions']"));
		ele1.click();
		Thread.sleep(10000);
		log.info("Click on Subbmissions Icon");
		log.pass("Successfully click on Submissios Icon");

		driver.findElement(By.xpath("//u[normalize-space()='SID1279']")).click();
		log.info("Click on Submission ID");
		log.pass("Successfully click on Submissio ID");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp = driver.findElement(By.xpath("//button[contains(text(), ' Client Submission ')]"));// (//button[@id='dropdownBasic1'])[1]
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp);
		Thread.sleep(2000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully select Client Submission Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		Thread.sleep(1000);
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Subm_Status_drp1 = driver.findElement(By.xpath("//button[contains(text(), ' Interview ')]"));// (//button[@id='dropdownBasic1'])[1]
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Subm_Status_drp1);
		Thread.sleep(4000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully select Interview Status");

		WebElement Sub_Status_drp = driver.findElement(By.xpath("//button[contains(text(), ' Client Interview ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Sub_Status_drp);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Sub-Status dropdown");
		log.pass("Successfully select Client Interview Sub-Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Cnf_Status_drpV = driver.findElement(By.xpath("//button[contains(text(), ' Confirmation ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Cnf_Status_drpV);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully select Confirmation Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.findElement(By.xpath("//a[normalize-space()='Edit']")).click();
		log.info("Click on Edit button");
		log.pass("Successfully click on Edit Button");

		// Work Authorization Drop down
		// Implement select class for handling the drop down
		WebElement Not_Joined_Status_drpV = driver.findElement(By.xpath("//button[contains(text(), ' Not Joined ')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Not_Joined_Status_drpV);
		Thread.sleep(1000);
		log.info("Using Select class handling the Submission Status dropdown");
		log.pass("Successfully select Not Joined Status");

		driver.findElement(By.xpath("//a[normalize-space()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully Click on Save button");

		driver.close();
		log.pass("Successfully Close the browser");
	}
}
