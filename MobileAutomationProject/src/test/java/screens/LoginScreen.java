package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseScreen.BaseScreen;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
    private static final String signUp = "text(\"Sign up\")";

    @AndroidFindBy(uiAutomator = signUp)
    private WebElement signUpBtn ;

    public SignUpScreen signUpScreen(){
        try {
            waiToBeVisible(signUpBtn);
            waiToBeClickable(signUpBtn);
            signUpBtn.click();
            Assert.assertTrue(isElementVisible(signUpBtn), "Unable to locate sign up button");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new SignUpScreen(driver);
    }
}
