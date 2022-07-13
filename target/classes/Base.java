package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;






public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName = System.getProperty("browser");
	    String browserName = prop.getProperty("browser");
	    
	    if(browserName.contains("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
	    	ChromeOptions options = new ChromeOptions();
	    	if(browserName.contains("headless")) {
	    	options.addArguments("headless");}
			driver = new ChromeDriver(options);
	    }else if(browserName.equalsIgnoreCase("firefox")) {
	    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	    	
	    }else if(browserName.equalsIgnoreCase("IE")) {
	    	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
	    	driver = new InternetExplorerDriver();
	    }
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	    return driver;
	}
	
	public String getScreenShotPath(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
			
	}

}
