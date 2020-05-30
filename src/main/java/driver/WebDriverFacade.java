package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverFacade {

    private By locator;
    private WebDriver driver = null;
    private WebDriverManager manager = null;

    public WebDriverFacade(){
        manager = WebDriverManager.chromedriver();
        manager.setup();
        driver = new ChromeDriver();

    }

    public void SetUpDriver()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void LoadPage(String url)
    {
        driver.get(url);
    }

    public void StopDriver()
    {
        if (driver != null) {
            driver.quit();
        }
    }

    public void setElementText(By locator, String value) {
        waitForElement(locator).clear();
        waitForElement(locator).sendKeys(value);
    }

    public void clickElement(By locator) {
        waitForElement(locator).click();
    }

    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
     }

    public void pageReload() {
        driver.navigate().refresh();;
    }

    public WebElement waitForElement(By locator) {
        try {
            return new WebDriverWait(driver, 25)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Locator can not be found");;
            throw new RuntimeException(e);
        }
    }

}
