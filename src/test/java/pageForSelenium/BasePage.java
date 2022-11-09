package pageForSelenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.driver.DriverSingleton;

public class BasePage {

    protected WebDriver webDriver = DriverSingleton.getInstance().getDriver();
    protected final Logger logger = LogManager.getLogger(BasePage.class);

    protected BasePage() {
        PageFactory.initElements(webDriver, this);
    }
}
