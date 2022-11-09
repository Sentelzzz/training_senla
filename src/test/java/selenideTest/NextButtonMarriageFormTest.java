package selenideTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageForSelenide.ApplicantsPage;
import pageForSelenide.CitizenPage;
import pageForSelenide.MainPage;
import pageForSelenide.ServiceSelectionPage;
import utils.ParseUtil;
import utils.data.DataProviders;

import static com.codeborne.selenide.Selenide.open;

public class NextButtonMarriageFormTest extends BaseTest{

    @Test(dataProvider = "userDataForCitizenNextButtonForm", dataProviderClass = DataProviders.class)
    public void checkThatNextButtonMarriageFormInactive(String secondName, String firstName, String middleName, String dateOfBirth, String passportNumber,
                                                        String gender) {
        open(String.format(ParseUtil.settingsParser("mainUrl"), ParseUtil.testParser("login"), ParseUtil.testParser("password")));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.mainPageIsOpen(), "Main page isn't opened!");
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        Assert.assertTrue(applicantsPage.applicantsPageIsOpen(), "Applicants page isn't opened!");
        applicantsPage.fillSecondNameField(DataProviders.validUser.getSecondName());
        applicantsPage.fillFirstNameField(DataProviders.validUser.getFirstName());
        applicantsPage.fillMiddleNameField(DataProviders.validUser.getMiddleName());
        applicantsPage.fillPhoneNumberField(DataProviders.validUser.getPhoneNumber());
        applicantsPage.fillPassportNumberField(DataProviders.validUser.getPassportNumber());
        applicantsPage.clickNextButton();
        ServiceSelectionPage serviceSelectionPage = new ServiceSelectionPage();
        Assert.assertTrue(serviceSelectionPage.isMarriagePageOpen(), "Service selection page isn't opened!");
        serviceSelectionPage.clickMarriageRegistrationButton();
        CitizenPage citizenPage = new CitizenPage();
        Assert.assertTrue(citizenPage.isDisplayedUniqueElement(), "Citizen page isn't opened!");
        citizenPage.fillSecondNameField(secondName);
        citizenPage.fillFirstNameField(firstName);
        citizenPage.fillMiddleNameField(middleName);
        citizenPage.fillDateOfBirthField(ParseUtil.parseStringToInt(dateOfBirth));
        citizenPage.fillPassportNumberField(passportNumber);
        citizenPage.fillGenderField(gender);
        Assert.assertFalse(citizenPage.isClickableNextButton(), "Next button is clickable!");
    }
}
