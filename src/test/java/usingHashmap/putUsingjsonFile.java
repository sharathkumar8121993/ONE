package usingHashmap;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

@Test

public class putUsingjsonFile {
	public void modify_using_jsonFile() {
		File file = new File("./sample.json");

		given().contentType(ContentType.JSON).body(file).when().put("http://localhost:8084/projects/TY_PROJ_1605")
				.then().assertThat().statusCode(200).log().all();

	}

}
