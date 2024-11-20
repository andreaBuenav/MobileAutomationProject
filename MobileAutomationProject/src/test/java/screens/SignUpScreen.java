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

    //Parameters
    private final String mail = faker.internet().emailAddress();
    private final String password = faker.internet().password();
    private  final String confirmPassword = password;
    //Buttons
    private static final String signUp="text(\"SIGN UP\")";
    //Fields
    private static final String mailInput = "resourceIdMatches(\".*RNE__Input__text-input\").text(\"Email\")";
    private static final String passwordInput = "resourceIdMatches(\".*RNE__Input__text-input\").text(\"Password\")";
    private static final String confPasswordInput = "input-repeat-password";
    //Other elements
    private static final String successWindow = ".resourceIdMatches(\"android:id/alertTitle\").text(\"Signed Up!\")";


    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    //Elements
    @AndroidFindBy(uiAutomator = mailInput)
    private WebElement mail_Input;
    @AndroidFindBy(uiAutomator = passwordInput)
    private WebElement password_Input;
    @AndroidFindBy(accessibility = confPasswordInput)
    private WebElement confPassword_Input;
    @AndroidFindBy(uiAutomator = successWindow)
    private WebElement successWindowPopUp;

    //Buttons
    @AndroidFindBy(uiAutomator = signUp)
    private WebElement signUpBtn;


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
            System.out.println(e.getMessage());
        }
    }
    public void confirmPasswordInput(){
        try{
            waiToBeClickable(confPassword_Input);
            confPassword_Input.sendKeys(confirmPassword);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void signUp(){
        try {
            maiInput();
            passwordInput();
            confirmPasswordInput();
            waiToBeClickable(signUpBtn);
            signUpBtn.click();
            waiToBeVisible(successWindowPopUp);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isSuccessPopUpPresent() {
            return successWindowPopUp.isDisplayed();

    }




}
