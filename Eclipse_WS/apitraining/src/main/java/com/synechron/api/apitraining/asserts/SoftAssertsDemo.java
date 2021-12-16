package com.synechron.api.apitraining.asserts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SoftAssertsDemo {

	@Test
	public void softAssertsDemo() {

		RestAssured.baseURI = "https://api.trello.com";

		given()
			.log().headers()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").when()
		.get("/1/boards/SIz5gELw")
		.then().log().headers()
			.assertThat().statusCode(200).and()
			.body("prefs.backgroundImageScaled.size()", equalTo(10),
					"prefs.backgroundImageScaled.size()", greaterThan(5),
					"prefs.backgroundImageScaled.size()", lessThan(1),
					"prefs.backgroundImageScaled.size()", greaterThanOrEqualTo(9),
					"prefs.backgroundImageScaled.size()", lessThanOrEqualTo(9));						

	}
}
