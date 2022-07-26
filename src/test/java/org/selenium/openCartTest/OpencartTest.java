package org.selenium.openCartTest;

import org.openqa.selenium.WebDriver;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpencartTest {
	
	
	@Parameters("Browser")
	@Test
	public void openCartApp(String browserName) {
		System.out.println("Browser Name: " + browserName);
		WebDriver driver =null;
		if(browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
		String homeTitle = driver.getTitle();
		String expectedTitle = "Your Store";
		
		Assert.assertEquals(homeTitle, expectedTitle);
		System.out.println("This line is for test github webhook, automatically trigger when push events happens");
		System.out.println("Added another line");
		System.out.println("Another line Poll");
		driver.quit();
		
		
		
		
	}
	
	

}
