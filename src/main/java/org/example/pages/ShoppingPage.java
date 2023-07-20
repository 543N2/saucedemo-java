package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingPage extends BasePage {

    @FindBy(css = ".title")
    private WebElement productTitleText;
    @FindBy(css = "#add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCartButton;
    @FindBy(css = "#remove-sauce-labs-bike-light")
    private WebElement bikeLightRemoveButton;

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    public String getPageName() {
        waitUntilVisible(productTitleText);
        return getText(productTitleText);
    }

    public void addBikeLightToCart() {
        waitUntilVisible(bikeLightAddToCartButton);
        clickElement(bikeLightAddToCartButton);
    }

    public void removeBikeLight(){
        waitUntilVisible(bikeLightRemoveButton);
        clickElement(bikeLightRemoveButton);
    }




}
