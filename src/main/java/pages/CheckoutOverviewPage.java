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
//        TODO please extract timeout value to a constant and use it here
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public double getItemTotalValue() {

        String totalText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("summary_subtotal_label"))
        ).getText();
        //TODO - please dont use magic strings, extract "Item total: $" to a constant and use it here
        String value = totalText.replace("Item total: $", "");
        return Double.parseDouble(value);
    }

    public void finish() {
        //TODO please extract selectors to constants and use them here
        //TODO - I recommend you to find more suitable name for this method,
        // because it is not clear what exactly it does,
        // and it is not clear that it returns item total value
//        TODO Why we use both wait for visibility and clickability? I think it is enough to wait for clickability, because it already implies visibility
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
    }

    public String getSuccessMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))
        ).getText();
    }
}