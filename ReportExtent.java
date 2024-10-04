package steps;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
	        
	        // Attach the HtmlReporter to ExtentReports
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        // Initialize WebDriver
	     
	         driver = new ChromeDriver();
	    }

	    @Test
	    public void testGoogleSearch() {
	        // Start the test
	        test = extent.createTest("Google Search Test", "This is a test for searching in Google");

	        driver.get("https://www.google.com");
	        String title = driver.getTitle();

	        // Log test steps and results
	        if (title.equals("Google")) {
	            test.pass("Navigated to Google successfully");
	        } else {
	            test.fail("Navigation to Google failed");
	        }
	    }

	    @AfterClass
	    public void teardown() {
	        driver.quit();
	        extent.flush();  // Write all logs to the report
	    }
	}

}
