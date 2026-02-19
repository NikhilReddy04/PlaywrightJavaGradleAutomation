package com.epam.api.steps;

import com.epam.api.config.Endpoints;
import com.epam.api.models.PaymentRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.equalTo;

public class CheckoutMockServerSteps {

    private static final String MOCK_BASE_URL =
            "https://47591e42-9064-4af2-838b-eccb66063652.mock.pstmn.io";

    @Step("Checkout with valid card details")
    public void checkoutWithValidCard() {

        PaymentRequest payment = new PaymentRequest(
                "4444555566667777",
                "12/30",
                "123",
                "Test User"
        );

        SerenityRest
                .given()
                .baseUri(MOCK_BASE_URL)
                .contentType(ContentType.JSON)
                .body(payment)
                .log().all()
                .when()
                .post(Endpoints.CHECKOUT)
                .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Checked Out successfully"));
    }

    @Step("Checkout with invalid card details")
    public void checkoutWithInvalidCard() {

        PaymentRequest payment = new PaymentRequest(
                "4111111111111111",
                "12/30",
                "123",
                "Test User"
        );

        SerenityRest
                .given()
                .baseUri(MOCK_BASE_URL)
                .contentType(ContentType.JSON)
                .body(payment)
                .log().all()
                .when()
                .post(Endpoints.CHECKOUT)
                .then()
                .log().all()
                .statusCode(401)
                .body("message", equalTo("Invalid card details"));
    }
}
