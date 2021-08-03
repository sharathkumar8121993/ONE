package com.comcast.create;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateStaticTResponse {
	@Test
	public void validateStaticResponseTest() {
		// expected data initialization
		String expectedData = "tobias.funke@reqres.in";

		// getting the response from the server
		Response response = when().get("https://reqres.in/api/users?page=2");

		// verification of status code

		response.then().statusCode(200).log().all();
		// capture the specific data from response body
		
		String actualData = response.jsonPath().get("data[2].email");
		
		System.out.println("expectedData:"+expectedData);
		System.out.println("actualData :"+actualData);
		
		Assert.assertEquals(actualData,expectedData);
	}

}
