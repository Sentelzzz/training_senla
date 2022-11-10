package selenideTest;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageForSelenide.ApplicantsPage;
import pageForSelenide.CitizenPage;
import pageForSelenide.MainPage;
import pageForSelenide.ServiceSelectionPage;
import utils.ParseUtil;
import utils.data.DataProviders;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NextButtonMarriageFormTest extends BaseTest{

    @Test(dataProvider = "userDataForCitizenNextButtonForm", dataProviderClass = DataProviders.class)
    public void checkThatNextButtonMarriageFormInactive(String secondName, String firstName, String middleName, String dateOfBirth, String passportNumber,
                                                        String gender) {
        open(String.format(ParseUtil.settingsParser("mainUrl"), ParseUtil.testParser("login"), ParseUtil.testParser("password")));
        MainPage mainPage = new MainPage();
        $(mainPage.getMainPageHeader()).shouldBe(Condition.visible);
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        $(applicantsPage.getApplicantsPageHeader()).shouldBe(Condition.visible);
        applicantsPage.fillSecondNameField(DataProviders.validUser.getSecondName());
        applicantsPage.fillFirstNameField(DataProviders.validUser.getFirstName());
        applicantsPage.fillMiddleNameField(DataProviders.validUser.getMiddleName());
        applicantsPage.fillPhoneNumberField(DataProviders.validUser.getPhoneNumber());
        applicantsPage.fillPassportNumberField(DataProviders.validUser.getPassportNumber());
        applicantsPage.clickNextButton();
        ServiceSelectionPage serviceSelectionPage = new ServiceSelectionPage();
        $(serviceSelectionPage.getMarriageRegistrationButton()).shouldBe(Condition.visible);
        serviceSelectionPage.clickMarriageRegistrationButton();
        CitizenPage citizenPage = new CitizenPage();
        Assert.assertTrue(citizenPage.isDisplayedUniqueElement(), "Citizen page isn't opened!");
        citizenPage.fillSecondNameField(secondName);
        citizenPage.fillFirstNameField(firstName);
        citizenPage.fillMiddleNameField(middleName);
        citizenPage.fillDateOfBirthField(ParseUtil.parseStringToInt(dateOfBirth));
        citizenPage.fillPassportNumberField(passportNumber);
        citizenPage.fillGenderField(gender);
        $(citizenPage.getNextButton()).shouldNotBe(Condition.enabled);
    }
}
