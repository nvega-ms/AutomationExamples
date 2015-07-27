package trainning.site.pages;

import org.openqa.selenium.WebDriver;

import trainning.site.sections.HeaderSection;

public class HomePage extends BasePage{
	
	HeaderSection header;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		driver.get("http://makingsense.com");
		header = new HeaderSection(driver);
	}
	public void goToMenu() {
		// TODO Auto-generated method stub
		header.goToMenu();
	}

}
