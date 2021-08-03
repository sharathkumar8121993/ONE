package com.sampleProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Put_updateProject {
	@Test
	public void update_project() {
		JSONObject JObject = new JSONObject();
		JObject.put("createdBy", "deepak");
		JObject.put("projectName", "SDET_18_project_111");
		JObject.put("status", "completed");
		JObject.put("teamSize", 50);

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(JObject);
		Response resp = reqSpec.put("http://localhost:8084/projects/TY_PROJ_1402");
		resp.prettyPrint();

		Assert.assertEquals(resp.getStatusCode(), 200);

	}

}
