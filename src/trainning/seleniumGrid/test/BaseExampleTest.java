package trainning.seleniumGrid.test;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BaseExampleTest {

	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browser) throws MalformedURLException {

			DesiredCapabilities capability=null;
		
			if(browser.equalsIgnoreCase("firefox")){
		
				capability= DesiredCapabilities.firefox();
				
				capability.setPlatform(Platform.ANY);
			
				capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}

			if(browser.equalsIgnoreCase("iexplorer")){
			
				capability= DesiredCapabilities.internetExplorer();
			
				capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			
			}
			
			if(browser.equalsIgnoreCase("chrome")){
				
				capability= DesiredCapabilities.chrome();
				
				capability.setPlatform(Platform.ANY);
				
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

	}
	
	@Test
	public void Test1() {
	  driver.get("http://makingsense.com");
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	 
	@AfterClass
	public void tearDown(){

		driver.quit();

	}
}
