package utils.data;

import models.*;
import org.testng.annotations.DataProvider;
import utils.ParseUtil;

public class DataProviders {

    public static final Applicants validUser = Applicants.builder()
            .secondName(ParseUtil.testParser("validateSecondName"))
            .firstName(ParseUtil.testParser("validateFirstName"))
            .middleName(ParseUtil.testParser("validateMiddleName"))
            .phoneNumber(ParseUtil.testParser("validatePhoneNumber"))
            .passportNumber(ParseUtil.testParser("validatePassportNumber"))
            .build();

    public static final Applicants validBoundaryUser = Applicants.builder()
            .secondName(ParseUtil.testParser("validBoundarySecondName"))
            .firstName(ParseUtil.testParser("validBoundaryFirstName"))
            .middleName(ParseUtil.testParser("validBoundaryMiddleName"))
            .phoneNumber(ParseUtil.testParser("validBoundaryPhoneNumber"))
            .passportNumber(ParseUtil.testParser("validBoundaryPassportNumber"))
            .build();

    public static final Applicants boundaryUser = Applicants.builder()
            .secondName(ParseUtil.testParser("boundarySecondName"))
            .firstName(ParseUtil.testParser("boundaryFirstName"))
            .middleName(ParseUtil.testParser("boundaryMiddleName"))
            .phoneNumber(ParseUtil.testParser("boundaryPhoneNumber"))
            .passportNumber(ParseUtil.testParser("boundaryPassportNumber")).build();

    public static final Citizen validFirstCitizen = Citizen.builder()
            .secondName(ParseUtil.testParser("validCitizenSecondName"))
            .firstName(ParseUtil.testParser("validCitizenFirstName"))
            .middleName(ParseUtil.testParser("validCitizenMiddleName"))
            .dateOfBirth(ParseUtil.testParser("validCitizenDateOfBirth"))
            .passportNumber(ParseUtil.testParser("validCitizenPassportNumber"))
            .gender(ParseUtil.testParser("validCitizenGender")).build();

    public static final Spouse validSpouse = Spouse.builder()
            .dateOfRegistration(ParseUtil.testParser("validDateOfRegistration"))
            .secondName(ParseUtil.testParser("validSecondNameOfSpouse"))
            .firstName(ParseUtil.testParser("validNameOfSpouse"))
            .middleName(ParseUtil.testParser("validMiddleNameOfSpouse"))
            .dateOfBirth(ParseUtil.testParser("validDateOfBirthOfSpouse"))
            .passportNumber(ParseUtil.testParser("validPassportNumberOfSpouse")).build();

    public static final Administrator validAdministrator = Administrator.builder()
            .dateofbirth(ParseUtil.testParser("administratorDateOfBirth"))
            .personalFirstName(ParseUtil.testParser("administratorFirstName"))
            .personalLastName(ParseUtil.testParser("administratorLastName"))
            .personalMiddleName(ParseUtil.testParser("administratorMiddleName"))
            .personalNumberOfPassport(ParseUtil.testParser("administratorPassportNumber"))
            .personalPhoneNumber(ParseUtil.testParser("administratorPhoneNumber")).build();

    public static final Administrator validAdministratorWithoutDateOfBirth = Administrator.builder()
            .dateofbirth("")
            .personalFirstName(ParseUtil.testParser("administratorFirstName"))
            .personalLastName(ParseUtil.testParser("administratorLastName"))
            .personalMiddleName(ParseUtil.testParser("administratorMiddleName"))
            .personalNumberOfPassport(ParseUtil.testParser("administratorPassportNumber"))
            .personalPhoneNumber(ParseUtil.testParser("administratorPhoneNumber")).build();

    public static final Administrator validAdministratorWithoutPersonalFirstName = Administrator.builder()
            .dateofbirth(ParseUtil.testParser("administratorDateOfBirth"))
            .personalFirstName("")
            .personalLastName(ParseUtil.testParser("administratorLastName"))
            .personalMiddleName(ParseUtil.testParser("administratorMiddleName"))
            .personalNumberOfPassport(ParseUtil.testParser("administratorPassportNumber"))
            .personalPhoneNumber(ParseUtil.testParser("administratorPhoneNumber")).build();

    public static final Administrator validAdministratorWithoutPersonalLastName = Administrator.builder()
            .dateofbirth(ParseUtil.testParser("administratorDateOfBirth"))
            .personalFirstName(ParseUtil.testParser("administratorFirstName"))
            .personalLastName("")
            .personalMiddleName(ParseUtil.testParser("administratorMiddleName"))
            .personalNumberOfPassport(ParseUtil.testParser("administratorPassportNumber"))
            .personalPhoneNumber(ParseUtil.testParser("administratorPhoneNumber")).build();

    public static final Administrator validAdministratorWithotPersonalMiddleName = Administrator.builder()
            .dateofbirth(ParseUtil.testParser("administratorDateOfBirth"))
            .personalFirstName(ParseUtil.testParser("administratorFirstName"))
            .personalLastName(ParseUtil.testParser("administratorLastName"))
            .personalMiddleName("")
            .personalNumberOfPassport(ParseUtil.testParser("administratorPassportNumber"))
            .personalPhoneNumber(ParseUtil.testParser("administratorPhoneNumber")).build();

    public static final Administrator validAdministratorWithoutPersonalNumberOfPassport = Administrator.builder()
            .dateofbirth(ParseUtil.testParser("administratorDateOfBirth"))
            .personalFirstName(ParseUtil.testParser("administratorFirstName"))
            .personalLastName(ParseUtil.testParser("administratorLastName"))
            .personalMiddleName(ParseUtil.testParser("administratorMiddleName"))
            .personalNumberOfPassport("")
            .personalPhoneNumber(ParseUtil.testParser("administratorPhoneNumber")).build();

    public static final Administrator validAdministratorWithoutPersonalPhoneNumber = Administrator.builder()
            .dateofbirth(ParseUtil.testParser("administratorDateOfBirth"))
            .personalFirstName(ParseUtil.testParser("administratorFirstName"))
            .personalLastName(ParseUtil.testParser("administratorLastName"))
            .personalMiddleName(ParseUtil.testParser("administratorMiddleName"))
            .personalNumberOfPassport(ParseUtil.testParser("administratorPassportNumber"))
            .personalPhoneNumber("").build();

    public static final NewMarriageApplication newMarriageRequest = NewMarriageApplication.builder()
            .mode(ParseUtil.testParser("mode"))
            .personalLastName(ParseUtil.testParser("personalLastName"))
            .personalMiddleName(ParseUtil.testParser("personalMiddleName"))
            .personalPhoneNumber(ParseUtil.testParser("personalPhoneNumber"))
            .personalNumberOfPassport(ParseUtil.testParser("personalNumberOfPassport"))
            .citizenLastName(ParseUtil.testParser("citizenLastName"))
            .citizenFirstName(ParseUtil.testParser("citizenFirstName"))
            .citizenMiddleName(ParseUtil.testParser("citizenMiddleName"))
            .citizenBirthDate(ParseUtil.testParser("citizenBirthDate"))
            .citizenNumberOfPassport(ParseUtil.testParser("citizenNumberOfPassport"))
            .citizenGender(ParseUtil.testParser("citizenGender"))
            .dateOfMarriage(ParseUtil.testParser("dateOfMarriage"))
            .newLastName(ParseUtil.testParser("newLastName"))
            .anotherPersonLastName(ParseUtil.testParser("anotherPersonLastName"))
            .anotherPersonFirstName(ParseUtil.testParser("anotherPersonFirstName"))
            .anotherPersonMiddleName(ParseUtil.testParser("anotherPersonMiddleName"))
            .birth_of_anotoherPerson(ParseUtil.testParser("birth_of_anotoherPerson"))
            .anotherPersonPassport(ParseUtil.testParser("anotherPersonPassport")).build();

    @DataProvider
    public static Object[][] userCorrectData() {
        return new Object[][]{
                {validBoundaryUser.getSecondName(), validBoundaryUser.getFirstName(),
                        validBoundaryUser.getMiddleName(), validBoundaryUser.getPhoneNumber(), validBoundaryUser.getPassportNumber()},
                {boundaryUser.getSecondName(), boundaryUser.getFirstName(),
                        boundaryUser.getMiddleName(), boundaryUser.getPhoneNumber(),
                        boundaryUser.getPassportNumber()},
        };
    }

    @DataProvider
    public static Object[][] userIncorrectData() {
        return new Object[][]{
                {ParseUtil.testParser("incorrectSecondName"), validUser.getFirstName(),
                        validUser.getMiddleName(), validUser.getPhoneNumber(),
                        validUser.getPassportNumber()},
                {validUser.getSecondName(), ParseUtil.testParser("incorrectFirstName"),
                        validUser.getMiddleName(), validUser.getPhoneNumber(),
                        validUser.getPassportNumber()},
                {validUser.getSecondName(), validUser.getFirstName(),
                        ParseUtil.testParser("incorrectMiddleName"), validUser.getPhoneNumber(),
                        validUser.getPassportNumber()},
                {validUser.getSecondName(), validUser.getFirstName(),
                        validUser.getMiddleName(), ParseUtil.testParser("incorrectPhoneNumber"),
                        validUser.getPassportNumber()},
                {validUser.getSecondName(), validUser.getFirstName(),
                        validUser.getMiddleName(), validUser.getPhoneNumber(),
                        ParseUtil.testParser("incorrectPassportNumber")}
        };
    }

    @DataProvider
    public static Object[][] userDataForApplicantsNextButtonForm() {
        return new Object[][]{
                {"", validUser.getFirstName(), validUser.getMiddleName(),
                        validUser.getPhoneNumber(), validUser.getPassportNumber()},
                {validUser.getSecondName(), "", validUser.getMiddleName(),
                        validUser.getPhoneNumber(), validUser.getPassportNumber()},
                {validUser.getSecondName(), validUser.getFirstName(), "",
                        validUser.getPhoneNumber(), validUser.getPassportNumber()},
                {validUser.getSecondName(), validUser.getFirstName(), validUser.getMiddleName(),
                        "", validUser.getPassportNumber()},
                {validUser.getSecondName(), validUser.getFirstName(), validUser.getMiddleName(),
                        validUser.getPhoneNumber(), ""}
        };
    }

    @DataProvider
    public static Object[][] userDataForCitizenNextButtonForm() {
        return new Object[][]{
                {"", validFirstCitizen.getFirstName(), validFirstCitizen.getMiddleName(),
                        validFirstCitizen.getDateOfBirth(), validFirstCitizen.getPassportNumber(), validFirstCitizen.getGender()},
                {validFirstCitizen.getSecondName(), "", validFirstCitizen.getMiddleName(),
                        validFirstCitizen.getDateOfBirth(), validFirstCitizen.getPassportNumber(), validFirstCitizen.getGender()},
                {validFirstCitizen.getSecondName(), validFirstCitizen.getFirstName(), "",
                        validFirstCitizen.getDateOfBirth(), validFirstCitizen.getPassportNumber(), validFirstCitizen.getGender()},
                {validFirstCitizen.getSecondName(), validFirstCitizen.getFirstName(), validFirstCitizen.getMiddleName(),
                        "", validFirstCitizen.getPassportNumber(), validFirstCitizen.getGender()},
                {validFirstCitizen.getSecondName(), validFirstCitizen.getFirstName(), validFirstCitizen.getMiddleName(),
                        validFirstCitizen.getDateOfBirth(), "", validFirstCitizen.getGender()},
                {validFirstCitizen.getSecondName(), validFirstCitizen.getFirstName(), validFirstCitizen.getMiddleName(),
                        validFirstCitizen.getDateOfBirth(), validFirstCitizen.getPassportNumber(), ""}
        };
    }

    @DataProvider
    public static Object[][] administratorDataWithEmptyFields() {
        return new Object[][] {
                {validAdministratorWithoutDateOfBirth},
                {validAdministratorWithoutPersonalFirstName},
                {validAdministratorWithoutPersonalLastName},
                {validAdministratorWithotPersonalMiddleName},
                {validAdministratorWithoutPersonalNumberOfPassport},
                {validAdministratorWithoutPersonalPhoneNumber}
        };
    }
}
