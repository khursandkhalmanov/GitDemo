package stepDefinitions;

import static org.testng.Assert.assertTrue;

import com.aventstack.extentreports.util.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.portalHomePage;
import resources.Base;

public class StepDefinition extends Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver =initializeDriver();
	}
	
	@And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
    }

	

	@And("^Click on Login link in home page to land on Secure sighn in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sighn_in_Page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		if(l.noThanksSize()>0) {
			l.noThanks().click();
		}
		LoginPage login = l.getLogin();
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getSubmit().click();
    }


	@Then("^Verify that user successfully logged in$")
	public void verify_that_user_successfully_logged_in() throws Throwable {
	    portalHomePage p = new portalHomePage(driver);
	    System.out.println(p.getSearchBox().isDisplayed());
	}
	
	@And("^Close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }


}
