package kitapyurdu.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import kitapyurdu.utils.Driver;
import kitapyurdu.utils.ReusebleMethods;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends ReusebleMethods {
    public CartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
}
