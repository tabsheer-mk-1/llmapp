package com.example.myllmapp;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class MyApiTest {

    @Test
    public void testGet() {
        given()
            .filter(new AllureRestAssured())
        .when()
            .get("https://www.google.com")
        .then()
            .assertThat()
            .statusCode(200)
            .and()
            .contentType("text/html");
    }
}
