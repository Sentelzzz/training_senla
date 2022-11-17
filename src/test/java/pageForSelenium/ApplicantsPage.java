package pageForSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicantsPage extends BasePage{

    @FindBy(xpath = "//h2//span[contains(text(), 'Вы вошли как пользователь')]")
    private WebElement applicantsPageHeader;

    @FindBy(xpath = "//input[@id='TextInputField-1']")
    private WebElement secondNameInput;

    @FindBy(xpath = "//input[@id='TextInputField-2']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='TextInputField-3']")
    private WebElement middleNameInput;

    @FindBy(xpath = "//input[@id='TextInputField-4']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id='TextInputField-5']")
    private WebElement passportNumberInput;

    @FindBy(xpath = "//button[contains(text(), 'Далее')]")
    private WebElement nextButton;

    @FindBy(xpath = "//*[name()='svg']")
    private WebElement colorIndicator;

    public String getColorOfIndicator(int indicatorNumber) {
        return webDriver.findElements(By.xpath("//*[name()='svg']")).get(indicatorNumber).getCssValue("color");
    }

    @Step("Click next button.")
    public void clickApplicantsNextButton() {
        logger.info("Click next button.");
        nextButton.click();
    }

    public boolean applicantsPageIsOpen() {
        return applicantsPageHeader.isDisplayed();
    }

    @Step("Fill second name field.")
    public void fillSecondNameField(String secondName) {
        logger.info("Fill second name field.");
        secondNameInput.sendKeys(secondName);
    }

    @Step("Fill first name field.")
    public void fillFirstNameField(String firstName) {
        logger.info("Fill first name field.");
        firstNameInput.sendKeys(firstName);
    }

    @Step("Fill middle name field.")
    public void fillMiddleNameField(String middleName) {
        logger.info("Fill middle name field.");
        middleNameInput.sendKeys(middleName);
    }

    @Step("Fill phone number field.")
    public void fillPhoneNumberField(Integer phoneNumber) {
        logger.info("Fill phone number field.");
        phoneNumberInput.sendKeys("" + phoneNumber);
    }

    @Step("Fill passport number field.")
    public void fillPassportNumberField(String passportNumber) {
        logger.info("Fill passport number field.");
        passportNumberInput.sendKeys(passportNumber);
    }

    @Step("Check that next button is clickable.")
    public boolean nextButtonIsClickable() {
        return nextButton.isEnabled();
    }

    public String getFirstNameFieldText() {
        logger.info("Get text from first name field.");
        return firstNameInput.getAttribute("defaultValue");
    }

    public String getSecondNameFieldText() {
        logger.info("Get text from second name field.");
        return secondNameInput.getAttribute("defaultValue");
    }

    public String getMiddleNameFieldText() {
        logger.info("Get text from middle name field.");
        return middleNameInput.getAttribute("defaultValue");
    }

    public String getPhoneNumberFieldText() {
        logger.info("Get text from phone number field.");
        return phoneNumberInput.getAttribute("defaultValue");
    }

    public String getPassportNumberFieldText() {
        logger.info("Get text from passport number field.");
        return passportNumberInput.getAttribute("defaultValue");
    }

    @Step("Check that second name field has red border.")
    public boolean isSecondNameAriaInvalid() {
        logger.info("Check that field have red border.");
        return Boolean.parseBoolean(secondNameInput.getAttribute("ariaInvalid"));
    }

    @Step("Check that first name field has red border.")
    public boolean isFirstNameAriaInvalid() {
        logger.info("Check that field have red border.");
        return Boolean.parseBoolean(firstNameInput.getAttribute("ariaInvalid"));
    }

    @Step("Check that middle name field has red border.")
    public boolean isMiddleNameAriaInvalid() {
        logger.info("Check that field have red border.");
        return Boolean.parseBoolean(middleNameInput.getAttribute("ariaInvalid"));
    }

    @Step("Check that phone number field field has red border.")
    public boolean isPhoneNumberAriaInvalid() {
        logger.info("Check that field have red border.");
        return Boolean.parseBoolean(phoneNumberInput.getAttribute("ariaInvalid"));
    }

    @Step("Check that passport number field has red border.")
    public boolean isPassportNumberAriaInvalid() {
        logger.info("Check that field have red border.");
        return Boolean.parseBoolean(passportNumberInput.getAttribute("ariaInvalid"));
    }

}
