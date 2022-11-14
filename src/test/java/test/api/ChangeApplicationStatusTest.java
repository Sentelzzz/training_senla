package test.api;

import api.ApiResponse;
import dataBase.DataBaseObjects;
import dataBase.DataBaseApplications;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.RootOfApplicationStatusBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParseUtil;

import java.sql.ResultSet;

import static constants.DataBaseConstants.SELECT_APPLICATIONS_STATUS;

public class ChangeApplicationStatusTest extends BaseTest{

    @Test
    public void changeApplicationStatusLikeRejected() {
        int applicationId = Integer.parseInt(ParseUtil.testParser("applicationId"));
        int staffId = Integer.parseInt(ParseUtil.testParser("staffId"));
        String action = ParseUtil.testParser("actionRejected");
        Response response = ApiResponse.changeStatusOfApplication(applicationId, staffId, action);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
        RootOfApplicationStatusBody changeApplicationStatusBody = gson.fromJson(response.body().asPrettyString(),
                RootOfApplicationStatusBody.class);
        Assert.assertEquals(changeApplicationStatusBody.data.statusOfApplication, action, "Status of application isn't changed!");

        DataBaseApplications dataBaseApplications = new DataBaseApplications();
        dataBaseApplications.connect(ParseUtil.testParser("DbLogin"), ParseUtil.testParser("DbPassword"));
        ResultSet resultSet = dataBaseApplications.requestSQL(String.format(SELECT_APPLICATIONS_STATUS, applicationId));
        Assert.assertEquals(DataBaseObjects.getSqlApplication(resultSet).getStatusOfApplication(), changeApplicationStatusBody.data.statusOfApplication,
                "Status doesn't math!");
        dataBaseApplications.close();
    }

    @Test
    public void changeApplicationStatusLikeApproved() {
        int applicationId = Integer.parseInt(ParseUtil.testParser("applicationId"));
        int staffId = Integer.parseInt(ParseUtil.testParser("staffId"));
        String action = ParseUtil.testParser("actionApproved");
        Response response = ApiResponse.changeStatusOfApplication(applicationId, staffId, action);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
        RootOfApplicationStatusBody changeApplicationStatusBody = gson.fromJson(response.body().asPrettyString(),
                RootOfApplicationStatusBody.class);
        Assert.assertEquals(changeApplicationStatusBody.data.statusOfApplication, action, "Status of application isn't changed!");

        DataBaseApplications dataBaseApplications = new DataBaseApplications();
        dataBaseApplications.connect(ParseUtil.testParser("DbLogin"), ParseUtil.testParser("DbPassword"));
        ResultSet resultSet = dataBaseApplications.requestSQL(String.format(SELECT_APPLICATIONS_STATUS, applicationId));
        Assert.assertEquals(DataBaseObjects.getSqlApplication(resultSet).getStatusOfApplication(), changeApplicationStatusBody.data.statusOfApplication,
                "Status doesn't math!");
        dataBaseApplications.close();
    }
}
