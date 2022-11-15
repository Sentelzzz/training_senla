package test.api;

import api.ApiResponse;
import dataBase.DataBaseApplications;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Administrator;
import models.RootOfNewAdministratorResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DateParser;
import utils.data.DataProviders;

import java.sql.ResultSet;

import static constants.DataBaseConstants.SELECT_ADMINISTRATOR;

public class CreateNewAdministratorTest extends BaseTest{

    private DataBaseApplications dataBaseApplications;
    private Response response;
    private String bodyAsString;

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
    public void createNewAdministrator() {
        response = ApiResponse.createNewAdministrator(DataProviders.validAdministrator);
        bodyAsString = response.body().asString();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Status code isn't 200!");
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");

        RootOfNewAdministratorResponse expectedData = gson.fromJson(bodyAsString, RootOfNewAdministratorResponse.class);
        ResultSet resultSet = dataBaseApplications.requestSQL(String.format(SELECT_ADMINISTRATOR, expectedData.data.getStaffId()));
        String actualData = DataBaseApplications.getStaffSqlAnswer(resultSet);
        Assert.assertTrue(actualData.contains(Integer.toString(expectedData.data.getStaffId())), "StaffId doesn't match!");
        Assert.assertTrue(actualData.contains(DataProviders.validAdministrator.getPersonalLastName()), "Lastname doesn't match!");
        Assert.assertTrue(actualData.contains(DataProviders.validAdministrator.getPersonalFirstName()), "Name doesn't match!");
        Assert.assertTrue(actualData.contains(DataProviders.validAdministrator.getPersonalMiddleName()), "Middlename doesn't match!");
        Assert.assertTrue(actualData.contains(DateParser.getSqlDate(DataProviders.validAdministrator.getDateofbirth())),
                "Date of birth doesn't match!");
        Assert.assertTrue(actualData.contains(DataProviders.validAdministrator.getPersonalNumberOfPassport()), "Passport number doesn't match!");
        Assert.assertTrue(actualData.contains(DataProviders.validAdministrator.getPersonalPhoneNumber()), "Phone number doesn't match!");
    }

    @Test(dataProvider = "administratorDataWithEmptyFields", dataProviderClass = DataProviders.class)
    public void createNewAdministratorWithEmptyField(Administrator administrator) {
        response = ApiResponse.createNewAdministrator(administrator);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR, "Status code isn't 500!");
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), "Response body doesn't have JSON format!");
    }

}
