package com.synechron.api.apitraining.extract;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Test
public class ExtractOutputUsingJsonPath {

	
	public void extractResponse() {
		RestAssured.baseURI = "https://api.trello.com";
		Response response = RestAssured.
			given().
				param("key", "c5f676759b86029624f7dcb31ccf655e").
				param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
			when().
				get("/1/boards/SIz5gELw").
			then(). 
				assertThat().statusCode(200).
			extract().response();
			
		String jsonResponse = response.asString();
		
		JsonPath jp = new JsonPath(jsonResponse);
		
		System.out.println("ID : " + jp.get("id"));
		System.out.println("Name : " + jp.get("name"));
		System.out.println("prefs : " + jp.get("prefs"));
		System.out.println("Permission  : " + jp.get("prefs.permissionLevel"));
		Map	 prefArray = jp.get("prefs");
		System.out.println(prefArray.keySet());
		
		
		System.out.println("First automation code ");
	}
}
