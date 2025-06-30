package com.example.myllmapp;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class SerenityRestAssuredTest {

    @Test
    public void createUser_shouldReturn201() {
        ((RequestSpecification) createUser("{\"name\":\"John\", \"job\":\"Developer\"}"))
            .then()
            .statusCode(201)
            .body("name", equalTo("John"))
            .body("job", equalTo("Developer"));
    }

    @Step("Create user with body: {0}")
    public io.restassured.response.ValidatableResponse createUser(String jsonBody) {
        return given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("https://reqres.in/api/users")
                .then();
    }
}
