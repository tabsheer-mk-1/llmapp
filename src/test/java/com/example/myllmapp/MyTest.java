package com.example.myllmapp;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;


public class MyTest{

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