package com.example.myllmapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class MyApiTest {

    @Test
    public void testGet() {
    	RestAssured
        .get("https://www.google.com")
        .then()
        .assertThat()
        .statusCode(200)
        .and()
        .contentType("text/html");
    }
}