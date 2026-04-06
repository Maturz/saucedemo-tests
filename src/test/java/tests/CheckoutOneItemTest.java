package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutOneItemTest extends BaseTest {

    @Test
    public void testOneItemCheckout() { 
        
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");
        inventoryPage.openCart();

        Assert.assertTrue(cart.isProductInCart("Sauce Labs Backpack"));

        cart.clickCheckout();

        checkoutPage.fillForm("John", "Doe", "12345");

        checkoutOverviewPage.finish();

        Assert.assertEquals(
            checkoutOverviewPage.getSuccessMessage(),
            "Thank you for your order!"
        );
    }
}
