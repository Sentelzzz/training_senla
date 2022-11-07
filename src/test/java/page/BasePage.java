package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.driver.DriverSingleton;

public class BasePage {

    protected WebDriver webDriver = DriverSingleton.getInstance().getDriver();

    protected BasePage() {
        PageFactory.initElements(webDriver, this);
    }
}
