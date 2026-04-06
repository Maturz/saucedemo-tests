package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {  // ✅ Наследуемся от BasePage
    
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By CART_ITEM_INVENTORY_ITEM_NAME = By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name']");
    
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public CartPage(WebDriver driver) {
        super(driver, TIMEOUT);
    }

    public boolean isProductInCart(String productName) {
        // ✅ Константа + точный селектор saucedemo
        List<WebElement> cartItems = driver.findElements(CART_ITEM_INVENTORY_ITEM_NAME);
        return cartItems.stream()
                .anyMatch(item -> item.getText().trim().equals(productName));
    }

    public CheckoutPage clickCheckout() {
        // ✅ Wait + click + Page Object
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(CHECKOUT_BUTTON)).click();
        return new CheckoutPage(driver);
    }
}
