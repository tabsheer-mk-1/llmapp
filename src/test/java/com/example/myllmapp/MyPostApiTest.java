package com.example.myllmapp;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyPostApiTest {

    @Test
    public void testPostRequest() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"Developer\" }";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("https://reqres.in/api/users")  // Public dummy API for testing POST
        .then()
            .statusCode(201)
            .body("name", equalTo("John"))
            .body("job", equalTo("Developer"));
    }
}
