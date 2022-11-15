package constants;

public class DataBaseConstants {

    public static final String DB_URL = "jdbc:postgresql://86.57.161.116:50432/register_office";
    public static final String SELECT_ADMINISTRATOR = "SELECT * FROM reg_office.staff WHERE staffid = %s";
    public static final String SELECT_APPLICATIONS_STATUS = "SELECT * FROM reg_office.applications WHERE applicationid = %s";
}
