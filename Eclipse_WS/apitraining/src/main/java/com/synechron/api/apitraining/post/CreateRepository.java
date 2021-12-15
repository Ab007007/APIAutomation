package com.synechron.api.apitraining.post;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;


public class CreateRepository {

	
	@Test
	public void createRepo() {
		RestAssured.baseURI = "https://api.github.com";
		String barrierToken = "Bearer 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";
		String projectName = "API_REPO_15_12";
		
		given().
			headers("Authorization", barrierToken).
			headers("Content-type","application/json").
			body("{\r\n" + 
					"    \"name\" : \"MY NEW REPO\""
					+ "}").
		when().
			post("/user/repos").
		then().
			assertThat().statusCode(201);
			
		
		
	}
}
