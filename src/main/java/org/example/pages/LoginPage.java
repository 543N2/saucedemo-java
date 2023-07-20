package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "#user-name")
    private WebElement usernameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "#login-button")
    private WebElement loginButton;
    @FindBy(css = ".error-message-container")
    private WebElement messageContainer;
    @FindBy(css = ".login_logo")
    private WebElement logoText;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String user, String password){

        waitUntilVisible(usernameInput);
        typeText(user, usernameInput);

        waitUntilVisible(passwordInput);
        typeText(password, passwordInput);

        waitUntilVisible(loginButton);
        clickElement(loginButton);
    }

    public String getPageUrl(){
        return getUrl();
    }

    public String getErrorMessage(){
        return messageContainer.getText();
    }
}
