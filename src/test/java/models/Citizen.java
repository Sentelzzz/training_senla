package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Citizen {

    private String secondName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private String passportNumber;
    private String gender;

}
