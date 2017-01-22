package core;

import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Selenium_WD {

	public static void main(String[] args) throws InterruptedException {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		System.setProperty("webdriver.gecko.driver", "C:/workspace45/SignUp/src/main/resources/browsers/gecko.exe");
		String url = "http://www.alex.academy/exercises/signup/v1/";

		String title_expected = "Sign Up";
		String submit_expected = "Invalid Last Name: [a-zA-Z,.'-]{3,30}";

		WebDriver driver = new FirefoxDriver();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		String title_actual = driver.findElement(By.xpath("//tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/span"))
				.getText();
		
		driver.findElement(By.id("id_fname")).sendKeys("Alexander");
		driver.findElement(By.id("id_lname")).sendKeys("S");
		driver.findElement(By.xpath("//td[5]/table/tbody/tr/td[2]/input")).click();
		
        String submit_actual = driver.findElement(By.id("ErrorLine")).getText();
        
		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID:\t\tTC-01.01.01");
			System.out.println("Test Case Resul:\t" + "PASSED");
		} else {
			System.out.println("Test Case ID:\t\tTC-01.01.01");
			System.out.println("Test Case Resul:\t" + "FAILED");
		}

		if  (submit_expected.equals(submit_actual)) {
			System.out.println("Test Case ID:\t\tTC-01.01.02");
			System.out.println("Test Case Resul:\t" + "FAILED");
		} else {
			System.out.println("Test Case ID:\t\tTC-01.01.02");
			System.out.println("Test Case Resul:\t" + "PASSED");
		}

		driver.quit();
	}

}
