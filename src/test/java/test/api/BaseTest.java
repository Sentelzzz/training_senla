package test.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseTest {

    protected GsonBuilder gsonBuilder = new GsonBuilder();
    protected Gson gson = gsonBuilder.create();
}
