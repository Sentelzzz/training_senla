package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewMarriageApplication {

    private String  mode;
    private String personalLastName;
    private String personalMiddleName;
    private String personalPhoneNumber;
    private String personalNumberOfPassport;
    private String citizenLastName;
    private String citizenFirstName;
    private String citizenMiddleName;
    private String citizenBirthDate;
    private String citizenNumberOfPassport;
    private String citizenGender;
    private String dateOfMarriage;
    private String newLastName;
    private String anotherPersonLastName;
    private String anotherPersonFirstName;
    private String anotherPersonMiddleName;
    private String birth_of_anotoherPerson;
    private String anotherPersonPassport;
}
