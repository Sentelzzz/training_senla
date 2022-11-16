package pageForSelenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceSelectionPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(), 'Регистрация брака')]")
    private WebElement marriageRegistrationsButton;

    @FindBy(xpath = "//button[contains(text(), 'Регистрация рождения')]")
    private WebElement birthRegistrationButton;

    public boolean isServicePageOpen() {
        return marriageRegistrationsButton.isDisplayed();
    }

    public void clickMarriageRegistrationButton() {
        logger.info("Click marriage registration button.");
        marriageRegistrationsButton.click();
    }

    public void clickOnBirthRegistrationButton() {
        logger.info("Click birth registration button.");
        birthRegistrationButton.click();
    }
}
