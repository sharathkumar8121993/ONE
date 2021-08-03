package com.TY.RMG.Projects;

import com.comcast.POJOClass.ProjectLibrary;
import com.mysql.cj.jdbc.Driver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.*;
import java.util.Random;

import static io.restassured.RestAssured.*;

public class CreateRandomProjectWithCreateStatusAndValidateInDBTest {

    @Test
    public void createProjectWithCreateStatusAndValidateInDBTest() throws SQLException {
        Random random=new Random();
        int ran=random.nextInt(1000);
        baseURI = "http://localhost";
        port = 8084;
        //create the project with created status using JSON class
        ProjectLibrary projectlibraryAll = new ProjectLibrary("sharatham1", "HelloWorld"+ran , "created", 12);
        Response response = (Response) given().contentType(ContentType.JSON).
                body(projectlibraryAll)
                .when().post("/addProject");
        response.then().log().all();

        //capture the project id

        String firstProjectId = response.jsonPath().get("projectId");
        System.out.println(firstProjectId);

        String firstProjectStatus = response.jsonPath().get("status");
        System.out.println(firstProjectStatus);
        //verify the projectid in the database
        //Step1:register the database

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        //step2:get connection wih db
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
        //Step3: issue statement
        Statement statement = conn.createStatement();

        //Step4:execute Query

        ResultSet result = statement.executeQuery("select * from project");
        String expData = null;
        String expStatus = null;
        while (result.next()) {
            if (result.getString(1).equals(firstProjectId)) {
                expData = result.getString(1);
                expStatus = result.getString(5);
                System.out.println("Project id is verified in the database");
                System.out.println("Project Status is verified in the database");
                break;
            }
        }
        //validate the database
        Assert.assertEquals(firstProjectId, expData);
        Assert.assertEquals(firstProjectStatus, expStatus);
    }
}


