package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ConfigReader;
import util.ElementHelper;

import java.util.Properties;

public class cartPage {

    By pageTitle = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By productName = By.id("com.lcwaikiki.android:id/itemBasketTitleText");
    By productCode = By.id("com.lcwaikiki.android:id/itemBasketCodeText");
    By productQuantity = By.id("com.lcwaikiki.android:id/itemBasketCountText");
    By productSize = By.id("com.lcwaikiki.android:id/itemBasketSizeText");
    By productColor = By.id("com.lcwaikiki.android:id/itemBasketColorText");
    By productPrice = By.id("com.lcwaikiki.android:id/itemBasketPrice");
    By completeOrderButton = By.id("com.lcwaikiki.android:id/tv_go_checkout");
    By clearBasketButton = By.id("com.lcwaikiki.android:id/basketClearLayout");
    By grandTotal = By.id("com.lcwaikiki.android:id/grandTotalValueText");
    By applyCouponButton = By.id("com.lcwaikiki.android:id/tvApplyCoupon");
    By applyCouponInputArea = By.id("com.lcwaikiki.android:id/etApplyCoupon");
    By closeButton = By.id("com.lcwaikiki.android:id/etApplyCoupon");
    By orderSummaryText = By.id("com.lcwaikiki.android:id/orderSummaryText");



    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;


    public cartPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.properties = ConfigReader.getProperties();

    }

    /**
     * check if an element exist with the given elementName.
     *
     * @param elementName String
     */
    public void checkElement(String elementName) {
        WebElement element;
        boolean isSame = false;
        if ("Product Name".equals(elementName)) {
            element = elementHelper.findElement(productName);
            isSame = properties.getProperty("selectedProductName").equals(element.getText());
            System.out.println("Product Name: " + properties.getProperty("selectedProductName"));
        }else if ("Product Code".equals(elementName)) {
            element = elementHelper.findElement(productCode);
            isSame = properties.getProperty("selectedProductCode").equals(element.getText());
            System.out.println("Product Code: " + properties.getProperty("selectedProductCode"));
        }else if ("Product Quantity".equals(elementName)) {
            element = elementHelper.findElement(productQuantity);
            isSame = properties.getProperty("selectedProductQuantity").equals(element.getText());
            System.out.println("Product Quantity: " + properties.getProperty("selectedProductQuantity"));
        }else if ("Product Size".equals(elementName)) {
            element = elementHelper.findElement(productSize);
            isSame = properties.getProperty("selectedProductSize").equals(element.getText());
            System.out.println("Product Size: " + properties.getProperty("selectedProductSize"));
        }else if ("Complete Order Button".equals(elementName)) {
            elementHelper.checkElementPresence(completeOrderButton);
            isSame  = true;
        }else if ("Product Price".equals(elementName)) {
            elementHelper.checkElementPresence(productPrice);
            isSame  = true;
        }else if ("Clear Basket Button".equals(elementName)) {
            elementHelper.checkElementPresence(clearBasketButton);
            isSame  = true;
        }else if ("Grand Total".equals(elementName)) {
            elementHelper.checkElementPresence(grandTotal);
            isSame  = true;
        }else if ("Apply Coupon Button".equals(elementName)) {
            elementHelper.checkElementPresence(applyCouponButton);
            isSame  = true;
        }else if ("Apply Coupon Input Area".equals(elementName)) {
            elementHelper.checkElementPresence(applyCouponInputArea);
            isSame  = true;
        }else if ("Close Button".equals(elementName)) {
            elementHelper.checkElementPresence(closeButton);
            isSame  = true;
        }else if ("Order Summary".equals(elementName)) {
            elementHelper.checkElementPresence(orderSummaryText);
            isSame  = true;
        }
        Assert.assertTrue(isSame);
    }

    /**
     * click the element given by its intuitive name
     *
     * @param elementName String
     */
    public void clickElement(String elementName) {
        if ("Product Name".equals(elementName)) {
            elementHelper.click(productName);
        }else if ("Product Quantity".equals(elementName)) {
            elementHelper.click(productQuantity);
        }else if ("Product Size".equals(elementName)) {
            elementHelper.click(productSize);
        }else if ("Complete Order Button".equals(elementName)) {
            elementHelper.click(productSize);
        }else if ("Clear Basket Button".equals(elementName)) {
            elementHelper.click(clearBasketButton);
        }else if ("Apply Coupon Button".equals(elementName)) {
            elementHelper.click(applyCouponButton);
        }else if ("Close Button".equals(elementName)) {
            elementHelper.click(closeButton);
        }else if ("Order Summary".equals(elementName)) {
            elementHelper.click(orderSummaryText);
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
            elementHelper.checkElementTextContains(pageTitle, text);
        }else if ("Product Color".equals(elementName)) {
            elementHelper.checkElementWithText(productColor, text);
        }
    }
}
