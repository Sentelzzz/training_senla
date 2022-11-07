package service;

import org.testng.Assert;
import page.MainPage;
import test.BaseTest;
import utils.ParseUtil;
import utils.driver.DriverSingleton;

public class NavigateSteps extends BaseTest {

    public void openMainPage() {
        logger.info("Open main page.");
        MainPage mainPage = new MainPage();
        DriverSingleton.getInstance().getDriver().navigate().to(String.format(ParseUtil.settingsParser("mainUrl"),
                ParseUtil.testParser("login"), ParseUtil.testParser("password")));
        Assert.assertTrue(mainPage.mainPageIsOpen(), "Main page isn't opened!");
    }
}
