package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.ElementHelper;

import java.util.Properties;

public class checkOutPage {

    By deliveryTypeSelectionCard = By.id("com.lcwaikiki.android:id/deliveryTypeConstraintLayout");

    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;


    public checkOutPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.properties = ConfigReader.getProperties();

    }


    public void checkElement(String elementName) {
        if ("Delivery Type Selection Card".equals(elementName)) {
            elementHelper.checkElementPresence(deliveryTypeSelectionCard);
        }
    }
}
