package com.comcast.assignmentAugust;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.io.File;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONFile_Test {
    @Test
    public void createProjectUsingJSONFile_Test() {
        baseURI = "http://localhost";
        port = 8084;
        File file = new File("./sampleCreateNew1.json");
        given().body(file).contentType(ContentType.JSON).
                when().post("/addProject").then().statusCode(201).
                contentType(ContentType.JSON).log().all();
    }
}
