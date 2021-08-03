package com.TY.RMG.Projects;

import com.mysql.cj.jdbc.Driver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class GetProjectVerifyDBandDeleteProjectAndVerifyDB {
    @Test
    public void getProjectVerifyDBandDeleteProjectAndVerifyDB() throws SQLException {
        baseURI = "http://localhost";
        port = 8084;
        Response response = when().get("/projects");
        response.then().contentType(ContentType.JSON).time(Matchers.lessThan(300L), TimeUnit.SECONDS)
                .log().all();
        String myproject = response.jsonPath().get("[2].projectId");

        Driver driver = new Driver();
        Connection conn = null;

        DriverManager.registerDriver(driver);
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
        Statement statement = conn.createStatement();
        ResultSet result1 = statement.executeQuery("select * from project");

        String expectedResult = null;
        while (result1.next()) {
            if (result1.getString(1).equals(myproject)) {
                expectedResult = result1.getString(1);
                System.out.println("project id is successfully verified in database");
                break;
            }
        }
        Assert.assertEquals(myproject, expectedResult);


        given().pathParam("proj1", myproject)
                .when().delete("/projects/{proj1}")
                .then().statusCode(204)
                .contentType(ContentType.JSON).assertThat().time(Matchers.lessThan(300L), TimeUnit.SECONDS)
                .log().all();
        conn.close();

    }
}
