package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.HomePageScreen;
import screens.SplashScreen;
import screens.SwipeScreen;
import utils.baseMobileTest.BaseMobileTest;

public class SwipeTest extends BaseMobileTest {

    @Test
    public void swipeTest(){
        SplashScreen splash = splashScreen();
        HomePageScreen home = splash.homePageScreen();
        SwipeScreen swipe = home.swipeScreen();
        swipe.scrollInteractions();

    }
}
