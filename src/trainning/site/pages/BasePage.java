package trainning.site.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

	protected WebDriver driver;

    public BasePage(WebDriver d)
	{
        driver = d;
        PageFactory.initElements(this.driver, this);
    }
    
    public void MaximazePage()
    {
        driver.manage().window().maximize();
    }

    public void ClosePage()
    {
        driver.close();
    }

    /// <summary>
    /// Method to clear all coockies.
    /// </summary>
    public void ClearAllCoockies()
    {
        driver.manage().deleteAllCookies();
    }

    /// <summary>
    /// Method to refresh the current page.
    /// </summary>
    public void RefreshPage() 
    {
        driver.navigate().refresh();
    }

}

