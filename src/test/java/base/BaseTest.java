package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        DriverFactory.initDriver(browser);
//        TODO Consider moving URL to config file, so we can easily change it without need to modify code
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}