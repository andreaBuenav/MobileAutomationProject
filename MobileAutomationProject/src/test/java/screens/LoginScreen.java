package screens;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseScreen.BaseScreen;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
    private static final String signUp = "text(\"Sign up\")";
    static Faker faker = new Faker();

    //Instance of signUpScreen so that this class can use the method sinUp
    SignUpScreen signUpScreen = new SignUpScreen(driver);
    //Needed parameters
    private  final String mail =signUpScreen.getMail();
    private final String password = signUpScreen.getPassword();
    //Elements
    private static final String loginTop = ".text(\"Login\").instance(0)";
    private static final String emailField = "resourceIdMatches(\".*RNE__Input__text-input\").text(\"Email\")";
    private static final String passwordField = "resourceIdMatches(\".*RNE__Input__text-input\").text(\"Password\")";
    private static final String loginBottom = "text(\"LOGIN\")";
    private static final String loginPopUp="resourceIdMatches(\"android:id/message\").text(\"You are logged in!\")";


    //Buttons
    @AndroidFindBy(uiAutomator = signUp)
    private WebElement signUpBtn ;
    @AndroidFindBy(uiAutomator = loginTop)
    private WebElement loginTopBtn;
    @AndroidFindBy(uiAutomator = loginBottom)
    private WebElement loginBtn;


    //Fields
    @AndroidFindBy(uiAutomator = emailField)
    private WebElement emailInput;
    @AndroidFindBy(uiAutomator = passwordField)
    private WebElement passwordInput;

    //Elements
    @AndroidFindBy(uiAutomator = loginPopUp)
    private WebElement loginSuccess;


//To move to the signUp test
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



    private void loginMail(){
        try{
            waiToBeClickable(emailInput);
            emailInput.click();
            emailInput.sendKeys(mail);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    private void loginPassword(){
        try {
            waiToBeClickable(passwordInput);
            passwordInput.sendKeys(password);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            driver.hideKeyboard();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void login(){
        try {
            loginMail();
            loginPassword();
            waiToBeClickable(loginBtn);
            loginBtn.click();
            waiToBeVisible(loginSuccess);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public boolean isLoginCorrect(){
            return loginSuccess.isDisplayed();
    }






}
