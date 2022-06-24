package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class productPage {

    By pageTitle = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By filterList = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/itemFilterText\")");
    By productImage = By.id("com.lcwaikiki.android:id/productImage");
    By closeButton = By.id("com.lcwaikiki.android:id/productClose");
    By expandButton = By.id("com.lcwaikiki.android:id/scrollCardView");
    By productName = By.id("com.lcwaikiki.android:id/productTitleText");
    By productPrice = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/basketDiscountPrice\")");
    By addFavButton = By.id("com.lcwaikiki.android:id/productDetailFavorite");
    By shareButton = By.id("com.lcwaikiki.android:id/btnShareProduct");
    By addToCartButton = By.id("com.lcwaikiki.android:id/basket");
    By sizeOptions = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/productSizeText\")");
    By goToCartPopUp = By.id("com.lcwaikiki.android:id/contentAddedBasketSlide");
    By goToCartButton = new MobileBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/slideDownMenu\").childSelector(new UiSelector().text(\"Sepete Git\"))");





    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public productPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkElement(String elementName) {
        if ("Product Image".equals(elementName)) {
            elementHelper.checkElementPresence(productImage);
        }else if ("Close Button".equals(elementName)) {
            elementHelper.checkElementPresence(closeButton);
        }else if ("Expand Button".equals(elementName)) {
            elementHelper.checkElementPresence(expandButton);
        }else if ("Product Name".equals(elementName)) {
            elementHelper.checkElementPresence(productName);
        }else if ("Product Price".equals(elementName)) {
            elementHelper.checkElementPresence(productPrice);
        }else if ("Add Favorites Button".equals(elementName)) {
            elementHelper.checkElementPresence(addFavButton);
        }else if ("Share Button".equals(elementName)) {
            elementHelper.checkElementPresence(shareButton);
        }else if ("AddToCart Button".equals(elementName)) {
            elementHelper.checkElementPresence(addToCartButton);
        }else if ("Size Options".equals(elementName)) {
            elementHelper.checkElementPresence(sizeOptions);
        }else if ("GotoCart Pop Up".equals(elementName)) {
            elementHelper.checkElementPresence(goToCartPopUp);
        }
    }

    public void clickElement(String elementName) {
        if ("Product Image".equals(elementName)) {
            elementHelper.click(productImage);
        }else if ("Close Button".equals(elementName)) {
            elementHelper.click(closeButton);
        }else if ("Expand Button".equals(elementName)) {
            elementHelper.click(expandButton);
        }else if ("Product Name".equals(elementName)) {
            elementHelper.click(productName);
        }else if ("Product Price".equals(elementName)) {
            elementHelper.click(productPrice);
        }else if ("Add Favorites Button".equals(elementName)) {
            elementHelper.click(addFavButton);
        }else if ("Share Button".equals(elementName)) {
            elementHelper.click(shareButton);
        }else if ("AddToCart Button".equals(elementName)) {
            elementHelper.click(addToCartButton);
        }else if ("Size Options".equals(elementName)) {
            elementHelper.click(sizeOptions);
        }else if ("GotoCart Button".equals(elementName)) {
            elementHelper.click(goToCartButton);
        }
    }

    public void chooseSize(String size) {
        elementHelper.clickElementWithText(sizeOptions,size);
    }
}
