package com.comcast.GenericUtils;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
public class BaseApiClass {



    DataBaseUtilities dbUtils=new DataBaseUtilities();

    @BeforeSuite
    public void bsConfig() throws Throwable {
        baseURI="http://localhost";
        port=8084;

        dbUtils.connectToDB();
    }
    @AfterSuite
    public void asConfig() throws Throwable
    {
        dbUtils.closeDB();
    }

}
