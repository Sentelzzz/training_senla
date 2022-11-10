package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Administrator {

    @SerializedName("dateofbirth")
    private String dateofbirth;
    private String personalFirstName;
    private String personalLastName;
    private String personalMiddleName;
    private String personalNumberOfPassport;
    private String personalPhoneNumber;
}
