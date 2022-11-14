package test.api;

import api.ApiResponse;
import dataBase.DataBaseApplications;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Administrator;
import models.RootOfNewAdministratorResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DateParser;
import utils.ParseUtil;
import utils.data.DataProviders;

import java.sql.ResultSet;

import static constants.DataBaseConstants.SELECT_ADMINISTRATOR;

public class CreateNewAdministratorTest extends BaseTest{

    @Test
    public void createNewAdministrator() {
        Response response = ApiResponse.createNewAdministrator(DataProviders.validAdministrator);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Status code isn't 200!");
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");

        RootOfNewAdministratorResponse getStaff = gson.fromJson(response.body().asPrettyString(), RootOfNewAdministratorResponse.class);
        DataBaseApplications dataBaseApplications = new DataBaseApplications();
        dataBaseApplications.connect(ParseUtil.testParser("DbLogin"), ParseUtil.testParser("DbPassword"));
        ResultSet resultSet = dataBaseApplications.requestSQL(String.format(SELECT_ADMINISTRATOR, getStaff.data.getStaffId()));
        String sqlAnswer = DataBaseApplications.getStaffSqlAnswer(resultSet);
        dataBaseApplications.close();
        Assert.assertTrue(sqlAnswer.contains(Integer.toString(getStaff.data.getStaffId())), "StaffId doesn't match!");
        Assert.assertTrue(sqlAnswer.contains(DataProviders.validAdministrator.getPersonalLastName()), "Lastname doesn't match!");
        Assert.assertTrue(sqlAnswer.contains(DataProviders.validAdministrator.getPersonalFirstName()), "Name doesn't match!");
        Assert.assertTrue(sqlAnswer.contains(DataProviders.validAdministrator.getPersonalMiddleName()), "Middlename doesn't match!");
        Assert.assertTrue(sqlAnswer.contains(DateParser.getSqlDate(DataProviders.validAdministrator.getDateofbirth())),
                "Date of birth doesn't match!");
        Assert.assertTrue(sqlAnswer.contains(DataProviders.validAdministrator.getPersonalNumberOfPassport()), "Passport number doesn't match!");
        Assert.assertTrue(sqlAnswer.contains(DataProviders.validAdministrator.getPersonalPhoneNumber()), "Phone number doesn't match!");
    }

    @Test(dataProvider = "administratorDataWithEmptyFields", dataProviderClass = DataProviders.class)
    public void createNewAdministratorWithEmptyField(Administrator administrator) {
        Response response = ApiResponse.createNewAdministrator(administrator);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR, "Status code isn't 500!");
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
    }
}
