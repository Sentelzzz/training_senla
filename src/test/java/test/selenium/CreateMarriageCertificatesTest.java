package test.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageForSelenium.*;
import service.NavigateSteps;
import utils.ParseUtil;
import utils.data.DataProviders;

public class CreateMarriageCertificatesTest extends BaseTest {

    @Test
    public void createNewMarriageCertificate() {
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
        applicantsPage.clickNextButton();
        ServiceSelectionPage serviceSelection= new ServiceSelectionPage();
        Assert.assertTrue(serviceSelection.isServicePageOpen(), "Service selection page isn't opened!");
        serviceSelection.clickMarriageRegistrationButton();
        CitizenPage citizenPage = new CitizenPage();
        Assert.assertTrue(citizenPage.isDisplayedUniqueElement(), "Citizen page isn't opened!");
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
        marriagePage.fillDateOfRegistrationField(ParseUtil.parseStringToInt(DataProviders.validSpouse.getDateOfRegistration()));
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
