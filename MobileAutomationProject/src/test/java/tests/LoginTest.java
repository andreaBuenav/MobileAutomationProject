package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomePageScreen;
import screens.LoginScreen;
import screens.SplashScreen;
import utils.baseMobileTest.BaseMobileTest;

public class LoginTest extends BaseMobileTest {

    @Test
    public void loginTest(){
        SplashScreen splash = splashScreen();
        HomePageScreen home = splash.homePageScreen();
        LoginScreen loginScreen = home.loginScreen();
        loginScreen.login();
        Assert.assertTrue(loginScreen.isLoginCorrect(), "Error, login unsuccessful :(");



    }
}
