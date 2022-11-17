package pageForSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(), 'Вас приветствует ЗАГС!')]")
    private WebElement mainPageHeader;

    @FindBy(xpath = "//button[contains(text(), 'Войти как пользователь')]")
    private WebElement loginLikeUserButton;

    @Step("Check that unique element on main page is exist.")
    public boolean mainPageIsOpen() {
        return mainPageHeader.isDisplayed();
    }

    @Step("Click login like user button.")
    public void loginLikeUser() {
        logger.info("Click login like user button,");
        loginLikeUserButton.click();
    }
}
