import drivers.DriverFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;

import java.util.List;

public class DjiBuyTest {
    private static WebDriver driver;

    @Before
    public void setUpDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void buyProductTest() {
        String shopUrl = "https://store.dji.com/lv/selection/camera-drones?from=store-nav";
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage(shopUrl);
        List<WebElement> allProductsList = mainPage.getAllListProducts();
        for (int i = 0; i < allProductsList.size(); i++) {
            mainPage.openPage(shopUrl);
            mainPage.clickProductFromList(i);

            ProductPage productPage = new ProductPage(driver);
            Assertions.assertThat(productPage.isDisplayed()).isTrue();
            String productNameExpected = productPage.getProductNameExpected();
            String productPriceExpected = productPage.getProductPriceExpected();
            productPage.shopNowButtonPress();
            productPage.continueWithoutCoverageButtonPress();
            productPage.buttonCheckoutClick();

            CartPage cartPage = new CartPage(driver);
            Assertions.assertThat(cartPage.isDisplayed()).isTrue();
            String productNameActual = cartPage.getActualName();
            String productPriceActual = cartPage.getActualPrice();

            SoftAssertions soft = new SoftAssertions();
            soft.assertThat(productNameExpected).contains(productNameActual);
            soft.assertThat(productPriceExpected).contains(productPriceActual);
            soft.assertAll();

            cartPage.deleteProductLink();
            Assertions.assertThat(cartPage.cartIsEmpty()).contains("pc-cart-empty");
            System.out.println("Test: " + i + ", Product: " + productNameActual);
        }
    }

    @After
    public void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
