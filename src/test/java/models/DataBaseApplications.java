package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class DataBaseApplications {

    @SerializedName("applicationid")
    public int applicationId;
    @SerializedName("citizenid")
    public int citizenId;
    @SerializedName("applicantid")
    public int applicantId;
    @SerializedName("staffid")
    public int staffId;
    @SerializedName("dateofapplication")
    public Date dateOfApplication;
    @SerializedName("kindofapplication")
    public String kindOfApplication;
    @SerializedName("statusofapplication")
    public String statusOfApplication;
    public String channel;
}
