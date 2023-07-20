package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    static WebDriver driver;
    static String browserName = "chrome";
    static String baseUrl = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static WebDriver init() {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickElement(WebElement element) {
        waitUntilVisible(element);
        element.click();
    }

    public void typeText(String text, WebElement element) {
        waitUntilVisible(element);
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        waitUntilVisible(element);
        return element.getText();
    }

    public boolean isVisible(WebElement element) {
        waitUntilVisible(element);
        return element.isDisplayed();
    }

}
