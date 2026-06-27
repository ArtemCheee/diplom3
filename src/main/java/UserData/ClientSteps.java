package UserData;


import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static UserData.ClientData.*;
import static io.restassured.RestAssured.given;

public class ClientSteps {

    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    @Step("Создание клиента")

    public static Response createClient(ClientModel client) {
        return given()
                .log().all()
                .contentType("application/json")
                .body(client)
                .when()
                .post(BASE_URL + CREATE_CLIENT_PATH)
                .then()
                .log().all()
                .extract().response();

    }


    @Step("Удаление клиента")


    public static Response deleteClient(String accessToken) {
        return given()
                .log().all()
                .header("Authorization", accessToken)
                .when()
                .delete(BASE_URL + DELETE_CLIENT_PATH)
                .then()
                .log().all()
                .extract().response();

    }

    @Step("Логин клиента")

    public static Response loginClient(ClientModel client) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(client)
                .when()
                .post(BASE_URL + LOGIN_CLIENT_PATH)
                .then()
                .extract().response();

    }
}