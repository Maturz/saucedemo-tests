package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public double getItemTotalValue() {

        String totalText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("summary_subtotal_label"))
        ).getText();

        String value = totalText.replace("Item total: $", "");
        return Double.parseDouble(value);
    }

    public void finish() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
    }

    public String getSuccessMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))
        ).getText();
    }
}