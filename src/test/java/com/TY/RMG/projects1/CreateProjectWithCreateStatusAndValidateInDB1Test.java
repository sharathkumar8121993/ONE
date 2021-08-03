package com.TY.RMG.projects1;

import com.comcast.GenericUtils.*;
import com.comcast.POJOClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateProjectWithCreateStatusAndValidateInDB1Test extends BaseApiClass {
    @Test

    public void createProjectWithCreatesStatusAndValidateInDB1Test() throws Throwable {
        JavaUtility jUtil = new JavaUtility();
        RestAssuredUtility rLib = new RestAssuredUtility();
        DataBaseUtilities dLib = new DataBaseUtilities();

        int ran1=jUtil.randomNumber();
        //create project with created status and using polo class
        ProjectLibrary projectLibrary = new ProjectLibrary("Sharathhhh", "hifffsjhfhf"+ ran1, "completed", 126);
        Response response = given().contentType(ContentType.JSON).body(projectLibrary).when().post(EndPoints.addProject);
        response.then().log().all();

        //capture projectId
        String firstProjectId = rLib.jsonPathConstant(response, "projectId");
        String actrProjectName = rLib.jsonPathConstant(response, "projectName");

        //verify the data
        dLib.connectToDB();
        String query = "select * from project";
        String expData = dLib.executeQueryAndGetData(query, 1, firstProjectId);
        String expName = dLib.executeQueryAndGetData(query, 4, actrProjectName);

        //validation

        Assert.assertEquals(firstProjectId, expData);
        Assert.assertEquals(actrProjectName, expName);


    }


}
