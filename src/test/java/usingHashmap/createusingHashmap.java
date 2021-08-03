package usingHashmap;

import java.util.HashMap;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class createusingHashmap {
	@Test
	public void create_using_hashmap() {
		HashMap map = new HashMap();
		map.put("createBy","Chaitra");
		map.put("projectName","TYss0001222");
		map.put("Status","Created");
		map.put("TeamSize", 20);

		given().contentType(ContentType.JSON).body(map).when().post("http://localhost:8084/addProject").then()
				.assertThat().statusCode(201);
		
		when().get("http://localhost:8084/projects").then().log().all().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON);
		
	}
	
}
