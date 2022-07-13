package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class Homepage extends Base{
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation (String useremail, String userpassword) throws IOException {
		
		LandingPage l = new LandingPage(driver);
		if(l.noThanksSize()>0) {
			l.noThanks().click();
		}
		LoginPage login = l.getLogin();
		login.getEmail().sendKeys(useremail);
		login.getPassword().sendKeys(userpassword);
		log.info("Homepage password entered");
		login.getSubmit().click();
		ForgotPassword fp = login.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendInstructions().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12345";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "678910";
		
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
