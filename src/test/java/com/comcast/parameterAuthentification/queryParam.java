package com.comcast.parameterAuthentification;

import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class queryParam {
	@Test
	public void queryParameter_Test() {
		baseURI = "https://reqres.in/";
		
		
		Response response = RestAssured.get("/api/users");

		given().queryParam("page", 2).when().get("/api/users").then()
		.assertThat().statusCode(200)
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS).log().all();
		
		long responseTimeInMilliSeconds = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response time in milliseconds using getTimeIn():"+responseTimeInMilliSeconds);
	}
}
