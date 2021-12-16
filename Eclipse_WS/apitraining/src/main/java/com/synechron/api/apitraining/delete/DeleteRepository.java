package com.synechron.api.apitraining.delete;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRepository {

	
	@Test
	public void deleteRepository()
	{
		RestAssured.baseURI = "https://api.github.com";
		String barrierToken = "Bearer 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";
		given().
			headers("Authorization", barrierToken).
			headers("Content-type","application/json").
		when().
			delete("/repos/AravindaHB/MY_pojo_Repo").
		then().
			assertThat().statusCode(204);
	}
}
