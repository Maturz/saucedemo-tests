package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By ITEM_TOTAL_LABEL = By.className("summary_subtotal_label");
    private static final By SUCCESS_HEADER = By.className("complete-header");
    private static final String ITEM_TOTAL_PREFIX = "Item total: $";
    private static final Duration TIMEOUT = Duration.ofSeconds(15); // для Chrome

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public double getItemTotalValue() {
        String totalText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ITEM_TOTAL_LABEL)
        ).getText();
        String value = totalText.replace(ITEM_TOTAL_PREFIX, "");
        return Double.parseDouble(value);
    }


    public void completeCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(FINISH_BUTTON)).click();
    }

    public String getSuccessMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(SUCCESS_HEADER)
        ).getText();
    }
}
