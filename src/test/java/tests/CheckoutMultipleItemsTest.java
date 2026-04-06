package tests;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import utils.DriverFactory;
import utils.ScreenshotUtils;

public class CheckoutMultipleItemsTest extends BaseTest {

    @Step("Multiple items checkout flow")
    @Test
    public void testMultipleItemsCheckout() {
        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(DriverFactory.getDriver());

        double price1 = inventory.getProductPrice("Sauce Labs Backpack");
        inventory.addProduct("Sauce Labs Backpack");

        double price2 = inventory.getProductPrice("Sauce Labs Bike Light");
        inventory.addProduct("Sauce Labs Bike Light");

        inventory.openCart();

        CartPage cart = new CartPage(DriverFactory.getDriver());
        Assert.assertTrue(cart.isProductInCart("Sauce Labs Backpack"));
        Assert.assertTrue(cart.isProductInCart("Sauce Labs Bike Light"));

        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(DriverFactory.getDriver());
        checkout.fillForm("John", "Doe", "12345");

        CheckoutOverviewPage overview = new CheckoutOverviewPage(DriverFactory.getDriver());

        double expected = price1 + price2;
        double actual = overview.getItemTotalValue();
        Assert.assertEquals(actual, expected, "Item total не совпадает");

        overview.finish();

        // ✅ ФИКС строки 29:
        Assert.assertTrue(
            overview.getSuccessMessage().contains("Thank you"), 
            "Order complete message не найден"
        );
        
        // 🏆 Allure скриншот
        attachScreenshot("Order Complete Success");
    }
    
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) DriverFactory.getDriver())
            .getScreenshotAs(OutputType.BYTES);
    }
}
