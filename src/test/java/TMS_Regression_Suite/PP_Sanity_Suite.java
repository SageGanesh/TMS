package TMS_Regression_Suite;

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

		ExtentTest log = extent.createTest("Vendor Manager Add new Vendor")
				.assignCategory("Approve the RMG Onboard");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("VendorManager@sageitinc.com");
		//driver.findElement(By.xpath("//input[@placeholder='Enter password']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/vendors']"));
		ele1.click();
		Thread.sleep(5000);
		log.info("Click on Onboards Icon");
		log.pass("Successfully click on Onboards Icon");

		driver.findElement(By.xpath("//a[contains(text(),'Add New')]")).click();
		Thread.sleep(2000);
		log.info("Click on Add New button");
		log.pass("Successfully click on Add New button");
		
		driver.findElement(By.xpath("//input[@formcontrolname='vendorName']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");
		
		driver.findElement(By.xpath("//input[@formcontrolname='vendorPOCName']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");
		
		driver.findElement(By.xpath("//input[@formcontrolname='contactNumber']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");
		
		driver.findElement(By.xpath("//input[@formcontrolname='emailAddress']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");
		
		//Tier Level Drop down
		
		// Country Drop down
		
		driver.findElement(By.xpath("//input[@formcontrolname='otherState']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");
		
		driver.findElement(By.xpath("//input[@formcontrolname='city']")).sendKeys("Ramesham");
		log.info("Input the Recruiter Name in textbox");
		log.pass("Successfully input the Recruiter Name in textbox");



		driver.close();
		log.pass("Successfully Close the browser");
		log.pass("Successfully Approve the RMG onboards by Sales Manager.");
	}
}
