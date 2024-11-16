package utils.baseScreen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    private AndroidDriver driver;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
    }

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public AndroidDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    private void waiToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    private void waiToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    
}
