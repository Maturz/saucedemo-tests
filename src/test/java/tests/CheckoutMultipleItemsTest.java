package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import utils.DriverFactory;

public class CheckoutMultipleItemsTest extends BaseTest {

    @Test
    public void testMultipleItemsCheckout() throws InterruptedException {

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

        Assert.assertEquals(actual, expected);

        overview.finish();

        Assert.assertEquals(
                overview.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}
