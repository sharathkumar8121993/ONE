package com.comcast.assignmentAugust;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingFormData_Test {
    @Test
    public void createProjectUsingFormData_Test() {
        baseURI = "http://localhost";
        port = 8084;
        HashMap map = new HashMap();
        map.put("createdBy", "Ramar");
        map.put("projectName", "CRM300");
        map.put("status", "created");
        map.put("teamSize", 10);
        given().contentType(ContentType.JSON).body(map).when().
                post("/addProject").then().statusCode(201).
                contentType(ContentType.JSON).log().all();
    }
}
