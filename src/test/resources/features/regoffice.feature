Feature: Create birth certificate

  Scenario: Login like user
    Given User navigate to "mainUrl"
    When User clicks login like user
    Then Open applicants form

  Scenario: Fill applicants form
    Given User inputs "validateSecondName" to "applicants second name" field "applicants" form
    And User inputs "validateFirstName" to "applicants first name" field "applicants" form
    And User inputs "validateMiddleName" to "applicants middle name" field "applicants" form
    And User inputs "validatePhoneNumber" to "applicants phone number" field "applicants" form
    And User inputs "validatePassportNumber" to "applicants passport number" field "applicants" form
    When User clicks "next" button on "applicants" page
    Then Open service selection page

  Scenario: Open birth registration page
    When User clicks birth registration button
    Then Open birth registration page

  Scenario: Fill birth registration form
    Given User inputs "validCitizenSecondName" to "birth registration second name" field "birth registration" form
    And User inputs "validCitizenFirstName" to "birth registration first name" field "birth registration" form
    And User inputs "validCitizenMiddleName" to "birth registration middle name" field "birth registration" form
    And User inputs "validCitizenDateOfBirth" to "birth registration date of birth" field "birth registration" form
    And User inputs "validCitizenPassportNumber" to "birth registration passport number" field "birth registration" form
    And User inputs "validCitizenGender" to "birth registration gender" field "birth registration" form
    When User clicks "next" button on "birth registration" page
    Then Open birth information page

  Scenario: Fill birth information form
    Given User inputs "birthPlace" to place of birth field
    And User inputs "mother" to mother field
    And User inputs "father" to father field
    When User clicks "finish" button on "birth information" page
    Then Open application