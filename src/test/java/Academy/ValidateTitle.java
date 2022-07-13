package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateTitle extends Base{
	
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	LandingPage l;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver =initializeDriver();
		log.info("Driver is initialized");
		
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	
	@Test
	public void validateTitle() throws IOException {
		
		l = new LandingPage(driver);
		l.noThanks().click();
		String title = l.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES123");
		log.info("Successfully validated");
	}
	
	@Test
	public void validateHeader() throws IOException {
		l = new LandingPage(driver);
		String title = l.getHeaderText().getText();
		Assert.assertEquals(title, "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		System.out.println(title);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}


}
