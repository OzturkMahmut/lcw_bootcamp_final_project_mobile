package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.util.regex.Pattern;


public class tutorialPage {

    By actionBarRoot = By.id("com.lcwaikiki.android:id/action_bar_root");
    By discoverText = MobileBy.AndroidUIAutomator("com.lcwaikiki.android:id/textView");
    By tvTutorials = MobileBy.AndroidUIAutomator("com.lcwaikiki.android:id/ivTutorial");
    By newBotNavInfoTitle = MobileBy.AndroidUIAutomator("com.lcwaikiki.android:id/tvTitle");
    By newBotNavInfo = MobileBy.AndroidUIAutomator("com.lcwaikiki.android:id/tvContent");
    By skipButton =By.id("com.lcwaikiki.android:id/tvNext");


    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public tutorialPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    /**
     * check if the app is opened
     *
     */
    public void isAppOpen() {
        elementHelper.checkElementPresence(actionBarRoot);
    }


    /**
     * click the element with the given string parameter
     *
     * @param elementName String
     */
    public void clickElement(String elementName) {
        if ("Skip Button".equals(elementName)) {
            elementHelper.click(skipButton);
        }else if ("Tv Tutorials".equals(elementName)) {
            elementHelper.checkElementPresence(tvTutorials);
        } else if ("Discover New Feature".equals(elementName)) {
            elementHelper.checkElementPresence(discoverText);
        }else if ("New Bottom NavBar Info Title".equals(elementName)) {
            elementHelper.checkElementPresence(newBotNavInfoTitle);
        } else if ("New Bottom NavBar Info".equals(elementName)) {
            elementHelper.checkElementPresence(newBotNavInfo);
        }
    }

    /**
     * check if an element exist with the given elementName.
     *
     * @param elementName String
     */
    public void checkElement(String elementName) {
        if ("Skip Button".equals(elementName)) {
            elementHelper.checkElementPresence(skipButton);
        }else if ("Tv Tutorials".equals(elementName)) {
            elementHelper.checkElementPresence(tvTutorials);
        } else if ("Discover New Feature".equals(elementName)) {
            elementHelper.checkElementPresence(discoverText);
        }else if ("New Bottom NavBar Info Title".equals(elementName)) {
            elementHelper.checkElementPresence(newBotNavInfoTitle);
        } else if ("New Bottom NavBar Info".equals(elementName)) {
            elementHelper.checkElementPresence(newBotNavInfo);
        }
    }
}
