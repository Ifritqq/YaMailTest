package org.yandex;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {

    public WebDriver driver;
    public static Actions actions;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[last()][contains(@class, 'FooterButtons')]")
    private WebElement mailEnterButtonOutside;

    @FindBy(tagName = "body")
    private WebElement scrollPage;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginInputArea;

    @FindBy(xpath = "//*[contains(@class,'passp-button passp-sign-in-button')]")
    private WebElement mailEnterInside;

    @FindBy(xpath = "//*[contains(@class, 'passp-form-field__error')]")
    private WebElement errorLogin;


    public void pushEnterOutsideButton() {
        actions = new Actions(driver);
        actions.moveToElement(mailEnterButtonOutside).build().perform();
        mailEnterButtonOutside.click();
    }

    public void inputTextLoginArea(String randLogin) {
        loginInputArea.sendKeys(randLogin);
    }

    public void clickEnterButtonInside() {
        mailEnterInside.click();
    }

    public void scrollPageDown() {
        scrollPage.sendKeys(Keys.END);
    }

    public void switchTab() {
        String parentHandle = driver.getWindowHandle();
        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parentHandle)) {
                driver.switchTo().window(childHandle);
            }
        }
    }

    public String loginError() {
        String strtxt = errorLogin.getText();

        return strtxt;
    }

}
