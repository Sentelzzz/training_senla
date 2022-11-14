package constants;

import static constants.EndPointsConstant.*;
import static constants.StringConstants.API_URL;

public class ApiRequestConstant {

    public static final String CREATE_USER_REQUEST = API_URL + CREATE_USER;
    public static final String GET_APPLICATION_REQUEST = API_URL + APPLICATION + "%s";
    public static final String GET_APPLICATIONS_REQUEST = API_URL + APPLICATIONS;
    public static final String CREATE_ADMIN_USER_REQUEST = API_URL + CREATE_ADMIN_USER;
    public static final String CHANGE_STATUS_OF_APPLICATION_REQUEST = API_URL + CHANGE_STATUS_OF_APPLICATION;
}
