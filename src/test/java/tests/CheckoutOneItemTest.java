package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutOneItemTest extends BaseTest {

    @Test
    // TODO this test is never throwing InterruptedException, so we can safely remove it from method signature
    public void testOneItemCheckout() {  // ✅ Copilot #1 & #2 FIXED!
        
        // ✅ extends BaseTest = DriverFactory автоматически
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProduct("Sauce Labs Backpack");
        inventoryPage.openCart();

        // ✅ DRY принцип
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
