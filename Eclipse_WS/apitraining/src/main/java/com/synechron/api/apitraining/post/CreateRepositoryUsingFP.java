package com.synechron.api.apitraining.post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;


public class CreateRepositoryUsingFP {

	
	@Test
	public void createRepo() {
		Faker f = new Faker();
		RestAssured.baseURI = "https://api.github.com";
		String barrierToken = "Bearer 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";
		String projectName = f.name().firstName();
		String projDesc = f.name().fullName();
		System.out.println(projectName);
		GitRepoPOJO gp = new GitRepoPOJO();
		gp.setName(projectName);
		gp.setDescription(projDesc);
		
		
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
