package util;

import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
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
    // TouchActions touchActions ;

    public ElementHelper(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
        this.touchAction = new TouchAction(driver);
        //this.touchActions = new TouchActions(driver);

    }

    /**
     * @param key
     * @return
     */
    public WebElement findElement(By key) {
        WebElement element = null;
        boolean endOfPage = false;
        String previousPageSource = driver.getPageSource();
        // Algorithm to scroll to element
        while (!endOfPage) {//if we hit the end of the page, page source stays the same,thus algorithm stops
            // could be an issue for pages with infinite lists
            try {
                element = presenceElement(key);
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
     * @param key
     * @return
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = null;
        boolean endOfPage = false;
        String previousPageSource = driver.getPageSource();
        // Algorithm to scroll to element
        while (!endOfPage) {//if we hit the end of the page, page source stays the same,thus algorithm stops
            // could be an issue for pages with infinite lists
            try {
                elements = presenceElements(key);
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
     * @param key
     * @return
     */
    public WebElement findElementInScrollableListWithText(By key,String text) {
        List<WebElement> elements = null;
        WebElement desElement = null;
        boolean endOfPage = false;
        boolean isFound = false;
        String previousPageSource = driver.getPageSource();
        // Algorithm to scroll to element
        while (!endOfPage&&!isFound) {//if we hit the end of the page, page source stays the same,thus algorithm stops
            // could be an issue for pages with infinite lists
            try {
                elements = presenceElements(key);
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
            if (!isFound){
                swipe(Direction.UP);
            }

            //refresh the page source to compare
            endOfPage = previousPageSource.equals(driver.getPageSource());
            previousPageSource = driver.getPageSource();
        }
        return desElement;
    }


    /**
     * @param key
     * @return
     */
    public void clickElementInScrollableListWithText(By key,String text) {
        findElementInScrollableListWithText(key,text).click();
    }

    /**
     * @param key
     */
    public void click(By key) {
        findElement(key).click();
    }

    /**
     * @param key
     * @param text
     */
    public void sendKey(By key, String text) {
        findElement(key).sendKeys(text);
    }

    /**
     * @param key
     * @return
     */
    public String getText(By key) {
        return findElement(key).getText();
    }

    /**
     * @param key
     * @param text
     * @return
     */
    public boolean checkElementText(By key, String text) {
        return wait.until(ExpectedConditions.textMatches(key, Pattern.compile(text)));
    }

    /**
     * @param key
     */
    public void checkElementVisible(By key) {
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    /**
     * @param key
     */
    public void checkElementPresence(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     * @param text
     * @return
     */
    public boolean checkTitle(String text) {
        return wait.until(ExpectedConditions.titleIs(text));
    }

    /**
     * @param key
     * @param attr
     * @return
     */
    public String getAttribute(By key, String attr) {
        return findElement(key).getAttribute(attr);
    }

    /**
     * @param key
     * @param attr
     * @param text
     */
    public void checkAttribute(By key, String attr, String text) {
        Assert.assertEquals(getAttribute(key, attr), text);
    }

    /**
     * @param key
     * @param text
     */
    public void clickElementWithText(By key, String text) {
        boolean find = false;
        List<WebElement> elements = findElements(key);

        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @param text
     */
    public boolean checkElementWithText(By key, String text) {
        boolean isFound = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public boolean checkElementWithTextBool(By key, String text) {
        boolean isFound = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                isFound = true;
                break;
            }
        }
        //Assert.assertEquals(true, find);
        return isFound;
    }

    /**
     * @param key
     * @param text
     * @param text2
     */
    public void sendKeyElementWithText(By key, String text, String text2) {
        boolean find = false;
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                element.sendKeys(text2);
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    public boolean checkElementTextContains(By selector, String text) {
        boolean isFound = false;
        WebElement element = findElement(selector);
        if (element.getText().contains(text)) {
            isFound = true;
        }
        Assert.assertEquals(true, isFound);
        return isFound;
    }


    /**
     * @param key
     * @return
     */
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     * @param key
     * @return
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    public void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
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
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder/2);
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
