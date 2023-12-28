package org.example.homework;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRestApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllPage() {

        given().log().all()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .statusCode(200);

    }
    @Test
    public void getSingleUser() {

        given().log().all()
                .when()
                .get("https://reqres.in/api/users/2")
                .then().log().all()
                .statusCode(200);


    }


}
