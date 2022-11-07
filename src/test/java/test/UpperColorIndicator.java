package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.ApplicantsPage;
import page.MainPage;
import service.NavigateSteps;
import utils.ParseUtil;

public class UpperColorIndicator extends BaseTest{

    @Test
    public void firstTest() {
        SoftAssert softAssert = new SoftAssert();

        NavigateSteps navigateSteps = new NavigateSteps();
        navigateSteps.openMainPage();

        logger.info("Click login like user button.");
        MainPage mainPage = new MainPage();
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        Assert.assertTrue(applicantsPage.applicantsPageIsOpen(), "Applicants page isn't opened!");

        logger.info("Fill the form test's data.");
        applicantsPage.fillSecondNameField(DataProviders.validUser.getSecondName());
        applicantsPage.fillFirstNameField(DataProviders.validUser.getFirstName());
        applicantsPage.fillMiddleNameField(DataProviders.validUser.getMiddleName());
        applicantsPage.fillPhoneNumberField(ParseUtil.parseStringToInt(DataProviders.validUser.getPhoneNumber()));
        applicantsPage.fillPassportNumberField(DataProviders.validUser.getPassportNumber());
        Assert.assertTrue(applicantsPage.nextButtonIsClickable(), "Next button is enabled!");

        logger.info("Click next button and check color of color indicator");
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
