package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarriagePage extends BasePage{

    @FindBy(xpath = "//label[@for='TextInputField-12']")
    private WebElement uniqueMarriagePageLabel;

    @FindBy(xpath = "//input[@id='TextInputField-12']")
    private WebElement dateOfRegistrationInput;

    @FindBy(xpath = "//input[@id='TextInputField-14']")
    private WebElement secondNameOfSpouseInput;

    @FindBy(xpath = "//input[@id='TextInputField-15']")
    private WebElement firstNameOfSpouseInput;

    @FindBy(xpath = "//input[@id='TextInputField-16']")
    private WebElement middleNameOfSpouseInput;

    @FindBy(xpath = "//input[@id='TextInputField-17']")
    private WebElement dateOfBirthSpouseInput;

    @FindBy(xpath = "//input[@id='TextInputField-18']")
    private WebElement passportNumberOfSpouseInput;

    @FindBy(xpath = "//button[contains(text(), 'Завершить')]")
    private WebElement finishButton;

    public boolean isMarriagePageOpen() {
        return uniqueMarriagePageLabel.isDisplayed();
    }

    public void fillDateOfRegistrationField(int dateOfRegistration) {
        logger.info("Fill date of registration field.");
        dateOfRegistrationInput.sendKeys("" + dateOfRegistration);
    }

    public void  fillSecondNameOfSpouseField(String secondNameOfSpouse) {
        logger.info("Fill second name of spouse field.");
        secondNameOfSpouseInput.sendKeys(secondNameOfSpouse);
    }

    public void fillFirstNameOfSpouseField(String firstNameOfSpouse) {
        logger.info("Fill first name of spouse field.");
        firstNameOfSpouseInput.sendKeys(firstNameOfSpouse);
    }

    public void fillMiddleNameOfSpouseField(String middleNameOfSpouse) {
        logger.info("Fill middle name of spouse field.");
        middleNameOfSpouseInput.sendKeys(middleNameOfSpouse);
    }

    public void fillDateOfBirthField(int dateOfSpouseBirth) {
        logger.info("Fill date of birth field.");
        dateOfBirthSpouseInput.sendKeys("" + dateOfSpouseBirth);
    }

    public void fillPassportNumberSpouseField(String passportNumberSpouse) {
        logger.info("Fill spouse passport number field.");
        passportNumberOfSpouseInput.sendKeys(passportNumberSpouse);
    }

    public void clickFinishButton() {
        logger.info("Click finish button.");
        finishButton.click();
    }

    public boolean isFinishButtonEnable() {
        return finishButton.isEnabled();
    }
}
