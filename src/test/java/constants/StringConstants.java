package constants;

import utils.ParseUtil;

public class StringConstants {

    public static final String API_URL = String.format(ParseUtil.settingsParser("apiUrl"), ParseUtil.testParser("swaggerLogin"),
            ParseUtil.testParser("swaggerPassword"));
}
