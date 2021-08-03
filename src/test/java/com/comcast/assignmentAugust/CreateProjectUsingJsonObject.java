package com.comcast.assignmentAugust;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJsonObject {
    @Test
    public void createProjectUsingJsonObject_Test() {
        baseURI = "http://localhost";
        port = 8084;
        JSONObject jobject = new JSONObject();
        jobject.put("createdBy", "ramar1000");
        jobject.put("projectName", "CRM600");
        jobject.put("status", "created");
        jobject.put("teamSize", 10);

        given().contentType(ContentType.JSON).body(jobject).when().post("/addProject")
                .then().statusCode(201).contentType(ContentType.JSON).log().all();
    }
}
