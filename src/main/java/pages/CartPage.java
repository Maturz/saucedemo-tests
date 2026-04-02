package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) {
//        TODO - please extract selector to a constant and use it here
//        TODO consider using BasePage class and encapsulate all interaction with driver there,
//         so you can reuse it in all pages
        return driver.findElements(By.xpath("//div[@class='cart_item']//div[text()='" + productName + "']")).size() > 0;
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
}