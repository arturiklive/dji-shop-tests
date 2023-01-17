package pages;

import drivers.WaitingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private static final By BUTTON_SHOP_NOW = By.xpath("//p[@class='styles__default-txt___O7vYi']");
    private static final By GET_NAME_LINK = By.xpath("//h1");
    private static final By GET_PRICE_LINK = By.xpath("(//span[@class='style__price___D132C style__normal-price___FcKyW'])[1]");
    private static final By BUTTON_CONTINUE_CLICK = By.xpath("//button[@class='xnv6R _27-6k _22qIt p8s4W _3RO_K']");
    private static final By BUTTON_CHECKOUT_CLICK = By.xpath("//button[@class='xnv6R _2QwEc _22qIt _27-yu']");
    private static WebDriver driver;

    public ProductPage(WebDriver driver) {
        ProductPage.driver = driver;
    }

    public boolean isDisplayed() {
        WaitingUtils.waitUntilElem(driver, BUTTON_SHOP_NOW, 20);
        return true;
    }

    public void shopNowButtonPress() {
        driver.findElement(BUTTON_SHOP_NOW).click();
    }

    public String getProductNameExpected() {
        return driver.findElement(GET_NAME_LINK).getText();
    }

    public String getProductPriceExpected() {
        return driver.findElement(GET_PRICE_LINK).getText();
    }

    public void continueWithoutCoverageButtonPress() {
        WaitingUtils.waitUntilElem(driver, BUTTON_CONTINUE_CLICK, 20);
        driver.findElement(BUTTON_CONTINUE_CLICK).click();
    }

    public void buttonCheckoutClick() {
        WaitingUtils.waitUntilElem(driver, BUTTON_CHECKOUT_CLICK, 20);
        driver.findElement(BUTTON_CHECKOUT_CLICK).click();
    }
}
