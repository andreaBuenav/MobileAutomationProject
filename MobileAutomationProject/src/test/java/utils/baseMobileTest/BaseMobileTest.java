package utils.baseMobileTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseMobileTest {

    private static  String PROPERTIES_FILE = "src/test/resources/config.properties";
    //Test properties
    private static Properties properties = new Properties();
    private static AndroidDriver driver;

    @BeforeTest(alwaysRun = true)//It should be executed everytime a test is done
    //Setup
    public void enviromentSetup(){
        UiAutomator2Options capabilities  = new UiAutomator2Options();
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }catch (MalformedURLException e){

        }
    }

    //Capabilities
    public void capabilities (){

    }














@AfterTest
    public void endTest(){
    driver.close();
}

}
