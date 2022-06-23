package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.util.regex.Pattern;

public class loginPage {


    By errorPopUp= By.id("com.lcwaikiki.android:id/slideDownText");
    By emailError= By.id("com.lcwaikiki.android:id/errortextEmail");
    By passwordError= By.id("com.lcwaikiki.android:id/errortextPassword");


    By lCWLogo = By.id("com.lcwaikiki.android:id/imageView2");
    By loginFormTitle = By.id("com.lcwaikiki.android:id/headerLogin");
    By loginButton= By.id("com.lcwaikiki.android:id/buttonLogin");
    By signupButton= By.id("com.lcwaikiki.android:id/registerNow");
    By emailRadioButton= By.id("com.lcwaikiki.android:id/radioBtnEmail");
    By phoneRadioButton= By.id("com.lcwaikiki.android:id/radioBtnPhone");
    By emailInputContainer= By.id("com.lcwaikiki.android:id/edtEmail");
    By phoneInputContainer = By.id("com.lcwaikiki.android:id/edtPhone");
    By passwordInputContainer= By.id("com.lcwaikiki.android:id/edtPassword");
    By showPasswordIcon= By.id("com.lcwaikiki.android:id/text_input_end_icon");
    By navBarButtons = By.id("com.lcwaikiki.android:id/tabView");
    By forgotPasswordTextButton= By.id("com.lcwaikiki.android:id/textForgotPassword");
    By orderTrackLink= By.id("com.lcwaikiki.android:id/orderTrack");
    By nearStoresLink= By.id("com.lcwaikiki.android:id/nearStores");
    By helpLink= By.id("com.lcwaikiki.android:id/help");
    By contactCustomerLayout= By.id("com.lcwaikiki.android:id/contactCustomerLayout");
    By whatsAppContact = By.id("com.lcwaikiki.android:id/llContactWhatsapp");
    By contactForm = By.id("com.lcwaikiki.android:id/contactCustomerForm");
    By contactPhoneNumber = By.id("com.lcwaikiki.android:id/contactCustomerPhoneNumber");
    By signLangServiceLink = By.id("com.lcwaikiki.android:id/signLanguageService");


    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public loginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkElementText(String text, String elementName) {
        if ("Login Form Title".equals(elementName)) {
            elementHelper.checkElementWithText(loginFormTitle, text);
        }
    }

    public void clickElement(String elementName) {
        if ("Sign Up Button".equals(elementName)) {
            elementHelper.click(signupButton);
        } else if ("Login Button".equals(elementName)) {
            elementHelper.click(loginButton);
        }
    }
}
