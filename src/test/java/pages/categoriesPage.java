package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class categoriesPage {


    By pageTitle = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By userCategoryList = By.id("com.lcwaikiki.android:id/recyclerCategoryBanner");
    By productCategoryList = By.id("com.lcwaikiki.android:id/recyclerCategoryMenus");
    By productSubCategoryList = By.id("com.lcwaikiki.android:id/recyclerCategorySubMenus");
    By userCategoryListBanner = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/categoryBannerText\")");
    By productCategoryListBanner = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/categoryText\")");
    //By productSubCategoryListText = new MobileBy.ByAndroidUIAutomator("");
    By productSubCategoryListText = new MobileBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/categoryMenusConstraint\").childSelector(new UiSelector().className(\"android.widget.TextView\"))");



    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public categoriesPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    /**
     * click the element with the given string parameter
     *
     * @param elementName String
     */
    public void clickElement(String elementName) {
        if ("Kadın".equals(elementName)) {
            elementHelper.clickElementWithText(userCategoryListBanner,elementName);
        } else if ("Erkek".equals(elementName)) {
            elementHelper.clickElementWithText(userCategoryListBanner,elementName);
        }else if ("Çocuk".equals(elementName)) {
            elementHelper.clickElementWithText(userCategoryListBanner,elementName);
        }else if ("Bebek".equals(elementName)) {
            elementHelper.clickElementWithText(userCategoryListBanner,elementName);
        }else if ("Giyim".equals(elementName)) {
            elementHelper.clickElementWithText(productCategoryListBanner,elementName);
        }else if ("Bluz".equals(elementName)) {
            elementHelper.clickElementInScrollableListWithText(productSubCategoryListText,elementName);
        }
    }

    /**
     * check if the visible text of the element with the given string parameter
     * equals to the given parameter text
     *
     * @param text        String
     * @param elementName String
     */
    public void checkElementText(String text, String elementName) {
        if ("Page Title".equals(elementName)) {
            elementHelper.checkElementWithText(pageTitle, text);
        }
    }
}
