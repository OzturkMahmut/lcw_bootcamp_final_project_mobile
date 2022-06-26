package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.ElementHelper;

import java.util.List;
import java.util.Properties;

public class productPage {

    By pageTitle = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By filterList = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/itemFilterText\")");
    By productImage = By.id("com.lcwaikiki.android:id/productImage");
    By closeButton = By.id("com.lcwaikiki.android:id/productClose");
    By expandButton = By.id("com.lcwaikiki.android:id/scrollCardView");
    By productName = By.id("com.lcwaikiki.android:id/productTitleText");
    By productCode = By.id("com.lcwaikiki.android:id/modelCode");
    By productPrice = By.id("com.lcwaikiki.android:id/price");
    By productPriceDiscount = By.id("com.lcwaikiki.android:id/basketDiscountPrice");
    By addFavButton = By.id("com.lcwaikiki.android:id/productDetailFavorite");
    By shareButton = By.id("com.lcwaikiki.android:id/btnShareProduct");
    By addToCartButton = By.id("com.lcwaikiki.android:id/basket");
    By sizeOptionsTexts = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/productSizeText\")");
    By sizeOptionCards = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/productSizeCardView\")");

    By goToCartPopUp = By.id("com.lcwaikiki.android:id/contentAddedBasketSlide");
    By goToCartButton = new MobileBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.lcwaikiki.android:id/slideDownMenu\").childSelector(new UiSelector().text(\"Sepete Git\"))");





    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    Properties properties;


    public productPage(AppiumDriver driver) {
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
        if ("Product Image".equals(elementName)) {
            elementHelper.checkElementPresence(productImage);
        }else if ("Close Button".equals(elementName)) {
            elementHelper.checkElementPresence(closeButton);
        }else if ("Expand Button".equals(elementName)) {
            elementHelper.checkElementPresence(expandButton);
        }else if ("Product Name".equals(elementName)) {
            elementHelper.checkElementPresence(productName);
        }else if ("Product Price".equals(elementName)) {
            if(!elementHelper.checkElementPresenceBool(productPrice)){
                elementHelper.checkElementPresence(productPriceDiscount);
            }
            elementHelper.checkElementPresence(productPrice);
        }else if ("Add Favorites Button".equals(elementName)) {
            elementHelper.checkElementPresence(addFavButton);
        }else if ("Share Button".equals(elementName)) {
            elementHelper.checkElementPresence(shareButton);
        }else if ("AddToCart Button".equals(elementName)) {
            elementHelper.checkElementPresence(addToCartButton);
        }else if ("Size Options".equals(elementName)) {
            elementHelper.checkElementPresence(sizeOptionsTexts);
        }else if ("GotoCart Pop Up".equals(elementName)) {
            elementHelper.checkElementPresence(goToCartPopUp);
        }
    }

    /**
     * click the element with the given string parameter
     *
     * @param elementName String
     */
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
            //With the click to the addToCartButton, We are storing the product info in config file to check in the cart page later
            //every click to addButton increases the quantity by one
            properties.setProperty("selectedProductQuantity", String.valueOf(Integer.parseInt(properties.getProperty("selectedProductQuantity")+1)));
            properties.setProperty("selectedProductName",elementHelper.findElement(productName).getText());
            properties.setProperty("selectedProductCode",elementHelper.findElement(productCode).getText());
            //size is saved in chooseSize method

        }else if ("Size Options".equals(elementName)) {
            elementHelper.click(sizeOptionsTexts);
        }else if ("GotoCart Button".equals(elementName)) {
            elementHelper.click(goToCartButton);
        }
    }

        //Todo: update
    /**
     * click the desired size and also store it in config file to check later on.
     * if desired size is not available choose any size to continue the case
     *
     * @param size String
     */
    public void chooseSize(String size) {
        int index = 0;
        boolean isSelected = false;
        List<WebElement> sizeCards = elementHelper.findElements(sizeOptionCards);
        List<WebElement> sizeTexts = elementHelper.findElements(sizeOptionsTexts);
        //some products have a standard size so there won't be any other choice
        if (!sizeTexts.get(0).getText().equals("Standart")){
            //some products has sizes in letters, some has in numbers, or maybe there is no product in preferred size
            for (WebElement element: sizeCards)
            {   //iterate through sizes to check if desired size is in stock, if so click
                if(element.getAttribute("content-desc").equals("Stokta")){
                    if(sizeTexts.get(index).getText().equals(size)){
                        sizeTexts.get(index).click();
                        properties.setProperty("selectedProductSize",sizeTexts.get(index).getText());
                        isSelected = true;
                    }
                }
                index += 1;
            }
            if(!isSelected){
                for (WebElement element:sizeCards)
                {   // if desired size is mot in stock, choose the first size in stock
                    if(element.getAttribute("content-desc").equals("Stokta")){
                        sizeTexts.get(index).click();
                        properties.setProperty("selectedProductSize",sizeTexts.get(index).getText());
                            isSelected = true;
                            break;
                    }
                    index += 1;
                }
            }
        }else{
            System.out.println("Product has a standard size. Therefore can not choose size: "+ size);
        }
    }
}
