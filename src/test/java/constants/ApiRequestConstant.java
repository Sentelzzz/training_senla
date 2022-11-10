package constants;

import utils.ParseUtil;

import static constants.EndPointsConstant.*;

public class ApiRequestConstant {

    public static final String CREATE_USER_REQUEST = String.format(ParseUtil.settingsParser("apiUrl"), ParseUtil.testParser("swaggerLogin"),
            ParseUtil.testParser("swaggerPassword")) + CREATE_USER;
    public static final String GET_APPLICATION_REQUEST = String.format(ParseUtil.settingsParser("apiUrl"), ParseUtil.testParser("swaggerLogin"),
            ParseUtil.testParser("swaggerPassword")) + APPLICATION + "%s";
    public static final String GET_APPLICATIONS_REQUEST = String.format(ParseUtil.settingsParser("apiUrl"), ParseUtil.testParser("swaggerLogin"),
            ParseUtil.testParser("swaggerPassword")) + APPLICATIONS;
    public static final String CREATE_ADMIN_USER_REQUEST = String.format(ParseUtil.settingsParser("apiUrl"), ParseUtil.testParser("swaggerLogin"),
            ParseUtil.testParser("swaggerPassword")) + CREATE_ADMIN_USER;
    public static final String CHANGE_STATUS_OF_APPLICATION_REQUEST = String.format(ParseUtil.settingsParser("apiUrl"), ParseUtil.testParser("swaggerLogin"),
            ParseUtil.testParser("swaggerPassword")) + CHANGE_STATUS_OF_APPLICATION;
}
