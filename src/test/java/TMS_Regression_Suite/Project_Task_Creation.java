package TMS_Regression_Suite;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Project_Task_Creation extends Base_Page_TMS {

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

	  @Test(priority = 5, description = "TimeSheet approval work flow :") public
	  void time_sheet_approval_basic_flow_in_TMS() throws InterruptedException,
	  IOException {
	  
			ExtentTest test1 = extent.createTest("time sheet should be approved by given approver : ")
					.assignCategory("TimeSheet_Approval");
			test1.getStatus();
			test1.info("timesheet approval");
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mkothakapa@sageitinc.com");

			driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");

			driver.findElement(By.xpath("//button[@type='submit']")).click();

			WebElement element1 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='inlineRadio2']")));
			Thread.sleep(6000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

			WebElement element2 = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='09/01/2023 - 09/30/2023'][1]")));
			Thread.sleep(6000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

			
			WebElement element3 = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='textbox']")));
			Thread.sleep(6000);
			element3.sendKeys("TimeSheet Summary");

			driver.findElement(By.xpath("//button[text()='Approve']")).click();

			Utility ut = new Utility(driver);

			ut.ScreenShot("timesheet_approved");

			extent.flush();

	  }
	  
	   
	 @Test(priority = 2, description = "should be able to login with basic user and should be able to submit the Timesheet")
	public void login_with_basic_valid_credentials_in_TMS() throws InterruptedException, IOException {

		ExtentTest log = extent.createTest(
				"the user should be able to login with basic user and " + "should be able to submit the timesheet")
				.assignCategory("TimeSheet_submission");
		System.out.println(log.getStatus());
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("gganesh@sageitinc.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Sageitinc@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Projects ' and @type='button' and @data-toggle='dropdown']"))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
		WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='3selfproject']")));
		  Thread.sleep(6000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
	    Thread.sleep(6000);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    WebElement timesheetlink2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//a[text()='09/01/2023 - 09/30/2023']")));
	    Thread.sleep(5000);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", timesheetlink2);
	    
		WebElement taskname_table = driver.findElement(By.xpath("//td//following::select"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", taskname_table);
		Select select=new Select(taskname_table);
		Thread.sleep(5000);
		select.selectByVisibleText("domain20 ");
		//driver.findElement(By.xpath("//option[text()='domain20 '] ")).click();
		driver.findElement(By.xpath("//input[@maxlength='50']")).sendKeys("TimeSheet");
		List<WebElement> hoursboxs = driver.findElements(By.xpath("//input[@type='text'and @maxlength='5']"));
		log.info("verifying the timesheet by entering the hours into it");

		hoursboxs.get(0).clear();
		hoursboxs.get(0).sendKeys("8");

		hoursboxs.get(1).clear();
		hoursboxs.get(1).sendKeys("8");

		hoursboxs.get(2).clear();
		hoursboxs.get(2).sendKeys("8");

		hoursboxs.get(3).clear();
		hoursboxs.get(3).sendKeys("8");

		hoursboxs.get(4).clear();
		hoursboxs.get(4).sendKeys("8");

		hoursboxs.get(5).clear();
		hoursboxs.get(5).sendKeys("8");

		hoursboxs.get(6).clear();
		hoursboxs.get(6).sendKeys("8");

		hoursboxs.get(7).clear();
		hoursboxs.get(7).sendKeys("8");

		hoursboxs.get(8).clear();
		hoursboxs.get(8).sendKeys("8");

		hoursboxs.get(9).clear();
		hoursboxs.get(9).sendKeys("8");

		hoursboxs.get(10).clear();
		hoursboxs.get(10).sendKeys("8");

		hoursboxs.get(11).clear();
		hoursboxs.get(11).sendKeys("8");

		hoursboxs.get(12).clear();
		hoursboxs.get(12).sendKeys("8");

		hoursboxs.get(13).clear();
		hoursboxs.get(13).sendKeys("8");

		hoursboxs.get(14).clear();
		hoursboxs.get(14).sendKeys("8");

		hoursboxs.get(15).clear();
		hoursboxs.get(15).sendKeys("8");

		hoursboxs.get(16).clear();
		hoursboxs.get(16).sendKeys("8");

		hoursboxs.get(17).clear();
		hoursboxs.get(17).sendKeys("8");
		hoursboxs.get(18).clear();
		hoursboxs.get(18).sendKeys("8");

		hoursboxs.get(19).clear();
		hoursboxs.get(19).sendKeys("8");

		hoursboxs.get(20).clear();
		hoursboxs.get(20).sendKeys("8");

		hoursboxs.get(21).clear();
		hoursboxs.get(21).sendKeys("8");

		hoursboxs.get(22).clear();
		hoursboxs.get(22).sendKeys("8");

		hoursboxs.get(23).clear();
		hoursboxs.get(23).sendKeys("8");

		hoursboxs.get(24).clear();
		hoursboxs.get(24).sendKeys("8");

		hoursboxs.get(25).clear();
		hoursboxs.get(25).sendKeys("8");

		hoursboxs.get(26).clear();
		hoursboxs.get(26).sendKeys("8");

		hoursboxs.get(27).clear();
		hoursboxs.get(27).sendKeys("8");

		hoursboxs.get(28).clear();
		hoursboxs.get(28).sendKeys("8");

		hoursboxs.get(29).clear();
		hoursboxs.get(29).sendKeys("8");

		log.info("the working hours entered successfully");

		List<WebElement> savebutton1 = driver
				.findElements(By.xpath("//button[@class='btn text-white btn-rounded btn-sm ml-1 ng-star-inserted']"));
		savebutton1.get(0).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary ng-star-inserted']")).click();
		Thread.sleep(5000);
		log.info("verifying the upload functionality :");
		Utility ut = new Utility(driver);
		ut.uploadFileWithRobot("C:\\Users\\Ganesh\\Downloads\\Ganesh.jpg");
		Thread.sleep(5000);
		log.info("file uploaded successfully : ");
		savebutton1.get(1).click();
		Thread.sleep(3000);
		log.addScreenCaptureFromPath(ut.ScreenShot("timesheet_submitted sucessfully"));

	}
	

	@Test(priority = 1, description = "the user should able to login into the system and able to create a new project")
	public void login_with_valid_credentials_in_TMS() throws InterruptedException, IOException {

		ExtentTest test1 = extent.createTest(
				"verify the login with admin credentials and create the new project and assigning the users and creating the task :")
				.assignCategory("Project_Creation");
		System.out.println(test1.getStatus());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		test1.info("attempting to login into the system by using the admin credentials");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@root.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123Pa$$word!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		test1.info("login is successful and the user should be able to land on the homepage ");
		WebElement ele = driver.findElement(By.xpath("//i[@class='bx bx-receipt ng-star-inserted']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele);
		ele.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		By text = By.xpath("//input[@placeholder='Name']"); // By date1=
		By.xpath("//button[@fdprocessedid='n174oo']");
		wait.until(ExpectedConditions.presenceOfElementLocated(text));
		WebElement textbox = driver.findElement(text);
		test1.info("creating the new project : entering the project details ");
		textbox.sendKeys("TestAutomation10");
		Thread.sleep(2000);
		List<WebElement> datepickers = driver.findElements(
				By.xpath("//button[@type='button' and @class='btn btn-outline-secondary fa fa-calendar']"));

		datepickers.get(0).click();
		Thread.sleep(3000);
		List<WebElement> datestart = driver.findElements(By.xpath("//div[text()='1']"));
		datestart.get(0).click();
		Thread.sleep(3000);
		datepickers.get(1).click();
		Thread.sleep(3000); //
		driver.findElement(By.xpath("//option[text()='Sep']")).click();
		List<WebElement> enddate = driver.findElements(By.xpath("//div[text()='30']"));
		enddate.get(1).click();
		driver.findElement(By.xpath("//select[@id='form-project-clientId']")).click();
		driver.findElement(By.xpath("//option[@title='SageIT']")).click();
		WebElement drop1 = driver.findElement(By.xpath("//select[@id='form-project-userId']"));
		drop1.click();
		Select selt1 = new Select(drop1);
		selt1.selectByVisibleText("root Admin");
		Thread.sleep(2000);
		WebElement approver = driver.findElement(By.xpath("//select[@id='form-project-approverId']"));
		approver.click();
		Select selt2 = new Select(approver);
		selt2.selectByVisibleText("Mounika kothakapa");
		driver.findElement(By.xpath("//select[@id='form-project-projectTypeId']")).click();
		driver.findElement(By.xpath("//option[text()='Fixed fee']")).click();
		driver.findElement(By.xpath("//select[@id='form-project-periodTypeId']")).click();
		driver.findElement(By.xpath("//select[@id='form-project-periodTypeId']//option[@title='Monthly']")).click();
		driver.findElement(By.xpath("//input[@id='form-project-aparNumber']")).sendKeys("123456");
		Thread.sleep(3000);
		test1.info("project is created successfully :");
		Utility ut = new Utility(driver); // ut.ScreenShot("fname");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(5000);
		test1.addScreenCaptureFromPath(ut.ScreenShot("project_created"));
		test1.info("assigning the users to the project ");
		driver.findElement(By.xpath("//button[text()='Users']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='dropdown-btn']")).click();
		driver.findElement(By.xpath("//div[text()='Select All']")).click();
		driver.findElement(By.xpath("//a[text()='Add Project Users']")).click();
		WebElement savebutton1 = driver.findElement(By.xpath("//button[text()='Save']"));
		js.executeScript("arguments[0].click();", savebutton1);
		Thread.sleep(5000);
		test1.addScreenCaptureFromPath(ut.ScreenShot("users_created"));
		driver.findElement(By.xpath("//button[text()='Task']")).click();
		test1.info("creating the task for the users ");
		driver.findElement(By.xpath("//a[text()='Add Task']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='form-task-name']")).sendKeys("domain20");
		List<WebElement> taskDate1 = driver
				.findElements(By.xpath("//button[@class='btn btn-outline-secondary fa fa-calendar']"));
		taskDate1.get(0).click();
		List<WebElement> calendarday1 = driver.findElements(By.xpath("//div[text()='1']"));
		calendarday1.get(0).click();
		Thread.sleep(3000);
		taskDate1.get(1).click();
		Thread.sleep(8000);
		WebElement calendarday2 = driver
				.findElement(By.xpath("//div[@aria-label='Saturday, September 30, 2023']//div[text()='30']"));
		calendarday2.click();
		driver.findElement(By.xpath("//span[@class='dropdown-multiselect__caret']")).click();
		driver.findElement(By.xpath("//div[text()='Select All']")).click();
		driver.findElement(By.xpath("//a[text()='Add Task Users']")).click();
		Thread.sleep(5000);
		WebElement savebutton2 = driver.findElement(By.xpath("//button[text()='Save']"));
		Thread.sleep(5000);
		// js.executeScript("arguments[0].scrollIntoView(true);", savebutton2);
		js.executeScript("arguments[0].click();", savebutton2);
		Thread.sleep(5000);
		// savebutton2.click(); Thread.sleep(5000);
		test1.info("task is created successfully :");
		test1.addScreenCaptureFromPath(ut.ScreenShot("task_created"));
		Thread.sleep(5000);

	}

	/*
	 * 
	 * @Test(priority=3 , description
	 * ="with invalid credentials , the system should not allow ,  the user to login in to the system and it should through an error saying please enter a valid data"
	 * ) public void login_with_invalid_credentials_in_TMS() {
	 * 
	 * driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	 * "jfljsljflajsfj");
	 * 
	 * driver.findElement(By.xpath("//input[@placeholder='Enter password']")).
	 * sendKeys("jsldfjasjlsfh");
	 * 
	 * driver.findElement(By.xpath("//button[@type='submit']")).click();
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority=4, description
	 * ="with in empty credentials , the system should not allow ,  the user to login in to the system and it should through an error saying username and password can,t be empty"
	 * ) public void login_with_emptydata_credentials_in_TMS() {
	 * 
	 * driver.findElement(By.xpath("//input[@id='email']")).sendKeys(" ");
	 * 
	 * driver.findElement(By.xpath("//input[@placeholder='Enter password']")).
	 * sendKeys("  ");
	 * 
	 * driver.findElement(By.xpath("//button[@type='submit']")).click();
	 * 
	 * }
	 * 
	 */

}
