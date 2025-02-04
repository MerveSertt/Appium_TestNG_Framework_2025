package kitapyurdu.pages;

import com.github.javafaker.Faker;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import kitapyurdu.utils.Driver;
import kitapyurdu.utils.ReusebleMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static kitapyurdu.utils.ExtentReport.informationNotes;


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
        informationNotes("Hesabım butonuna tıklandı.");
    }

    public void uyeOlButonunaTikla(){
        uyeOl.click();
        informationNotes("Uye ol butonuna tıklandı.");
    }

    public void isimGir(String name){
        isim.sendKeys(name);
        informationNotes("İsim kutusuna "+name+" ismi girildi.");

    }

    public void soyisimGir(String lastName){
        soyad.sendKeys(lastName);
        informationNotes("Soyisim kutusuna "+lastName+" soyismi girildi.");
    }

    public void emailGir(String Email){
        email.sendKeys(Email);
        informationNotes("Email kutusuna "+Email+"'i girildi.");
    }

    public void sifreGir(String password){
        sifre.sendKeys(password);
        informationNotes("Şifre kutusuna "+password+" girildi.");
    }

    public void sifreTekrari(String password){
        sifreTekrari.sendKeys(password);
        informationNotes("Şifre kutusuna "+password+" tekrar girildi.");
    }

    public void checkBoxIsaretle(){
        checkBox.click();
        informationNotes("Checkbox seçildi.");
    }

    public void uyeOl(){
        uyeOlButonu.click();
        informationNotes("Uye ol butonuna tıklandı");
    }

    public void mailHataMesajiAliniginiDogrula(){
        Assert.assertEquals(failedMessage.getText(), "E-posta adresiniz geçersizdir.");
        informationNotes("Hata mesajı alındığı doğrulandı");
    }

    public void okButonunaBas(){
        okButton.click();
        informationNotes("Ok butonuna tıklandı.");
    }






}
