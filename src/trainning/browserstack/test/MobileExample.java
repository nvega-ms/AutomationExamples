package trainning.browserstack.test;


import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileExample {  
  
  private WebDriver driver;  


  @BeforeClass
  @org.testng.annotations.Parameters(value={"browser","platform","device"})
  public void setUp(String browser, String platform, String device) throws Exception {
	  
    DesiredCapabilities capability = new DesiredCapabilities();
    
    capability.setCapability("browserName", "iPhone");
 //   capability.setPlatform(Platform.MAC);
    capability.setCapability("device", "iPhone 5");
    /*
    capability.setCapability("platform",platform);
    capability.setCapability("browserName", browser);
    capability.setCapability("device", device);
    */
    capability.setCapability("project", "TrainnigMobileExample");
    capability.setCapability("build", "1.0");
    driver = new RemoteWebDriver(
      new URL("http://sergiomarchetti1:qz6JmW9zV6ypTscf47jn@hub.browserstack.com/wd/hub"),
      capability);
  }  

  @Test
  public void testSimple() throws Exception {
    driver.get("http://www.google.com");
    System.out.println("Page title is: " + driver.getTitle());
    Assert.assertEquals("Google", driver.getTitle());
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Browser Stack");
    element.submit();
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterClass  
  public void tearDown() throws Exception {  
    driver.quit();  
  }
}
