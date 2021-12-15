package com.synechron.api.apitraining.post;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateList {

	
	@Test
	public void createList() {
		String name = "My New Board1";
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured. 
			given().
				queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
				queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				queryParam("idBoard", "61b723a261adc5688924b5aa"). 
				queryParam("name", name). 
				header("Content-type", "application/json").
			when().
				post("/1/lists/").
			then().
				assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and()
				.body("name", CoreMatchers.equalTo(name));
				
	}
}
