package pageForSelenium;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//button[contains(text(), 'Далее')]")
    private WebElement nextButton;

    @Step("Check that unique element on marriage page is exist.")
    public boolean isMarriagePageOpen() {
        return uniqueMarriagePageLabel.isDisplayed();
    }

    @Step("Fill date of marriage registration field.")
    public void fillDateOfRegistrationField(int dateOfRegistration) {
        logger.info("Fill date of registration field.");
        dateOfRegistrationInput.sendKeys("" + dateOfRegistration);
    }

    @Step("Fill second name of spouse field.")
    public void  fillSecondNameOfSpouseField(String secondNameOfSpouse) {
        logger.info("Fill second name of spouse field.");
        secondNameOfSpouseInput.sendKeys(secondNameOfSpouse);
    }

    @Step("Fill first name of spouse field.")
    public void fillFirstNameOfSpouseField(String firstNameOfSpouse) {
        logger.info("Fill first name of spouse field.");
        firstNameOfSpouseInput.sendKeys(firstNameOfSpouse);
    }

    @Step("Fill middle name of spouse field.")
    public void fillMiddleNameOfSpouseField(String middleNameOfSpouse) {
        logger.info("Fill middle name of spouse field.");
        middleNameOfSpouseInput.sendKeys(middleNameOfSpouse);
    }

    @Step("Fill date of birth field.")
    public void fillDateOfBirthField(int dateOfSpouseBirth) {
        logger.info("Fill date of birth field.");
        dateOfBirthSpouseInput.sendKeys("" + dateOfSpouseBirth);
    }

    @Step("Fill spouse passport number field.")
    public void fillPassportNumberSpouseField(String passportNumberSpouse) {
        logger.info("Fill spouse passport number field.");
        passportNumberOfSpouseInput.sendKeys(passportNumberSpouse);
    }

    @Step("Click finish button.")
    public void clickFinishButton() {
        logger.info("Click finish button.");
        finishButton.click();
    }

    @Step("Check that finish button is clickable.")
    public boolean isFinishButtonEnable() {
        return finishButton.isEnabled();
    }

    @Step("Click next button.")
    public void clickNextButton() {
        nextButton.click();
    }
}
