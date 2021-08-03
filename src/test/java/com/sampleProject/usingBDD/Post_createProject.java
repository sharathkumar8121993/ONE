package com.sampleProject.usingBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post_createProject {
	@Test
	public void update_project() {
		JSONObject JObject = new JSONObject();
		JObject.put("createdBy", "deepak");
		JObject.put("projectName", "SDET_18_project_123");
		JObject.put("status", "ongoing");
		JObject.put("teamSize", 10);

		given()
		.contentType(ContentType.JSON)
		.body(JObject)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
	}
}
