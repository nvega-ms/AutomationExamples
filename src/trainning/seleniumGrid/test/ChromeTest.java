package trainning.seleniumGrid.test;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ChromeTest {
	
	  WebDriver driver;
	  
	 
	  @BeforeClass
	  public void beforeClass() {
		  	 DesiredCapabilities capabilities = DesiredCapabilities.chrome();		  	
		     try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
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
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	  }

}