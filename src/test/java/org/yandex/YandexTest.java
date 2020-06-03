package org.yandex;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class YandexTest {

    public static SearchPage searchPage;
    public static XmlFileCreate xmlFileCreate;
    public static MailPage mailPage;
    public static WebDriver driver;
    public static String rndStrLog;
    public static String errorText = "Такого аккаунта нет";


    @BeforeAll()
    public static void setup() {

        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        mailPage = new MailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
        rndStrLog = ConfProperties.getRandString();

    }

    @Test
    public void startTest() {
        searchPage.inputTextArea("Яндекс почта");
        searchPage.clickSearchButton();
        searchPage.clickResultButton();

        mailPage.switchTab();
        mailPage.scrollPageDown();
        mailPage.pushEnterOutsideButton();
        mailPage.inputTextLoginArea(rndStrLog);
        mailPage.clickEnterButtonInside();

        assertEquals(mailPage.loginError(), errorText);

    }

    @AfterAll()
    public static void finalStep() {
        xmlFileCreate = new XmlFileCreate();
        driver.quit();
    }
}
