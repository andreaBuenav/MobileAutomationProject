package utils.baseMobileTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import screens.SplashScreen;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseMobileTest {

    private static  String PROPERTIES_FILE = "src/test/resources/config.properties";

    //Test properties
    private static Properties properties = new Properties();
    private static AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)//It should be executed everytime a test is done
    //Setup
    public void environmentSetup(){
        loadProperties();
        UiAutomator2Options capabilities  = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }

    //Properties
    public void loadProperties (){
        try{
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        } catch (IOException e) {
           throw new RuntimeException("Error loading property files " + PROPERTIES_FILE);
        }
    }

    //Capabilities
    public static String getCapabilities(String variable){
        return properties.getProperty(variable);
    }

    public static void setUpCapabilities(UiAutomator2Options capabilities){
        capabilities.setPlatformName(getCapabilities("platformName"));
        capabilities.setPlatformVersion(getCapabilities("platformVersion"));
        capabilities.setDeviceName(getCapabilities("deviceName"));
        capabilities.setAppActivity(getCapabilities("appActivity"));
        capabilities.setAppPackage(getCapabilities("appPackage"));
    }

    public SplashScreen splashScreen(){
        return new SplashScreen(driver);
    }



    //Closing the driver
    @AfterTest
    public static void downServer(){
        driver.quit();
    }















}
