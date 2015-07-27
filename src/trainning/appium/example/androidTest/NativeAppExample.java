package trainning.appium.example.androidTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;  //used to find elements (by id, class, xpath etc)
import org.openqa.selenium.WebElement; //Used to web elements
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver; 
import io.appium.java_client.android.AndroidDriver; //Used  for Appium drivers



public class NativeAppExample {
	
	AppiumDriver driver;

	@BeforeTest
	public void beforeTest()
	{
		File classpathRoot = new File(System.getProperty("user.dir")); // path to Eclipse project
		File appDir = new File(classpathRoot, "/Resources"); // path to <project folder>/APKFolder
		File app = new File(appDir, "FunPoint.apk"); //path to <project folder>/APKFolder/APKFile.apk
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		// Name of mobile web browser to automate. Should be an empty string if automating an app instead.

		capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); 

		// Which mobile OS to use: Android, iOS or FirefoxOS

		capabilities.setCapability("platformName", "Android"); 


		capabilities.setCapability(CapabilityType.VERSION, "4.4.2"); 

		//Device name. If the device is connected to the PC, you should execute the command "adb devices" -> http://screencast.com/t/BJf5DtHxV 

		capabilities.setCapability("deviceName", "4d00bfd7479f80c9");
		
		// Java package of the tested Android app
  
		capabilities.setCapability("appPackage", "com.funpoint"); 

		// Activity to lunch
		
		capabilities.setCapability("appActivity", ".ui.SplashActivity");
		
		// The absolute local path to the APK
			
		capabilities.setCapability("app", app.getAbsolutePath());

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {       driver.quit(); }
	
	
	@Test
	public void existButtons(){
			WebElement button1 = driver .findElement(By.name ("ACCEDE CON FACEBOOK" ));
			Assert.assertNotNull("The Accede con Facebook button should be displayed" , button1);
			WebElement button2 = driver .findElement(By.name ("REGISTRATE CON TU MAIL"));
			Assert.assertNotNull("The Accede con Facebook button should be displayed" , button2);
			WebElement button3 = driver .findElement(By.name ("YA TENGO CUENTA" ));
			Assert.assertNotNull("The Accede con Facebook button should be displayed" , button3);
	}
}

