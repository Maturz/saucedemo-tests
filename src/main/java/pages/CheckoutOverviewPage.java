package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {
    
   
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By ITEM_TOTAL_LABEL = By.className("summary_subtotal_label");
    private static final By SUCCESS_HEADER = By.className("complete-header");
    private static final String ITEM_TOTAL_PREFIX = "Item total: $";
    private static final Duration TIMEOUT = Duration.ofSeconds(30); 
public class CheckoutPage {
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
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
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void fillForm() {
        // ✅ Chrome + Firefox OK
        WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(FIRST_NAME));
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys("Kiryl");

        wait.until(ExpectedConditions.elementToBeClickable(LAST_NAME)).sendKeys("Maturz");
        wait.until(ExpectedConditions.elementToBeClickable(ZIP_CODE)).sendKeys("12345");

        wait.until(ExpectedConditions.elementToBeClickable(CONTINUE_BUTTON)).click();
    }
}
