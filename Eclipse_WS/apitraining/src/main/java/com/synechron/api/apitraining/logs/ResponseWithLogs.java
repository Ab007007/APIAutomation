package com.synechron.api.apitraining.logs;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ResponseWithLogs {

	
	/*
	 * 1. BDD : Given when then format
	 * 2. RestAssured Class Format
	 * 3. Given Expect When format
	 * 
	 */
	
	//@Test
	public void LogHeader() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
			given().
				param("key", "c5f676759b86029624f7dcb31ccf655e").
				param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").log().params().
			when().
				get("/1/boards/SIz5gELw").
			then().log().headers().log().body().
				assertThat().statusCode(200).and(). 
				body("name", CoreMatchers.equalTo("POSTMAN_DASHBOARD")).and(). 
				body("id", CoreMatchers.equalTo("61b723a261adc5688924b5aa"));
				
		
		System.out.println("First automation code ");
		
			
	}
	@Test
	public void LogAll() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
			given().
				param("key", "c5f676759b86029624f7dcb31ccf655e").
				param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").log().all().
			when().
				get("/1/boards/SIz5gELw").
			then().log().all().
				assertThat().statusCode(200).and(). 
				body("name", CoreMatchers.equalTo("POSTMAN_DASHBOARD")).and(). 
				body("id", CoreMatchers.equalTo("61b723a261adc5688924b5aa"));
				
		
		System.out.println("First automation code ");
		
			
	}
	
}
