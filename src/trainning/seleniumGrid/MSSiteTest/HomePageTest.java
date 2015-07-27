package trainning.seleniumGrid.MSSiteTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {

	  WebDriver driver;
	    
	  By menuLocator = By.cssSelector("nav-menu-top");
	  
	  By videoLocator = By.cssSelector("video#video");
	  
	  @BeforeClass
//	  @Parameters({"browser"})
	  public void beforeClass(/*String browser*/) {
		  	 DesiredCapabilities capabilities = DesiredCapabilities.chrome();    	
		     try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
				driver.get("http://makingsense.com");
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	 	 
		  
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.manage().deleteAllCookies();
		  driver.quit();
	  }
	  
	  @Test
	  public void isMenuPresent() {
		  
		  WebElement menu = driver.findElement(menuLocator);
		  Assert.assertNull(menu, "The menu should be displayed");
	  }
	  
	  @Test
	  public void isVideoDisplayed() {
		  WebElement video = driver.findElement(menuLocator);
		  Assert.assertNull(video, "The video should be displayed");
		  
	  }

}
