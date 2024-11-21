package screens;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseScreen.BaseScreen;

public class SwipeScreen extends BaseScreen {
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

private static final String logo ="WebdriverIO logo";
private static final String scrollView = "new UiSelector().description(\"Swipe-screen\")";
private static final String last = "card";
private static final String lastCardC = "new UiSelector().description(\\\"card\\\")";


@AndroidFindBy(accessibility = logo)
private WebElement logoH;
@AndroidFindBy(accessibility = last)
private WebElement lastCard;


    private static final String hiddenLogo =     "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"WebdriverIO logo\"))";



    public void scrollInteractions() {
        try {
            driver.findElements(AppiumBy.androidUIAutomator(scrollView));
            //Swipe to find the card
            driver.findElements(AppiumBy.androidUIAutomator(lastCardC));
            waiToBeVisible(lastCard);
            Assert.assertTrue(isElementVisible(lastCard), "Unable to find last car");
           //Scroll to find the logo
            driver.findElement(AppiumBy.androidUIAutomator(hiddenLogo));
            waiToBeVisible(logoH);
            Assert.assertTrue(isElementVisible(logoH), "Unable to find logo");
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }


    }

    public void swipeRight() {

    }









}










