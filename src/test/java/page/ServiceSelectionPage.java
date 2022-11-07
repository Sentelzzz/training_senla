package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceSelectionPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(), 'Регистрация брака')]")
    private WebElement marriageRegistrationsButton;

    public boolean isMarriagePageOpen() {
        return marriageRegistrationsButton.isDisplayed();
    }

    public void clickMarriageRegistrationButton() {
        marriageRegistrationsButton.click();
    }
}
