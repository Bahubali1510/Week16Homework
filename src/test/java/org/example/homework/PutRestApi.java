package org.example.homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/*
* PUT is a method of modifying resources where the client sends data that updates the entire resource.

PATCH is a method of modifying resources where the client sends partial data that is to be updated without modifying the entire data.*/

public class PutRestApi {

    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Test
    public void updateEmployee() {

        String jsonData = "{\n" +
                "    \"name\": \"Hani\",\n" +
                "    \"job\": \"tester\"\n" +
                "}";

        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //create request specification
        requestSpecification = given();

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonData);

        response = requestSpecification.put();

        System.out.println(response.prettyPrint());

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

//        validatableResponse.body("data.name", equalTo("bhavesh"));

    }

   }
