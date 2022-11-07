package test;

import models.Applicants;
import models.FirstCitizen;
import models.Spouse;
import org.testng.annotations.DataProvider;
import utils.ParseUtil;

public class DataProviders {

    public static final Applicants validUser = Applicants.builder().secondName(ParseUtil.testParser("validateSecondName"))
            .firstName(ParseUtil.testParser("validateFirstName"))
            .middleName(ParseUtil.testParser("validateMiddleName"))
            .phoneNumber(ParseUtil.testParser("validatePhoneNumber"))
            .passportNumber(ParseUtil.testParser("validatePassportNumber"))
            .build();

    public static final Applicants validBoundaryUser = Applicants.builder().secondName(ParseUtil.testParser("validBoundarySecondName"))
            .firstName(ParseUtil.testParser("validBoundaryFirstName"))
            .middleName(ParseUtil.testParser("validBoundaryMiddleName"))
            .phoneNumber(ParseUtil.testParser("validBoundaryPhoneNumber"))
            .passportNumber(ParseUtil.testParser("validBoundaryPassportNumber"))
            .build();

    public static final Applicants boundaryUser = Applicants.builder().secondName(ParseUtil.testParser("boundarySecondName"))
            .firstName(ParseUtil.testParser("boundaryFirstName"))
            .middleName(ParseUtil.testParser("boundaryMiddleName"))
            .phoneNumber(ParseUtil.testParser("boundaryPhoneNumber"))
            .passportNumber(ParseUtil.testParser("boundaryPassportNumber")).build();

    public static final FirstCitizen validFirstCitizen = FirstCitizen.builder().secondName(ParseUtil.testParser("validCitizenSecondName"))
            .firstName(ParseUtil.testParser("validCitizenFirstName"))
            .middleName(ParseUtil.testParser("validCitizenMiddleName"))
            .dateOfBirth(ParseUtil.testParser("validCitizenDateOfBirth"))
            .passportNumber(ParseUtil.testParser("validCitizenPassportNumber"))
            .gender(ParseUtil.testParser("validCitizenGender")).build();

    public static final Spouse validSpouse = Spouse.builder().dateOfRegistration(ParseUtil.testParser("validDateOfRegistration"))
            .secondName(ParseUtil.testParser("validSecondNameOfSpouse"))
            .firstName(ParseUtil.testParser("validNameOfSpouse"))
            .middleName(ParseUtil.testParser("validMiddleNameOfSpouse"))
            .dateOfBirth(ParseUtil.testParser("validDateOfBirthOfSpouse"))
            .passportNumber(ParseUtil.testParser("validPassportNumberOfSpouse")).build();

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
}
