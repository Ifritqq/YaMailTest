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

    @FindBy(xpath = "//a[contains(@class, 'link link_theme_outer') and contains(@href, 'https://mail.yandex.ru/')]")
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
