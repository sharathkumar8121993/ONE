package com.comcast.assignmentAugust;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.comcast.POJOClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChaining_PostGetPutDelete {

	@Test
	public void testRequestChaining() {
		baseURI = "http://localhost";
		port = 8084;
		ProjectLibrary projectLibrary1 = new ProjectLibrary("nithish", "CRM102", "completed", 37);

		// create the project
		Response response = given().contentType(ContentType.JSON).body(projectLibrary1).when().post("/addProject");
		response.then().statusCode(201).log().all();

		String myproject = response.jsonPath().get("projectId");
		// get the project

		given().pathParam("projectId", myproject).when().get("/projects/{projectId}").then().statusCode(200).log()
				.all();

		// change the Project values
		ProjectLibrary projectLibrary2 = new ProjectLibrary("nithish", "CRM202", "completed", 37);
		given().contentType(ContentType.JSON).body(projectLibrary2).pathParam("project", myproject).when()
				.put("/projects/{project}").then().statusCode(200).log().all();

		// delete the project

		given().pathParam("project1", myproject).when().delete("/projects/{project1}").then().statusCode(204).log()
				.all();
	}
}
