package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ApplicationStatusBody {

    @SerializedName("applicationid")
    public int applicationId;
    @SerializedName("citizenid")
    public int citizenId;
    @SerializedName("applicantid")
    public int applicantId;
    @SerializedName("staffid")
    public int staffId;
    @SerializedName("dateafapplicaton")
    public Date dateOfApplication;
    @SerializedName("kindofapplication")
    public String kindOfApplication;
    @SerializedName("statusofapplication")
    public String statusOfApplication;
    public String channel;
    public Object image;
}
