package com.comcast.parameterAuthentification;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChaining {
	@Test
	public void getAndDeleterequestChaining() {
		baseURI = "http://localhost";
		port = 8084;
		// get all the projects
		Response response = when().get("/projects");

//capture any projectid

		String firstProjectId = response.jsonPath().get("[0].projectId");
		System.out.println(firstProjectId);

//delete that project

		given().pathParam("ProjID", firstProjectId).when().delete("/projects/{ProjID}").then().assertThat()
				.statusCode(204).log().all();
	}

}
