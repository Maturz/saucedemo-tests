# SauceDemo End-to-End Tests

Automated end-to-end tests for [saucedemo.com](https://www.saucedemo.com/) using Selenium WebDriver, TestNG, and Allure reporting.

---

## Project Structure
saucedemo-tests/
├── src/
│ ├── main/java/
│ │ ├── pages/ # Page Object classes
│ │ │ ├── LoginPage.java
│ │ │ ├── InventoryPage.java
│ │ │ ├── CartPage.java
│ │ │ ├── CheckoutPage.java
│ │ │ └── CheckoutOverviewPage.java
│ │ └── utils/
│ │ └── DriverFactory.java
│ └── test/java/
│ ├── base/
│ │ └── BaseTest.java
│ └── tests/
│ ├── CheckoutOneItemTest.java
│ └── CheckoutMultipleItemsTest.java
├── testng.xml # Test suite (Chrome + Firefox in parallel)
└── pom.xml

text

---

## Prerequisites

| Tool | Version |
|------|---------|
| Java JDK | 17.0.6+ |
| Maven | 3.8+ |
| Google Chrome | Latest |
| Mozilla Firefox | Latest |
| Allure CLI | 2.27+ |

### Install Allure CLI
```bash
# Windows (Chocolatey)
choco install allure-commandline

# macOS
brew install allure

# Linux  
sudo apt-get install allure
```

---

## Running the Tests

### ✅ Run all tests (Chrome + Firefox parallel)
```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```


### Single test
```bash
mvn clean test -Dtest=CheckoutOneItemTest
```

### Chrome only
```bash
mvn clean test -Dbrowser=chrome -Dsurefire.suiteXmlFiles=testng.xml
```

---

## Allure Report (automatic)

**После тестов:**
```bash
allure serve target/allure-results
```


**Или статический:**
```bash
allure generate target/allure-results -o allure-report --clean
# allure-report/index.html
```

---

## Test Results Expected

**Allure Overview:**
✅ 100% PASSED (4/4 тестов)
✅ Parallel execution (Timeline)
✅ Browser labels (firefox/chrome)
✅ Features: Checkout, Login

text

---

## Technical Stack

- **Framework:** TestNG + Maven + Allure 2.27 [web:1]
- **Pattern:** Page Object Model  
- **Drivers:** ThreadLocal (parallel safe)
- **Waits:** Explicit WebDriverWait
- **Config:** config.properties

**🚀 Готово для EPAM!** 🎉
🚀 testng.xml (добавьте/обновите):
xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Saucedemo Suite" parallel="tests" thread-count="2">
  <parameter name="browser" value="firefox"/>
  <test name="Checkout Tests">
    <classes>
      <class name="tests.CheckoutOneItemTest"/>
      <class name="tests.CheckoutMultipleItemsTest"/>
    </classes>
  </test>
</suite>


text
# SauceDemo End-to-End Tests

Automated end-to-end tests for [saucedemo.com](https://www.saucedemo.com/) using Selenium WebDriver, TestNG, Maven, and Allure reporting.

---

## Project Structure
saucedemo-tests/
├── src/
│ ├── main/java/
│ │ ├── pages/ # Page Object classes
│ │ │ ├── LoginPage.java
│ │ │ ├── InventoryPage.java
│ │ │ ├── CartPage.java
│ │ │ ├── CheckoutPage.java
│ │ │ └── CheckoutOverviewPage.java
│ │ └── utils/
│ │ └── DriverFactory.java
│ └── test/java/
│ ├── base/
│ │ └── BaseTest.java
│ └── tests/
│ ├── CheckoutOneItemTest.java
│ └── CheckoutMultipleItemsTest.java
├── src/test/resources/
│ └── config.properties # Test configuration
├── testng.xml # Test suite configuration
└── pom.xml # Maven dependencies

text

---

## Prerequisites

| Tool | Version |
|------|---------|
| Java JDK | 17+ |
| Maven | 3.8+ |
| Chrome | Latest |
| Firefox | Latest |
| Allure CLI | 2.27+ |

### Install Allure CLI

**Windows:**
```bash
choco install allure-commandline
# или scoop install allure
```

**macOS:**
```bash
brew install allure
```

**Linux:**
```bash
sudo apt-get install allure
```

---

## 🚀 Running Tests

### 1. All tests (Firefox parallel)
```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

### 2. Single test
```bash
mvn clean test -Dtest=CheckoutOneItemTest
```

### 3. Chrome only
```bash
mvn clean test -Dtest=CheckoutOneItemTest -Dbrowser=chrome
```

### 4. Full flow + Allure report
```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml && allure serve target/allure-results
```

---

## 📊 Allure Report

**Auto-open after tests:**
```bash
allure serve target/allure-results
```


**Static report:**
```bash
allure generate target/allure-results -o allure-report --clean
# Open allure-report/index.html
```

---



**Allure Dashboard shows:**
