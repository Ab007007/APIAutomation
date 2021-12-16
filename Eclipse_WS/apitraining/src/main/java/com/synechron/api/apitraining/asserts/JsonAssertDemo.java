package com.synechron.api.apitraining.asserts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.CoreMatchers;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;

public class JsonAssertDemo {

	
	@Test
	public void validateJson() throws IOException, JSONException
	{
			RestAssured.baseURI = "https://api.trello.com";
			String expectedValue = new String(Files.readAllBytes(Paths.get("output.txt")));
			String actualValue = 	RestAssured.
				given().
					param("key", "c5f676759b86029624f7dcb31ccf655e").
					param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				when().
					get("/1/boards/SIz5gELw").asString();
			
		//	Assert.assertEquals(expectedValue, actualValue);
			JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
			System.out.println(expectedValue);
			System.out.println(actualValue);
				
			
	}
}
