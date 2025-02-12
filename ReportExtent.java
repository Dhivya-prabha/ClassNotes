package steps;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ReportExtent {
	
	public class ExtentReportExample {
	    ExtentReports extent;
	    ExtentTest test;
	    ChromeDriver driver;

	    @BeforeClass
	    public void setup() {
	        // Initialize the HtmlReporter
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./extentReport.html");
	        
	        // Attach the HtmlReporter to ExtentReports
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        // Initialize WebDriver
	     
	         driver = new ChromeDriver();
	    }

	    @Test
	    public void testGoogleSearch() throws IOException {
	        // Start the test
	        test = extent.createTest("Google Search Test", "This is a test for searching in Google");

	        driver.get("https://www.google.com");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        File image = driver.getScreenshotAs(OutputType.FILE);
	        
	        FileUtils.copyFile(image, new File("./img1.png"));
	        String title = driver.getTitle();
	        
	        
	        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Java", Keys.ENTER);
	        FileUtils.copyFile(image, new File("./img2.png"));
	        test.assignAuthor("Dhivya Prabha");
	        test.assignCategory("Smoke Test");

	        // Log test steps and results
	        if (title.equals("Google")) {
	            test.pass("Navigated to Google successfully", MediaEntityBuilder.createScreenCaptureFromPath("./img1.png").build());
	        } else {       	
	        		        	
	            test.fail("Navigation to Google failed");
	        }
	        test.pass("Navigated to Google successfully", MediaEntityBuilder.createScreenCaptureFromPath("./img2.png").build());
	        
	        test.fail("Navigation to Google failed",  MediaEntityBuilder.createScreenCaptureFromPath("./img3.png").build());
	    }
	    
	    

	    @AfterClass
	    public void teardown() {
	        //driver.quit();
	        extent.flush();  // Write all logs to the report
	    }
	}

}
