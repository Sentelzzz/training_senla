package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Applicants {

    private String firstName;
    private String secondName;
    private String middleName;
    private String phoneNumber;
    private String passportNumber;

}
