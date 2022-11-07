package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.driver.DriverSingleton;

public class BaseTest {

    protected WebDriver driver;
    protected final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void openBrowser() {
        driver = DriverSingleton.getInstance().getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }
}
