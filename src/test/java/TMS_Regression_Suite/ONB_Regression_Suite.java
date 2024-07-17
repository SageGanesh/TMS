package TMS_Regression_Suite;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
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
	 * SalesSubmit_theRMG(): This method is use to submit the RMG onboard.
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
}
