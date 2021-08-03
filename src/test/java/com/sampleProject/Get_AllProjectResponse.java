package com.sampleProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Get_AllProjectResponse {
	@Test
	public void get_allProject() {
		Response resp = RestAssured.get("http://localhost:8084/projects");
		String respBody = resp.asString();
		System.out.println(respBody);
		String prettyResponseBody = resp.prettyPrint();
		System.out.println(prettyResponseBody);

		int actStatusCode = resp.getStatusCode();
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200);
		
		String actContentType=resp.contentType();
		System.out.println(actContentType);
		Assert.assertEquals(actContentType,"application/json");
		
	}

}
