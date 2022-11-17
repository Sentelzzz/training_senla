package pageForSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceSelectionPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(), 'Регистрация брака')]")
    private WebElement marriageRegistrationsButton;

    @FindBy(xpath = "//button[contains(text(), 'Регистрация рождения')]")
    private WebElement birthRegistrationButton;

    @Step("Check that unique element on service selection page is exist.")
    public boolean isServicePageOpen() {
        return marriageRegistrationsButton.isDisplayed();
    }

    @Step("Click marriage registration button.")
    public void clickMarriageRegistrationButton() {
        logger.info("Click marriage registration button.");
        marriageRegistrationsButton.click();
    }

    @Step("Click birth registration button.")
    public void clickOnBirthRegistrationButton() {
        logger.info("Click birth registration button.");
        birthRegistrationButton.click();
    }
}
