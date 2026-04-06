package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
import pages.*;

public class BaseTest {
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cart;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("firefox") String browser) {
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
        
        // ✅ Инициализация page objects
        loginPage = new LoginPage(DriverFactory.getDriver());
        inventoryPage = new InventoryPage(DriverFactory.getDriver());
        cart = new CartPage(DriverFactory.getDriver());
        checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutOverviewPage = new CheckoutOverviewPage(DriverFactory.getDriver());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
