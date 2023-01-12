import drivers.DriverFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;

public class DjiBuyTest {
    private static WebDriver driver;

    @Before
    public void setUpDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void buyProductTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage("https://store.dji.com/lv/selection/camera-drones?from=store-nav");
        mainPage.clickRandomProduct();

        ProductPage productPage = new ProductPage(driver);
        Assertions.assertThat(productPage.isDisplayed()).isTrue();
        String productNameExpected = productPage.getProductNameExpected();
        String productPriceExpected = productPage.getProductPriceExpected();
        System.out.println(productNameExpected);
        System.out.println(productPriceExpected);
        productPage.shopNowButtonPress();
        productPage.continueWithoutCoverageButtonPress();
        productPage.buttonCheckoutClick();

        CartPage cartPage = new CartPage(driver);
        Assertions.assertThat(cartPage.isDisplayed()).isTrue();
        String productNameActual = cartPage.getActualName();
        String productPriceActual = cartPage.getActualPrice();
        System.out.println(productNameActual);
        System.out.println(productPriceActual);

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(productNameExpected).contains(productNameActual);
        soft.assertThat(productPriceExpected).contains(productPriceActual);
        soft.assertAll();

        cartPage.deleteProductLink();
        System.out.println(cartPage.cartIsEmpty());
        Assertions.assertThat(cartPage.cartIsEmpty()).contains("pc-cart-empty");

        Thread.sleep(5000);
    }
    @After
    public void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
