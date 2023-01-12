package pages;

import drivers.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private static final By GET_PRODUCT_NAME = By.xpath("//a[@data-test-locator='linkTableRowProductTitle']");
    private static final By GET_PRODUCT_TOTAL_PRICE = By.xpath("//span[@class='semibold Summary__value___1QmHi']");
    private static final By DELETE_PRODUCT_LINK = By.xpath("//i[@class='_26SUY style__icon___1mkC8 _3c0Qz']");
    private static final By EMPTY_CART_LINK = By.xpath("//a[@data-test-locator='linkGoShopping']");
    private static WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isDisplayed(){
        WaitingUtils.waitUntilElem(driver, GET_PRODUCT_TOTAL_PRICE, 10);
        return true;
    }
    public String getActualName(){
        return driver.findElement(GET_PRODUCT_NAME).getAttribute("innerHTML");
    }
    public String getActualPrice(){
        return driver.findElement(GET_PRODUCT_TOTAL_PRICE).getAttribute("innerHTML");
    }
    public void deleteProductLink(){
        WaitingUtils.waitUntilElem(driver, DELETE_PRODUCT_LINK, 10);
        driver.findElement(DELETE_PRODUCT_LINK).click();
    }
    public String cartIsEmpty(){
        WaitingUtils.waitUntilElem(driver, EMPTY_CART_LINK, 10);
        return driver.findElement(EMPTY_CART_LINK).getAttribute("href");
    }
}