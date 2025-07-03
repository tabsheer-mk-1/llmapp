package com.example.myllmapp;

import io.restassured.RestAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyApiTests  {

    @Test
    public void testGet() {
        given()
        .when()
            .get("https://www.google.com")
        .then()
            .assertThat()
            .statusCode(200)
            .and()
            .contentType("text/html");
    }
}
