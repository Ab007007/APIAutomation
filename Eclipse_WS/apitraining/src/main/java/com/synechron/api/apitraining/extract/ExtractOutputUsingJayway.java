package com.synechron.api.apitraining.extract;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class ExtractOutputUsingJayway {

	
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
		
		
		
		System.out.println("ID : " + JsonPath.read(jsonResponse, "$.id"));
		System.out.println("Name : " + JsonPath.read(jsonResponse, "$.name"));
		System.out.println("prefs : " + JsonPath.read(jsonResponse, "$.prefs"));
		System.out.println("Permission  : " + JsonPath.read(jsonResponse, "prefs.permissionLevel"));
		
		List<Map<String, ?>> prefsArray = JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled");
		
		// get list of maps
		for(Map<String,?> ele : prefsArray)
		{
			System.out.println(ele);
		}
		
		
		
		// get all the urls from the different map
		List<String> urls = JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled[*].url");
		for(String url:urls) {
			System.out.println(url);
		}
		
		
		// get all the url the complete response
		List<String> allurls = JsonPath.read(jsonResponse, "$..url");
		for(String url:allurls) {
			System.out.println(url);
		}
		
		// Adding Expression to the json response
		//$.prefs.backgroundImageScaled.[?(@.width<1000)].width
		
		List<Integer> widths = JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled.[?(@.width<1000)].width");
		for(Integer w:widths) {
			System.out.println(w);
		}
		
		//printing all the values in map
		
		int size = JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled.size()");
		for (int i = 0; i < size; i++)
		{
			System.out.println("Width at index " + i + " is " + JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled["+ i + "].width") );
			System.out.println("Height at index " + i + " is " + JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled["+ i + "].height") );
			System.out.println("Url at index " + i + " is " + JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled["+ i + "].url") );
			System.out.println("\n***************************************************************\n");
		}
		System.out.println(size);
		System.out.println("First automation code ");
	}
}
