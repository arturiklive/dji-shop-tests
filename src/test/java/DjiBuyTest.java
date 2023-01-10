import drivers.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

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
        Thread.sleep(5000);
    }
    @After
    public void tearDownDriver() {
        driver.close();
        driver.quit();
    }
}
