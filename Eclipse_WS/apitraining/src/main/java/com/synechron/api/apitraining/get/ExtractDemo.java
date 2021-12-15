package com.synechron.api.apitraining.get;

import org.hamcrest.CoreMatchers;

import io.restassured.RestAssured;

public class ExtractDemo {

	
	/*
	 * 1. BDD : Given when then format
	 * 2. RestAssured Class Format
	 * 3. Given Expect When format
	 * 
	 */
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
			given().
				param("key", "c5f676759b86029624f7dcb31ccf655e").
				param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
			expect().statusCode(200).and(). 
				body("name", CoreMatchers.equalTo("POSTMAN_DASHBOARD")).and(). 
				body("id", CoreMatchers.equalTo("61b723a261adc5688924b5aa")).
			when().
				get("/1/boards/SIz5gELw");
			
		
		System.out.println("Extract automation code ");
		
			
	}
	
}
