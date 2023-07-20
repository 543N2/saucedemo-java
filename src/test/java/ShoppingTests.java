import org.example.pages.BasePage;
import org.example.pages.Header;
import org.example.pages.LoginPage;
import org.example.pages.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTests {

    WebDriver driver;
    LoginPage loginPage;
    ShoppingPage shoppingPage;
    Header header;

    @BeforeMethod
    public void setUp() {
        driver = BasePage.init();
        loginPage = new LoginPage(driver);
        shoppingPage = new ShoppingPage(driver);
        header = new Header(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(shoppingPage.getPageName(), "Products");
        Assert.assertEquals(shoppingPage.getUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Add to cart button adds +1 cart badge")
    public void addToCartAddsBadge() {
        shoppingPage.addBikeLightToCart();
        Assert.assertTrue(header.cartButtonHasOneBadge());
    }

    @Test(testName = "Remove button removes cart badge")
    public void removeButtonRemovesCartBadge() throws InterruptedException {
        shoppingPage.addBikeLightToCart();
        shoppingPage.removeBikeLight();
        Assert.assertTrue(header.cartButtonHasNoBadge());
    }

}
