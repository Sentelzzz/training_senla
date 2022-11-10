package selenideTest;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageForSelenide.ApplicantsPage;
import pageForSelenide.MainPage;
import utils.ParseUtil;
import utils.data.DataProviders;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NextButtonCitizenFormTest extends BaseTest{

    @Test(dataProvider = "userDataForApplicantsNextButtonForm", dataProviderClass = DataProviders.class)
    public void checkThatNextButtonDisabled(String secondName, String firstName, String middleName, String phoneNumber, String passportNumber) {
        open(String.format(ParseUtil.settingsParser("mainUrl"), ParseUtil.testParser("login"), ParseUtil.testParser("password")));
        MainPage mainPage = new MainPage();
        $(mainPage.getMainPageHeader()).shouldBe(Condition.visible);
        mainPage.loginLikeUser();
        ApplicantsPage applicantsPage = new ApplicantsPage();
        $(applicantsPage.getApplicantsPageHeader()).shouldBe(Condition.visible);
        applicantsPage.fillSecondNameField(secondName);
        applicantsPage.fillFirstNameField(firstName);
        applicantsPage.fillMiddleNameField(middleName);
        applicantsPage.fillPhoneNumberField(phoneNumber);
        applicantsPage.fillPassportNumberField(passportNumber);
        $(applicantsPage.getNextButton()).shouldNotBe(Condition.enabled);
    }
}
