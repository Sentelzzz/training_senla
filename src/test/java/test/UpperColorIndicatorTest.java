package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.ApplicantsPage;
import page.MainPage;
import service.NavigateSteps;
import utils.ParseUtil;
import utils.data.DataProviders;

public class UpperColorIndicatorTest extends BaseTest{

    @Test
    public void firstTest() {
        SoftAssert softAssert = new SoftAssert();
        NavigateSteps navigateSteps = new NavigateSteps();
        navigateSteps.openMainPage();
        MainPage mainPage = new MainPage();
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        Assert.assertTrue(applicantsPage.applicantsPageIsOpen(), "Applicants page isn't opened!");
        applicantsPage.fillSecondNameField(DataProviders.validUser.getSecondName());
        applicantsPage.fillFirstNameField(DataProviders.validUser.getFirstName());
        applicantsPage.fillMiddleNameField(DataProviders.validUser.getMiddleName());
        applicantsPage.fillPhoneNumberField(ParseUtil.parseStringToInt(DataProviders.validUser.getPhoneNumber()));
        applicantsPage.fillPassportNumberField(DataProviders.validUser.getPassportNumber());
        Assert.assertTrue(applicantsPage.nextButtonIsClickable(), "Next button is enabled!");
        applicantsPage.clickNextButton();
        softAssert.assertEquals(ParseUtil.getColor(applicantsPage.getColorOfIndicator(Integer.
                parseInt(ParseUtil.testParser("firstNumberTestedColorIndicator")))), ParseUtil.
                testParser("expectedColorOfColorIndicator"), "The color of the first number of the tested color indicator is not green!");
        softAssert.assertEquals(ParseUtil.getColor(applicantsPage.getColorOfIndicator(Integer.
                parseInt(ParseUtil.testParser("secondNumberTestedColorIndicator")))), ParseUtil.
                testParser("expectedColorOfColorIndicator"), "The color of the first number of the tested color indicator is not green!");
        softAssert.assertAll();
    }
}
