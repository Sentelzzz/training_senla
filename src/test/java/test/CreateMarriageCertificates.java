package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;
import service.NavigateSteps;
import utils.ParseUtil;

public class CreateMarriageCertificates extends BaseTest{

    @Test
    public void createNewMarriageCertificate() {
        NavigateSteps navigateSteps = new NavigateSteps();
        navigateSteps.openMainPage();

        logger.info("Click login like user button.");
        MainPage mainPage = new MainPage();
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        Assert.assertTrue(applicantsPage.applicantsPageIsOpen(), "Applicants page isn't opened!");

        logger.info("Fill the form test's data and click next button.");
        applicantsPage.fillSecondNameField(DataProviders.validUser.getSecondName());
        applicantsPage.fillFirstNameField(DataProviders.validUser.getFirstName());
        applicantsPage.fillMiddleNameField(DataProviders.validUser.getMiddleName());
        applicantsPage.fillPhoneNumberField(ParseUtil.parseStringToInt(DataProviders.validUser.getPhoneNumber()));
        applicantsPage.fillPassportNumberField(DataProviders.validUser.getPassportNumber());
        applicantsPage.clickNextButton();
        ServiceSelectionPage serviceSelection= new ServiceSelectionPage();
        Assert.assertTrue(serviceSelection.isMarriagePageOpen(), "Service selection page isn't opened!");

        logger.info("Click marriage registration button.");
        serviceSelection.clickMarriageRegistrationButton();
        CitizenPage citizenPage = new CitizenPage();
        Assert.assertTrue(citizenPage.isDisplayedUniqueElement(), "Citizen page isn't opened!");

        logger.info("Fill the citizen form test's data and click next button.");
        citizenPage.fillSecondNameField(DataProviders.validFirstCitizen.getSecondName());
        citizenPage.fillFirstNameField(DataProviders.validFirstCitizen.getFirstName());
        citizenPage.fillMiddleNameField(DataProviders.validFirstCitizen.getMiddleName());
        citizenPage.fillDateOfBirthField(ParseUtil.parseStringToInt(DataProviders.validFirstCitizen.getDateOfBirth()));
        citizenPage.fillPassportNumberField(DataProviders.validFirstCitizen.getPassportNumber());
        citizenPage.fillGenderField(DataProviders.validFirstCitizen.getGender());
        Assert.assertTrue(citizenPage.isClickableNextButton(), "Next button isn't clickable!");
        citizenPage.clickNextButton();
        MarriagePage marriagePage = new MarriagePage();
        Assert.assertTrue(marriagePage.isMarriagePageOpen(), "Marriage page isn't opened!");

        logger.info("Fill the spouse form test's data and click finish button.");
        marriagePage.fillDateOfBirthField(ParseUtil.parseStringToInt(DataProviders.validSpouse.getDateOfRegistration()));
        marriagePage.fillSecondNameOfSpouseField(DataProviders.validSpouse.getSecondName());
        marriagePage.fillFirstNameOfSpouseField(DataProviders.validSpouse.getFirstName());
        marriagePage.fillMiddleNameOfSpouseField(DataProviders.validSpouse.getMiddleName());
        marriagePage.fillDateOfBirthField(ParseUtil.parseStringToInt(DataProviders.validSpouse.getDateOfBirth()));
        marriagePage.fillPassportNumberSpouseField(DataProviders.validSpouse.getPassportNumber());
        Assert.assertTrue(marriagePage.isFinishButtonEnable(), "Finish button isn't clickable!");
        marriagePage.clickFinishButton();

        ApplicationsPage applicationsPage = new ApplicationsPage();
        Assert.assertTrue(applicationsPage.isRefreshButtonExist(), "Application wasn't create!");
    }
}
