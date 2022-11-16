Feature: Create birth certificate

  Scenario: Login like user
    Given User navigate to "mainUrl"
    When User clicks login like user
    Then Open applicants form

  Scenario: Fill applicants form
    Given User inputs "validateSecondName" to secondName field
    And User inputs "validateFirstName" to firstName field
    And User inputs "validateMiddleName" to middleName field
    And User inputs "validatePhoneNumber" to phoneNumber field
    And User inputs "validatePassportNumber" to passportNumber field
    When User clicks next button on applicants form page
    Then Open service selection page

  Scenario: Open birth registration page
    When User clicks birth registration button
    Then Open birth registration page

  Scenario: Fill birth registration form
    Given User inputs "validCitizenSecondName" to secondName field birth registration form
    And User inputs "validCitizenFirstName" to firstName field birth registration form
    And User inputs "validCitizenMiddleName" to middleName field birth registration form
    And User inputs "validCitizenDateOfBirth" to date of birth field birth registration form
    And User inputs "validCitizenPassportNumber" to passport number field birth registration form
    And User inputs "validCitizenGender" to gender field birth registration form
    When User click next button on birth registration form
    Then Open birth information page

  Scenario: Fill birth information form
    Given User inputs "birthPlace" to place of birth field
    And User inputs "mother" to mother field
    And User inputs "father" to father field
    When User clicks finish button
    Then Open application