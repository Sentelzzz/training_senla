package pageForSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationsPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(), 'Создать новую заявку')]")
    private WebElement refreshButton;

    @Step("Check that unique element on application page is exist.")
    public boolean isRefreshButtonExist() {
        return refreshButton.isDisplayed();
    }

}
