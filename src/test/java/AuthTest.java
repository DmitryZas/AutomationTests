import driver.WebDriverFacade;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class AuthTest{
    private WebDriverFacade driver;
    private MainPage mainPage;

    @Before
        public void setup(){
        driver = new WebDriverFacade();
        mainPage = new MainPage(driver);
        driver.SetUpDriver();
    }

    @Test
    public void authWindow() {
        mainPage.loadPage("https://intertop.ua/");
        driver.clickElement(By.className("js-link-info-close"));
        driver.clickElement(By.id("auth_block"));
        String authHeader = driver.waitForElement(By.className("login-heading")).getText();
        Assert.assertEquals("Я уже зарегистрирован", authHeader);
    }

    @Test
    public void sucessfullAuth() {
        mainPage.loadPage("https://intertop.ua/");
        driver.clickElement(By.id("auth_block"));
        driver.setElementText(By.xpath("//input[@id='email']"), "dmitry.zasuha@gmail.com");
        driver.setElementText(By.xpath("//input[@id='password']"), "@Peugeot306xs");
        driver.clickElement(By.className("show-hide-password"));
        driver.clickElement(By.xpath("//span[contains(text(),'Войти')]"));
        driver.wait(5);
        mainPage.loadPage("https://intertop.ua/");
        driver.pageReload();
        driver.clickElement(By.id("auth_block"));
        driver.wait(10);
        String logOutLink = driver.waitForElement(By.xpath("//*[@id=\"auth_block\"]/div[1]/div/div[2]/span")).getText();
        Assert.assertEquals("Выйти", logOutLink);
    }

    @After
    public void end(){
        driver.StopDriver();}
}
