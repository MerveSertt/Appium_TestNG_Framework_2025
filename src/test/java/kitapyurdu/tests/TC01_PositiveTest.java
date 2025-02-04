package kitapyurdu.tests;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import kitapyurdu.pages.HomePage;
import org.testng.annotations.Test;

import static kitapyurdu.utils.Driver.driver;

public class TC01_PositiveTest{

    @Test
    public void testKitapYurdu() throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.chooseBooksFromBestseller();
        KeyEvent back = new KeyEvent(AndroidKey.BACK);
        driver.pressKey(back);
    }
}
