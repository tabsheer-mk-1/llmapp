package com.example.myllmapp;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class UserAPI {

    @Test
    @DisplayName("Get user by ID - Should return correct user")
    void getUserById_ShouldReturnCorrectUser() {
        given()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("name", equalTo("Leanne Graham"))
            .body("username", equalTo("Bret"))
            .body("email", equalTo("Sincere@april.biz"));
    }

    @Test
    @DisplayName("Get non-existent user - Should return 404")
    void getNonExistentUser_ShouldReturn404() {
        given()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/users/999")
        .then()
            .statusCode(404);
    }
}