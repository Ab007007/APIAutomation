package com.synechron.api.apitraining.download;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FileDownloadDemo {
//https://github.com/mozilla/geckodriver/releases/download/v0.30.0/geckodriver-v0.30.0-win64.zip
	
	@Test
	public void validateFileDownload() {
		File f = new File("download\\geckodriver-v0.30.0-win64.zip");
		int exptectedSize = (int)f.length();
		System.out.println("Expected file size " + exptectedSize);
		
		byte[] actualValue = RestAssured.given().
		get("https://github.com/mozilla/geckodriver/releases/download/v0.30.0/geckodriver-v0.30.0-win64.zip").then()
		.extract().asByteArray();
		System.out.println("Acutal length "+ actualValue.length);
		
		
		
	}
}
