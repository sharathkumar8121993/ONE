package com.reqres.in;

import static io.restassured.RestAssured.when;

import org.testng.Assert;

import io.restassured.response.Response;

public class validateStaticRequest_reqres_Test {
	public void validateStaticResponseTest() {
		// expected data initialization
		String expectedData = "rmgProject0001";

		// getting the response from the server
		Response response = when().get("http://localhost:8084/projects");

		// verification of status code

		response.then().statusCode(200).log().all();
		// capture the specific data from response body
		
		String actualData = response.jsonPath().get("[1].projectName");
		
		System.out.println("expectedData:"+expectedData);
		System.out.println("actualData :"+actualData);
		
		Assert.assertEquals(actualData,expectedData);
	}
}
