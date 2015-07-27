package trainning.appium.example.androidTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import trainning.site.pages.HomePage;
import trainning.site.sections.MenuSection;

public class WebAppTest {
	
	WebDriver driver;

	MenuSection menuSection;
	
	@BeforeClass
    public void setUp() throws Exception {
		 
		 DesiredCapabilities capabilities = DesiredCapabilities.android();
	     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"4d00bfd7479f80c9");
	     capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.chrome");
	     driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
 
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	    driver.quit();
	}

	@Test
	public void isMenuPageComplete(){
		HomePage home = new HomePage(driver);
   	 	home.goToMenu();
   	 	menuSection = new MenuSection(driver);
	    Assert.assertNotNull(menuSection.isCloseButtonDisplayed(), "The Close button should be displayed");
	    Assert.assertNotNull(menuSection.isGoToAboutUsDisplayed(), "The About us option should be displayed");
	    Assert.assertNotNull(menuSection.isGoToServicesDisplayed(), "The Services option should be displayed");
	    Assert.assertNotNull(menuSection.isGoToProductsDisplayed(), "The Products option should be displayed");
	    Assert.assertNotNull(menuSection.isGoToBlogDisplayed(), "The Blog option should be displayed");
	    Assert.assertNotNull(menuSection.isGoToCareersDisplayed(), "The Careers option should be displayed");
	    Assert.assertNotNull(menuSection.isGoToTalkToUsDisplayed(), "The Talk to Us option should be displayed");
	}
	
	@Test
	public void goBackToMenu()
	{
		HomePage home = new HomePage(driver);
   	 	home.goToMenu();
   	 	menuSection = new MenuSection(driver);
   	 	menuSection.closeMenu();
	}
}
