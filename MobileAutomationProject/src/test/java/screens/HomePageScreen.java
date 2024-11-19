package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseScreen.BaseScreen;

public class HomePageScreen extends BaseScreen {

    private static final String webView = "description(\"Webview\")";
    private static final String login ="description(\"Login\")";
    private static final String forms="description(\"Forms\")";
    private static final String swipe="description(\"Swipe\")";
    private static final String drag=".description(\"Drag\")";

    //Buttons
    @AndroidFindBy(uiAutomator = webView)
    private WebElement webViewBtn;
    @AndroidFindBy(uiAutomator = login)
    private WebElement loginBtn;
    @AndroidFindBy(uiAutomator = forms)
    private WebElement formsBtn;
    @AndroidFindBy(uiAutomator = swipe)
    private WebElement swipeBtn;
    @AndroidFindBy(uiAutomator = drag)
    private WebElement dragBtn;
    

    public HomePageScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebViewScreen webViewScreen(){
        try {
            waiToBeVisible(webViewBtn);
            waiToBeClickable(webViewBtn);
            webViewBtn.click();
            Assert.assertTrue(isElementVisible(webViewBtn), "Unable to locate web view button");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new WebViewScreen(driver);
    }

    public LoginScreen loginScreen(){
        try {
            waiToBeVisible(loginBtn);
            waiToBeClickable(loginBtn);
            loginBtn.click();
            Assert.assertTrue(isElementVisible(loginBtn), "Unable to locate login button");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new LoginScreen(driver);
    }

    public FormsScreen formsScreen(){
        try {
            waiToBeVisible(formsBtn);
            waiToBeClickable(formsBtn);
            formsBtn.click();
            Assert.assertTrue(isElementVisible(formsBtn), "Unable to locate forms button");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new FormsScreen(driver);
    }
    public SwipeScreen swipeScreen(){
        try {
            waiToBeVisible(swipeBtn);
            waiToBeClickable(swipeBtn);
            swipeBtn.click();
            Assert.assertTrue(isElementVisible(swipeBtn), "Unable to locate swipe button");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new SwipeScreen(driver);
    }
    public DragScreen dragScreen(){
        try {
            waiToBeVisible(dragBtn);
            waiToBeClickable(dragBtn);
            dragBtn.click();
            Assert.assertTrue(isElementVisible(dragBtn), "Unable to locate drag button");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new DragScreen(driver);
    }


    public void clickAllBottomButtons(){
        webViewScreen();
        loginScreen();
        formsScreen();
        swipeScreen();
        dragScreen();
    }











}
