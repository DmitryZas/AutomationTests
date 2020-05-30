package pages;


import driver.WebDriverFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage{
    public WebDriverFacade driver;

    public MainPage(WebDriverFacade driver) {
        this.driver = driver;
    }

    public void loadPage(String url) {
        driver.LoadPage(url);
    }



   /* private final static String URL = "https://intertop.ua";
    WDFacade wDFacade;

    public MainPage(WDFacade wDFacade) {
        super(URL, wDFacade);
    }

    public void loadPage() {
        wDFacade.loadPage(URL);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='auth_block']")
    public WebElement authButton;

    public void openAuthWindow() {
        wDFacade.clickElement(authButton);
    }*/


}
