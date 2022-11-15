package test.api;

import api.ApiResponse;
import dataBase.DataBaseObjects;
import dataBase.DataBaseApplications;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.RootOfApplicationStatusBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ParseUtil;

import java.sql.ResultSet;

import static constants.DataBaseConstants.SELECT_APPLICATIONS_STATUS;

public class ChangeApplicationStatusTest extends BaseTest{

    private DataBaseApplications dataBaseApplications;
    private Response response;
    private String bodyAsString;
    private ResultSet resultSet;

    @BeforeMethod
    public void connect() {
        dataBaseApplications = new DataBaseApplications();
        dataBaseApplications.connect(DataBaseLogin, DataBasePassword);
    }

    @AfterMethod
    public void close() {
        dataBaseApplications.close();
    }

    @Test
    public void changeApplicationStatusLikeRejected() {
        int applicationId = Integer.parseInt(ParseUtil.testParser("applicationId"));
        int staffId = Integer.parseInt(ParseUtil.testParser("staffId"));
        String action = ParseUtil.testParser("actionRejected");
        response = ApiResponse.changeStatusOfApplication(applicationId, staffId, action);
        bodyAsString = response.body().asString();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
        RootOfApplicationStatusBody changeApplicationStatusBody = gson.fromJson(bodyAsString, RootOfApplicationStatusBody.class);
        Assert.assertEquals(changeApplicationStatusBody.data.statusOfApplication, action, "Status of application isn't changed!");

        resultSet = dataBaseApplications.requestSQL(String.format(SELECT_APPLICATIONS_STATUS, applicationId));
        Assert.assertEquals(DataBaseObjects.getSqlApplication(resultSet).getStatusOfApplication(), changeApplicationStatusBody.data.statusOfApplication,
                "Status doesn't match!");
    }

    @Test
    public void changeApplicationStatusLikeApproved() {
        int applicationId = Integer.parseInt(ParseUtil.testParser("applicationId"));
        int staffId = Integer.parseInt(ParseUtil.testParser("staffId"));
        String action = ParseUtil.testParser("actionApproved");
        response = ApiResponse.changeStatusOfApplication(applicationId, staffId, action);
        bodyAsString = response.body().asString();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
        RootOfApplicationStatusBody changeApplicationStatusBody = gson.fromJson(bodyAsString, RootOfApplicationStatusBody.class);
        Assert.assertEquals(changeApplicationStatusBody.data.statusOfApplication, action, "Status of application isn't changed!");

        resultSet = dataBaseApplications.requestSQL(String.format(SELECT_APPLICATIONS_STATUS, applicationId));
        Assert.assertEquals(DataBaseObjects.getSqlApplication(resultSet).getStatusOfApplication(), changeApplicationStatusBody.data.statusOfApplication,
                "Status doesn't math!");
    }
}
