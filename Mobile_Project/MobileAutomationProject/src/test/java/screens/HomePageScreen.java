package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.baseScreen.BaseScreen;

public class HomePageScreen extends BaseScreen {

    public HomePageScreen(AndroidDriver driver) {
        super(driver);
    }

    private static final String homePageTitle = "";
    //new UiSelector().className("android.widget.TextView").textContains("WEBDRIVER")
    @AndroidBy(uiAutomator = "className(\"android.widget.TextView\").textContains(\"WEBDRIVER\")")
    private WebElement homePage_title;

    public boolean isTitleCorrect(String title){
        return homePage_title.isDisplayed();
    }






}
