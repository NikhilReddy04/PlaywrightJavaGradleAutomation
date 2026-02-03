package com.epam.api.config;

import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;

public class ApiConfig {
    private static final String BASE_URL = "https://apis.ccbp.in";
    public static void init() {
        SerenityRest.setDefaultBasePath("");
        RestAssured.baseURI = BASE_URL;
    }
}
