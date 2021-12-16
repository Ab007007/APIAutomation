package com.synechron.api.apitraining.specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecDemo {

	RequestSpecification rSpec;
	RequestSpecBuilder rBuilder;
	
	ResponseSpecification resSpec;
	ResponseSpecBuilder resBuilder;
	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.rootPath = "prefs.backgroundImageScaled";
		//RestAssured.reset();
		rBuilder = new RequestSpecBuilder();
		rBuilder.addParam("key", "c5f676759b86029624f7dcb31ccf655e");
		rBuilder.addParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3");
		rBuilder.addHeader("Content-Type", "application/json");
		
		rSpec = rBuilder.build();
		
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectStatusCode(200);
		resBuilder.expectBody("width",  hasItem(108));
		resBuilder.expectBody("height",  hasItem(192));
		
		resSpec = resBuilder.build();
	}
	
	@Test
	public void verifyWidthValue()
	{
		
		
		given().spec(rSpec).
		when().
			get("/1/boards/SIz5gELw").
		then().spec(resSpec);
	}
	
	@Test
	public void verifyHeightValue()
	{
		
		given().spec(rSpec).
		when().get("/1/boards/SIz5gELw").
		then().spec(resSpec);
	}
	
	@Test
	public void verifyURLValue()
	{
		
		given().spec(rSpec).
		when().
			get("/1/boards/SIz5gELw").
		then().spec(resSpec);
	}
}
