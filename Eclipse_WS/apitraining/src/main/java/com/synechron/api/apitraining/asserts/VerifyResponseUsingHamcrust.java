package com.synechron.api.apitraining.asserts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class VerifyResponseUsingHamcrust {

	@Test
	public void verifyResponseBody() {
		RestAssured.baseURI = "https://api.trello.com";
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("name", equalTo("POSTMAN_DASHBOARD")).and(). 
			body("id", equalTo("61b723a261adc5688924b5aa"));
		
	}

	@Test
	public void verifyHeader() {
		RestAssured.baseURI = "https://api.trello.com";
		
		given().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().
		assertThat().
			statusCode(200).and(). 
			contentType(ContentType.JSON).and(). 
			header("Expires", "Thu, 01 Jan 1970 00:00:00").and().
			header("Content-Type", "application/json; charset=utf-8");
		System.out.println("Validation of header is complete");
		
	}

	@Test
	public void verifyMulitpleValues()
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("name", equalToIgnoringCase("postman_dashboard")).and(). 
			body("id", equalTo("61b723a261adc5688924b5aa"));
	}

	
	@Test
	public void verifyArrayElementSingleValue()
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("prefs.backgroundImageScaled.width", hasItem(108));
	}

	@Test
	public void verifyArrayElementMultipleValues()
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("prefs.backgroundImageScaled.width", hasItems(56,108,270,540));
	}
	
	@Test
	public void verifyKeyInaMap()
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("prefs.backgroundImageScaled[0]", hasKey("width"));
	}

	
	@Test
	public void verifyKeyAndValueInaMap()
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("prefs.backgroundImageScaled.findAll{ it.width == 108 }", hasItems(hasEntry("width",108)));
	}


	@Test
	public void verifyMultiOptions()
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("prefs.backgroundImageScaled.size()", equalTo(9)).and().
			body("prefs.backgroundImageScaled.size()", greaterThan(5)).and().
			body("prefs.backgroundImageScaled.size()", lessThan(10)).and().
			body("prefs.backgroundImageScaled.size()", greaterThanOrEqualTo(9)).and().
			body("prefs.backgroundImageScaled.size()", lessThanOrEqualTo(9));
	}

}
