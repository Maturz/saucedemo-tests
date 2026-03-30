package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import utils.DriverFactory;

public class CheckoutOneItemTest extends BaseTest {

    @Test
    public void testOneItemCheckout() throws InterruptedException {

        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(DriverFactory.getDriver());
        inventory.addProduct("Sauce Labs Backpack");
        inventory.openCart();

        CartPage cart = new CartPage(DriverFactory.getDriver());
        Assert.assertTrue(cart.isProductInCart("Sauce Labs Backpack"));

        cart.clickCheckout();


        CheckoutPage checkout = new CheckoutPage(DriverFactory.getDriver());
        checkout.fillForm("John", "Doe", "12345");

        CheckoutOverviewPage overview = new CheckoutOverviewPage(DriverFactory.getDriver());
        overview.finish();

        Assert.assertEquals(
                overview.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}