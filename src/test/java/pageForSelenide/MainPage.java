package pageForSelenide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public static final String LOGIN_LIKE_USER_BUTTON = "//button[contains(text(), 'Войти как пользователь')]";
    public static final String MAIN_PAGE_HEADER = "//h2[contains(text(), 'Вас приветствует ЗАГС!')]";

    public boolean mainPageIsOpen() {
        return $(By.xpath(MAIN_PAGE_HEADER)).isDisplayed();
    }

    public void loginLikeUser() {
        logger.info("Click login like user button,");
        $(By.xpath(LOGIN_LIKE_USER_BUTTON)).click();
    }

    public By getMainPageHeader() {
        return By.xpath(MAIN_PAGE_HEADER);
    }
}
