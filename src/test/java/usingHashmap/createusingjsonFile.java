package usingHashmap;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createusingjsonFile {
	@Test
	public void createProjectusingJSON(){
		File file=new File("./sampleCreat.json");
		
		given().contentType(ContentType.JSON).body(file).when().post("http://localhost:8084/addProject").then().assertThat().statusCode(201).log().all();
		
	}

}
