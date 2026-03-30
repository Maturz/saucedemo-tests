package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void openCart() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

    public double getProductPrice(String productName) {
        String priceText = driver.findElement(By.xpath("//div[text()='" + productName + "']/../../..//div[@class='inventory_item_price']")).getText();
        return Double.parseDouble(priceText.replace("$", ""));
    }
}