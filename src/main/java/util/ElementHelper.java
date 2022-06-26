package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Pattern;

public class ElementHelper {
    AppiumDriver driver;
    WebDriverWait wait;
    Actions action;
    TouchAction touchAction;

    public ElementHelper(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
        this.touchAction = new TouchAction(driver);

    }

    /**
     * find the element
     *
     * @param selector By
     * @return element
     */
    public WebElement findElement(By selector) {
        WebElement element = null;
        boolean endOfPage = false;
        // Algorithm to scroll to element
        String previousPageSource = driver.getPageSource();
        while (!endOfPage) {//if we hit the end of the page, page source stays the same,thus algorithm stops
            // could be an issue for pages with infinite lists
            try {
                element = presenceElement(selector);
                break;

            } catch (Exception e) {//if element is not found on the screen, we scroll
                System.out.println(e);
                swipe(Direction.UP);
            }
            //refresh the page source to compare
            endOfPage = previousPageSource.equals(driver.getPageSource());
            previousPageSource = driver.getPageSource();
        }
        return element;
    }

    /**
     * find the elements of same type and return them in a list
     *
     * @param selector By
     * @return elements
     */
    public List<WebElement> findElements(By selector) {
        List<WebElement> elements = null;
        boolean endOfPage = false;
        // Algorithm to scroll to element
        String previousPageSource = driver.getPageSource();
        while (!endOfPage) {//if we hit the end of the page, page source stays the same,thus algorithm stops
            // could be an issue for pages with infinite lists
            try {
                elements = presenceElements(selector);
                break;

            } catch (Exception e) {//if element is not found on the screen, we scroll
                System.out.println(e);
                swipe(Direction.UP);
            }
            //refresh the page source to compare
            endOfPage = previousPageSource.equals(driver.getPageSource());
            previousPageSource = driver.getPageSource();
        }
        return elements;
    }

    /**
     * find an element in a vertical scrollable list with the given text parameter
     * if the element is not visible on the screen, list is scrolled
     * algorithm is not suitable for infinite lists
     *
     * @param selector By
     * @param text     String
     */
    public WebElement findElementInScrollableListWithText(By selector, String text) {
        List<WebElement> elements = null;
        WebElement desElement = null;
        boolean endOfPage = false;
        boolean isFound = false;
        String previousPageSource = driver.getPageSource();
        // Algorithm to scroll to element
        while (!endOfPage && !isFound) {//if we hit the end of the page, page source stays the same,thus algorithm stops
            // could be an issue for pages with infinite lists
            try {
                elements = presenceElements(selector);
                for (WebElement element : elements) {
                    if (element.getText().contains(text)) {
                        desElement = element;
                        isFound = true;
                        break;
                    }
                }
                //break;

            } catch (Exception e) {//if element is not found on the screen, we scroll
                System.out.println(e);
            }
            if (!isFound) {
                swipe(Direction.UP);
            }

            //refresh the page source to compare
            endOfPage = previousPageSource.equals(driver.getPageSource());
            previousPageSource = driver.getPageSource();
        }
        return desElement;
    }


    /**
     * find and click an element in a vertical scrollable list with the given text parameter
     * if the element is not visible on the screen, list is scrolled
     * algorithm is not suitable for infinite lists
     *
     * @param selector By
     * @param text     String
     */
    public void clickElementInScrollableListWithText(By selector, String text) {
        findElementInScrollableListWithText(selector, text).click();
    }

    /**
     * find the element and click it
     *
     * @param selector By
     */
    public void click(By selector) {
        findElement(selector).click();
    }

    /**
     * find the element(e.g. input container) and input the given text parameter
     *
     * @param selector By
     * @param text     String
     */
    public void sendKey(By selector, String text) {
        findElement(selector).sendKeys(text);
    }

    /**
     * find the element and get the visible text of this element
     *
     * @param selector By
     */
    public String getText(By selector) {
        return findElement(selector).getText();
    }

    /**
     * compare the visible text of the element with the given text parameter
     *
     * @param selector By
     * @param text     String
     */
    public boolean checkElementText(By selector, String text) {
        return wait.until(ExpectedConditions.textMatches(selector, Pattern.compile(text)));
    }

    /**
     * check if the element is visible on screen
     *
     * @param selector By
     */
    public void checkElementVisible(By selector) {
        wait.until(ExpectedConditions.visibilityOf(findElement(selector)));
    }

    /**
     * check if the element is present on the DOM of a page
     *
     * @param selector By
     */
    public void checkElementPresence(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    /**
     * check if the title of a page is equals to the given text parameter
     *
     * @param text String
     */
    public boolean checkTitle(String text) {
        return wait.until(ExpectedConditions.titleIs(text));
    }

    /**
     * Get the value of the given attribute of the element.
     *
     * @param selector By
     * @param attr     String
     * @return WebElement
     */
    public String getAttribute(By selector, String attr) {
        return findElement(selector).getAttribute(attr);
    }

    /**
     * Get the value of the given attribute of the element and check
     * if it is equal to the given parameter text
     *
     * @param selector By
     * @param attr     String
     * @param text     String
     */
    public void checkAttribute(By selector, String attr, String text) {
        Assert.assertEquals(getAttribute(selector, attr), text);
    }

    /**
     * find the elements of same type and click the element with
     * the text matching the given text parameter
     *
     * @param selector By
     * @param text     String
     */
    public void clickElementWithText(By selector, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(selector);

        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }

    /**
     * find the elements of same type and check if an element with
     * the text containing the given text parameter exists
     *
     * @param selector By
     * @param text     String
     */
    public boolean checkElementWithText(By selector, String text) {
        boolean isFound = false;
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    /**
     * find the elements of same type and check if an element with
     * the text containing the given text parameter exists
     * this method does not throw an exception if an element is not found
     * but simply returns a boolean false
     *
     * @param selector By
     * @param text     String
     * @return boolean
     */
    public boolean checkElementWithTextBool(By selector, String text) {
        boolean isFound = false;
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    /**
     * list the elements of same type and find the element with
     * the text matching the given text parameter, then input the text
     * given with the parameter text2
     *
     * @param selector By
     * @param text     String
     * @param text2    String
     */
    public void sendKeyElementWithText(By selector, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertTrue(find);
    }

    /**
     * check if the visible text of the element contains the given text parameter
     *
     * @param selector By
     * @param text     String
     * @return boolean
     */
    public boolean checkElementTextContains(By selector, String text) {
        boolean isFound = false;
        WebElement element = findElement(selector);
        if (element.getText().contains(text)) {
            isFound = true;
        }
        Assert.assertTrue(isFound);
        return isFound;
    }

    /**
     * check if the element is present on the DOM of a page
     *
     * @param selector By
     * @return WebElement
     */
    public WebElement presenceElement(By selector) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    /**
     * check if the element list is present on the DOM of a page
     *
     * @param selector By
     * @return WebElement list
     */
    public List<WebElement> presenceElements(By selector) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    /**
     * carry out a swipe action from the center of the screen
     * towards the given direction parameter
     *
     * @param dir Direction
     */
    public void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'");

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better to avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // half the distance to center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder / 2);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart).waitAction()
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }
        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
