package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Administrator;
import models.NewMarriageApplication;
import org.apache.http.protocol.HTTP;
import utils.ParseUtil;

import static constants.ApiRequestConstant.*;
import static io.restassured.RestAssured.given;

public class ApiResponse {

    public static Response getListOfApplications() {
        return given()
                .when()
                .get(GET_APPLICATIONS_REQUEST);
    }

    public static Response createNewAdministrator(Administrator administrator) {
        return given()
                .body(ParseUtil.objectToJson(administrator))
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .post(CREATE_ADMIN_USER_REQUEST);
    }

    public static Response changeStatusOfApplication(int applicationId, int staffId, String action) {
        return given()
                .body("{\"applId\":" + applicationId + ",\"staffid\":" + staffId + ",\"action\":\"" + action +"\"}")
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .post(CHANGE_STATUS_OF_APPLICATION_REQUEST);
    }

    public static Response createNewMarriageApplication(NewMarriageApplication newMarriageApplication) {
        return given()
                .body(ParseUtil.objectToJson(newMarriageApplication))
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .post(CREATE_USER_REQUEST);
    }
}
