package com.synechron.api.apitraining.get;

import org.hamcrest.CoreMatchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetWithRestAssuredClass {
/*
 * npm install http-server -gj
json-server --watch db.json

 */
	public static void main(String[] args) {
		RequestSpecification rspec = RestAssured.given();
		rspec.param("key", "c5f676759b86029624f7dcb31ccf655e");
		rspec.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3");
		
		Response response = rspec.get("https://api.trello.com/1/boards/SIz5gELw");
		
		response.prettyPrint();
		
		ValidatableResponse validateRes = response.then();
		
		validateRes.statusCode(200);
		validateRes.body("name", CoreMatchers.equalTo("POSTMAN_DASHBOARD"));
	}
}
