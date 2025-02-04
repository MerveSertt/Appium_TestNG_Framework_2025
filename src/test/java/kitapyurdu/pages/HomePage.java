package kitapyurdu.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import kitapyurdu.utils.Driver;
import kitapyurdu.utils.ReusebleMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static kitapyurdu.utils.Driver.driver;
import static kitapyurdu.utils.ExtentReport.informationNotes;

public class HomePage extends ReusebleMethods{
    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }


    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/recyclerViewList")
    private WebElement swipeElement;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.mobisoft.kitapyurdu:id/imageViewProduct\"])[4]")
    private WebElement fifthBook;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id=\\\"com.mobisoft.kitapyurdu:id/productDetailScrollView\\\"]/android.view.ViewGroup/android.widget.TextView")
    private List<WebElement> bookInformation;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Künye\"))")
    private WebElement kunye;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/productDetailScrollView")
    private WebElement scrollElement;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/textViewAttributeTitle")
    private List<WebElement> titleKunye;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/textViewAttributeName")
    private List<WebElement> informationKunye;


    public void chooseBooksFromBestseller(){
        ReusebleMethods.visibleWait(driver,swipeElement,15);
        ReusebleMethods.swipeGesture(driver,swipeElement,"left",1.0,1000);
        ReusebleMethods.clickGesture(driver,fifthBook);
        informationNotes("5. ürün seçildi.");
        ReusebleMethods.scrollGesture(driver,scrollElement,"down",2.0,1000);

        for (int i = 0; i < titleKunye.size(); i++) {
            System.out.print(titleKunye.get(i).getText() + "\t");
            System.out.println(informationKunye.get(i).getText());
        }

        informationNotes("Seçilen urunun kunye bilgisi yazdırıldı.");
    }
}
