package org.example.homework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRestApi {

    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Test
    public void createUser() {

        String jsonData = "{\n" +
                "    \"name\": \"Alka\",\n" +
                "    \"job\": \"tester\"\n" +
                "}";

        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);


        System.out.println(validatableResponse.extract().asPrettyString());
    }


}
