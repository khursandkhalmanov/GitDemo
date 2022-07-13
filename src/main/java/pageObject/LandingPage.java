package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By sighnin = By.xpath("//span[text()='Login']");
	By nothanks = By.xpath("//button[text()='NO THANKS']");
	By title = By.cssSelector(".text-center>h2");
	By navBar = By.cssSelector(".navbar-default.navbar-static-top li > a");
	By header = By.cssSelector("div[class*='video-banner'] h3");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public LoginPage getLogin() {
		driver.findElement(sighnin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public int noThanksSize() {
		return driver.findElements(nothanks).size();
	}
	
	public WebElement noThanks() {
		return driver.findElement(nothanks);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getHeaderText() {
		return driver.findElement(header);
	}
}
