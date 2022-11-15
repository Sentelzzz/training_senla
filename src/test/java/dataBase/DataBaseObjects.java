package dataBase;

import models.DataBaseApplications;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseObjects {

    public static DataBaseApplications getSqlApplication(ResultSet resultSet) {
        DataBaseApplications dbApplications = new DataBaseApplications();
        try {
            while (resultSet.next()) {
                dbApplications.setApplicationId(resultSet.getInt("applicationid"));
                dbApplications.setCitizenId(resultSet.getInt("citizenid"));
                dbApplications.setApplicantId(resultSet.getInt("applicantid"));
                dbApplications.setStaffId(resultSet.getInt("staffid"));
                dbApplications.setDateOfApplication(resultSet.getDate("dateofapplication"));
                dbApplications.setKindOfApplication(resultSet.getString("kindofapplication"));
                dbApplications.setStatusOfApplication(resultSet.getString("statusofapplication"));
                dbApplications.setChannel(resultSet.getString("channel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbApplications;
    }
}
