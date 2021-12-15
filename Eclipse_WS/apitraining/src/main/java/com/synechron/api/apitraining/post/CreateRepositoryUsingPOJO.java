package com.synechron.api.apitraining.post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class CreateRepositoryUsingPOJO {

	
	@Test
	public void createRepo() {
		RestAssured.baseURI = "https://api.github.com";
		String barrierToken = "Bearer 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";
		String projectName = "API_REPO_15_12";
		
		GitRepoPOJO gp = new GitRepoPOJO();
		gp.setName("MY_pojo_Repo");
		gp.setDescription("my desc");
		
		
		given().
			headers("Authorization", barrierToken).
			headers("Content-type","application/json").
			body(gp).
		when().
			post("/user/repos").
		then().
			assertThat().statusCode(201);
			
		
		
	}
}
