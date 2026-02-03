package com.epam.api.steps;

import com.epam.api.config.Endpoints;
import com.epam.api.models.LoginRequest;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.http.ContentType;

public class LoginApiSteps {

    @Step("Login via API with username {0}")
    public void login(String username, String password) {

        SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .body(new LoginRequest(username, password))
                .when()
                .post(Endpoints.LOGIN)
                .then()
                .statusCode(200);
    }

    @Step("Save auth token")
    public void saveToken() {
        String token = SerenityRest.lastResponse()
                .jsonPath()
                .getString("jwt_token");

        Serenity
                .setSessionVariable("AUTH_TOKEN")
                .to(token);
    }
}
