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
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;



public class ValidateNavigationBar extends Base {
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	public WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException {
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateNavigationBar() throws IOException {
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed()); 
		log.info("Navigation Bar is displayed");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
