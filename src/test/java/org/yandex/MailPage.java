package org.yandex;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage {

    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@data-reactid, '101')]")
    private WebElement mailEnterButtonOutside;

    @FindBy(tagName = "body")
    private WebElement scrollPage;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginInputArea;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")
    private WebElement mailEnterInside;

    @FindBy(xpath = "//*[contains(@class, 'passp-form-field__error')]")
    private WebElement errorLogin;

    public void pushEnterOutsideButton() {
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
