package selenideTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageForSelenide.ApplicantsPage;
import pageForSelenide.MainPage;
import pageForSelenide.ServiceSelectionPage;
import utils.ParseUtil;
import utils.data.DataProviders;

import static com.codeborne.selenide.Selenide.open;

public class CloseButtonServiceSelectionPageTest extends BaseTest{

    @Test
    public void isCloseButtonServiceSelectionPageWorkTest() {
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
        serviceSelectionPage.clickCloseButton();
        Assert.assertTrue(mainPage.mainPageIsOpen(), "Main page isn't opened!");
    }
}
