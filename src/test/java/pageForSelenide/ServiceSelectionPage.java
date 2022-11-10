package pageForSelenide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ServiceSelectionPage {

    private static final Logger logger = LogManager.getLogger(ServiceSelectionPage.class);

    public static final String MARRIAGE_REGISTRATION_BUTTON = "//button[contains(text(), 'Регистрация брака')]";
    public static final String CLOSE_BUTTON = "//button[contains(text(), 'Закрыть')]";
    public static final String BACK_BUTTON = "//button[contains(text(), 'Назад')]";

    public By getMarriageRegistrationButton() {
        return By.xpath(MARRIAGE_REGISTRATION_BUTTON);
    }

    public void clickCloseButton() {
        logger.info("Click close button.");
        $(By.xpath(CLOSE_BUTTON)).click();
    }

    public void clickBackButton() {
        logger.info("Click back button.");
        $(By.xpath(BACK_BUTTON)).click();
    }

    public void clickMarriageRegistrationButton() {
        logger.info("Click marriage registrations button.");
        $(By.xpath(MARRIAGE_REGISTRATION_BUTTON)).click();
    }
}
