package TMS_Regression_Suite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	
	
	
	TakesScreenshot ts;

	WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public String  ScreenShot(String filename) {

		try {

			ts = (TakesScreenshot) driver;
			File fname = ts.getScreenshotAs(OutputType.FILE);
			
			File destination=new File("./Html_Report/ScreenShots/" + filename + ".jpeg");
			
			String absolutepath=destination.getCanonicalPath();
            FileUtils.copyFile(fname,destination);
					
            return absolutepath;
            
            
		} catch (Exception e) {

			e.printStackTrace();

		}
		return filename;
		
	}

	// Function to Make border
	public void MakeBorder(WebElement Element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '3px solid red'", Element);

	}
	
	
	 public void uploadFileWithRobot (String imagePath) {
		 
	        StringSelection stringSelection = new StringSelection(imagePath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	        robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	



	

}
