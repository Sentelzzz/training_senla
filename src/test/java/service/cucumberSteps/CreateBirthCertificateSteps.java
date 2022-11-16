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

    @Given("User inputs {string} to secondName field")
    public void userInputsToSecondNameField(String secondName) {
        applicantsPage.fillSecondNameField(ParseUtil.testParser(secondName));
    }

    @And("User inputs {string} to firstName field")
    public void userInputsToFirstNameField(String firstName) {
        applicantsPage.fillFirstNameField(ParseUtil.testParser(firstName));
    }

    @And("User inputs {string} to middleName field")
    public void userInputsToMiddleNameField(String middleName) {
        applicantsPage.fillMiddleNameField(ParseUtil.testParser(middleName));
    }

    @And("User inputs {string} to phoneNumber field")
    public void userInputsToPhoneNumberField(String phoneNumber) {
        applicantsPage.fillPhoneNumberField(Integer.parseInt(ParseUtil.testParser(phoneNumber)));
    }

    @And("User inputs {string} to passportNumber field")
    public void userInputsToPassportNumberField(String passportNumber) {
        applicantsPage.fillPassportNumberField(ParseUtil.testParser(passportNumber));
    }

    @When("User clicks next button on applicants form page")
    public void userClicksNextButtonOnApplicantsFormPage() {
        applicantsPage.clickNextButton();
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

    @Given("User inputs {string} to secondName field birth registration form")
    public void userInputsToSecondNameFieldBirthRegistrationForm(String secondName) {
        birthRegistrationPage.writeSecondName(ParseUtil.testParser(secondName));
    }

    @And("User inputs {string} to firstName field birth registration form")
    public void userInputsToFirstNameFieldBirthRegistrationForm(String firstName) {
        birthRegistrationPage.writeFirstName(ParseUtil.testParser(firstName));
    }

    @And("User inputs {string} to middleName field birth registration form")
    public void userInputsToMiddleNameFieldBirthRegistrationForm(String middleName) {
        birthRegistrationPage.writeMiddleName(ParseUtil.testParser(middleName));
    }

    @And("User inputs {string} to date of birth field birth registration form")
    public void userInputsToDateOfBirthFieldBirthRegistrationForm(String dateOfBirth) {
        birthRegistrationPage.writeDateOfBirth(ParseUtil.parseStringToInt(ParseUtil.testParser(dateOfBirth)));
    }

    @And("User inputs {string} to passport number field birth registration form")
    public void userInputsToPassportNumberFieldBirthRegistrationForm(String passportNumber) {
        birthRegistrationPage.writePassportNumber(ParseUtil.testParser(passportNumber));
    }

    @And("User inputs {string} to gender field birth registration form")
    public void userInputsToGenderFieldBirthRegistrationForm(String gender) {
        birthRegistrationPage.writeGender(ParseUtil.testParser(gender));
    }

    @When("User click next button on birth registration form")
    public void userClickNextButtonOnBirthRegistrationForm() {
        birthRegistrationPage.clickNextButton();
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

    @When("User clicks finish button")
    public void userClicksFinishButton() {
        birthInformationPage.clickFinishButton();
    }

    @Then("Open application")
    public void openApplication() {
        Assert.assertTrue(applicationsPage.isRefreshButtonExist());
    }
}
