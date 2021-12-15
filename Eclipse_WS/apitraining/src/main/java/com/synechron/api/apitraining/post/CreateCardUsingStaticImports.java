package com.synechron.api.apitraining.post;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class CreateCardUsingStaticImports {

	@Test
	public void createList() {
		String name = "My Card1";
		RestAssured.baseURI = "https://api.trello.com";

		given().
			queryParam("key", "c5f676759b86029624f7dcb31ccf655e")
			.queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3")
			.queryParam("idList", "61b81bdbbc81fd078b3646bc")
			.queryParam("name", name)
			.header("Content-type", "application/json")
		.when().
			post("/1/cards")
		.then()
			.assertThat().statusCode(200)
				
			.and().contentType(ContentType.JSON)
			.and().body("name", equalTo(name));

	}
}
