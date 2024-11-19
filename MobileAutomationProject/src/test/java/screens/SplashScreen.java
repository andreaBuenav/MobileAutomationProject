package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.baseScreen.BaseScreen;

//Initializes and shows the splash screen
public class SplashScreen extends BaseScreen {
    public SplashScreen(AndroidDriver driver) {
        super(driver);
    }

    //new UiSelector().text("WEBDRIVER")
    private static final String homeScreenText = "text(\"WEBDRIVER\")\n";

    @AndroidFindBy(uiAutomator = homeScreenText)
    private WebElement homeScreen;

    public boolean isHomeScreenDisplayed(){
        waiToBeVisible(homeScreen);
        return homeScreen.isDisplayed();
    }

    public HomePageScreen homePageScreen(){
        return new HomePageScreen(driver);
    }

}
