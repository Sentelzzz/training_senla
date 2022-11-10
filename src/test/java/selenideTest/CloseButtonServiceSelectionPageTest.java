package selenideTest;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageForSelenide.ApplicantsPage;
import pageForSelenide.MainPage;
import pageForSelenide.ServiceSelectionPage;
import utils.ParseUtil;
import utils.data.DataProviders;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CloseButtonServiceSelectionPageTest extends BaseTest{

    @Test
    public void isCloseButtonServiceSelectionPageWorkTest() {
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
        serviceSelectionPage.clickCloseButton();
        $(mainPage.getMainPageHeader()).shouldBe(Condition.visible);
    }
}
