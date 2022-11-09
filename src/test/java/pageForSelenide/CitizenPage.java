package pageForSelenide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CitizenPage {

    private static final Logger logger = LogManager.getLogger(ApplicantsPage.class);

    public static final String UNIQUE_FIELD_CITIZEN_FORM_LABEL = "//label[contains(text(), 'Пол')]";
    public static final String SECOND_NAME_INPUT = "//input[@id='TextInputField-6']";
    public static final String FIRST_NAME_INPUT = "//input[@id='TextInputField-7']";
    public static final String MIDDLE_NAME_INPUT = "//input[@id='TextInputField-8']";
    public static final String DATE_OF_BIRTH_INPUT = "//input[@id='TextInputField-9']";
    public static final String PASSPORT_NUMBER_INPUT = "//input[@id='TextInputField-10']";
    public static final String GENDER_INPUT = "//input[@id='TextInputField-11']";
    public static final String NEXT_BUTTON = "//button[contains(text(), 'Далее')]";

    public boolean isDisplayedUniqueElement() {
        return $(By.xpath(UNIQUE_FIELD_CITIZEN_FORM_LABEL)).isDisplayed();
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

    public void fillDateOfBirthField(int dateOfBirth) {
        logger.info("Fill date of birth field.");
        $(By.xpath(DATE_OF_BIRTH_INPUT)).sendKeys("" + dateOfBirth);
    }

    public void fillPassportNumberField(String passportNumber) {
        logger.info("Fill passport number field.");
        $(By.xpath(PASSPORT_NUMBER_INPUT)).sendKeys(passportNumber);
    }

    public void fillGenderField(String gender) {
        logger.info("Fill gender field.");
        $(By.xpath(GENDER_INPUT)).sendKeys(gender);
    }

    public boolean isClickableNextButton() {
        return $(By.xpath(NEXT_BUTTON)).isEnabled();
    }
}
