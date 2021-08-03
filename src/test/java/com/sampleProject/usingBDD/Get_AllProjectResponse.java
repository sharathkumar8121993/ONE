package com.sampleProject.usingBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_AllProjectResponse {
	@Test
	public void get_allProject() {

		when().get("http://localhost:8084/projects").then().log().all().assertThat().statusCode(200).assertThat()
				.contentType(ContentType.JSON);

	}

}
