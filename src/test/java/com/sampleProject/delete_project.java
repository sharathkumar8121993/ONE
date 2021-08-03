package com.sampleProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class delete_project {
	@Test
	public void _allProject() {
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_403");
		String result = resp.asString();
		System.out.println(result);
		
//		int actStatusCode = resp.getStatusCode();
//		System.out.println(actStatusCode);
//		Assert.assertEquals(actStatusCode, 204);
//		
//		String actContentType=resp.contentType();
//		System.out.println(actContentType);
//		Assert.assertEquals(actContentType,"application/json");
		
//		Response responeget=RestAssured.get("http://localhost:8084/projects/TY_PROJ_1007");
//		String getResp = resp.asString();
//		System.out.println(getResp);
		
	}
}
