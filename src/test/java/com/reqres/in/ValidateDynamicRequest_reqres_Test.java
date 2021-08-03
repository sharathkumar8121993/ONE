package com.reqres.in;

import static io.restassured.RestAssured.*;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateDynamicRequest_reqres_Test {
	@Test
	public void validateDynamicRequest_reqres_Test() {
		baseURI = "https://reqres.in/api/users?page=2";
		String expectedData = "https://reqres.in/img/faces/7-image.jpg";
		String actualData = null;
		Response response = when().get(baseURI);

		response.then().statusCode(200).log().all();

		List<String> list = response.jsonPath().get("data.avatar");
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
	}
}
