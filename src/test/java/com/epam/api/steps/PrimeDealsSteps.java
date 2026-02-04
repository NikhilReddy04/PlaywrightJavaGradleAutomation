package com.epam.api.steps;


import com.epam.api.config.Endpoints;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeDealsSteps {

    @Step("Call the Prime Deals API with auth token")
    public void callPrimeDealsApi() {
        String token = Serenity.sessionVariableCalled("AUTH_TOKEN");

        if(token != null){
        Serenity.recordReportData()
                .withTitle("Auth Token")
                .andContents("Token generated");}

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(Endpoints.PRIME_DEALS)
                .then()
                .statusCode(200);
    }


    @Step("Verify that 'prime_deals' array is present and not empty")
    public void verifyPrimeDealsArray() {
        JsonPath json = SerenityRest.lastResponse().jsonPath();
        assertThat(json.getList("prime_deals")).isNotNull();
        assertThat(json.getList("prime_deals").size()).isGreaterThan(0);
    }

    @Step("Verify first deal has required fields")
    public void verifyFirstDealFields() {
        JsonPath json = SerenityRest.lastResponse().jsonPath();
        assertThat(json.getInt("prime_deals[0].id")).isGreaterThan(0);
        assertThat(json.getString("prime_deals[0].title")).isNotEmpty();
        assertThat(json.getInt("prime_deals[0].price")).isGreaterThan(0);
    }
}
