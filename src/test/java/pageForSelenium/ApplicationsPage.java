package pageForSelenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationsPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(), 'Создать новую заявку')]")
    private WebElement refreshButton;

    public boolean isRefreshButtonExist() {
        return refreshButton.isDisplayed();
    }

}
