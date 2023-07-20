package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Header extends BasePage {

    @FindBy(css = "#shopping_cart_container>.shopping_cart_link")
    private WebElement cartButton;
    @FindBy(css = "#shopping_cart_container>.shopping_cart_link>.shopping_cart_badge")
    private WebElement cartBadgeButton;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean cartButtonHasOneBadge(){
        return isVisible(cartBadgeButton);
    }

    public boolean cartButtonHasNoBadge(){
        List<WebElement> children = cartButton.findElements(By.tagName("span"));
        return children.isEmpty();
    }
}
