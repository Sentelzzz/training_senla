package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import page.MainPage;
import utils.ParseUtil;
import utils.driver.DriverSingleton;

public class NavigateSteps {

    private final Logger logger = LogManager.getLogger(NavigateSteps.class);

    public void openMainPage() {
        logger.info("Open main page.");
        MainPage mainPage = new MainPage();
        DriverSingleton.getInstance().getDriver().navigate().to(String.format(ParseUtil.settingsParser("mainUrl"),
                ParseUtil.testParser("login"), ParseUtil.testParser("password")));
        Assert.assertTrue(mainPage.mainPageIsOpen(), "Main page isn't opened!");
    }
}
