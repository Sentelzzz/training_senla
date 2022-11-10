package test.api;

import api.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.RootOfApplicationStatusBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParseUtil;

public class ChangeApplicationStatusTest {

    @Test
    public void changeApplicationStatusLikeRejected() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Response response = ApiResponse.changeStatusOfApplication(Integer.parseInt(ParseUtil.testParser("applicationId")),
                Integer.parseInt(ParseUtil.testParser("staffId")), ParseUtil.testParser("actionRejected"));
        RootOfApplicationStatusBody changeApplicationStatusBody = gson.fromJson(response.body().asPrettyString(),
                RootOfApplicationStatusBody.class);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
        Assert.assertEquals(changeApplicationStatusBody.data.statusOfApplication, ParseUtil.testParser("actionRejected"), "Status of application isn't changed!");
    }

    @Test
    public void changeApplicationStatusLikeApproved() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Response response = ApiResponse.changeStatusOfApplication(Integer.parseInt(ParseUtil.testParser("applicationId")),
                Integer.parseInt(ParseUtil.testParser("staffId")), ParseUtil.testParser("actionApproved"));
        RootOfApplicationStatusBody changeApplicationStatusBody = gson.fromJson(response.body().asPrettyString(),
                RootOfApplicationStatusBody.class);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
        Assert.assertEquals(changeApplicationStatusBody.data.statusOfApplication, ParseUtil.testParser("actionApproved"), "Status of application isn't changed!");
    }
}
