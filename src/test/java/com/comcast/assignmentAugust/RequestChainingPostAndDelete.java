package com.comcast.assignmentAugust;

import org.testng.annotations.Test;
import com.comcast.POJOClass.ProjectLibrary;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RequestChainingPostAndDelete {
	@Test
	public void requestChainingPostAndDelete_Test() {
		ProjectLibrary projectLibrary = new ProjectLibrary("sharath", "CRM1000", "completed", 301);

		Response response = given().contentType("application/json").body(projectLibrary).when()
				.post("http://localhost:8084/addProject");
		System.out.println(response.prettyPrint());

		String myproject = response.jsonPath().get("projectId");
		System.out.println(myproject);

		given().pathParam("project", myproject).when().delete("http://localhost:8084/project/{project}").then()
				.assertThat().statusCode(204);
	}
}
