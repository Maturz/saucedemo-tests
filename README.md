<<<<<<< HEAD
# saucedemo-tests
=======
# SauceDemo End-to-End Tests

Automated end-to-end tests for [saucedemo.com](https://www.saucedemo.com/) using Selenium WebDriver, TestNG, and Allure reporting.

---

## Project Structure

```
saucedemo-tests/
├── src/
│   ├── main/java/
│   │   ├── pages/              # Page Object classes
│   │   │   ├── LoginPage.java
│   │   │   ├── InventoryPage.java
│   │   │   ├── CartPage.java
│   │   │   ├── CheckoutPage.java
│   │   │   └── CheckoutOverviewPage.java
│   │   └── utils/
│   │       └── DriverFactory.java
│   └── test/java/
│       ├── base/
│       │   └── BaseTest.java
│       └── tests/
│           ├── CheckoutOneItemTest.java
│           └── CheckoutMultipleItemsTest.java
├── testng.xml                  # Test suite (Chrome + Firefox in parallel)
└── pom.xml
```

---

## Prerequisites

| Tool | Version |
|------|---------|
| Java JDK | 17.0.6+ |
| Maven | 3.8+ |
| Google Chrome | Latest |
| Mozilla Firefox | Latest |
| Allure CLI | 2.27+ (for HTML report) |

> Chrome and Firefox must be installed on your machine. Selenium 4 manages drivers automatically — no manual driver download needed.

### Install Allure CLI (for report generation)

**Windows (Scoop):**
```bash
scoop install allure
```

**macOS (Homebrew):**
```bash
brew install allure
```

**Linux:**
```bash
sudo apt-get install allure
```

Or download from [https://github.com/allure-framework/allure2/releases](https://github.com/allure-framework/allure2/releases)

---

## Running the Tests

### Run all tests (Chrome + Firefox in parallel)

```bash
mvn clean test
```

This executes both `CheckoutOneItemTest` and `CheckoutMultipleItemsTest` simultaneously in Chrome and Firefox, as configured in `testng.xml`.

### Customize the product names

Product names are parametrized in `testng.xml`. To test with different products, edit the parameter values:

```xml
<parameter name="productName" value="Sauce Labs Fleece Jacket"/>
<parameter name="productName1" value="Sauce Labs Fleece Jacket"/>
<parameter name="productName2" value="Sauce Labs Bolt T-Shirt"/>
```

Available products on the site:
- Sauce Labs Backpack
- Sauce Labs Bike Light
- Sauce Labs Bolt T-Shirt
- Sauce Labs Fleece Jacket
- Sauce Labs Onesie
- Test.allTheThings() T-Shirt (Red)

---

## Generating the Allure Report

After running the tests, raw results are saved to `allure-results/`.

### Option 1 — Open in browser immediately (recommended)

```bash
allure serve allure-results
```

This starts a local server and opens the report automatically in your browser.

### Option 2 — Generate static HTML report

```bash
allure generate allure-results --clean -o allure-report
```

Then open `allure-report/index.html` in your browser.

### Option 3 — Via Maven plugin

```bash
mvn allure:report
```

Report will be generated at `target/site/allure-maven-plugin/index.html`.

---

## Test Cases

### UC-1: Checkout Flow (one item)
1. Login with `standard_user`
2. Add a parametrized product to the cart
3. Validate the item is present in the cart
4. Proceed to checkout and fill in the information form
5. Complete checkout and verify the success message: **"Thank you for your order!"**

### UC-2: Checkout Flow (several items)
1. Login with `standard_user`
2. Add two parametrized products to the cart
3. Validate both items are present in the cart
4. Proceed to checkout and fill in the information form
5. Validate the displayed item total equals the sum of both product prices
6. Complete checkout and verify the success message: **"Thank you for your order!"**

---

## Technical Details

- **Pattern:** Page Object Model (POM)
- **Browsers:** Chrome and Firefox (run in parallel via TestNG)
- **Locators:** CSS Selectors and XPath
- **Parallelism:** `ThreadLocal<WebDriver>` in `DriverFactory` ensures thread safety
- **Waits:** Explicit waits (`WebDriverWait`) used in `CheckoutPage` and `CheckoutOverviewPage`
- **Reporting:** Allure 2.27
>>>>>>> dfba88e (solution is ready)
# saucedemo-tests
