package pages;

import drivers.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class MainPage {
    private static int randomItemNumber =  new Random().nextInt(4) + 1;
    private static final By CLICK_COOKIES_LINK = By.xpath("(//button[@class='cc-consent-accept cc-btn cc-btn-primary'])[1]");
    private static final By BUY_LINK = By.xpath("(//span[@class='Compare__buy-now___vzkSs'])["+randomItemNumber+"]");
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage(String url){
        driver.get(url);
        WaitingUtils.waitUntilElem(driver, BUY_LINK, 10);
        clickCookies();
    }
    public void clickCookies(){
        if(driver.findElement(CLICK_COOKIES_LINK).isDisplayed()) {
            WaitingUtils.waitUntilElem(driver, CLICK_COOKIES_LINK, 10);
            driver.findElement(CLICK_COOKIES_LINK).click();
        }
    }
    public void clickRandomProduct(){
        driver.findElement(BUY_LINK).click();
    }
}