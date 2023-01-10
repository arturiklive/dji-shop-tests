package drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingUtils {
    public static void waitUntilElem(WebDriver driver, By waitingElement, int waitingTime) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(waitingElement));
    }
}