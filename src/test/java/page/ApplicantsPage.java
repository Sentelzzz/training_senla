package page;

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

    public void clickNextButton() {
        nextButton.click();
    }

    public boolean applicantsPageIsOpen() {
        return applicantsPageHeader.isDisplayed();
    }

    public void fillSecondNameField(String secondName) {
        secondNameInput.sendKeys(secondName);
    }

    public void fillFirstNameField(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillMiddleNameField(String middleName) {
        middleNameInput.sendKeys(middleName);
    }

    public void fillPhoneNumberField(Integer phoneNumber) {
        phoneNumberInput.sendKeys("" + phoneNumber);
    }

    public void fillPassportNumberField(String passportNumber) {
        passportNumberInput.sendKeys(passportNumber);
    }

    public boolean nextButtonIsClickable() {
        return nextButton.isEnabled();
    }

    public String getFirstNameFieldText() {
        return firstNameInput.getAttribute("defaultValue");
    }

    public String getSecondNameFieldText() {
        return secondNameInput.getAttribute("defaultValue");
    }

    public String getMiddleNameFieldText() {
        return middleNameInput.getAttribute("defaultValue");
    }

    public String getPhoneNumberFieldText() {
        return phoneNumberInput.getAttribute("defaultValue");
    }

    public String getPassportNumberFieldText() {
        return passportNumberInput.getAttribute("defaultValue");
    }

    public boolean isSecondNameAriaInvalid() {
        return Boolean.parseBoolean(secondNameInput.getAttribute("ariaInvalid"));
    }

    public boolean isFirstNameAriaInvalid() {
        return Boolean.parseBoolean(firstNameInput.getAttribute("ariaInvalid"));
    }

    public boolean isMiddleNameAriaInvalid() {
        return Boolean.parseBoolean(middleNameInput.getAttribute("ariaInvalid"));
    }

    public boolean isPhoneNumberAriaInvalid() {
        return Boolean.parseBoolean(phoneNumberInput.getAttribute("ariaInvalid"));
    }

    public boolean isPassportNumberAriaInvalid() {
        return Boolean.parseBoolean(passportNumberInput.getAttribute("ariaInvalid"));
    }

}
