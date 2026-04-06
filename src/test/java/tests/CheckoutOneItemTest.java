package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import utils.DriverFactory;

public class CheckoutOneItemTest extends BaseTest {

    @Test
//    TODO this test is never tthrowing InterruptedException, so we can safely remove it from method signature
    public void testOneItemCheckout() throws InterruptedException {

        LoginPage login = new LoginPage(DriverFactory.getDriver());
//        TODO Consider moving test data to config file, so we can easily change it without need to modify code
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(DriverFactory.getDriver());
//TODO Please avoid magic strings in code, consider moving product name to constant
        inventory.addProduct("Sauce Labs Backpack");
        inventory.openCart();

        CartPage cart = new CartPage(DriverFactory.getDriver());
//        TODO DRY - we are using same product name in multiple places, consider moving it to constant
        Assert.assertTrue(cart.isProductInCart("Sauce Labs Backpack"));

        cart.clickCheckout();


        CheckoutPage checkout = new CheckoutPage(DriverFactory.getDriver());
//        TODO Magic strings
        checkout.fillForm("John", "Doe", "12345");

        CheckoutOverviewPage overview = new CheckoutOverviewPage(DriverFactory.getDriver());
        overview.finish();

        Assert.assertEquals(
                overview.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}