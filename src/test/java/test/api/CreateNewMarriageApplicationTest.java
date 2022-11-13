package test.api;

import api.ApiResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.data.DataProviders;

public class CreateNewMarriageApplicationTest extends BaseTest{

    @Test
    public void createNewMarriageApplication() {
        Response response = ApiResponse.createNewMarriageApplication(DataProviders.newMarriageRequest);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Status code isn't 200!");
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
    }
}
