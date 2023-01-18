package pages;

import drivers.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class MainPage {
    private static final int randomItemNumber = new Random().nextInt(4) + 1;
    private static final By CLICK_COOKIES_LINK = By.xpath("(//button[@class='cc-consent-accept cc-btn cc-btn-primary'])[1]");
    private static final By BUY_LINK = By.xpath("(//span[@class='Compare__buy-now___vzkSs'])[" + randomItemNumber + "]");
    private static final By GET_ALL_LIST_PRODUCTS = By.xpath("//span[@class='Compare__buy-now___vzkSs']");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
        WaitingUtils.waitUntilElem(driver, BUY_LINK, 20);
        clickCookies();
    }

    public void clickCookies() {
        if (driver.findElement(CLICK_COOKIES_LINK).isDisplayed()) {
            WaitingUtils.waitUntilElem(driver, CLICK_COOKIES_LINK, 20);
            driver.findElement(CLICK_COOKIES_LINK).click();
        }
    }

    public List<WebElement> getAllListProducts() {
        return driver.findElements(GET_ALL_LIST_PRODUCTS);
    }

    public void clickProductFromList(int i) {
        i = i + 1;
        driver.findElement(By.xpath("(//span[@class='Compare__buy-now___vzkSs'])[" + i + "]")).click();
    }
}