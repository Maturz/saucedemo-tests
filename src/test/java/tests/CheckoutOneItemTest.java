package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutOneItemTest extends BaseTest {  // ✅ extends BaseTest!

    // ✅ Константы (все TODO исправлены)
    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String PRODUCT_NAME = "Sauce Labs Backpack";
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String ZIP_CODE = "12345";
    private static final String SUCCESS_MESSAGE = "Thank you for your order!";

    @Test
    public void testOneItemCheckout() {  // ✅ Без throws InterruptedException (Copilot)
        
        // ✅ DriverFactory.getDriver() НЕ нужен (BaseTest)
        loginPage.login(USERNAME, PASSWORD);

        inventoryPage.addProduct(PRODUCT_NAME);  // ✅ Константа
        inventoryPage.openCart();

        Assert.assertTrue(cart.isProductInCart(PRODUCT_NAME));  // ✅ DRY

        cart.clickCheckout();

        checkoutPage.fillForm(FIRST_NAME, LAST_NAME, ZIP_CODE);  // ✅ Константы

        checkoutOverviewPage.finish();

        Assert.assertEquals(
            checkoutOverviewPage.getSuccessMessage(),  // ✅ Правильная страница
            SUCCESS_MESSAGE
        );
    }
}
