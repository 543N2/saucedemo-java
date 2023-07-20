import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests {

    WebDriver driver;
    LoginPage loginPage;
    ShoppingPage shoppingPage;

    @BeforeMethod
    public void setUp() {
        driver = BasePage.init();
        loginPage = new LoginPage(driver);
        shoppingPage = new ShoppingPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "valid credentials", priority = 0)
    public void validCredentials() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(shoppingPage.getPageName(), "Products");
//        Assert.assertEquals(shoppingPage.getPageName(), "Products");
        Assert.assertEquals(shoppingPage.getUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(testName = "invalid credentials", priority = 1)
    public void invalidCredentials() {
        loginPage.login("not_a_user", "not_the_password");
        Assert.assertEquals(loginPage.getUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(testName = "blank credentials", priority = 2)
    public void blankCredentials() {
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getPageUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(testName = "blank username", priority = 3)
    public void blankUsername() {
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getPageUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(testName = "blank password", priority = 4)
    public void blankPassword() {
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getPageUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

}
