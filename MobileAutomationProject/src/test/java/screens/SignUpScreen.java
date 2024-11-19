package screens;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseScreen.BaseScreen;

public class SignUpScreen extends BaseScreen {
    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }
    static Faker faker = new Faker();

    private static final String mail = faker.internet().emailAddress();
    private static final String password = faker.internet().password();
    private static final String confirmPassword = password;
    private static final String signUp="text(\"SIGN UP\")";
    private static final String mailInput = "resourceIdMatches(\".*RNE__Input__text-input\").text(\"Email\")";
    private static final String passwordInput = "resourceIdMatches(\".*RNE__Input__text-input\").text(\"Password\")";
    private static final String confPasswordInput = "resourceIdMatches(\".*RNE__Input__text-input\").text(\"Confirm password\")";
    private static final String successWindow = "android:id/content";
    private static final String ok ="resourceIdMatches(\"android:id/content\")";
    private static final String successful = "android:id/message";

    //Elements
    @AndroidFindBy(uiAutomator = mailInput)
    private WebElement mail_Input;
    @AndroidFindBy(uiAutomator = passwordInput)
    private WebElement password_Input;
    @AndroidFindBy(uiAutomator = confPasswordInput)
    private WebElement confPassword_Input;
    @AndroidFindBy(id = successful)
    private WebElement success;
    @AndroidFindBy(id = successWindow)
    private WebElement successWindowPopUp;

    //Buttons
    @AndroidFindBy(uiAutomator = signUp)
    private WebElement signUpBtn;
    @AndroidFindBy(id = ok)
    private WebElement okBtn;


    //Methods
    public void maiInput() {
        try {
            //Mail
            waiToBeVisible(mail_Input);
            waiToBeClickable(mail_Input);
            mail_Input.click();
            mail_Input.sendKeys(mail);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void passwordInput() {
        try {
            //Password
            password_Input.sendKeys(password);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void confirmPassword(){
        try {
            //Password confirmation
            confPassword_Input.sendKeys(confirmPassword);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            waiToBeClickable(signUpBtn);
            signUpBtn.click();
            Assert.assertTrue(isSuccessPopUpPresent(), "Popup window failed to be located");
            waiToBeVisible(successWindowPopUp);
            waiToBeVisible(success);
            waiToBeVisible(okBtn);
            waiToBeClickable(okBtn);
            okBtn.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
    public void signUp(){
        maiInput();
        passwordInput();
        confirmPassword();

    }

    public boolean isSuccessPopUpPresent() {
        try {
            return successWindowPopUp.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}
