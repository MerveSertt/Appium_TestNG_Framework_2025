package kitapyurdu.tests;

import io.appium.java_client.AppiumBy;
import kitapyurdu.pages.Register;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_NegativeTest{

    @Test
    public void testKitapyurduNegative(){

        Register register = new Register();

        register.hesabimSayfasinaGit();
        register.uyeOlButonunaTikla();
        register.isimGir();
        register.soyisimGir();
        register.emailGir();
        register.sifreGir();
        register.sifreTekrari();
        register.checkBoxIsaretle();
        register.uyeOl();
        register.mailHataMesajiAliniginiDogrula();
        register.okButonunaBas();

    }


}
