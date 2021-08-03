package com.comcast.create;

import com.comcast.POJOClass.ProjectLibrary;
import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class CreateMultipleDataWithDataProvider_Test {
	@Test(dataProvider = "getData")
	public void createMultipleProjects(String createdBy, String projectName, int teamSize) {
		baseURI = "http://localhost";
		port = 8084;

		ProjectLibrary projectLibrary = new ProjectLibrary(createdBy, projectName, "completed", teamSize);

		given().contentType(ContentType.JSON).body(projectLibrary).when().post("/addProject").then().log().all();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[5][3];

		obj[0][0] = "Sharatham";
		obj[0][1] = "TY1";
		obj[0][2] = 26;

		obj[1][0] = "Dharmaraj";
		obj[1][1] = "TYss1";
		obj[1][2] = 31;

		obj[2][0] = "hello";
		obj[2][1] = "TYss1001";
		obj[2][2] = 21;

		obj[3][0] = "world";
		obj[3][1] = "TYss_2001";
		obj[3][2] = 28;

		obj[4][0] = "new";
		obj[4][1] = "TYsss1";
		obj[4][2] = 28;
		return obj;
	}
}
