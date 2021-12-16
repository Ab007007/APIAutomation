package com.synechron.api.apitraining.root;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SettingRootPath {

	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.rootPath = "prefs.backgroundImageScaled";
		//RestAssured.reset();
	}
	
	@Test
	public void verifyWidthValue()
	{
		
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("width", hasItem(108));
	}
	
	@Test
	public void verifyHeightValue()
	{
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200).and(). 
			body("height", hasItem(192));
	}
	
	@Test
	public void verifyURLValue()
	{
		
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e"). 
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/SIz5gELw").
		then().log().headers().
		assertThat().
			statusCode(200);
	}
}
