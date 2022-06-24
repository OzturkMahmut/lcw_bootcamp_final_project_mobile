package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import java.util.regex.Pattern;

public class signUpPage {



    By errorPopUp= By.id("com.lcwaikiki.android:id/slideDownText");
    By emailError= By.id("com.lcwaikiki.android:id/errortextEmail");
    By passwordError= By.id("com.lcwaikiki.android:id/errortextPassword");
    By welcomeHeader = By.id("com.lcwaikiki.android:id/txtWelcomeHeader");
    By homePageTitle = By.id("com.lcwaikiki.android:id/txtWelcomeHeader");
    By tabView= By.id("com.lcwaikiki.android:id/tabView");
    By formTitle = By.id("com.lcwaikiki.android:id/headerLogin");

    By lCWLogo = By.id("com.lcwaikiki.android:id/imageView2");
    By signUpFormTitle = By.id("com.lcwaikiki.android:id/headerLogin");
    By emailInputContainer = By.id("com.lcwaikiki.android:id/edtEmail");
    By passwordInputContainer = By.id("com.lcwaikiki.android:id/edtPassword");
    By showPasswordIcon = By.id("com.lcwaikiki.android:id/text_input_end_icon");
    By phoneInputContainer = By.id("com.lcwaikiki.android:id/edtPhoneNumber");
    By emailCheckbox = By.id("com.lcwaikiki.android:id/emailChecked");
    By callCheckbox = By.id("com.lcwaikiki.android:id/callChecked");
    By smsCheckbox = By.id("com.lcwaikiki.android:id/smsChecked");
    By threeCheckboxes = By.id("com.lcwaikiki.android:id/clRegisterPermission");
    By registerInfoContainer = By.id("com.lcwaikiki.android:id/contactPermisssionTextView");
    By termsOfUseCheckbox = By.id("com.lcwaikiki.android:id/contractChecked");
    By clarificationText = By.id("com.lcwaikiki.android:id/privacy_policy_info");
    By loginButton= By.id("com.lcwaikiki.android:id/loginNow");
    By signUpButton= By.id("com.lcwaikiki.android:id/buttonRegister");
    By phoneConfirmationPopUpTitle= By.id("com.lcwaikiki.android:id/dialogTitleText");
    By phoneConfirmationDesc= By.id("com.lcwaikiki.android:id/dialogDescription");
    By confirmCodeInputArea= By.id("com.lcwaikiki.android:id/activationCode");
    By completeSignUpButton= By.id("com.lcwaikiki.android:id/completeButton");


    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public signUpPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkElementText(String text, String elementName) {
        if ("Sign Up Form Title".equals(elementName)) {
            elementHelper.checkElementWithText(signUpFormTitle, text);
        }else if ("Phone Confirmation Pop Up".equals(elementName)) {
            elementHelper.checkElementWithText(phoneConfirmationPopUpTitle, text);
        }else if ("Phone Confirmation Pop Up Description".equals(elementName)) {
            elementHelper.checkElementTextContains(phoneConfirmationDesc, text);
        }
    }

    public void checkElement(String elementName) {
        if ("Email Input Container".equals(elementName)) {
            elementHelper.checkElementPresence(emailInputContainer);
        } else if ("Password Input Container".equals(elementName)) {
            elementHelper.checkElementPresence(passwordInputContainer);
        } else if ("Show Password Icon".equals(elementName)) {
            elementHelper.checkElementPresence(showPasswordIcon);
        } else if ("Phone Number Input Container".equals(elementName)) {
            elementHelper.checkElementPresence(phoneInputContainer);
        } else if ("Email CheckBox".equals(elementName)) {
            elementHelper.checkElementPresence(emailCheckbox);
        } else if ("Call CheckBox".equals(elementName)) {
            elementHelper.checkElementPresence(callCheckbox);
        } else if ("SMS CheckBox".equals(elementName)) {
            elementHelper.checkElementPresence(smsCheckbox);
        } else if ("Register Info Container".equals(elementName)) {
            elementHelper.checkElementPresence(registerInfoContainer);
        } else if ("Terms of Use CheckBox".equals(elementName)) {
            elementHelper.checkElementPresence(termsOfUseCheckbox);
        } else if ("Clarification Text".equals(elementName)) {
            elementHelper.checkElementPresence(clarificationText);
        } else if ("Sign Up Button".equals(elementName)) {
            elementHelper.checkElementPresence(signUpButton);
        } else if ("Login Button".equals(elementName)) {
            elementHelper.checkElementPresence(loginButton);
        }else if ("Complete Sign Up Button".equals(elementName)) {
            elementHelper.checkElementPresence(completeSignUpButton);
        }
    }

    public void fillOutInputContainer(String container, String input) {
        if ("Email".equals(container)) {
            elementHelper.sendKey(emailInputContainer, input);
        } else if ("Password".equals(container)) {
            elementHelper.sendKey(passwordInputContainer, input);
        } else if ("Phone Number".equals(container)) {
            elementHelper.sendKey(phoneInputContainer, input);
        }
    }

    public void checkCheckbox(String checkboxName) {
        if ("Email".equals(checkboxName)) {
            elementHelper.click(emailCheckbox);
        } else if ("Call".equals(checkboxName)) {
            elementHelper.click(callCheckbox);
        } else if ("Sms".equals(checkboxName)) {
            elementHelper.click(smsCheckbox);
        } else if ("Terms of Use".equals(checkboxName)) {
            elementHelper.click(termsOfUseCheckbox);
        }
    }

    public void clickElement(String elementName) {
        if ("Sign Up Button".equals(elementName)) {
            elementHelper.click(signUpButton);
        } else if ("Login Button".equals(elementName)) {
            elementHelper.click(loginButton);
        }
    }
}
