package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutOverviewPage {  // ✅ CheckoutOverviewPage (НЕ CheckoutPage!)
    
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By ITEM_TOTAL_LABEL = By.xpath("//div[contains(@class, 'summary_subtotal_label')]");  // ✅ XPath!
    private static final By SUCCESS_HEADER = By.className("complete-header");
    private static final String ITEM_TOTAL_PREFIX = "Item total: $";
    private static final Duration TIMEOUT = Duration.ofSeconds(30); 

    private final WebDriver driver;     // ✅ Добавлены поля
    private final WebDriverWait wait;   // ✅

    public CheckoutOverviewPage(WebDriver driver) {  // ✅ Конструктор
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public double getItemTotalValue() {
        WebElement subtotal = wait.until(ExpectedConditions.visibilityOfElementLocated(ITEM_TOTAL_LABEL));
        String text = subtotal.getText();
        String value = text.replace(ITEM_TOTAL_PREFIX, "");
        return Double.parseDouble(value);
    }

    public void finish() {  // finish() для CheckoutMultipleItemsTest
        wait.until(ExpectedConditions.elementToBeClickable(FINISH_BUTTON)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_HEADER)).getText();
    }
}
