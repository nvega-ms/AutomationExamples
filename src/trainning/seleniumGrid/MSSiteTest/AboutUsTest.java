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

public class AboutUsTest {

	WebDriver driver;
	
	By aboutUsLocator = By.cssSelector("nav.nav-menu-top a[title='Go to About Us']");
	
	By playLocator = By.id("btPlayStart");
	
	By menuLocator = By.cssSelector("nav-menu-top");
	
	@BeforeClass
//	@Parameters({"browser"})
	public void beforeClass(/*String browser*/)
	{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

	
	     try {
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			driver.findElement(aboutUsLocator).click();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void afterClass()
	{
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	 @Test
	  public void isPlayButtonDisplayed() {
		 WebElement playButton = driver.findElement(playLocator);
		  Assert.assertNull(playButton, "The Play button should be displayed");
	  }
	 
	 @Test
	  public void isMenuPresent() {
		  
		  WebElement menu = driver.findElement(menuLocator);
		  Assert.assertNull(menu, "The menu should be displayed");
	  }

}
