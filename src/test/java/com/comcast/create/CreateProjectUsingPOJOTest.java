package com.comcast.create;

import com.comcast.POJOClass.ProjectLibrary;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingPOJOTest {
	@Test
	public void createUsingPojo() {
		ProjectLibrary projectLibrary = new ProjectLibrary("testyantra21","sdet_18_offline30","completed",420);
		given().contentType(ContentType.JSON)
		.body(projectLibrary).when().post("http://locahost:8084/addProject").then().assertThat().statusCode(201).log().all()
		.assertThat().contentType(ContentType.JSON);
	}

}
