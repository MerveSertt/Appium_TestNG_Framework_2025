package kitapyurdu.pages;

import com.github.javafaker.Faker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import kitapyurdu.utils.Driver;
import kitapyurdu.utils.ReusebleMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Register extends ReusebleMethods {

Faker faker = new Faker();
String fakeMail = faker.internet().emailAddress();

    public Register() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(accessibility = "Hesabım")
    private WebElement hesabim;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ücretsiz Üye Ol\")")
    private WebElement uyeOl;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/editTextName")
    private WebElement isim;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/editTextSurname")
    private WebElement soyad;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/editTextMail")
    private WebElement email;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/editTextPassword")
    private WebElement sifre;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/editTextAgainPassword")
    private WebElement sifreTekrari;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/aggreement")
    private WebElement checkBox;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/btnRegister")
    private WebElement uyeOlButonu;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/back_button_center_text")
    private WebElement header;

    @AndroidFindBy(id="com.mobisoft.kitapyurdu:id/textViewDesc1")
    private WebElement failedMessage;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/textViewConfirm")
    private WebElement okButton;


    public void hesabimSayfasinaGit(){
        hesabim.click();
    }

    public void uyeOlButonunaTikla(){
        uyeOl.click();
    }

    public void isimGir(){
        isim.sendKeys("Any name");
    }

    public void soyisimGir(){
        soyad.sendKeys("Any lastname");
    }

    public void emailGir(){
        email.sendKeys("laden.farren@");
    }

    public void sifreGir(){
        sifre.sendKeys("123456.s");
    }

    public void sifreTekrari(){
        sifreTekrari.sendKeys("123456.s");
    }

    public void checkBoxIsaretle(){
        checkBox.click();
    }

    public void uyeOl(){
        uyeOlButonu.click();
    }

    public void mailHataMesajiAliniginiDogrula(){
        Assert.assertEquals(failedMessage.getText(), "E-posta adresiniz geçersizdir.");
    }

    public void okButonunaBas(){
        okButton.click();
    }






}
