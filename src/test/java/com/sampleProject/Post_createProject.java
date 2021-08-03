package com.sampleProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post_createProject {
	@Test
	public void update_project() {
		JSONObject JObject = new JSONObject();
		JObject.put("createdBy", "deepak");
		JObject.put("projectName", "SDET_18_project_100");
		JObject.put("status", "ongoing");
		JObject.put("teamSize", 10);

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(JObject);
		Response resp = reqSpec.post("http://localhost:8084/addProject");
		resp.prettyPrint();

		Assert.assertEquals(resp.getStatusCode(), 201);

	}
}
