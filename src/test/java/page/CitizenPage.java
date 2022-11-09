package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitizenPage extends BasePage{

    @FindBy(xpath = "//label[contains(text(), 'Пол')]")
    private WebElement uniqueFieldCitizenFormLabel;

    @FindBy(xpath = "//input[@id='TextInputField-6']")
    private WebElement secondNameInput;

    @FindBy(xpath = "//input[@id='TextInputField-7']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='TextInputField-8']")
    private WebElement middleNameInput;

    @FindBy(xpath = "//input[@id='TextInputField-9']")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//input[@id='TextInputField-10']")
    private WebElement passportNumberInput;

    @FindBy(xpath = "//input[@id='TextInputField-11']")
    private WebElement genderInput;

    @FindBy(xpath = "//button[contains(text(), 'Далее')]")
    private WebElement nextButton;

    public boolean isDisplayedUniqueElement() {
        return uniqueFieldCitizenFormLabel.isDisplayed();
    }

    public void fillSecondNameField(String secondName) {
        logger.info("Fill second name field.");
        secondNameInput.sendKeys(secondName);
    }

    public void fillFirstNameField(String firstName) {
        logger.info("Fill first name field.");
        firstNameInput.sendKeys(firstName);
    }

    public void fillMiddleNameField(String middleName) {
        logger.info("Fill middle name field.");
        middleNameInput.sendKeys(middleName);
    }

    public void fillDateOfBirthField(int dateOfBirth) {
        logger.info("Fill date of birth field.");
        dateOfBirthInput.sendKeys("" + dateOfBirth);
    }

    public void fillPassportNumberField(String passportNumber) {
        logger.info("Fill passport number field.");
        passportNumberInput.sendKeys(passportNumber);
    }

    public void fillGenderField(String gender) {
        logger.info("Fill gender field.");
        genderInput.sendKeys(gender);
    }

    public boolean isClickableNextButton() {
        return nextButton.isEnabled();
    }

    public void clickNextButton() {
        logger.info("Click next button.");
        nextButton.click();
    }
}
