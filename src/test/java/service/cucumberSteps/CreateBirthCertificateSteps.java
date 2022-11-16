package service.cucumberSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageForSelenium.*;
import utils.ParseUtil;
import utils.driver.DriverSingleton;

public class CreateBirthCertificateSteps {

    private final WebDriver driver = DriverSingleton.getInstance().getDriver();

    private final MainPage mainPage = new MainPage();
    private final ApplicantsPage applicantsPage = new ApplicantsPage();
    private final ServiceSelectionPage serviceSelectionPage = new ServiceSelectionPage();
    private final BirthRegistrationPage birthRegistrationPage = new BirthRegistrationPage();
    private final BirthInformationPage birthInformationPage = new BirthInformationPage();
    private final ApplicationsPage applicationsPage = new ApplicationsPage();

    @Given("User navigate to {string}")
    public void userNavigateToRegOfficeEu(String url) {
        driver.manage().window().maximize();
        driver.navigate().to(String.format(ParseUtil.settingsParser(url),
                ParseUtil.testParser("login"), ParseUtil.testParser("password")));
    }

    @When("User clicks login like user")
    public void userClickLoginLikeUser() {
        mainPage.loginLikeUser();
    }

    @Then("Open applicants form")
    public void openApplicantsForm() {
        Assert.assertTrue(mainPage.mainPageIsOpen());
    }

    @Then("Open service selection page")
    public void openServiceSelectionPage() {
        Assert.assertTrue(serviceSelectionPage.isServicePageOpen());
    }

    @When("User clicks birth registration button")
    public void userClicksBirthRegistrationButton() {
        serviceSelectionPage.clickOnBirthRegistrationButton();
    }

    @Then("Open birth registration page")
    public void openBirthRegistrationPage() {
        Assert.assertTrue(birthRegistrationPage.isBirthRegistrationOpen());
    }

    @Then("Open birth information page")
    public void openBirthInformationPage() {
        Assert.assertTrue(birthInformationPage.isBirthInformationPageOpen());
    }

    @Given("User inputs {string} to place of birth field")
    public void userInputsToPlaceOfBirthField(String birthPlace) {
        birthInformationPage.fillBirthPlaceField(ParseUtil.testParser(birthPlace));
    }

    @And("User inputs {string} to mother field")
    public void userInputsToMotherField(String mother) {
        birthInformationPage.fillMotherField(ParseUtil.testParser(mother));
    }

    @And("User inputs {string} to father field")
    public void userInputsToFatherField(String father) {
        birthInformationPage.fillFatherField(ParseUtil.testParser(father));
    }

    @Then("Open application")
    public void openApplication() {
        Assert.assertTrue(applicationsPage.isRefreshButtonExist());
    }

    @Given("User inputs {string} to {string} field {string} form")
    public void userInputsToSecondNameFieldForm(String value, String fieldName, String formName) {
        switch (ParseUtil.testParser(formName)) {
            case ("Applicants"):
                switch (ParseUtil.testParser(fieldName)) {
                    case ("secondName"):
                        applicantsPage.fillSecondNameField(ParseUtil.testParser(value));
                        break;
                    case ("firstName"):
                        applicantsPage.fillFirstNameField(ParseUtil.testParser(value));
                        break;
                    case ("middleName"):
                        applicantsPage.fillMiddleNameField(ParseUtil.testParser(value));
                        break;
                    case ("phoneNumber"):
                        applicantsPage.fillPhoneNumberField(Integer.parseInt(ParseUtil.testParser(value)));
                        break;
                    case ("passportNumber"):
                        applicantsPage.fillPassportNumberField(ParseUtil.testParser(value));
                        break;
                }
            case ("Birth registration"):
                switch (ParseUtil.testParser(fieldName)) {
                    case ("secondName"):
                        birthRegistrationPage.writeSecondName(ParseUtil.testParser(value));
                        break;
                    case ("firstName"):
                        birthRegistrationPage.writeFirstName(ParseUtil.testParser(value));
                        break;
                    case ("middleName"):
                        birthRegistrationPage.writeMiddleName(ParseUtil.testParser(value));
                        break;
                    case ("dateOfBirth"):
                        birthRegistrationPage.writeDateOfBirth(ParseUtil.parseStringToInt(ParseUtil.testParser(value)));
                        break;
                    case ("passportNumber"):
                        birthRegistrationPage.writePassportNumber(ParseUtil.testParser(value));
                        break;
                    case ("gender"):
                        birthRegistrationPage.writeGender(ParseUtil.testParser(value));
                        break;
                }
        }
    }

    @When("User clicks {string} button on {string} page")
    public void userClicksButtonOnPage(String button, String pageName) {
        switch (ParseUtil.testParser(pageName)) {
            case ("Applicants"):
                switch (ParseUtil.testParser(button)) {
                    case ("next"):
                        applicantsPage.clickApplicantsNextButton();
                        break;
                }
            case ("Birth registration"):
                switch (ParseUtil.testParser(button)) {
                    case ("next"):
                        birthRegistrationPage.clickNextButton();
                        break;
                }
            case ("Birth information"):
                switch (ParseUtil.testParser(button)) {
                    case ("finish"):
                        birthInformationPage.clickFinishButton();
                        break;
                }
        }
    }
}
