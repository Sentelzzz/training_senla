package test.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.ParseUtil;

public abstract class BaseTest {

    protected String DataBaseLogin = ParseUtil.testParser("DbLogin");
    protected String DataBasePassword = ParseUtil.testParser("DbPassword");
    protected GsonBuilder gsonBuilder = new GsonBuilder();
    protected Gson gson = gsonBuilder.create();
}
