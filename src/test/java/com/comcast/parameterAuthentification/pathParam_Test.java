package com.comcast.parameterAuthentification;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class pathParam_Test {
	@Test
	public void pathParamter() {
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("ProjID","TY_PROJ_402")
		.when().delete("/projects/{ProjID}").then().assertThat().statusCode(204).log().all();
				
	}

}
