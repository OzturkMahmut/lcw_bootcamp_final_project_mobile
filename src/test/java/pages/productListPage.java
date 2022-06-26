package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class productListPage {

    By pageTitle = By.id("com.lcwaikiki.android:id/toolbarTitle");
    By productList = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/productImage\")");
    By filterButton = By.id("com.lcwaikiki.android:id/filter_product");
    By filterPageTitle = By.id("com.lcwaikiki.android:id/toolbarTitle");
    //TODO: bu bylar colora göre genel bir by al childselector kullanarak
    By filterList = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/itemFilterText\")");
    By subFilterList = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/checked_color_text\")");
    By subFilterApplyButton = By.id("com.lcwaikiki.android:id/subFilterButton");
    By selectedSubFilterList = new MobileBy.ByAndroidUIAutomator("resourceId(\"com.lcwaikiki.android:id/selectFilterTitleText\")");
    By filterApplyButton = By.id("com.lcwaikiki.android:id/buttonFilter");



    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public productListPage(AppiumDriver driver) {
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
        if ("Page Title".equals(elementName)) {
            elementHelper.checkElementWithText(pageTitle, text);
        }
    }

    /**
     * click the element with the given string parameter
     *
     * @param elementName String
     */
    public void clickElement(String elementName) {
        if ("Filtre".equals(elementName)) {
            elementHelper.click(filterButton);
        }
    }

    /**
     * filter the products by the desired filter value
     *
     * @param filterType  String
     * @param filterValue String
     */
    public void filterProductBy(String filterType, String filterValue) {
        elementHelper.clickElementInScrollableListWithText(filterList,filterType);
        elementHelper.clickElementInScrollableListWithText(subFilterList,filterValue);
        elementHelper.click(subFilterApplyButton);
        elementHelper.click(filterApplyButton);
    }

    /**
     * click the nth element in the product list
     *
     * @param index int
     */
    public void clickElementInProductListWithIndex(int index) {
        elementHelper.findElements(productList).get(index).click();
    }
}