package com.hrms.API.steps.practice;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import com.hrms.API.utils.APIConstants;

public class TokenGenerationSteps {

	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	public static String token;

	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
		RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body(
				"{\r\n" + "  \"email\": \"postman1@postman1.com\",\r\n" + "  \"password\": \"postman1\"\r\n" + "}");

		Response generateTokenResponse = generateTokenRequest.when().post(APIConstants.GENERATE_TOKEN_ENDPOINT);
		// generateTokenResponse.prettyPrint();

		token = "Bearer " + generateTokenResponse.body().jsonPath().get("token");
		// System.out.println("token: "+token);

	}
}
