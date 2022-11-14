package dataBase;

import java.sql.*;

import static constants.DataBaseConstants.DB_URL;

public class DataBaseApplications {

    private Connection connect = null;
    private Statement statement = null;

    public void connect(String username, String password) {
        try {
            connect = DriverManager
                    .getConnection(DB_URL, username, password);
            statement = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }

    public ResultSet requestSQL(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStaffSqlAnswer(ResultSet resultSet) {
        String dataBaseAnswer = "";
        try {
            while (resultSet.next()) {
                int staffId = resultSet.getInt("staffid");
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String middleName = resultSet.getString("middlename");
                Date date = resultSet.getDate("dateofbirth");
                String passportNumber = resultSet.getString("passportnumber");
                String phoneNumber = resultSet.getString("phonenumber");
                dataBaseAnswer = staffId + " " + surname + " " + name + " " + middleName + " " + date + " " + passportNumber + " " + phoneNumber;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataBaseAnswer;
    }
}
