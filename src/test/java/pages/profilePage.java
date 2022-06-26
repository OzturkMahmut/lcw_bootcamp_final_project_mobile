package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.ElementHelper;

import java.util.Properties;

public class profilePage {


    By logo =  By.id("com.lcwaikiki.android:id/imageView2");
    By welcomeText =  By.id("com.lcwaikiki.android:id/textWelcome");
    By fullName =  By.id("com.lcwaikiki.android:id/textName");
    By personalInfoLink =  By.id("com.lcwaikiki.android:id/tvPersonalInfo");
    By addressesLink =  By.id("com.lcwaikiki.android:id/tvAddress");
    By ordersLink =  By.id("com.lcwaikiki.android:id/tvOrders");
    By reviewsLink =  By.id("com.lcwaikiki.android:id/tvEvaluations");
    By discountsLink  =  By.id("com.lcwaikiki.android:id/tvMergedDiscounts");
    By lCWMoneyLink =  By.id("com.lcwaikiki.android:id/tvLCWMoney");
    By savedCardsLink =  By.id("com.lcwaikiki.android:id/tvSavedCards");
    By nearStoresLink =  By.id("com.lcwaikiki.android:id/tvNearStores");




    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;


    public profilePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.properties = ConfigReader.getProperties();

    }

    /**
     * check if the visible text of the element with the given string parameter
     * equals to the given parameter text
     *
     * @param text        String
     * @param elementName String
     */
    public void checkElementText(String text, String elementName) {
        if ("Full Name".equals(elementName)) {
            elementHelper.checkElementText(fullName, text);
        }
    }
}
