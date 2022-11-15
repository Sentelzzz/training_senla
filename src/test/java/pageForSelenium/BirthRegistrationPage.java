package pageForSelenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BirthRegistrationPage extends BasePage{

    @FindBy(xpath = "//div[@class='MuiDialogTitle-root']//following-sibling::span")
    private WebElement registrationPageHeader;

    @FindBy(xpath = "//label[contains(text(), 'Фамилия')]//following-sibling::input")
    private WebElement secondNameInput;

    @FindBy(xpath = "//label[contains(text(), 'Имя')]//following-sibling::input")
    private WebElement firstNameInput;

    @FindBy(xpath = "//label[contains(text(), 'Отчество')]//following-sibling::input")
    private WebElement middleNameInput;

    @FindBy(xpath = "//label[contains(text(), 'Дата рождения')]//following-sibling::input")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//label[contains(text(), 'Номер паспорта')]//following-sibling::input")
    private WebElement passportNumberInput;

    @FindBy(xpath = "//label[contains(text(), 'Пол')]//following-sibling::input")
    private WebElement genderInput;

    @FindBy(xpath = "//button[contains(text(), 'Далее')]")
    private WebElement nextButton;

    public void writeSecondName(String secondName) {
        logger.info("Fill secondName field.");
        secondNameInput.sendKeys(secondName);
    }

    public void writeFirstName(String firstName) {
        logger.info("Fill firstName field.");
        firstNameInput.sendKeys(firstName);
    }

    public void writeMiddleName(String middleName) {
        logger.info("Fill middleName field.");
        middleNameInput.sendKeys(middleName);
    }

    public void writeDateOfBirth(int dateOfBirth) {
        logger.info("Fill date of birth field.");
        dateOfBirthInput.sendKeys("" + dateOfBirth);
    }

    public void writePassportNumber(String passportNumber) {
        logger.info("Fill passport number field.");
        passportNumberInput.sendKeys(passportNumber);
    }

    public void writeGender(String gender) {
        logger.info("Fill gender field.");
        genderInput.sendKeys(gender);
    }

    public boolean isBirthRegistrationOpen() {
        return registrationPageHeader.getAttribute("innerText").contains("Регистрация рождения");
    }

    public void clickNextButton() {
        logger.info("Click next button.");
        nextButton.click();
    }
}
