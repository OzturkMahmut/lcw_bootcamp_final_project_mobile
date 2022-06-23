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


    public void isAppOpen() {
        elementHelper.checkElementPresence(actionBarRoot);
    }

    public void checkTvTutorialsElement() {
        wait.until(ExpectedConditions.presenceOfElementLocated(tvTutorials));

    }

    public void checkText(String text) {
        wait.until(ExpectedConditions.textMatches(discoverText, Pattern.compile(text)));

    }

    public void checkTitle(String title) {
        wait.until(ExpectedConditions.textMatches(newBotNavInfoTitle, Pattern.compile(title)));

    }

    public void checkTitleDescription(String titleDesc) {
        wait.until(ExpectedConditions.textMatches(newBotNavInfo, Pattern.compile(titleDesc)));
    }

    public void checkButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(skipButton));
    }

    public void dragItem() {

    }

    public void clickElement(String elementName) {
        if ("Skip Button".equals(elementName)) {
            elementHelper.click(skipButton);
        }
    }
}
