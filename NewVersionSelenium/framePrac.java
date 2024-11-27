import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//iframe
public class framePrac {
	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		//driver.switchTo().frame(0);
		//System.out.println("into 0");
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			System.out.println(i);
			if (i == size) {
				System.out.println(i);
				
				driver.findElement(By.tagName("button")).click();
			}
			driver.switchTo().defaultContent();
		}

	}

}
