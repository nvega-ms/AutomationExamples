package trainning.seleniumGrid.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SafariMacTest {

	  WebDriver driver;
	  
	  @BeforeClass
	  public void beforeClass() {
		  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		  capabilities.setPlatform(Platform.MAC);
	//	  capabilities.setVersion("7.1.4");
	//	  capabilities.setJavascriptEnabled(true);
		  
		  try {
			   driver = new RemoteWebDriver(new URL("http://192.168.6.95:4444/wd/hub"), capabilities);
		  } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.manage().deleteAllCookies();
		  driver.quit();
	  }
	  
	  @Test
	  public void f() {
		  driver.get("http://makingsense.com");
		  driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		  Assert.assertNotNull(driver.findElement(By.cssSelector("data.data")), "Falla");
	  }
	

}