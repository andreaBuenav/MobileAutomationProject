package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomePageScreen;
import screens.SplashScreen;
import utils.baseMobileTest.BaseMobileTest;


public class NavigationMenuTest extends BaseMobileTest {
    @Test
    public void navigationTest(){
        SplashScreen splashScreen = splashScreen();
        Assert.assertTrue(splashScreen().isHomeScreenDisplayed(), "Not in the homepage");
        HomePageScreen home = splashScreen.homePageScreen();
        home.clickAllBottomButtons();





    }
}
