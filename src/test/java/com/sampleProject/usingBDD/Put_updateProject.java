package com.sampleProject.usingBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Put_updateProject {
	@Test
	public void update_project() {
		JSONObject JObject = new JSONObject();
		JObject.put("createdBy", "deepak");
		JObject.put("projectName", "SDET_18_project_1112");
		JObject.put("status", "ongoing");
		JObject.put("teamSize", 50);


		given()
		.contentType(ContentType.JSON)
		.body(JObject)
		.when()
		.put("http://localhost:8084/TY_PROJ_1402")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
	}

}
