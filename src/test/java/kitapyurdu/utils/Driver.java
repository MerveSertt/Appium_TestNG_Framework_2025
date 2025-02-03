package kitapyurdu.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    public static AndroidDriver driver;

    public static AndroidDriver getDriver() {

        if(driver==null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setAppPackage("com.mobisoft.kitapyurdu")
                    .setAppActivity("com.mobisoft.kitapyurdu.main.SplashActivity");

            URL url = null;
            try {
                url = new URL("http://0.0.0.0:4723");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver = new AndroidDriver(url, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeApp(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
