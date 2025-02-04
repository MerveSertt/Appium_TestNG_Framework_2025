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
        register.isimGir("Any name");
        register.soyisimGir("Any lastname");
        register.emailGir("laden.farren@");
        register.sifreGir("123456.s");
        register.sifreTekrari("123456.s");
        register.checkBoxIsaretle();
        register.uyeOl();
        register.mailHataMesajiAliniginiDogrula();
        register.okButonunaBas();

    }


}
