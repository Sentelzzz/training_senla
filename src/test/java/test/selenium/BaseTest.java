package test.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.ParseUtil;
import utils.TestListener;
import utils.driver.DriverSingleton;

import java.io.File;

@Listeners(TestListener.class)
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

    @AfterSuite
    public void addLogs() {
        File logs = new File(ParseUtil.settingsParser("logsFile"));
        TestListener.appendLogToAllure(logs);
    }
}
