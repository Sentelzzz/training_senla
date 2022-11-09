package pageForSelenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(), 'Вас приветствует ЗАГС!')]")
    private WebElement mainPageHeader;

    @FindBy(xpath = "//button[contains(text(), 'Войти как пользователь')]")
    private WebElement loginLikeUserButton;

    public boolean mainPageIsOpen() {
        return mainPageHeader.isDisplayed();
    }

    public void loginLikeUser() {
        logger.info("Click login like user button,");
        loginLikeUserButton.click();
    }
}
