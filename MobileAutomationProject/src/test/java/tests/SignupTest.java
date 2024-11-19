package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomePageScreen;
import screens.LoginScreen;
import screens.SignUpScreen;
import screens.SplashScreen;
import utils.baseMobileTest.BaseMobileTest;

public class SignupTest extends BaseMobileTest {


    @Test
    public void signUpTest(){
        SplashScreen splashScreen = splashScreen();
        HomePageScreen home = splashScreen.homePageScreen();
        Assert.assertTrue(splashScreen().isHomeScreenDisplayed(), "Not in the homepage");
        LoginScreen login = home.loginScreen();
        SignUpScreen signUp = login.signUpScreen();
        signUp.signUp();




    }
}
