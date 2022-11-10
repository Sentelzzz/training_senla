package pageForSelenide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ApplicantsPage {

    private static final Logger logger = LogManager.getLogger(ApplicantsPage.class);

    public static final String APPLICANTS_PAGE_HEADER = "//h2//span[contains(text(), 'Вы вошли как пользователь')]";
    public static final String SECOND_NAME_INPUT = "//input[@id='TextInputField-1']";
    public static final String FIRST_NAME_INPUT = "//input[@id='TextInputField-2']";
    public static final String MIDDLE_NAME_INPUT = "//input[@id='TextInputField-3']";
    public static final String PHONE_NUMBER_INPUT = "//input[@id='TextInputField-4']";
    public static final String PASSPORT_NUMBER_INPUT = "//input[@id='TextInputField-5']";
    public static final String NEXT_BUTTON = "//button[contains(text(), 'Далее')]";

    public By getApplicantsPageHeader() {
        return By.xpath(APPLICANTS_PAGE_HEADER);
    }

    public void fillSecondNameField(String secondName) {
        logger.info("Fill second name field.");
        $(By.xpath(SECOND_NAME_INPUT)).sendKeys(secondName);
    }

    public void fillFirstNameField(String firstName) {
        logger.info("Fill first name field.");
        $(By.xpath(FIRST_NAME_INPUT)).sendKeys(firstName);
    }

    public void fillMiddleNameField(String middleName) {
        logger.info("Fill middle name field.");
        $(By.xpath(MIDDLE_NAME_INPUT)).sendKeys(middleName);
    }

    public void fillPhoneNumberField(String phoneNumber) {
        logger.info("Fill phone number field.");
        $(By.xpath(PHONE_NUMBER_INPUT)).sendKeys(phoneNumber);
    }

    public void fillPassportNumberField(String passportNumber) {
        logger.info("Fill passport number field.");
        $(By.xpath(PASSPORT_NUMBER_INPUT)).sendKeys(passportNumber);
    }

    public By getNextButton() {
        return By.xpath(NEXT_BUTTON);
    }

    public void clickNextButton() {
        logger.info("Click next button.");
        $(By.xpath(NEXT_BUTTON)).click();
    }
}
