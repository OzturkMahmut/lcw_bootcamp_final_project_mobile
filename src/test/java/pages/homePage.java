package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;
import java.util.regex.Pattern;

public class homePage {


    By welcomeHeader = By.id("com.lcwaikiki.android:id/txtWelcomeHeader");
    By salesBannerView = By.id("com.lcwaikiki.android:id/bannerRecyclerView");
    By searchInputContainer = By.id("com.lcwaikiki.android:id/search");
    By searchIcon = By.id("com.lcwaikiki.android:id/searchIcon");
    By navBarButtons = By.id("com.lcwaikiki.android:id/tabView");
    By navBarButtonsText = By.id("com.lcwaikiki.android:id/textItemTab");


    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public homePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    /**
     * check if the visible text of the element with the given string parameter
     * equals to the given parameter text
     *
     * @param text        String
     * @param elementName String
     */
    public void checkElementText(String text, String elementName) {
        if ("Welcome Header".equals(elementName)) {
            elementHelper.checkElementText(welcomeHeader, text);
        }
    }

    /**
     * click a navBar button with the given string parameter
     *
     * @param navBarButtonName String
     */
    public void clickNavBarButton(String navBarButtonName) {
        if ("Homepage".equals(navBarButtonName)) {
            elementHelper.findElements(navBarButtons).get(0).click();
        } else if ("Categories".equals(navBarButtonName)) {
            elementHelper.findElements(navBarButtons).get(1).click();
        } else if ("MyCart".equals(navBarButtonName)) {
            elementHelper.findElements(navBarButtons).get(2).click();
        } else if ("Favorites".equals(navBarButtonName)) {
            elementHelper.findElements(navBarButtons).get(3).click();
        } else if ("Profile".equals(navBarButtonName)) {
            elementHelper.findElements(navBarButtons).get(4).click();
        }
    }

    /**
     * check if bottom navigation button exist with the given name.
     *
     * @param navBarButtonName String
     */
    public void checkNavBarButton(String navBarButtonName) {
        if ("Homepage".equals(navBarButtonName)) {
            elementHelper.checkElementWithText(navBarButtonsText,"Ana sayfa");
        } else if ("Categories".equals(navBarButtonName)) {
            elementHelper.checkElementWithText(navBarButtonsText,"Kategoriler");
        } else if ("MyCart".equals(navBarButtonName)) {
            elementHelper.checkElementWithText(navBarButtonsText,"Sepetim");
        } else if ("Favorites".equals(navBarButtonName)) {
            elementHelper.checkElementWithText(navBarButtonsText,"Favoriler");
        } else if ("Profile".equals(navBarButtonName)) {
            elementHelper.checkElementWithText(navBarButtonsText,"Profil");
        }
    }


    /**
     * check if given bottom navigation button is selected.
     *
     * @param navBarButtonName String
     */
    public void isSelected(String navBarButtonName) {
        boolean isSelected = false;
        if ("Homepage".equals(navBarButtonName)) {
            isSelected = elementHelper.findElements(navBarButtons).get(0).getAttribute("selected").equals("true");
        } else if ("Categories".equals(navBarButtonName)) {
            isSelected = elementHelper.findElements(navBarButtons).get(0).getAttribute("selected").equals("true");
        } else if ("MyCart".equals(navBarButtonName)) {
            isSelected = elementHelper.findElements(navBarButtons).get(0).getAttribute("selected").equals("true");
        } else if ("Favorites".equals(navBarButtonName)) {
            isSelected = elementHelper.findElements(navBarButtons).get(0).getAttribute("selected").equals("true");
        } else if ("Profile".equals(navBarButtonName)) {
            isSelected = elementHelper.findElements(navBarButtons).get(0).getAttribute("selected").equals("true");

        }
        Assert.assertTrue(isSelected);
    }

}
