package trainning.site.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import trainning.site.pages.BasePage;

public class MenuSection extends BasePage{
	

			
	By bycloseButton = By.cssSelector("a.modal--do-close.color-inverted");
	
	By bygoToAboutUs = By.cssSelector("div.content--table-center nav a[title='Go to About Us']");
	
	By byServices =By.cssSelector("div.content--table-center nav a[title='Go to Services']");
	
	By byGoToProducts = By.cssSelector("div.content--table-center nav a[title='Go to Products']");
	
	By byGoToBlog = By.cssSelector("div.content--table-center nav a[title='Go to Journal']");
	
	By byGoToCareers = By.cssSelector("div.content--table-center nav a[title='Go to Careers']");
	
	By byGoToTalkToUs = By.cssSelector("div.content--table-center nav a[title='Go to Talk to us']");
	
	
	WebElement closeButton; 
	
	WebElement goToAboutUs;
	
	WebElement goToServices;
	
	WebElement goToProducts; 
	
	WebElement goToBlog;
	
	WebElement goToCareers;
	
	WebElement goToTalkToUs;
	
	
	public MenuSection (WebDriver driver)
	{
		super(driver);
	}


	public WebElement isCloseButtonDisplayed() {
		// TODO Auto-generated method stub
		closeButton = driver.findElement(bycloseButton);
		return closeButton;
	}


	public WebElement isGoToAboutUsDisplayed() {
		// TODO Auto-generated method stub
		goToAboutUs = driver.findElement(bygoToAboutUs);
		return goToAboutUs;
	}
	
	public void closeMenu()
	{
		closeButton = driver.findElement(bycloseButton);
		closeButton.click();
	}


	public WebElement isGoToProductsDisplayed() {
		// TODO Auto-generated method stub
		goToProducts = driver.findElement(byGoToProducts);
		return goToProducts;
	}


	public WebElement isGoToServicesDisplayed() {
		// TODO Auto-generated method stub
		goToServices = driver.findElement(byServices);
		return goToServices;
	}


	public WebElement isGoToBlogDisplayed() {
		// TODO Auto-generated method stub
		goToBlog = driver.findElement(byGoToBlog);
		return goToBlog;
	}


	public WebElement isGoToCareersDisplayed() {
		// TODO Auto-generated method stub
		goToCareers = driver.findElement(byGoToCareers);
		return goToCareers;
	}


	public WebElement isGoToTalkToUsDisplayed() {
		// TODO Auto-generated method stub
		goToTalkToUs = driver.findElement(byGoToTalkToUs);
		return goToTalkToUs;
	}

}
