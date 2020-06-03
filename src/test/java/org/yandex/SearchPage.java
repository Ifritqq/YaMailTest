package org.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'text')]")
    private WebElement textArea;

    @FindBy(xpath = "//*[contains(@class, 'button mini-suggest__button button_theme_websearch')]")
    private WebElement searchButton;

    @FindBy(css = ".bno > h2:nth-child(1) > a:nth-child(2)")
    private WebElement result;


    public void inputTextArea(String txtSearch) {

        textArea.sendKeys(txtSearch);
    }

    public void clickSearchButton() {

        searchButton.click();
    }

    public void clickResultButton() {

        result.click();
    }

}
