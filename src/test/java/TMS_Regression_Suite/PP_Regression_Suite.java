package TMS_Regression_Suite;

import java.time.Duration;

import org.openqa.selenium.By;
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

	@Test(priority = 1, description = "Admin Add new Tier Rule")
	public void AddnewTireRule_ByAdmin() {

		ExtentTest log = extent.createTest("Admin Add new Tier Rule").assignCategory("Add new Tire Rule");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@root.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123Pa$$word!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		log.info("Login with valid credentials");
		log.pass("Successfully login the application");

		WebElement ele1 = driver.findElement(By.xpath("//a[@href='/tierrules']"));
		ele1.click();
		log.info("Click on Tier Rules Icon");
		log.pass("Successfully click on Tier Rules Icon");

		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		log.info("Click on Add New button");
		log.pass("Successfully Click on Add New button");

		driver.findElement(By.xpath("//input[@id='form-tierLevel']")).sendKeys("Auto Tier 01");
		log.info("Input the Tier Level name in text box");
		log.pass("Successfully input tier level path in Textbox");

		driver.findElement(By.xpath("//input[@id='form-frequency']")).sendKeys("01");
		log.info("Input the Tier Level Frequency hours in text box");
		log.pass("Successfully input tier level Frequency hours in Textbox");

		driver.findElement(By.xpath("//input[@id='form-minutes']")).sendKeys("01");
		log.info("Input the Tier Level Frequency minutes in text box");
		log.pass("Successfully input tier level Frequency minutes in Textbox");

		driver.findElement(By.xpath("//button[text()='Save']")).click();
		log.info("Click on Save button");
		log.pass("Successfully click on Save button");

	}
}
