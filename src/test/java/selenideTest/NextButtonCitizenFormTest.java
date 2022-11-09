package selenideTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageForSelenide.ApplicantsPage;
import pageForSelenide.MainPage;
import utils.ParseUtil;
import utils.data.DataProviders;

import static com.codeborne.selenide.Selenide.open;

public class NextButtonCitizenFormTest extends BaseTest{

    @Test(dataProvider = "userDataForApplicantsNextButtonForm", dataProviderClass = DataProviders.class)
    public void checkThatNextButtonDisabled(String secondName, String firstName, String middleName, String phoneNumber, String passportNumber) {
        open(String.format(ParseUtil.settingsParser("mainUrl"), ParseUtil.testParser("login"), ParseUtil.testParser("password")));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.mainPageIsOpen(), "Main page isn't opened!");
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        Assert.assertTrue(applicantsPage.applicantsPageIsOpen(), "Applicants page isn't opened!");
        applicantsPage.fillSecondNameField(secondName);
        applicantsPage.fillFirstNameField(firstName);
        applicantsPage.fillMiddleNameField(middleName);
        applicantsPage.fillPhoneNumberField(phoneNumber);
        applicantsPage.fillPassportNumberField(passportNumber);
        Assert.assertFalse(applicantsPage.nextButtonIsClickable(), "Next button is clickable!");
    }
}
