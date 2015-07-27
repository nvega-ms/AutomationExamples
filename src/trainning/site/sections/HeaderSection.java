package trainning.site.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSection {

	By byMenuIcon = By.cssSelector("span.icon-hamburguer");
	
	By byButton = By.cssSelector("a[href='#our-work'].button.button--default");
	
	By byMSLogo = By.cssSelector("g.logo--is-mobile");
	
	By byTitle = By.cssSelector("div.content--table-center div.wrapper");
	
	WebElement menuIcon;
	
	WebElement button;
	
	WebElement logo;
	
	WebElement title;
	
	WebDriver driver;
	
	public HeaderSection(WebDriver d)
	{
		driver = d;
		menuIcon = driver.findElement(byMenuIcon); 
		button = driver.findElement(byButton);
		logo = driver.findElement(byMSLogo);
		title = driver.findElement(byTitle);; 
	}
	
	public WebElement idsMenuIconDisplayed()
	{
		return menuIcon;
	}
	
	public WebElement idsButtonDisplayed()
	{
		return button;
	}
	
	public WebElement idsMSLogoDisplayed()
	{
		return logo;
	}
	
	public WebElement idsTitleDisplayed()
	{
		return title;
	}

	public void goToMenu() {
		
		try{
			menuIcon.click();
		}
		catch(Exception e)
		{}
	}
}
