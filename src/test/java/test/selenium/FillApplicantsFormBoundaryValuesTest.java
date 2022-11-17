package test.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageForSelenium.ApplicantsPage;
import pageForSelenium.MainPage;
import service.NavigateSteps;
import utils.ParseUtil;
import utils.data.DataProviders;

public class FillApplicantsFormBoundaryValuesTest extends BaseTest {

    @Test (dataProvider = "userCorrectData", dataProviderClass = DataProviders.class, description = "Fill applicants form using valid data.")
    public void fillApplicantsFormValidValues(String secondName, String firstName, String middleName, String phoneNumber, String passportNumber) {
        SoftAssert softAssert = new SoftAssert();
        NavigateSteps navigateSteps = new NavigateSteps();
        navigateSteps.openMainPage();
        MainPage mainPage = new MainPage();
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        Assert.assertTrue(applicantsPage.applicantsPageIsOpen(), "Applicants page isn't opened!");
        applicantsPage.fillSecondNameField(secondName);
        softAssert.assertEquals(secondName, applicantsPage.getSecondNameFieldText(), "Second names don't match!");
        softAssert.assertFalse(applicantsPage.isSecondNameAriaInvalid(), "Red indicator around second name field present!");
        applicantsPage.fillFirstNameField(firstName);
        softAssert.assertEquals(firstName, applicantsPage.getFirstNameFieldText(), "First names don't match!");
        softAssert.assertFalse(applicantsPage.isFirstNameAriaInvalid(), "Red indicator around first name field present");
        applicantsPage.fillMiddleNameField(middleName);
        softAssert.assertEquals(middleName, applicantsPage.getMiddleNameFieldText(), "Middle names don't match!");
        softAssert.assertFalse(applicantsPage.isMiddleNameAriaInvalid(), "Red indicator around middle name field present");
        applicantsPage.fillPhoneNumberField(ParseUtil.parseStringToInt(phoneNumber));
        softAssert.assertEquals(phoneNumber, applicantsPage.getPhoneNumberFieldText(), "Phone numbers don't match!");
        softAssert.assertFalse(applicantsPage.isPhoneNumberAriaInvalid(), "Red indicator around phone number field present");
        applicantsPage.fillPassportNumberField(passportNumber);
        softAssert.assertEquals(passportNumber, applicantsPage.getPassportNumberFieldText(), "Passport numbers don't match!");
        softAssert.assertFalse(applicantsPage.isPassportNumberAriaInvalid(), "Red indicator around passport number field present");
        Assert.assertTrue(applicantsPage.nextButtonIsClickable(), "Next button is enabled!");
        applicantsPage.clickApplicantsNextButton();
        softAssert.assertAll();
    }

    @Test(dataProvider = "userIncorrectData", dataProviderClass = DataProviders.class, description = "Fill applicants form using invalid data.")
    public void fillApplicantsFormIncorrectValues(String secondName, String firstName, String middleName, String phoneNumber, String passportNumber) {
        SoftAssert softAssert = new SoftAssert();
        NavigateSteps navigateSteps = new NavigateSteps();
        navigateSteps.openMainPage();
        MainPage mainPage = new MainPage();
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        Assert.assertTrue(applicantsPage.applicantsPageIsOpen(), "Applicants page isn't opened!");
        applicantsPage.fillSecondNameField(secondName);
        softAssert.assertFalse(applicantsPage.getSecondNameFieldText().contains(secondName), "Second names match!");
        softAssert.assertTrue(applicantsPage.isSecondNameAriaInvalid(), "Red indicator around second name field is not presented!");
        applicantsPage.fillFirstNameField(firstName);
        softAssert.assertFalse(applicantsPage.getSecondNameFieldText().contains(firstName), "First names match!");
        softAssert.assertTrue(applicantsPage.isFirstNameAriaInvalid(), "Red indicator around first name field is not presented!");
        applicantsPage.fillMiddleNameField(middleName);
        softAssert.assertFalse(applicantsPage.getSecondNameFieldText().contains(middleName), "Middle names match!");
        softAssert.assertTrue(applicantsPage.isMiddleNameAriaInvalid(), "Red indicator around middle name field is not presented!");
        applicantsPage.fillPhoneNumberField(ParseUtil.parseStringToInt(phoneNumber));
        softAssert.assertFalse(applicantsPage.getSecondNameFieldText().contains(phoneNumber), "Phone numbers match!");
        softAssert.assertTrue(applicantsPage.isPhoneNumberAriaInvalid(), "Red indicator around phone number field is not presented!");
        applicantsPage.fillPassportNumberField(passportNumber);
        softAssert.assertFalse(applicantsPage.getSecondNameFieldText().contains(passportNumber), "Passport numbers match!");
        softAssert.assertTrue(applicantsPage.isPassportNumberAriaInvalid(), "Red indicator around passport number field is not presented!");
        softAssert.assertAll();
    }


}
