package com.sampleProject.usingBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class delete_project {
	@Test
	public void _allProject() {

		given()

				.delete("http://localhost:8084/projects/TY_PROJ_1006").then().log().all().assertThat().statusCode(204);

	}
}
