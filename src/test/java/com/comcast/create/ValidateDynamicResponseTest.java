package com.comcast.create;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateDynamicResponseTest {
	@Test
	public void validateDynamicResponseTest() {
		String expectedData = "rmg";
		String actualData = null;
		Response response = when().get("http://localhost:8084/projects");

		response.then().statusCode(200).log().all();

		List<String> list = response.jsonPath().get("createdBy");
		boolean flag = false;
		for (String data : list) {
			if (data.equals(expectedData)) {
				actualData = data;
				flag = true;
				System.out.println("the value is present:" + actualData);
				break;
			}
		}
		Assert.assertEquals(flag, true);
		Assert.assertEquals(actualData, expectedData);
	}

}
