package pageForSelenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BirthInformationPage extends BasePage{

    @FindBy(xpath = "//label[contains(text(), 'Место рождения')]")
    private WebElement birthPageLabel;

    @FindBy(xpath = "//label[contains(text(), 'Место рождения')]//following-sibling::input")
    private WebElement birthPlaceInput;

    @FindBy(xpath = "//label[contains(text(), 'Мать')]//following-sibling::input")
    private WebElement motherInput;

    @FindBy(xpath = "//label[contains(text(), 'Отец')]//following-sibling::input")
    private WebElement fatherInput;

    @FindBy(xpath = "//button[contains(text(), 'Завершить')]")
    private WebElement finishButton;

    public void fillBirthPlaceField(String birthPlace) {
        logger.info("Fill birth place input");
        birthPlaceInput.sendKeys(birthPlace);
    }

    public void fillMotherField(String mother) {
        logger.info("Fill mother field.");
        motherInput.sendKeys(mother);
    }

    public void fillFatherField(String father) {
        logger.info("Fill father field.");
        fatherInput.sendKeys(father);
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean isBirthInformationPageOpen() {
        return birthPageLabel.isDisplayed();
    }
}
